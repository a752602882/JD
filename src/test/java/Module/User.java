package Module;

public class User {

    private String userName;
    private String pwd;
    private String pwdRepeat;
    private String userNameInfo;
    private String pwdInfo;
    private String pwdRepeatInfo;

    public String getUserNameInfo() {
        return userNameInfo;
    }

    public void setUserNameInfo(String userNameInfo) {
        this.userNameInfo = userNameInfo;
    }

    public String getPwdInfo() {
        return pwdInfo;
    }

    public void setPwdInfo(String pwdInfo) {
        this.pwdInfo = pwdInfo;
    }

    public String getPwdRepeatInfo() {
        return pwdRepeatInfo;
    }

    public void setPwdRepeatInfo(String pwdRepeatInfo) {
        this.pwdRepeatInfo = pwdRepeatInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwdRepeat() {
        return pwdRepeat;
    }

    public void setPwdRepeat(String pwdRepeat) {
        this.pwdRepeat = pwdRepeat;
    }

    public User() {
        super();
    }
}
