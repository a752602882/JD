package Pro;

import Handle.CouponsPageHandle;
import Unit.BaseDriver;

public class CouponsPagePro {

    public CouponsPageHandle cph;
    public CouponsPagePro(BaseDriver driver){
        cph = new CouponsPageHandle(driver);
    }

    /**
     * 抢自营卷流程
     */
    public void autoGetCoupons(){
        cph.clickComputerOffice();
    }

}
