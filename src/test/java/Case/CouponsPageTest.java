package Case;

import Pro.CouponsPagePro;
import Pro.MainPagePro;
import Unit.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
      boolean isSuccess =  cpp.autoGetCoupons();  //
        Assert.assertEquals(isSuccess,true,"写入execl文件不成功>>>>>>>>>>>");
    }


    @AfterClass
    public void end(){
        driver.stop();
    }
}
