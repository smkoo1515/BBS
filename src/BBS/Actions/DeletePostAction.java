package BBS.Actions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsSession;
import BBS.BbsView;
import BBS.Beans.UserInfoBean;

public class DeletePostAction extends BbsAction{

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();
        String bbsName = req.getParameter("BBS");
        String postNumber = req.getParameter("POSTNO");
        String userId = (String)((UserInfoBean)req.getSession().getAttribute(BbsSession.BBSSESSION)).getId();
        deletePost(bbsName,postNumber,userId);

        view.setViewPage("ViewBbs.do?BBS=" + bbsName);
        return view;
    }

    private void deletePost(String bbsName, String postNumber, String userId){
        String sqlFile="deletePost.sql";
        Map<String, String> sqlParams = new HashMap<String, String>();
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("postno", postNumber);
        sqlParams.put("userid", userId);
        try {
            executeQuery(sqlFile, sqlParams);
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

}
