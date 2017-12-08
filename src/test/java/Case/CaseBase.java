package Case;

import Unit.BaseDriver;

public class CaseBase {
    public BaseDriver InitDriver(String brower){
        return  new BaseDriver(brower);
    }
}
