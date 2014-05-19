package BBS.Actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
import BBS.Beans.PostBean;

public class ViewBbsAction extends BbsAction {

    private int postPerPage = 5;

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String bbsName = req.getParameter("BBS");
        req.setAttribute("postPerPage", postPerPage);
        List<PostBean> postList = selectPostList(bbsName);
        if(postList != null){
            BbsView view = new BbsView();
            Map<String,Object> bbsMap = new HashMap<String,Object>();
            bbsMap.put(bbsName, postList);
            view.setModelMap(bbsMap);
            view.setViewPage("/BBS/" + bbsName + ".jsp");
            return view;
        }
        return null;
    }

    private List<PostBean> selectPostList(String bbsName) {
        String tmpSql = "select * from " + bbsName + " order by postno desc limit " + postPerPage;
        List<PostBean> postList = new ArrayList<PostBean>();
        try{
            ResultSet rs = executeQuery(tmpSql);

            while(rs.next()){
                PostBean postBean=new PostBean();
                postBean.setPostNumber(Integer.parseInt(rs.getString("postno")));
                postBean.setUserId(rs.getString("userid"));
                postBean.setUserName(rs.getString("username"));
                postBean.setTitle(rs.getString("title"));
                postBean.setContent(rs.getString("content"));
                postBean.setWriteDate(rs.getString("writedate"));
                postBean.setReadCount(Integer.parseInt(rs.getString("readcount")));
                postBean.setRecommandCount(Integer.parseInt(rs.getString("recommand")));
                postBean.setDeleteFlag(rs.getString("delflg"));

                postList.add(postBean);
            }
            return postList;
        }
        catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        return null;
    }
}
