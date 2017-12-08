package Basic.Info;

import Unit.BaseDriver;
import Unit.HandleCookie;
import Unit.ProUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PersonInfo {

    public BaseDriver driver;
    public HandleCookie cookie;

    @BeforeClass
    public void  init(){
        driver = new BaseDriver("chrome");
        driver.get("https://www.jd.com");

        cookie =new HandleCookie(driver);
        cookie.setCookie();
    }
    @Test
    public void testcookie(){
        driver.setSleep();
        driver.get("https://i.jd.com/user/info");


        WebElement iLike =driver.driver.findElement(By.className("hobul"));
        List<WebElement> like_li=iLike.findElements(By.tagName("li"));


        for (int i=0;i<like_li.size();i++) {
            String  js_string = "document.getElementsByName('hobbyType')[" + i + "].className='selected'";
            JavascriptExecutor js = (JavascriptExecutor) driver.driver;
            js.executeScript(js_string);
        }
    }
}
