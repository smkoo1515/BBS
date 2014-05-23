package BBS.Actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
import BBS.Beans.PostBean;

public class ReadPostAction extends BbsAction{

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();
        String bbsName = req.getParameter("BBS");
        String postNumber = req.getParameter("POSTNO");
        Map<String, Object> postMap = new HashMap<>();
        postMap.put(postNumber, getPost(bbsName,postNumber));
        view.setModelMap(postMap);
        view.setViewPage("/BBS/readPost.jsp");
        return view;
    }

    private PostBean getPost(String bbsName, String postNumber){
        PostBean post = new PostBean();
        String sqlFile="getPostContent.sql";
        Map<String, String> sqlParams = new HashMap<String, String>();
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("postno", postNumber);
        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        try {
            executeQuery(sqlFile, sqlParams);
            result = getResult();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        post.setPostNumber(Integer.parseInt(result.get(0).get("postno")));
        post.setUserId(result.get(0).get("userid"));
        post.setUserName(result.get(0).get("username"));
        post.setTitle(result.get(0).get("title"));
        post.setContent(result.get(0).get("content"));
        post.setWriteDate(result.get(0).get("writedate"));
        post.setReadCount(Integer.parseInt(result.get(0).get("readcount")));
        post.setRecommandCount(Integer.parseInt(result.get(0).get("recommand")));
        return post;
    }

}
