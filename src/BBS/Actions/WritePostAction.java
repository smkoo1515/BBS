package BBS.Actions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;

public class WritePostAction extends BbsAction {

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String bbsName = req.getParameter("BBS");
        String userid = req.getParameter("userid");
        String username = req.getParameter("username");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        String sqlFile="writePost.sql";
        Map<String, String> sqlParams = new HashMap<String, String>();
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("userid", userid);
        sqlParams.put("username", username);
        sqlParams.put("title", title);
        sqlParams.put("content", content);

        try {
            executeQuery(sqlFile, sqlParams);
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        BbsView view = new BbsView();
        view.setViewPage("ViewBbs.do?BBS=" + bbsName);
        view.setRedirect(true);
        return view;
    }

}
