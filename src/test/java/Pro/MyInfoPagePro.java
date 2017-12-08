package Pro;

import Handle.MyInfoPageHandle;
import Unit.BaseDriver;

public class MyInfoPagePro {

    public MyInfoPageHandle miph;

    public  MyInfoPagePro(BaseDriver driver){
        miph = new MyInfoPageHandle(driver);
    }


    /**
     * 判断名字是否合理
     */
    public boolean AssertName(String name){
        System.out.println(miph.getUsername());
        if (miph.getUsername().equals(name)){
            return true;
        }
        return false;
    }

}
