//　セッション処理

package BBS;

import javax.servlet.http.HttpServletRequest;

import BBS.Beans.UserInfoBean;

public class BbsSession{

    //　セッションの名前
    public static final String BBSSESSION = "bbsUserInfo";

    //　ログイン処理
    public HttpServletRequest login(HttpServletRequest req, UserInfoBean userInfo) {
        //　パスワードは保管しない
        userInfo.setPassword(null);
        //　セッションにユーザー情報保管
        req.getSession().setAttribute(BBSSESSION, userInfo);

        return req;
    }

    //　ログアウト処理
    public HttpServletRequest logout(HttpServletRequest req) {
        //　セッション削除
        req.getSession().removeAttribute(BBSSESSION);
        return req;
    }

    //　セッション情報存在有無チェック
    public boolean check(HttpServletRequest req){
        if((req.getSession(false) != null) && (req.getSession().getAttribute(BBSSESSION) != null))
            return true;
        else
            return false;
    }
}
