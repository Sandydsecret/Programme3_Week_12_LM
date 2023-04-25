package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //  Mouse Hover on Gear Menu
        doMouseHoverNoClick(By.cssSelector("a[id='ui-id-6'] span:nth-child(2)"));
        //  Click on Bags
        clickOnElement(By.cssSelector("a[id='ui-id-25'] span"));
        //  Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle ')]"));
        //  Verify the text ‘Overnight Duffle’
        verifyElements("Message does not displayed as requirement", "Overnight Duffle", By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        //  Change Qty 3
        sendTextToElement(By.id("qty"), Keys.DELETE + "3");
        //  Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));
        //  Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyElements("You added Overnight Duffle to your shopping cart.", "You added Overnight Duffle to your shopping cart.", By.xpath("//div[contains(text(),'You added Overnight Duffle to your ')]"));
        //  Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        //  Verify the product name ‘Cronus Yoga Pant’
        verifyElements("Expected Text is not Displayed","Overnight Duffle", By.cssSelector("td[class='col item'] strong[class='product-item-name']"));
        //  Verify the Qty is ‘3’
        verifyElements("Expected Text is not Displayed","", By.cssSelector("td[class='col qty'] input[class*='input-text qty']"));
        //  Verify the product price ‘$135.00’
        verifyElements("Expected Text is not Displayed","$135.00",By.xpath("//td[@class='col subtotal']//span[@class='price']"));
        //  Change Qty to ‘5’
        sendTextToElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), Keys.DELETE + "5");
        //  Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        //  Verify the product price ‘$225.00’
        verifyElements("","$225.00",By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"));
    }
}
