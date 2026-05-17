package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
	
	 WebDriver driver;
	 WebDriverWait wait;

	    public WaitUtils(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    }

	    public WebElement waitForVisibility(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	    

	    public WebElement waitForClickable(By locator) {
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    public boolean isElementDisplayed(By locator) {

	        try {
	            return waitForVisibility(locator).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }

}
}
