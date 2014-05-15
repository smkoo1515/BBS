package BBS;

import java.util.HashMap;
import java.util.Map;

public class BbsView {
    private boolean isRedirect;
    private Map<String,Object> modelMap = new HashMap<String,Object>();
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
