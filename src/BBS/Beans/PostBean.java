package BBS.Beans;


public class PostBean  {
    private int postNumber;
    private String userName;
    private String userId;
    private String title;
    private String content;
    private String writeDate;
    private int readCount;
    private int recommandCount;
    private int userNumber;
    private String deleteFlag;

    public int getPostNumber() {
        return postNumber;
    }
    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getReadCount() {
        return readCount;
    }
    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
    public int getRecommandCount() {
        return recommandCount;
    }
    public void setRecommandCount(int recommandCount) {
        this.recommandCount = recommandCount;
    }
    public int getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
    public String getWriteDate() {
        return writeDate;
    }
    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    public String getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }




}