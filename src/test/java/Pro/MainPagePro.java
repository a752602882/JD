package Pro;

import Handle.MainPageHandle;
import Unit.BaseDriver;
import Unit.POIUtil;
import Unit.ProUnit;
import Unit.SelectionSort;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean serachIsEqualsData(){
        String[] serachValue=null;
        String[]  data ;
        mph.moveToSerach();
        mph.setSerachText("胡");
        if (mph.getSerachReturnEelementSize()>0){
           serachValue=mph.getSerachReturnListValue();

            ProUnit prop  =new ProUnit("search.properties");
             data=prop.getPro("name").split(">");

            List<String> tmp = new ArrayList<String>();
            for(String str:serachValue){
                if (!str.equals(""))
                    tmp.add(str);
            }
            serachValue= tmp.toArray(new String[0]);


            //对两个数组排序
            SelectionSort.sort(data);
            SelectionSort.sort(serachValue);
            if (data==serachValue) {
                System.out.print("数组值相等");
                return true;
            }

            }


        return false;
    }


    /**
     * 在输入框中输入 “rx”  读取ecexc表中数据对照
     */
    public boolean serachIsEqualsDataFromExecl(String path,String sheetName){
        String[] serachValue=null;
        mph.moveToSerach();
        mph.setSerachText("rx");
        if (mph.getSerachReturnEelementSize()>0) {
            serachValue = mph.getSerachReturnListValue();
            Object[][] results= POIUtil.readExcel(path,sheetName);

            String[] readValue = new String[results.length];
            for (int i = 0 ;i<results.length;i++){
               readValue[i]=  results[i][0].toString();
            }
             SelectionSort.sort(readValue);
             SelectionSort.sort(serachValue);

            if (readValue==serachValue) {
                System.out.print("数组值相等");
                return true;
            }
        }
        return  false;
    }
    /**
     * 检验搜索查询功能
     */
    public void serachUp()  {
        mph.clickPhotoButton();

        //方法2：推荐,使用第三方插件获得元素，设计脚本后，制作成exe文件

        try {
            Runtime exe = Runtime.getRuntime();
            exe.exec("openFile.exe");
        } catch (IOException e) {
            System.out.println("Error to run the exe");
            e.printStackTrace();
        }

       /*
        方法1
        mph.setSerachFileUp();
        try {
            pressKeyEvent(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        */
    }

    //按物理按键
    public static void pressKeyEvent(int keycode) throws AWTException {
        Robot robot = new Robot();
//      robot.keyPress(KeyEvent.VK_ENTER);//按下enter键
        robot.keyPress(keycode);
    }

}
