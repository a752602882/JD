package Case;

import Pro.CouponsPagePro;
import Pro.MainPagePro;
import Unit.BaseDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CouponsPageTest extends CaseBase {

    public BaseDriver driver;
    public CouponsPagePro cpp;
    @BeforeClass
    public void init()
    {
        driver = InitDriver("chrome");
        cpp= new CouponsPagePro(driver);
        driver.get("https://a.jd.com/");
        driver.setSleep(10);
    }

    @Test
    public void autoCoupons(){
        cpp.autoGetCoupons();  //     .//*[@id='quanlist']/div[6]/div[4]/div/a/span
    }
}
