package pages;

import org.openqa.selenium.*;
//import org.testng.Assert;
import utils.WaitUtils;

public class ProductPage {

    WebDriver driver;
    WaitUtils waitUtils;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    //By addToCart = By.xpath("//div[text()='Buy with EMI']/ancestor::*[10]/div[1]");
    By addToCart = By.xpath("//div[text()='Add to cart']");
    //By addToCart = By.xpath("//div[text()='Buy with EMI']//parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div//*[name()='svg']");
    By goToCart = By.xpath("//a[@title='Cart']");

    public void addProductToCart() {

    	waitUtils.waitForClickable(addToCart).click();
    	waitUtils.waitForClickable(goToCart).click();
    }
    
}
