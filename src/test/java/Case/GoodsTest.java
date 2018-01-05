package Case;

import Pro.GoodsPagePro;
import Unit.BaseDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoodsTest extends CaseBase
{

    public BaseDriver driver;
    public GoodsPagePro gpp;

    @BeforeClass
    public void init(){
         driver = InitDriver("chrome");
         gpp = new GoodsPagePro(driver);
         driver.get("https://search.jd.com/search?keyword=rx580&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&suggest=1.def.0.V12&wq=Rx&ev=115_93873%5E&uc=0#J_searchWrap");
         driver.setSleep(10);
    }


    /**
     *  遍历 特定网页 所有商品
     */
    @Test
    public  void watchGoodsToBackHomePage(){

        gpp.watchGoodsAndBack();
    }

}
