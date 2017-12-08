package Unit;

import org.openqa.selenium.By;

public class GetByLocator {


    public static By getByLocator(String key,String value){
        switch (key){
            case "name":  return By.name(value);
            case "id": return  By.id(value);
            case "className": return By.className(value);
            case "xpath":return By.xpath(value);
            case "linkText":return  By.linkText(value);
            case "partialLinkText":return  By.partialLinkText(value);
            case "tagName":return  By.tagName(value);
            case "cssSelector":return  By.cssSelector(value);
            default:return  null;
        }
    }


    public static By getByLocator_v4(String key){

        ProUnit proUnit = new ProUnit("element.properties");
         String  tag = proUnit.getPro(key).split(">")[0];
         String  value = proUnit.getPro(key).split(">")[1];
        switch (tag){
            case "id": return  By.id(value);
            case "name":  return By.name(value);
            case "className": return By.className(value);
            case "xpath":return By.xpath(value);
            case "linkText":return  By.linkText(value);
            case "partialLinkText":return  By.partialLinkText(value);
            case "tagName":return  By.tagName(value);
            case "cssSelector":return  By.cssSelector(value);
            default:return  null;

        }
    }
}
