package Basic.Login;

import Page.BasePage;
import Unit.GetByLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

/*
     1 修改GetByLocator.getByLocator方法
     2 参数化
 */
public class Login_v4
{

    public WebDriver driver;
    public BasePage basePage;

    private  String   username = "752602882@qq.com";
    private  String   password = "5423110ppp";

    private  String mainpage_url = "https://passport.jd.com/new/login.aspx";
    private  String  name_value="我的名字还为想好";


    /**
     * 登录流程
     */
    @Test
    public void login() throws InterruptedException {
        init();

        mainPageElementSet();

        String main_handle=getMainPageHandle();

        loginSuccessPageElementSet();

        switchPage(main_handle);

        List<WebElement> username_Element = selfInfoPageElementSet();

        AssertName(username_Element);
    }


    /**
     *  初始化环境
     */
    public  void init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(mainpage_url);
        driver.manage().window().maximize();

    //    basePage =new BasePage(driver);
    }

    /**
     *  主页面元素操作
     */
    public  void  mainPageElementSet() {

        basePage.click(basePage.element_v3(GetByLocator.getByLocator_v4("acount_value")));
        basePage.setValue_v3(basePage.element_v3(GetByLocator.getByLocator_v4("username_ele")),username);
        basePage.setValue_v3(basePage.element_v3(GetByLocator.getByLocator_v4("password_ele")),password);
        basePage.click(basePage.element_v3(GetByLocator.getByLocator_v4("login_btn")));

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  获得主页面句柄
     */
    public String getMainPageHandle(){
        return  basePage.getHandle();
    }

    /**
     *   登录成功后页面元素操作
     */
    public void loginSuccessPageElementSet() throws InterruptedException {
        basePage.click(basePage.element_v3(GetByLocator.getByLocator_v4("nickname_ele")));
        sleep(2000);
    }

    /**
     *  交换页面handle
     */
    private void switchPage(String handle_old) {
       Set<String> handles =basePage.getHandles();
       for (String handle:handles){
           if (handle.equals(handle_old)){
               continue;
           }
           driver.switchTo().window(handle);
           break;
       }
    }
    /**
     * 个人信息页面
     */
    public List<WebElement> selfInfoPageElementSet(){
        WebElement element=basePage.element_v3(GetByLocator.getByLocator_v4("u_name_ele"));
        return basePage.elements(element,GetByLocator.getByLocator_v4("a_tag"));
    }
    /**
     *   断言判读
     */
    public  void AssertName( List<WebElement> username_Element){
        for (WebElement node :username_Element){
            if (node.getText().equals(name_value));{
                System.out.println("登录成功:"+node.getText());
            }
        }
    }
}
