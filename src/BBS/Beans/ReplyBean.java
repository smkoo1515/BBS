package BBS.Beans;

public class ReplyBean {
    private int index;
    private int postNumber;
    private int replyNumber;
    private String userId;
    private String userName;
    private String content;
    private String replyDate;
    private String deleteFlag;
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getPostNumber() {
        return postNumber;
    }
    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }
    public int getReplyNumber() {
        return replyNumber;
    }
    public void setReplyNumber(int replyNumber) {
        this.replyNumber = replyNumber;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getReplyDate() {
        return replyDate;
    }
    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }
    public String getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
