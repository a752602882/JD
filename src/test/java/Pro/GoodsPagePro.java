package Pro;

import Handle.GoodsPageHandle;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class GoodsPagePro {
    public GoodsPageHandle gph;
    public BaseDriver driver;

    public GoodsPagePro(BaseDriver driver) {
        this.driver = driver;
        gph = new GoodsPageHandle(driver);
    }


    /**
     * 遍历所有商品
     */
    public void watchGoodsAndBack() {

        int size = gph.getGoodsSize();
        String handle_old = driver.getHandle();


        for (int i=1;i<=size;i++) {
            String value1 =".//*[@id='J_goodsList']/ul/li["+i+"]/div/div[1]/a/img";
            String value2  = ".//*[@id='J_goodsList']/ul/li["+i+"]/div/div/div[2]/div[1]/div[1]/a/img";

            if (i==12){
                System.out.println(i);
            }

            gph.clickGoodPic(value1,value2);
            driver.setSleep(10);

            //通过handle跳转回到旧页面
            Set<String> allhandles = driver.getHandles();
            for (String handle : allhandles) {
                if (handle.equals(handle_old))
                    continue;
                driver.jumpOtherPage(handle);
                //强制等待1s
             /*  try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            //关闭新弹出的窗口
            driver.close();
            //只有一个页面，获得这个页面的handle
            driver.jumpOtherPage(handle_old);
        }
    }



}

