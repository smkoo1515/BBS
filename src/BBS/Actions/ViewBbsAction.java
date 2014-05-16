package BBS.Actions;

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

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String bbsName = req.getParameter("BBS");
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
        String tmpSql = "select * from " + bbsName;
        List<PostBean> postList = new ArrayList<PostBean>();
        try{
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(tmpSql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                PostBean postBean=new PostBean();
                postBean.setPostNumber(Integer.parseInt(rs.getString("postno")));
                postBean.setUserId(rs.getString("userid"));
                postBean.setUserName(rs.getString("username"));
                postBean.setTitle(rs.getString("title"));
                postBean.setContent(rs.getString("content"));
                postBean.setWritedate(rs.getString("writedate"));
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
        finally{
            if(rs!=null) try{rs.close();}catch(SQLException sqex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException sqex){}
        }

        return null;
    }
}
