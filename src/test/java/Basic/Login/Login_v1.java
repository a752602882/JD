package Basic.Login;

import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Login_v1
{

    public WebDriver driver;

    private  String   username = "752602882@qq.com";
    private  String   password = "5423110ppp";

    private  String mainpage_url = "https://passport.jd.com/new/login.aspx";

    private  String  username_ele="loginname";
    private  String  password_ele="nloginpwd";
    private  String  login_btn="login-btn";
    private  String  nickname_ele="nickname";
    private  String  u_name_ele="u-name";

    private  String  name_value="我的名字还为想好";
    private  String  acount_value="账户登录";

    private  String linkText = "linkText";
    private  String name = "name";
    private  String id = "id";
    private  String className = "className";
    private  String xpath = "xpath";
    private  String partialLinkText = "partialLinkText";
    private  String tagName = "tagName";
    private  String cssSelector = "cssSelector";

    /**
     * 登录流程
     */
    @Test
    public void login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(mainpage_url);
        driver.manage().window().maximize();

        driver.findElement(GetByLocator.getByLocator(linkText,acount_value)).click();
        driver.findElement(GetByLocator.getByLocator(id,username_ele)).sendKeys(username);
        driver.findElement(GetByLocator.getByLocator(id,password_ele)).sendKeys(password);

        driver.findElement(GetByLocator.getByLocator(className,login_btn)).click();
        sleep(2000);

        String main_handle=driver.getWindowHandle();

        //验证部分
        driver.findElement(GetByLocator.getByLocator(className,nickname_ele)).click();
        sleep(2000);
        //交换页面handle
        switchPage(main_handle);

        WebElement element=driver.findElement(GetByLocator.getByLocator(className,u_name_ele));
        List<WebElement> username_Element  =element.findElements(By.tagName("a"));
        for (WebElement node :username_Element){
            if (node.getText().equals(name_value));{
                System.out.println("登录成功:"+node.getText());
            }
        }

    }

    private void switchPage(String handle_old) {
       Set<String> handles =driver.getWindowHandles();
       for (String handle:handles){
           if (handle.equals(handle_old)){
               continue;
           }
           driver.switchTo().window(handle);
           break;
       }
    }
}
