package Handle;

import Page.LoginPage;
import Unit.BaseDriver;

public class LoginPageHandle {


    public LoginPage lp;

    public LoginPageHandle(BaseDriver driver){
        lp = new LoginPage(driver);
    }

    /**
     * 点击 linktext"账户登录"的element
     */
    public void clickLoginTabText(){
        lp.click(lp.getLoginTabText());
    }

    /**
     * 设置用户名的值
     */
    public void setUsername(String username){
       lp.setValue_v3(lp.getUsername(),username);
    }

    /**
     * 设置密码的值
     */
    public void setPassword(String password){
       lp.setValue_v3(lp.getPassword(),password);
    }

    /**
     * 点击登陆element
     */
    public void clickLoginButton(){
        lp.click(lp.getLoginButton());
    }
    /**
     * 判断页面是否显示
     * @return
     */
    public  boolean isDisplay() {
        return  lp.isDisplay(lp.getLoginTabText());
    }

}
