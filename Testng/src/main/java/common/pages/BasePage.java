package common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	 private  WebDriver driver;
	@FindBy(how=How.NAME,using="username")
	WebElement username1;
	@FindBy(how=How.CSS,using="[name='password']")
	WebElement password1;
	public void setUsername(String username) {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username1));
        username1.sendKeys(username);
    }
	public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setPassword(String password) {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(password1));
         password1.sendKeys(password);
    }
    public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
    	
        }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
