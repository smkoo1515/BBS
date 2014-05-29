package BBS.Actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
import BBS.Beans.ReplyBean;

public class ViewReplyAction extends BbsAction {

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        String bbsName = req.getParameter("BBS");
        String postNumber = req.getParameter("POSTNO");

        int replyCount = getReplyCount(bbsName, postNumber);
        req.setAttribute("replyCount", replyCount);
        List<ReplyBean> replyList = selectReplyListFrom(bbsName, postNumber);
        if(replyList != null){
            BbsView view = new BbsView();
            Map<String,Object> replyMap = new HashMap<String,Object>();
            replyMap.put(bbsName+"@"+postNumber, replyList);
            view.setModelMap(replyMap);
            view.setViewPage("REPLY/reply.jsp");
            return view;
        }
        return null;
    }

    private List<ReplyBean> selectReplyListFrom(String bbsName, String postNumber) {
        Map<String, String> sqlParams = new HashMap<String, String>();
        String sqlFile = "selectReplyList.sql";
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("postno", postNumber);

        List<ReplyBean> replyList = new ArrayList<ReplyBean>();
        try{
            ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
            executeQuery(sqlFile, sqlParams);
            result = getResult();

            for(int i=0; i < result.size(); i++){
                ReplyBean replyBean=new ReplyBean();
                replyBean.setReplyNumber(Integer.parseInt(result.get(i).get("replyno")));
                replyBean.setUserId((result.get(i).get("userid")));
                replyBean.setUserName((result.get(i).get("username")));
                replyBean.setContent(result.get(i).get("content"));
                replyBean.setReplyDate(result.get(i).get("replydate"));

                replyList.add(replyBean);
            }
            return replyList;
        }
        catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        return null;
    }

    private int getReplyCount(String bbsName, String postNumber){
        Map<String, String> sqlParams = new HashMap<String, String>();
        String sqlFile = "getReplyCount.sql";
        sqlParams.put("bbsName", bbsName);
        sqlParams.put("postno", postNumber);

        try {
            ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
            executeQuery(sqlFile,sqlParams);
            result = getResult();
            int replyCount = Integer.parseInt(result.get(0).get("count(*)"));
            return replyCount;
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return 0;
    }

}
