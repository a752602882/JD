package Case;

import Pro.LoginPagePro;
import Pro.MainPagePro;
import Pro.MyInfoPagePro;
import Unit.BaseDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;



public class Login extends CaseBase {

    public LoginPagePro loginPagePro;
    public MainPagePro mainPagePro;
    public MyInfoPagePro myInfoPagePro;
    public BaseDriver driver;


    @BeforeClass
    public void  init(){
        driver =   InitDriver("chrome");
        loginPagePro = new LoginPagePro(driver);
        mainPagePro = new MainPagePro(driver);
        myInfoPagePro = new MyInfoPagePro(driver);
        driver.get("https://passport.jd.com/new/login.aspx");
        // getLoginHome();
        driver.setSleep();
    }


    @Test
    public  void testLogin()
    {
        loginPagePro.login("752602882@qq.com","5423110ppp");
        String handle_old= driver.getHandle();
        mainPagePro.loginClickName();
        switchPage(handle_old);
        System.out.println(myInfoPagePro.AssertName("我的名字还未想好"));

    }


    private void switchPage(String handle_old) {
        Set<String> handles =driver.getHandles();
        for (String handle:handles){
            if (handle.equals(handle_old)){
                continue;
            }
            driver.JumpOtherPage(handle);
            break;
        }
    }

}
