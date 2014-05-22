package BBS.Actions;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
import BBS.Beans.PostBean;
import BBS.Beans.UserInfoBean;

public class UserInfoViewAction extends BbsAction {

	@Override
	public BbsView doServiceWith(HttpServletRequest req) {
	
		Map<String, String> sqlParams = new HashMap<String, String>();
		BbsView view = new BbsView();
		String id = req.getParameter("id");
		String sqlFile = "selectUserInfo.sql";
		sqlParams.put("id", id);
		try {
			executeQuery(sqlFile, sqlParams);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		result = getResult();
		
		req.setAttribute("id", result.get(0).get("id"));
		req.setAttribute("name", result.get(0).get("name"));
		req.setAttribute("email", result.get(0).get("email"));
		req.setAttribute("gender", result.get(0).get("gender"));
		req.setAttribute("birthday", result.get(0).get("birthday"));
		req.setAttribute("interest", result.get(0).get("interest"));
		req.setAttribute("passwd", result.get(0).get("passwd"));
		
        System.out.println("id :" + result.get(0).get("id"));
        System.out.println("name :" + result.get(0).get("name"));
        System.out.println("email :" +result.get(0).get("email"));
        System.out.println("gender :" +result.get(0).get("gender"));
        System.out.println("birthday :" +result.get(0).get("birthday"));
        System.out.println("interest :" +result.get(0).get("interest"));
        System.out.println("passwd :" +result.get(0).get("passwd"));
		
		
		view.setViewPage("/BBS/UserInfoView.jsp");
		return view;
	}
}
