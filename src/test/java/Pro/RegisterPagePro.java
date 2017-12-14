package Pro;

import Handle.RegisterPageHandle;
import Module.User;
import Unit.BaseDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class RegisterPagePro {

    public RegisterPageHandle pgh;
    public  BaseDriver driver;

    public RegisterPagePro(BaseDriver driver){
       pgh=   new  RegisterPageHandle(driver);
       this.driver =driver;
    }

    /**
     * 点击同意按钮
     */
    public  void clickAgree(){
        pgh.clickAgreeButton();
    }

    /**
     *  注册填写字段
     */
    public  void register(User user){
        pgh.setUserNameElement(user.getUserName());
        pgh.setPwdElement(user.getPwd());
        pgh.setPwdRepeatElement(user.getPwdRepeat());
        pgh.clickRegisterButtonElement();

     //   driver.setSleep(10);
        //判断提示信息是否和Execl文件中读取的一致
        String userName =  pgh.getUserNameInfoText();
        String password =  pgh.getPwdInfoText();
        String passwordRe =  pgh.getPwdRepeatInfoText();

        Assert.assertEquals(userName,user.getUserNameInfo());
        Assert.assertEquals(password,user.getPwdInfo());
        Assert.assertEquals(passwordRe,user.getPwdRepeatInfo());


    }
}
