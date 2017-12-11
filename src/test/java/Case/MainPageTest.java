package Case;

import Page.MainPage;
import Pro.MainPagePro;
import Unit.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest extends CaseBase{

    public MainPagePro mpp;
    public BaseDriver driver;

    @BeforeClass
     public void init()
     {
         driver = InitDriver("chrome");
         mpp= new MainPagePro(driver);
         driver.get("https://www.jd.com/");
         driver.setSleep();
     }

    /**
     * 点击搜索框
     */

    @Test
    public  void  testSerach(){

       Assert.assertEquals(true,mpp.serachIsEqualsData(),"读取文件和搜索结果返回不一致");
    }
    @Test
    public  void testSerachUpFile(){
        mpp.serachUp();
    }
}
