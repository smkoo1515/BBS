package BBS.Actions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsSession;
import BBS.BbsView;
import BBS.Beans.UserInfoBean;

public class UpdatePostAction extends BbsAction {

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        UserInfoBean userInfo = (UserInfoBean) req.getSession().getAttribute(BbsSession.BBSSESSION);
        String bbsName = req.getParameter("BBS");
        String userid =userInfo.getId();
        String username = userInfo.getName();
        String title = req.getParameter("TITLE");
        String content = req.getParameter("CONTENT");
        String postNumber = req.getParameter("POSTNO");

        String sqlFile="updatePost.sql";
        Map<String, String> sqlParams = new HashMap<String, String>();
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("userid", userid);
        sqlParams.put("title", title);
        sqlParams.put("content", content);
        sqlParams.put("postno", postNumber);

        try {
            executeQuery(sqlFile, sqlParams);
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        BbsView view = new BbsView();
        view.setViewPage("ReadPost.do?BBS=" + bbsName + "&&POSTNO=" + postNumber);
        view.setRedirect(true);
        return view;
    }

}
