package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

public class LoginPage extends  BasePage {

    public LoginPage(BaseDriver driver) {
        super(driver);
    }

    /**
     *  获得linktext=密码登录的element
     */
    public  WebElement  getLoginTabText(){
        return element_v3(GetByLocator.getByLocator_v4("acount_value"));
    }

    /**
     *  获得登录按钮的element
     */
    public  WebElement  getLoginButton(){
        return element_v3(GetByLocator.getByLocator_v4("login_btn"));
    }

    /**
     *  获得用户输入框element
     */
    public WebElement getUsername(){
       return element_v3(GetByLocator.getByLocator_v4("username_ele"));
    }


    /**
     *  获得密码输入框element
     */
    public WebElement getPassword(){
        return element_v3(GetByLocator.getByLocator_v4("password_ele"));
    }

    public  boolean isDisplay(WebElement element){
        return element.isDisplayed();
    }
}
