package Pro;

import Handle.CouponsPageHandle;
import Module.Quan;
import Unit.BaseDriver;
import Unit.POIUtil;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class CouponsPagePro {

    public CouponsPageHandle cph;
    public List<WebElement> quanList;
    public BaseDriver driver;

    public CouponsPagePro(BaseDriver driver) {
        cph = new CouponsPageHandle(driver);
        this.driver = driver;
    }


    /**
     * 抢自营卷流程
     */
    public Boolean autoGetCoupons() {
        cph.clickComputerOffice();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quanList = cph.getQuanInfo();
        List<Object[]> quans =new ArrayList<>();
        for (int i=0;i<quanList.size();i++) {


            //单独优惠券页面显示的中间部分节点
            String ticker_name=cph.getQuanTicket_name(quanList.get(i));
            String price = cph.getQuanPrice(quanList.get(i));
            String limit = cph.getQuanLimit(quanList.get(i));
            String propress = cph.getQuanPropress(quanList.get(i));
            String ishave = cph.getQuanIshave(quanList.get(i));
            String[] object = new String[5];
            object[0]=ticker_name;
            object[1]=price;
            object[2]=limit;
            object[3]=propress;
            object[4]=ishave;
            //Quan quan = new Quan(ticker_name,propress,ishave,limit,price);
            quans.add(object);

        }
        String[] titleRow = {"优惠券名","进度","是否拥有","限制","价值"};
        Boolean  isSuccess=  POIUtil.write("quan.xlsx","sheet1",quans,titleRow);
        return isSuccess;
    }

    /**
     * 获得所有自营卷读取信息
     */


}
