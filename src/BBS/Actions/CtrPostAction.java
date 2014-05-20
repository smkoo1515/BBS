package BBS.Actions;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;

public class CtrPostAction extends BbsAction {

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();
        req.setAttribute("BBS", req.getParameter("BBS"));
        String Command = req.getParameter("CMD");
        if(Command.equals("Write")){
            view.setViewPage("/BBS/WritePost.jsp");
        }else if(Command.equals("Modify")){
            view.setViewPage("/BBS/ModifyPost.jsp");
        }else{
            view.setViewPage("/BBS/ReadPost.jsp");
        }
        return view;
    }
}
