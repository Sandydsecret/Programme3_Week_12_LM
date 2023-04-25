package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get Text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * This method will find an element
     */
    public WebElement findElementFromWebPage(By by){
        return driver.findElement(by);
    }
    /**
     * This method will find the list of elements
     */
    public List<WebElement> findElementsFromWebPage(By by){
        return driver.findElements(by);
    }
    /**
     *
     */
    public void doVerifyElements(By by, String expectedMessage,String displayMessage ) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);

    }
    /**
     *  This method will verify the element
     */
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
    /**
     * This method will use to hover mouse on element
     */
    public void doMouseHoverNoClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }


    public void selectByVisibleTextFromDropdown(By by,String text){
        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByVisibleText(text);
    }
}
