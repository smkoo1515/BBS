package BBS.Actions;

import java.sql.SQLException;

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

        String writeSql = "insert into " + bbsName + "(userid, username, title, content) values(\'" + userid + "\',\'" + username + "\',\'" + title + "\',\'" + content + "\');";
        try {
            executeQuery(writeSql);
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
