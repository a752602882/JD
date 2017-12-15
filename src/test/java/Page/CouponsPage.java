package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

//优惠券页面
public class CouponsPage extends BasePage{


    public CouponsPage(BaseDriver driver) {
        super(driver);
    }


    /**
     * 获得“电脑办公”Elemennt
     */
    public WebElement getComputerOfficeElement(){

       return element_v3(GetByLocator.getByLocator_v4("computerOfficeText"));
    }

}
