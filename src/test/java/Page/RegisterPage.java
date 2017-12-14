package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

public class RegisterPage extends  BasePage {
    public RegisterPage(BaseDriver driver) {
        super(driver);
    }

    //获得“同意并继续”按钮
    public WebElement getAgreeButton(){
       return elementNode(GetByLocator.getByLocator_v4("ui-dialog"),GetByLocator.getByLocator_v4("agreeButton"));

    }

    /**
     * 获得“用户名输入框”
     */
    public WebElement getUserNameElement(){
      return element_v3(GetByLocator.getByLocator_v4("regName"));
    }

    /**
     * 获得“密码输入框”
     */
    public WebElement getPwdElement(){
        return element_v3(GetByLocator.getByLocator_v4("pwd"));
    }

    /**
     * 获得“确认输入框”
     */
    public WebElement getPwdRepeatElement(){
        return element_v3(GetByLocator.getByLocator_v4("pwdRepeat"));
    }

    /**
     * 获得“注册按钮”
     */
    public WebElement getRegisterButtonElement(){
        return element_v3(GetByLocator.getByLocator_v4("btn-register"));
    }


    /**
     * 获得“用户名输入框”下方的错误提示信息
     */
    public WebElement getUserNameInfoElement(){
        return elementNode(GetByLocator.getByLocator_v4("span_error1"),GetByLocator.getByLocator_v4("div_span"));
    }

    /**
     * 获得“密码输入框”下方的错误提示信息
     */
    public WebElement getPwdInfoElement(){
        return elementNode(GetByLocator.getByLocator_v4("span_error2"),GetByLocator.getByLocator_v4("div_span"));
    }

    /**
     * 获得“确认输入框”下方的错误提示信息
     */
    public WebElement getPwdRepeatInfoElement(){
        return elementNode(GetByLocator.getByLocator_v4("span_error3"),GetByLocator.getByLocator_v4("div_span"));
    }

}
