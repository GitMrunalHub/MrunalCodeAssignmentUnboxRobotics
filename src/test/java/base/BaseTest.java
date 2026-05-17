package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

	@BeforeMethod
    public void setUp() {
    
    	WebDriverManager.chromedriver().setup();

       driver = new ChromeDriver();

       // Maximize browser window
       driver.manage().window().maximize();
        
       // Open Flipkart
        driver.get("https://www.flipkart.com");
    }

    /**
     * Close browser
     */
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
