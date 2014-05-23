package BBS.Actions;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsSession;
import BBS.BbsView;

public class LogoutAction extends BbsAction{

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        BbsView view = new BbsView();
        BbsSession session = new BbsSession();
        session.logout(req);
        view.setViewPage("/BBS/Index.jsp");
        view.setRedirect(true);
        return view;
    }

}
