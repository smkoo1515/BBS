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

    private int postPerPage = 10;
    private int pages;

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String bbsName = req.getParameter("BBS");
        String pageStr = req.getParameter("PAGE");
        pages = 1;
        if(pageStr != null){
            pages = Integer.parseInt(pageStr);
        }
        req.setAttribute("postPerPage", postPerPage);
        int postCount = getPostCount(bbsName);
        req.setAttribute("postCount", postCount);
        List<PostBean> postList = selectPostListFrom(bbsName);
        if(postList != null){
            BbsView view = new BbsView();
            Map<String,Object> bbsMap = new HashMap<String,Object>();
            bbsMap.put(bbsName, postList);
            view.setModelMap(bbsMap);
            view.setViewPage("BBS/bbs.jsp");
            return view;
        }
        return null;
    }

    private List<PostBean> selectPostListFrom(String bbsName) {
        Map<String, String> sqlParams = new HashMap<String, String>();
        String sqlFile = "selectPostList.sql";
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("startPost", Integer.toString((pages-1)*postPerPage));
        sqlParams.put("postPerPage", Integer.toString(postPerPage));

        List<PostBean> postList = new ArrayList<PostBean>();
        try{
            ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
            executeQuery(sqlFile, sqlParams);
            result = getResult();

            for(int i=0; i < result.size(); i++){
                PostBean postBean=new PostBean();
                postBean.setPostNumber(Integer.parseInt(result.get(i).get("postno")));
                postBean.setUserName(result.get(i).get("username"));
                postBean.setTitle(result.get(i).get("title"));
                postBean.setWriteDate(result.get(i).get("writedate"));
                postBean.setReadCount(Integer.parseInt(result.get(i).get("readcount")));
                postBean.setRecommandCount(Integer.parseInt(result.get(i).get("recommand")));

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

    private int getPostCount(String bbsName){
        Map<String, String> sqlParams = new HashMap<String, String>();
        String sqlFile = "getPostCount.sql";
        sqlParams.put("bbsName", bbsName);

        try {
            ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
            executeQuery(sqlFile,sqlParams);
            result = getResult();
            int postCount = Integer.parseInt(result.get(0).get("count(*)"));
            return postCount;
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return 0;
    }

}
