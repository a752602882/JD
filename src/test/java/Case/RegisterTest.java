package Case;

import Module.User;
import Pro.RegisterPagePro;
import Unit.BaseDriver;
import Unit.POIUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Thread.sleep;


public class RegisterTest extends CaseBase {

    public RegisterPagePro rpp;
    public BaseDriver driver;


    @BeforeClass
    public void init() {
        driver = InitDriver("chrome");
        rpp = new RegisterPagePro(driver);
        driver.get("https://reg.jd.com/reg/person?ReturnUrl=http%3A%2F%2Fwww.jd.com");
        // getLoginHome();
        driver.setSleep(10);
        rpp.clickAgree();
    }

    @DataProvider(name = "testData")
    public Iterator<Object[]> words() {
        Object[][] data = POIUtil.readExcel("register.xlsx", "Sheet1");
       return  change(data);
    }


    @Test(dataProvider = "testData")
    public void testRegister(User user) throws InterruptedException {

        rpp.register(user);


    }

    @AfterClass
    public void end(){
        driver.stop();
    }

    /**
     * 把Sting[][]转化List<User>
     */
    public Iterator<Object[]> change(Object[][] data){
        List<Object> results = new ArrayList<Object>();
        for (int i = 0 ;i<data.length;i++){
            User user = new User();
            for (int j =0;j<data[i].length;j++){
                 switch (j) {
                    case 0: user.setUserName(data[i][j].toString());break;
                    case 1: user.setPwd(data[i][j].toString());break;
                    case 2: user.setPwdRepeat(data[i][j].toString());break;
                    case 3: user.setUserNameInfo(data[i][j].toString());break;
                    case 4: user.setPwdInfo(data[i][j].toString());break;
                    case 5: user.setPwdRepeatInfo(data[i][j].toString());break;
                }
            }
            results.add(user);
        }

           List<Object[]> users = new ArrayList<>();
           for(Object u :results){
               users.add(new Object[]{u});
           }
           return users.iterator();
    }

}
