package Handle;

import Page.MyInfoPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyInfoPageHandle {

    public MyInfoPage mip;

    public  MyInfoPageHandle(BaseDriver driver){
         mip = new MyInfoPage(driver);
    }


    /**
     * 获得用户名
     */
    public String getUsername(){
        List<WebElement> username_Element =   mip.getnameElements();
        return  mip.getText(username_Element.get(0));

    }
}
