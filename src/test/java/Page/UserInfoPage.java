package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserInfoPage extends BasePage
{


    public UserInfoPage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 获得兴趣列表
     */
    public List<WebElement> getHobby(){
       return elements(element_v3(GetByLocator.getByLocator_v4("hobul")),GetByLocator.getByLocator_v4("hobbyType"));
    }


    /**
     *点击"更多个人信息"element
     */
    public WebElement getMoreInfoElement(){
       return element_v3(GetByLocator.getByLocator_v4("moreinfo"));
    }


    /**
     * 获得婚姻单选radio
     */
    public List<WebElement> geJdradio(){
        return   elements(element_v3(GetByLocator.getByLocator_v4("fl")),GetByLocator.getByLocator_v4("jdradio"));
    }

    /**
     * 获得身份证号element
     */
    public WebElement getCid(){
        return element_v3(GetByLocator.getByLocator_v4("cid"));
    }

    /**
     * 获得月收入
     */
    public WebElement getMonthlyIncome(){
        return element_v3(GetByLocator.getByLocator_v4("monthlyIncome"));
    }

    /**
     * 获得教育程度element
     */
    public WebElement getEducation(){
        return element_v3(GetByLocator.getByLocator_v4("education"));
    }
    /**
     * 获得所在行业element
     */
    public WebElement getIndustryInfo(){
        return  element_v3(GetByLocator.getByLocator_v4("industryInfo"));
    }
}
