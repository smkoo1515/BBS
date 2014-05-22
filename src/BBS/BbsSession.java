package BBS;

import javax.servlet.http.HttpServletRequest;

import BBS.Beans.UserInfoBean;

public class BbsSession{

    public HttpServletRequest login(HttpServletRequest req, UserInfoBean userInfo) {
        userInfo.setPassword(null);
        req.getSession().setAttribute("bbsUserInfo", userInfo);
        return req;
    }

    public HttpServletRequest logout(HttpServletRequest req) {
        req.getSession().removeAttribute("bbsUserInfo");
        return req;
    }

    public boolean check(HttpServletRequest req){
        if((req.getSession(false) != null) && (req.getSession().getAttribute("bbsUserInfo") != null))
            return true;
        else
            return false;
    }
}
