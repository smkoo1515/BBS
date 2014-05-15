package BBS.Beans;

public class BbsContentBean  {
    private int contentNumber;
    private String userId;
    private String contentTitle;



    public int getContentNumber() {
        return contentNumber;
    }
    public void setContentNumber(int contentNumber) {
        this.contentNumber = contentNumber;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getContentTitle() {
        return contentTitle;
    }
    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }
}