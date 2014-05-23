package BBS;

import javax.servlet.http.HttpServletRequest;

import BBS.Beans.UserInfoBean;

public class BbsSession{

    public static final String BBSSESSION = "bbsUserInfo";

    public HttpServletRequest login(HttpServletRequest req, UserInfoBean userInfo) {
        userInfo.setPassword(null);
        req.getSession().setAttribute(BBSSESSION, userInfo);

        return req;
    }

    public HttpServletRequest logout(HttpServletRequest req) {
        req.getSession().removeAttribute(BBSSESSION);
        return req;
    }

    public boolean check(HttpServletRequest req){
        if((req.getSession(false) != null) && (req.getSession().getAttribute(BBSSESSION) != null))
            return true;
        else
            return false;
    }
}
