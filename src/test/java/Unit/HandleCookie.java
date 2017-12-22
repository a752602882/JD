package Unit;

import org.openqa.selenium.Cookie;

import java.util.Set;

public class HandleCookie {

    public  BaseDriver driver;
    public  ProUnit proUnit;
    public  HandleCookie(BaseDriver driver){
        this.driver =driver;
        proUnit =new ProUnit("cookie.properties");

    }

    public void setCookie(){
        String value = proUnit.getPro("thor");
        Cookie cookie = new Cookie("thor",value,"jd.com","/",null);
        driver.setCookie(cookie);
    }

    public void setCookie(String key){
        String value = proUnit.getPro(key);
        Cookie cookie = new Cookie(key,"jd.com","/",null);
        driver.setCookie(cookie);
    }

    /**
     * 获取cookie
     * */
    public void writeCookie(){

        Set<Cookie> cookies  = driver.getCookie();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("thor")){
                String cookieValue=cookie.getValue();
                proUnit.writePro(cookie.getName(),cookie.getValue());
                proUnit.writeFile("cookie.properties");
            }
        }
    }



}
