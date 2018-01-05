package Handle;

import Page.MainPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageHandle {

    public MainPage mainPage;
    public WebElement serachElement;
    public List<WebElement> liElement;

    public MainPageHandle(BaseDriver driver){
        mainPage = new MainPage(driver);
    }

    /**
     * 点击该元素
     */
    public  void clickCenterUserName(){
        if(mainPage.isDisplay(mainPage.getCenterUserName())) {
            mainPage.click(mainPage.getCenterUserName());
        }
    }


    /**
     * 把鼠标移动到搜索框
     *
     */
    public void moveToSerach(){
      serachElement= mainPage.getSearchElement();
        if(mainPage.isDisplay(serachElement)){
            mainPage.move(serachElement);
        }
        mainPage.click(serachElement);
    }



    /**
     * 设置输入框值
     */
    public void setSerachText(String key){
        mainPage.setText(serachElement,key);
    }

    /**
     * 获得搜索框弹出的返回的li
     */
    public int getSerachReturnEelementSize(){
     liElement =null;
     WebElement element =  mainPage.getSearchReturnElement();
     liElement = mainPage.getReturnElementList(element);
     return  liElement.size();


    }
    /**
     * 获得搜索关键字返回的提示值(数组)
     */
    public String[] getSerachReturnListValue(){

        int size = liElement.size();
        if (size>0){
            String[] serach = new String[size];
         for (int i = 0;i<size;i++) {
             serach[i]= mainPage.getPropertyValue(liElement.get(i),"title");
         }

         return serach;
        }
        return null;
    }

    /**
     * 点击搜索照片按钮
     */
    public  void clickPhotoButton(){
      mainPage.click( mainPage.getPhotoSearchButtonElement());
    }


    /**
     * 设置上传图片搜索
     */
    public  void setSerachFileUp(){
        mainPage.setText(mainPage.getUpSearchfile(),"C:\\Users\\Administrator\\Desktop\\用例思路\\检查用.jpg");
    }


}
