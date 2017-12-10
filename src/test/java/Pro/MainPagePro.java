package Pro;

import Handle.MainPageHandle;
import Unit.BaseDriver;
import Unit.ProUnit;
import Unit.SelectionSort;

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


}
