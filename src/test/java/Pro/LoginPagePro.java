package Pro;

import Handle.LoginPageHandle;
import Unit.BaseDriver;

public class LoginPagePro {

    public LoginPageHandle lph;

    public LoginPagePro(BaseDriver driver){

        lph = new LoginPageHandle(driver);
    }


    /**
     *  登录流程
     */
    public  void  login(String username, String password){

        if (lph.isDisplay()){
            lph.clickLoginTabText();
            lph.setUsername(username);
            lph.setPassword(password);
            lph.clickLoginButton();
        }
    }
}
