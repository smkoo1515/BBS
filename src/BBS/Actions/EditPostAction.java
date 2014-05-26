package BBS.Actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
import BBS.Beans.PostBean;

public class EditPostAction extends BbsAction{

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();
        String bbsName = (String) req.getParameter("BBS");
        String title = req.getParameter("TITLE");
        String content = req.getParameter("CONTENT");
        String postno = req.getParameter("POSTNO");
        Map<String, Object> postMap = new HashMap<>();
        PostBean post = new PostBean();
        post.setContent(content);
        post.setTitle(title);
        post.setPostNumber(Integer.parseInt(postno));
        postMap.put("bbsName", bbsName);
        postMap.put("post", post);
        view.setModelMap(postMap);
        view.setViewPage("/POST/editPost.jsp");
        return view;
    }
}
