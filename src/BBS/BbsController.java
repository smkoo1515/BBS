//　すべてのアクション（要請）を処理するコントローラー

//　web.xml設定によって「*.do」のURIはコントローラーで処理


package BBS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsController extends HttpServlet {

    //　反応速度向上のためアクションをキャッシング
    private Map<String, BbsAction> actionMap;


    //　要請をdoProcessに移行
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }


    //  初期処理
    public void init () throws ServletException
    {
       super.init();
       //　キャッシングオブジェクト生成
       actionMap = new HashMap<String, BbsAction>();
    }


    //　コントローラーのメインプロセス
    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //　URI要請からアクションの名前を抽出
        String command = getCommandBy(req);
        BbsAction action = null;
        try {
            //　名前からアクションの獲得
            action = getActionBy(command);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return;
        }
        //　アクションを実行し、その結果をビューオブジェクトに保管
        BbsView view = action.doServiceWith(req);
        //　ビューに移行
        doHandleView(view, req, resp);
    }

    //　URI要請からアクションの名前を抽出
    private String getCommandBy(HttpServletRequest req) {
        String command = req.getRequestURI().substring(req.getContextPath().length());
        command = command.replaceFirst("^/", "");
        return command = command.substring(0, command.lastIndexOf("."));

    }

    //　名前からアクションの獲得
    private BbsAction getActionBy(String command) throws ServletException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //　アクションがキャッシングされてるかチェック
        if( !actionMap.containsKey(command) ) {
            //　アクションパス設定
            String actionPath = "BBS.Actions." + command + "Action";
            BbsAction action = null;
            action = (BbsAction) Class.forName(actionPath).newInstance();

            //　アクションの有効性チェック
            if( action instanceof BbsAction) {
                //　アクションをキャッシング
                actionMap.put(command, (BbsAction) action);
            } else {
                return null;
            }
        }
        //　アクションを獲得
        return actionMap.get(command);
    }

    //　ビューに移行
    private void doHandleView(BbsView view, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(view == null) return;

        //　ビューに伝達するデータ
        if( view.getModelMap() != null && !view.getModelMap().isEmpty() ) {
            //　キーを「modelMap」に設定
            req.setAttribute("modelMap", view.getModelMap());
        }

        //　ページ移動方法によってビューに移行
        if( view.isRedirect() ) {
            resp.sendRedirect(view.getViewPage());
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(view.getViewPage());
            dispatcher.forward(req, resp);
        }
    }
}
