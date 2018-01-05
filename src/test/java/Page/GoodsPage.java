package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoodsPage extends BasePage {

    public GoodsPage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 获得所有商品的父节点
     */
    public WebElement getGoodsElement() {
        return element_v3(GetByLocator.getByLocator_v4("goods-ul"));
    }

    /**
     * 获得所有商品的子节点
     */
    public List<WebElement> getGoodsNodeElement() {
        return elements(getGoodsElement(), GetByLocator.getByLocator_v4("goods-ul-li"));
    }


    /**
     * 获得单个图片的
     */
    public WebElement getGoodPictureElement(String value1, String value2) {
        WebElement element;
        long startTime = System.currentTimeMillis();
        try {
            element = element_v3(GetByLocator.getByLocator("xpath", value1));
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间：>>>>>>>>>" + (endTime - startTime) + "ms");
            element = element_v3(GetByLocator.getByLocator("xpath", value2));
        }

        return element;
    }
}
