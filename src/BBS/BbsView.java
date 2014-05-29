//　ビュー

package BBS;

import java.util.HashMap;
import java.util.Map;

public class BbsView {
    //　Redirect、Forward区分
    private boolean isRedirect;
    //　ビューに伝達する情報を保管
    private Map<String,Object> modelMap = new HashMap<String,Object>();
    //　移行するビューにURI
    private String viewPage;


    public Map<String,Object> getModelMap() {
        return modelMap;
    }
    public void setModelMap(Map<String,Object> modelMap) {
        this.modelMap = modelMap;
    }
    public String getViewPage() {
        return viewPage;
    }
    public void setViewPage(String viewPage) {
        this.viewPage = viewPage;
    }
    public boolean isRedirect() {
        return isRedirect;
    }
    public void setRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }
}
