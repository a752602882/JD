package Unit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BaseDriver  {

    public WebDriver driver;

    public BaseDriver(String browser){
        SelectDriver selectDriver = new SelectDriver();
        driver = selectDriver.driverName(browser);
        driver.manage().window().maximize();
    }

    public  void stop(){
        System.out.println("关闭driver");
        driver.close();
    }
    /**
     * 封装get
     */
    public  void  get(String url){
        driver.get(url);
    }

    /**
     * 获取页面handles
     */
    public String  getHandle(){
        return driver.getWindowHandle();
    }

    /**
     * 获取页面handles
     */
    public Set<String> getHandles(){
        return driver.getWindowHandles();
    }
    /**
     * 设置超时时间
     */
    public  void setSleep(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     * 跳转页面
     */
    public  void jumpOtherPage(String handle){

        driver.switchTo().window(handle);
    }

    /**
     * 返回上个页面
     */
    public  void back(){
        driver.navigate().back();
    }
    /**
     * 关闭窗口
     */
    public  void close(){
        driver.close();
    }




    public void setCookie(Cookie cookie) {
            driver.manage().addCookie(cookie);
    }

    public Set<Cookie> getCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }
    /**
     * 滑动到页面底部
     */
    public void scrollingToBottom(){

        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
