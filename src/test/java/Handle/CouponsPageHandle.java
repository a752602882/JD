package Handle;

import Page.CouponsPage;
import Unit.BaseDriver;

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
}
