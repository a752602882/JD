package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class BasePage {

    public BaseDriver driver;
    public  BasePage(BaseDriver driver){
        this.driver = driver;
    }

    public WebElement element_v3(By by){
       return driver.driver.findElement(by);
    }
    /**
     * 查找子元素
     */
    public  WebElement elementNode(By father,By child){
         return    element_v3(father).findElement(child);

    }

    /**
     * 查找元素集
     */
    public List<WebElement> elements(WebElement ele, By by){
     return ele.findElements(by);
    }

    /**
     * 点击
     */
    public void click(WebElement element){
        element.click();
    }



    /**
     * 设置值
     */
    public  void setValue_v3(WebElement element,String value){
        element.sendKeys(value);
    }

    /**
     * 获取页面handles
     */
    public String  getHandle(){
       return driver.driver.getWindowHandle();
    }

    /**
     * 获取页面handles
     */
    public Set<String> getHandles(){
        return driver.driver.getWindowHandles();
    }

    /**
     * 判断元素是否存在
     */
    public  boolean isDisplay(WebElement element){
        return element.isDisplayed();
    }

    /**
     * 返回元素文本
     */
    public String getText(WebElement element)
    {
        return element.getText();
    }

    /**
     * 设置元素文本
     */
    public void setText(WebElement element,String key)
    {
         element.sendKeys(key);
    }

    /**
     * 设置是否选中
     */
    public  boolean isSelect(WebElement element){
       return element.isSelected();
    }

    /**
     * 下拉框设置选择
     */
    public  void select(WebElement element,int index){

        Select select = new Select(element);
        select.selectByIndex(index);

    }
    /**
     *  移动鼠标到指定元素
     */
    public void move(WebElement element){
        Actions actions = new Actions(driver.driver);
        actions.moveToElement(element).perform();
    }
    /**
     * 获得元素属性值
     */
    public String getPropertyValue(WebElement element,String prop)
    {
        return element.getAttribute(prop);
    }

    /**
     * 清空输入值
     */
    public void clear(WebElement element){
        element.clear();
    }
}
