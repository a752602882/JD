package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends  BasePage {

    public MainPage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 获得页面顶部中间用户名
     */
    public WebElement getCenterUserName(){
      return element_v3(GetByLocator.getByLocator_v4("nickname_ele"));
    }


    /**
     *  获得Search输入框element
     */
    public WebElement getSearchElement(){

        return element_v3(GetByLocator.getByLocator_v4("key"));

    }

    /**
     *  获得Search输入框返回值element
     */
    public WebElement getSearchReturnElement(){
        return element_v3(GetByLocator.getByLocator_v4("shelper"));
    }



    /**
     * 获得搜素结果列表element
     */
    public List<WebElement> getReturnElementList(WebElement element){
        return elements(element,GetByLocator.getByLocator_v4("li"));
    }

}
