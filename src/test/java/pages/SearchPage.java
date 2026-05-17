package pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import utils.WaitUtils;

import java.util.List;

public class SearchPage {

    WebDriver driver;
    WaitUtils waitUtils;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    By resultText = By.xpath("//span[contains(text(),'results')]");

    By products = By.xpath("//div[contains(@data-id,'MOB')]");

    By compareCheckboxes = By.xpath("//div[contains(@data-id,'MOB')]//label[.//input[@type='checkbox']]");
    
    By compareTrayCount = By.xpath("//span[text()='COMPARE']/../../div/span[2]");

    public void verifySearchResults() {  

        String text = waitUtils.waitForVisibility(resultText).getText();

        Assert.assertTrue(text.contains("results"));
    }

    public void addProductsToCompare() {

    	waitUtils.waitForVisibility(compareCheckboxes);
        List<WebElement> compare = driver.findElements(compareCheckboxes);

        compare.get(9).click();
        compare.get(10).click();
        Assert.assertEquals((waitUtils.waitForVisibility(compareTrayCount)).getText(), "2");
    }

    public void click11thPhone() {

        List<WebElement> phones = driver.findElements(products);
        phones.get(17).click();
    }
}
