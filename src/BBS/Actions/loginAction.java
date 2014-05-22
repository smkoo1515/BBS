package BBS.Actions;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsSession;
import BBS.BbsView;
import BBS.Beans.UserInfoBean;

public class loginAction extends BbsAction{
    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String id = (String) req.getParameter("id");
        String passwd = (String) req.getParameter("passwd");
        BbsView view = new BbsView();
        UserInfoBean userInfo = new UserInfoBean();
        String sqlFile="getUserInfoFromId.sql";
        Map<String, String> sqlParams = new HashMap<String, String>();
        sqlParams.put("id", id);
        sqlParams.put("passwd", passwd);
        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        try {
            executeQuery(sqlFile, sqlParams);
            result = getResult();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        if(result.size() == 1){
            userInfo.setId(result.get(0).get("id"));
            userInfo.setName(result.get(0).get("name"));
            userInfo.setEmail(result.get(0).get("email"));
            userInfo.setAuth(result.get(0).get("auth"));
            userInfo.setGender(result.get(0).get("gender"));
            BbsSession session = new BbsSession();
            session.login(req,userInfo);
        }

        view.setViewPage("Index.jsp");
        view.setRedirect(true);
        return view;
    }
=======
import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;

public class loginAction extends BbsAction{

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();


        return view;
    }

>>>>>>> heo
}
