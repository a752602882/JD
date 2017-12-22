package Handle;

import Page.CouponsPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CouponsPageHandle  {
    public CouponsPage cp;

    public CouponsPageHandle(BaseDriver driver){
         cp = new CouponsPage(driver);
    }

    /**
     * 点击“电脑办公”选项
     */
    public void clickComputerOffice(){
        cp.click(cp.getComputerOfficeElement());
    }

    /**
     * 获得所有页面元素
     */
    public List<WebElement> getQuanInfo(){
      return cp.getQuanListElement();

    }

    /**
     * 获得优惠券的抵用价格
     */
    public String getQuanPrice(WebElement quan){
       return cp.getText(cp.getQuanPriceElement(quan));
    }
    /**
     * 获得优惠券的抵用价格
     */
    public String getQuanLimit(WebElement quanType){
       return cp.getText(cp.getQuanLimitElement(quanType));
    }

    /**
     * 该优惠券票进度
     */
    public String getQuanPropress(WebElement quanType){
        return cp.getText(cp.getProgressElement(quanType));
    }
    /**
     * 该优惠券票是否拥有文本
     */
    public String getQuanIshave(WebElement quan){
        return cp.getText(cp.getQuanIsHaveElement(quan));
    }


    /**
     * 获得优惠券的抵用价格
     */
    public String getQuanTicket_name(WebElement quan){
        return cp.getText(cp.getQuanTicket_nameElement(quan));
    }
}
