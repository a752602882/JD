package Case;

import Pro.MainPagePro;
import Unit.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class MainPageTest extends CaseBase{

    public MainPagePro mpp;
    public BaseDriver driver;

    @BeforeClass
     public void init()
     {
         driver = InitDriver("chrome");
         mpp= new MainPagePro(driver);
         driver.get("https://www.jd.com/");
         driver.setSleep(10);
     }

    /**
     * 点击搜索框
     */

    @Test
    public  void  testSerach(){

       Assert.assertEquals(true,mpp.serachIsEqualsData(),"读取文件和搜索结果返回不一致");
    }

    @Test
    public  void  testSerach_ReadExcel(){

        Assert.assertEquals(true,mpp.serachIsEqualsDataFromExecl("serachHistoryt.xlsx","Sheet1"),"读取文件和搜索结果返回不一致");
    }

    @Test
    public  void testSerachUpFile(){
        mpp.serachUp();
    }


    @AfterClass
    public void end(){
        driver.stop();
    }

    /**
     * 滑动到页面底部
     */
    @Test
    public void scrollingToBottomOfPage(){

      driver.scrollingToBottom();

    }


}
