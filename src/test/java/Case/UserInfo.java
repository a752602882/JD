package Case;

import Pro.UserInfoPagePro;
import Unit.BaseDriver;
import Unit.HandleCookie;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserInfo extends  CaseBase {

    public UserInfoPagePro uipp;
    public BaseDriver driver;
    public HandleCookie cookie;

    @BeforeClass
    public void init(){
        driver = InitDriver("chrome");
        driver.get("https://i.jd.com/user/info");
        uipp = new UserInfoPagePro(driver);
        cookie =new HandleCookie(driver);
        cookie.setCookie();
        driver.setSleep();
    }

    @Test
    public void selectAllHobby(){


        driver.get("https://i.jd.com/user/info");
        uipp.selectAllHobby();
    }

    @Test
    public void setMoreInfo(){
        driver.get("https://i.jd.com/user/info");
        uipp.JumpAndSetMoreInfo("500223199206147716");
    }
}
