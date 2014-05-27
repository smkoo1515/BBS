package BBS.Actions;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;

public class MoveAction  extends BbsAction{
    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();
        String page = req.getParameter("PAGE");
        boolean redirect = false;
        if(req.getParameter("REDIRECT") != null){
            redirect = true;
        }
        view.setViewPage(page);
        view.setRedirect(redirect);
        return view;
    }

}
