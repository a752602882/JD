package Pro;

import Handle.UserInfoPageHandle;
import Unit.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;

public class UserInfoPagePro {

    public  UserInfoPageHandle uiph;
    public  BaseDriver driver;
    public   UserInfoPagePro(BaseDriver driver){
        uiph = new UserInfoPageHandle(driver);
        this.driver =driver;
    }

    /**
     * 选中所有兴趣
     */
    public  void selectAllHobby(){

        for (int i=0;i< uiph.getHobbyeSize();i++) {
            String  js_string = "document.getElementsByName('hobbyType')[" + i + "].className='selected'";
            JavascriptExecutor js = (JavascriptExecutor) driver.driver;
            js.executeScript(js_string);
        }
    }

    /**
     *  跳转到MoreInfo页面
     */
    public  void JumpAndSetMoreInfo(String id){
        uiph .clickMoreInfoElement();
       // uiph.selectJdradio(); 这个radio单选还没解决
        uiph.setCID(id);
        uiph.setEducation(2);
        uiph.setMonthlyIncome(2);
        uiph.setIndustryInfo(2);
    }





}
