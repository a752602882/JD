package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyInfoPage extends  BasePage  {
    public MyInfoPage(BaseDriver driver) {
        super(driver);
    }

    /**
     *
     */
    public List<WebElement> getnameElements(){
        WebElement element=element_v3(GetByLocator.getByLocator_v4("u_name_ele"));
        return elements(element,GetByLocator.getByLocator_v4("a_tag"));
    }
}
