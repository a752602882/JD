package Pro;

import Handle.MainPageHandle;
import Unit.BaseDriver;
import Unit.ProUnit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MainPagePro {

    public MainPageHandle mph;

    public MainPagePro(BaseDriver driver){
        mph = new MainPageHandle(driver);
    }

    public void loginClickName(){
        mph.clickCenterUserName();
    }


    /**
     * 在搜索框输入文字，检验返回值是否和数据库匹配
     */
    public  void  serachIsEqualsData(){

        List<String> serachValue = new ArrayList<>();
        mph.moveToSerach();
        mph.setSerachText("胡");
        if (mph.getSerachReturnEelementSize()>0){
           serachValue=mph.getSerachReturnListValue();

            ProUnit prop  =new ProUnit("search.properties");
            String[]  data = prop.getPro("name").split(">");
            for(int i=0;i< data.length;i++)
                 System.out.print(data[i]);

            }


    }


}
