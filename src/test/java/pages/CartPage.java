package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

public class CartPage {

    WebDriver driver;
    WaitUtils waitUtils;

    public CartPage(WebDriver driver) {
        this.driver = driver;	
        waitUtils = new WaitUtils(driver);
    }

    By quantityField = By.xpath("//div[text()='Qty: 1']");
    By selectQuantity = By.xpath("//div[text()='2 ']");
    By removeBtn = By.xpath("//div[text()='Remove']");
    By missingCartItems =By.xpath("Missing Cart items?");

    public void increaseQty() {

    	waitUtils.waitForClickable(quantityField).click();
    	waitUtils.waitForClickable(selectQuantity).click();
        Assert.assertTrue(driver.getPageSource().contains("QUANTITY to '2'"));
    }

    public void removeProduct() {

    	waitUtils.waitForClickable(removeBtn).click();
    	Assert.assertEquals((waitUtils.waitForVisibility(missingCartItems)).getText(), "Missing Cart items?");
    }
}
