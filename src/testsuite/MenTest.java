package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.time.Duration;

public class MenTest extends Utility{
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //  Mouse Hover on Men Menu
        WebElement menMenu = findElementFromWebPage(By.cssSelector("li.level0.nav-3>a.level-top.ui-corner-all>span:nth-of-type(1)"));
        //  Mouse Hover on Bottoms
        WebElement bottoms = findElementFromWebPage(By.cssSelector("#ui-id-18 span"));
        //  Click on Pants
        WebElement pants=findElementFromWebPage(By.cssSelector("#ui-id-23 span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menMenu).moveToElement(bottoms).moveToElement(pants).click().build().perform();
        //  Mouse Hover on product name 'Cronus Yoga Pant' and click on size 32.
        WebElement productNameCronus = findElementFromWebPage(By.cssSelector(".product-item-link"));
        WebElement size=findElementFromWebPage(By.cssSelector("[data-role=\"swatch-option-880\"][data-rendered=\"true\"] .swatch-option.text"));
        actions.moveToElement(productNameCronus).moveToElement(size).click().build().perform();
        //  Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        findElementFromWebPage(By.cssSelector("#option-label-color-93-item-49")).click();
        //  Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        findElementFromWebPage(By.cssSelector(".action.tocart.primary")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //   Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText="You added Cronus Yoga Pant to your shopping cart.";
        WebElement actualTextFromElement=findElementFromWebPage(By.cssSelector("[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]"));
        String actualText=actualTextFromElement.getText();
        Assert.assertEquals("Expected text is not coming",expectedText,actualText);
        //   Click on ‘shopping cart’ Link into message
        findElementFromWebPage(By.cssSelector(".message-success.success.message div a")).click();
        //   Verify the text ‘Shopping Cart.’
        String expectedTextShoppingCart="Shopping Cart";
        WebElement actualTextFromShoppingCartElement=findElementFromWebPage(By.cssSelector("main div h1 span"));
        String actualTextShoppingCart=actualTextFromShoppingCartElement.getText();
        Assert.assertEquals("Expected text is not coming",expectedTextShoppingCart,actualTextShoppingCart);
        //   Verify the product name ‘Cronus Yoga Pant’
        String expectedTextCronusPant="Cronus Yoga Pant";
        WebElement actualTextFromCronusPantElement=findElementFromWebPage(By.cssSelector("[data-th=\"Item\"] div strong a"));
        String actualTextCronusPant=actualTextFromCronusPantElement.getText();
        Assert.assertEquals("Expected text is not coming",expectedTextCronusPant,actualTextCronusPant);
        //   Verify the product size ‘32’
        String expectedTextSize="32";
        WebElement actualTextFromSizeElement=findElementFromWebPage(By.cssSelector(".item-options>dd:first-of-type"));
        String actualTextSize=actualTextFromSizeElement.getText();
        Assert.assertEquals("Expected text is not coming",expectedTextSize,actualTextSize);

        //   Verify the product colour ‘Black’
        String expectedTextColour="Black";
        WebElement actualTextColourElement=findElementFromWebPage(By.cssSelector(".item-options>dd:last-of-type"));
        String actualTextColour=actualTextColourElement.getText();
        Assert.assertEquals("Expected text is not coming",expectedTextColour,actualTextColour);

    }
    @After
    public void tearDown() {
        //closeBrowser();
    }

}
