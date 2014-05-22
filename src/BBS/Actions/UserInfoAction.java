package BBS.Actions;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
       


public class UserInfoAction extends BbsAction {

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("year");
        String interest = req.getParameter("interest");
        String passwd = req.getParameter("passwd");
        
        System.out.println("id :" + id);
        System.out.println("name :" + name);
        System.out.println("email :" +email);
        System.out.println("gender :" +gender);
        System.out.println("birthday :" +birthday);
        System.out.println("interest :" +interest);
        System.out.println("passwd :" +passwd);
        
        String sqlFile="userInfo.sql";
        Map<String, String> sqlParams = new HashMap<String, String>();
        sqlParams.put("id", id);
        sqlParams.put("name", name);
        sqlParams.put("email", email);
        sqlParams.put("gender", gender);
        sqlParams.put("birthday", birthday);
        sqlParams.put("interest", interest);
        sqlParams.put("passwd", passwd);

        try {
            executeQuery(sqlFile, sqlParams);
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        BbsView view = new BbsView();
        view.setViewPage("UserInfoView.do?id=" + id);
        view.setRedirect(true);

        return view;
    }

}




