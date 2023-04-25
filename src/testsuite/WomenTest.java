package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //  Mouse Hover on Women Menu
        WebElement womenMenu = findElementFromWebPage(By.cssSelector("a[id='ui-id-4'] span:nth-child(1)"));
        //  Mouse Hover on Tops
        WebElement topsOption = findElementFromWebPage(By.cssSelector("a[id='ui-id-9'] span:nth-child(1)"));
        //  Click on Jackets
        WebElement jacketOption = findElementFromWebPage(By.cssSelector("a[id='ui-id-11'] span:nth-child(1)"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).moveToElement(topsOption).moveToElement(jacketOption).click().build().perform();
        //  Select Sort By filter “Product Name”
        WebElement dropDown = findElementFromWebPage(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByValue("name");

        //  Verify the products name display in alphabetical order
        List<WebElement> elementList = findElementsFromWebPage(By.xpath("//img[starts-with(@class,'product-image-photo')]"));
        System.out.println("Total elements are : " + elementList.size());

        List<WebElement> elementListDisplay = findElementsFromWebPage(By.cssSelector(".products .product-item-info .product-item-name"));
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : elementListDisplay) {

            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList);
        System.out.println(originalProductNameList + "\n");

        List<WebElement> afterSortingElementList=findElementsFromWebPage(By.cssSelector(".products .product-item-info .product-item-name"));
        List<String> afterSortingProductName=new ArrayList<>();
        for(WebElement product:afterSortingElementList){
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted",originalProductNameList,afterSortingProductName);
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //  Mouse Hover on Women
        WebElement womenMenu = findElementFromWebPage(By.cssSelector("a[id='ui-id-4'] span:nth-child(1)"));
        //  Mouse Hover on Tops
        WebElement topsOption = findElementFromWebPage(By.cssSelector("a[id='ui-id-9'] span:nth-child(1)"));
        //  Click on Jackets
        WebElement jacketOption = findElementFromWebPage(By.cssSelector("a[id='ui-id-11'] span:nth-child(1)"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).moveToElement(topsOption).moveToElement(jacketOption).click().build().perform();
        //  Select Sort By filter “Price”
        WebElement dropDown = findElementFromWebPage(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByValue("price");
        //  Verify the products price display in Low to High
        List<WebElement> originalList=findElementsFromWebPage(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
        originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
        }
        System.out.println("Before Sorting: " + originalProductPriceList);
        List<WebElement> afterSortingList = findElementsFromWebPage(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement product : afterSortingList) {
        afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
        }
        Collections.sort(originalProductPriceList);
        System.out.println("After Sorting: " + afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
