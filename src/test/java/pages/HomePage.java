package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    WebDriver driver;
    WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }
    
    By closePopup = By.xpath("//span[(text()='✕')]");
    By searchBox = By.name("q");
    By searchIcon = By.xpath("//button[@type='submit']");

    public void closeLoginPopup() {
    	waitUtils.waitForClickable(closePopup).click();
    }
    public void searchProduct(String product) {
    	waitUtils.waitForVisibility(searchBox).sendKeys(product + "\n");
    	waitUtils.waitForClickable(searchIcon).click();
        
        
    }
}
