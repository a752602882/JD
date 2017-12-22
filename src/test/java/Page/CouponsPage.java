package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

//优惠券页面
public class CouponsPage extends BasePage {


    public CouponsPage(BaseDriver driver) {
        super(driver);
    }


    /**
     * 获得“电脑办公”Elemennt
     */
    public WebElement getComputerOfficeElement() {

        return element_v3(GetByLocator.getByLocator_v4("computerOfficeText"));
    }


    /**
     * 读取此页所有优惠券
     */
    public List<WebElement> getQuanListElement() {
        return elements(element_v3(GetByLocator.getByLocator_v4("cate-cont")), GetByLocator.getByLocator_v4("quan-item"));
    }



    /**
     * 获得单个优惠券抵用金额元素
     */
    public WebElement getQuanPriceElement(WebElement quan) {
        WebElement fatherNode = element(quan, GetByLocator.getByLocator_v4("q-price"));
        return element(fatherNode, GetByLocator.getByLocator_v4("q-price-node"));

    }

    /**
     * 获得单个优惠券使用限制元素
     */
    public WebElement getQuanLimitElement(WebElement quan) {
        return element(element(quan, GetByLocator.getByLocator_v4("q-price")), GetByLocator.getByLocator_v4("q-price-limit"));
    }

    /**
     * 获得单个优惠券使用限制元素
     */
    public WebElement getProgressElement(WebElement quan) {
        return element(element(quan, GetByLocator.getByLocator_v4("q-progress")), GetByLocator.getByLocator_v4("q-progress-txt"));
    }

    /**
     * 获得单个优惠券使用限制元素
     */
    public WebElement getQuanIsHaveElement(WebElement quan) {
        return element(element(quan, GetByLocator.getByLocator_v4("q-opbtns")), GetByLocator.getByLocator_v4("q-opbtns-a-span"));
    }

    /**
     * 获得单个优惠券名字  元素
     */
    public WebElement getQuanTicket_nameElement(WebElement quan) {
        return element(element(quan, GetByLocator.getByLocator_v4("q-range")), GetByLocator.getByLocator_v4("q-range-span"));
    }
}
