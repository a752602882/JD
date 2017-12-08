package Handle;

import Page.UserInfoPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserInfoPageHandle {

    public UserInfoPage uip;

    public  UserInfoPageHandle(BaseDriver driver)
    {
        uip= new UserInfoPage(driver);
    }

    /**
     * 返回总共获得的兴趣数量
     */
    public  int getHobbyeSize(){
     return   uip.getHobby().size();
    }

    /**
     * 点击"更多个人信息"element
     */
    public  void clickMoreInfoElement(){
        if (uip.isDisplay(uip.getMoreInfoElement())) {
            uip.click(uip.getMoreInfoElement());
        }else {
            System.out.println("没有发现元素uip："+uip.getMoreInfoElement());
        }
    }


   //         moreInfo页面


    /**
     *  设置婚姻状态
     */
    public void selectJdradio(){

      List<WebElement> jdradio =uip.geJdradio();

      if (!uip.isSelect(jdradio.get(0))){
          uip.click(jdradio.get(0));
      }

    }

    /**
     * 设置身份证号码
     */
    public void setCID(String key){
        uip.setText(uip.getCid(),key);
    }

    /**
     * 设置月收入
     */
    public  void setMonthlyIncome(int index){
        uip.select(uip.getMonthlyIncome(),index);
    }

    /**
     * 设置教育程度
     */
    public  void setEducation(int index){
        uip.select(uip.getEducation(),index);
    }

    /**
     * 设置所在行业
     */
    public  void setIndustryInfo(int index){
        uip.select(uip.getIndustryInfo(),index);
    }


}
