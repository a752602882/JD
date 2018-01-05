package Handle;

import Page.GoodsPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

public class GoodsPageHandle {
    public GoodsPage goodsPage;

    public GoodsPageHandle(BaseDriver driver) {
        goodsPage = new GoodsPage(driver);
    }

    /**
     * 获得每个商品的根节点,记录总数
     */
    public int getGoodsSize() {
       return goodsPage.getGoodsNodeElement().size();
    }

    /**
     * 点击单个商品图片的那部分
     */
     public  void clickGoodPic(String  value1,String value2){
        WebElement picture =  goodsPage.getGoodPictureElement(value1,value2);
        goodsPage.click(picture);
     }

}
