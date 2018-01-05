package Case;

import Pro.LoginPagePro;
import Pro.MainPagePro;
import Pro.MyInfoPagePro;
import Unit.BaseDriver;
import Unit.HandleCookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;



public class Login extends CaseBase {

    public LoginPagePro loginPagePro;
    public MainPagePro mainPagePro;
    public MyInfoPagePro myInfoPagePro;
    public BaseDriver driver;
    public HandleCookie cookie;

    @BeforeClass
    public void  init(){
        driver =   InitDriver("chrome");
        loginPagePro = new LoginPagePro(driver);
        mainPagePro = new MainPagePro(driver);
        myInfoPagePro = new MyInfoPagePro(driver);
        cookie = new HandleCookie(driver);
        driver.get("https://passport.jd.com/new/login.aspx");
        // getLoginHome();
        driver.setSleep(10);

    }


    @Test
    public  void testLogin()
    {
        loginPagePro.login("752602882@qq.com","5423110ppp");
        String handle_old= driver.getHandle();
        mainPagePro.loginClickName();

        //写入cookie
        cookie.writeCookie();

   //     switchPage(handle_old);
   //     System.out.println(myInfoPagePro.AssertName("我的名字还未想好"));



    }


    private void switchPage(String handle_old) {
        Set<String> handles =driver.getHandles();
        for (String handle:handles){
            if (handle.equals(handle_old)){
                continue;
            }
            driver.jumpOtherPage(handle);
            break;
        }
    }


    @AfterClass
    public void end(){
        driver.stop();
    }
}
