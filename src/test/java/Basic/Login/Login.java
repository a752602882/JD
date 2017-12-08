package Basic.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Login
{

    public WebDriver driver;

    /**
     * 登录流程
     */
    @Test
    public void login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://passport.jd.com/new/login.aspx");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("账户登录")).click();
        driver.findElement(By.id("loginname")).sendKeys("752602882@qq.com");
        driver.findElement(By.id("nloginpwd")).sendKeys("5423110ppp");

        driver.findElement(By.className("login-btn")).click();
        sleep(2000);

        String main_handle=driver.getWindowHandle();

        //验证部分
        driver.findElement(By.className("nickname")).click();
        sleep(2000);
        //交换页面handle
        switchPage(main_handle);

        WebElement element=driver.findElement(By.className("u-name"));
        List<WebElement> username_Element  =element.findElements(By.tagName("a"));
        for (WebElement node :username_Element){
            if (node.getText().equals("我的名字还为想好"));{
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
