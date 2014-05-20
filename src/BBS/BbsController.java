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

    private Map<String, BbsAction> actionMap;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doProcess(req, resp);
    }


    public void init () throws ServletException
    {
       super.init();

       actionMap = new HashMap<String, BbsAction>();
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String command = getCommandBy(req);
        BbsAction action = null;
        try {
            action = getActionBy(command);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return;
        }
        BbsView view = action.doServiceWith(req);
        doHandleView(view, req, resp);
    }

    private String getCommandBy(HttpServletRequest req) {
        String command = req.getRequestURI().substring(req.getContextPath().length());
        command = command.replaceAll("^/.+/", "");
        return command = command.substring(0, command.lastIndexOf("."));

    }

    private BbsAction getActionBy(String command) throws ServletException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        if( !actionMap.containsKey(command) ) {
            String actionPath = "BBS.Actions." + command + "Action";

            BbsAction action = null;
            action = (BbsAction) Class.forName(actionPath).newInstance();

            if( action instanceof BbsAction) {
                actionMap.put(command, (BbsAction) action);
            } else {
                return null;
            }
        }
        return actionMap.get(command);
    }
    private void doHandleView(BbsView view, HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        if(view == null) return;

        if( view.getModelMap() != null && !view.getModelMap().isEmpty() ) {
            req.setAttribute("modelMap", view.getModelMap());
        }

        if( view.isRedirect() ) {
            resp.sendRedirect(view.getViewPage());
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(view.getViewPage());
            dispatcher.forward(req, resp);
        }
    }
}
