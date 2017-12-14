package Handle;

import Page.RegisterPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageHandle {

    public RegisterPage rg;
    public RegisterPageHandle(BaseDriver driver){
       rg=  new RegisterPage(driver);
    }

    /**
     * 点击同意按钮
     */
    public void clickAgreeButton(){
        rg.click(rg.getAgreeButton());
    }

    /**
     * “用户名”输入框 填写值
     */
    public void setUserNameElement(String value){
       WebElement element= rg.getUserNameElement();
        rg.clear(element);
        rg.setValue_v3(element,value);
    }

    /**
     * “密码”输入框 填写值
     */
    public void setPwdElement(String value){
        WebElement element= rg.getPwdElement();
        rg.clear(element);
        rg.setValue_v3(element,value);
    }

    /**
     * “确认密码”输入框 填写值
     */
    public void setPwdRepeatElement(String value){
        WebElement element= rg.getPwdRepeatElement();
        rg.clear(element);
        rg.setValue_v3(element,value);
    }

    /**
     * 点击“注册”按钮
     */
    public void clickRegisterButtonElement(){
          rg.click(rg.getRegisterButtonElement());
    }

    /**
     * “用户名”下方提示信息设置为显示状态 ,并读取该值
     */
    public String getUserNameInfoText(){
        return rg.getText(rg.getUserNameInfoElement());
    }

    /**
     * “密码”下方提示信息设置为显示状态 ,并读取该值
     */
    public String getPwdInfoText(){
       return rg.getText(rg.getPwdInfoElement());

    }

    /**
     * “确认密码”下方提示信息设置为显示状态 ,并读取该值
     */
    public String getPwdRepeatInfoText(){
        return rg.getText(rg.getPwdRepeatInfoElement());

    }

}
