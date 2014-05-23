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
            view.setViewPage("/BBS/writePost.jsp");
        }else if(Command.equals("Modify")){
            view.setViewPage("/BBS/modifyPost.jsp");
        }else{
            ReadPost read = new ReadPost(req);
            return read.getView();
        }
        return view;
    }
}
