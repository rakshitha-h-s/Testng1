package employeemanagementtest.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseFrames {
	private WebDriver driver;
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	private WebElement username;
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	private WebElement password;
	@FindBy(how=How.XPATH,using="//input[@value='Login' and @type='submit']")
	private WebElement login;
	public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
    	
        }
	public PractiseFrames(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/");
    }
    public void setUsernameAndPassword()
    {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("rakshitha");
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Test@1");
        wait.until(ExpectedConditions.visibilityOf(login));
        login.click();
        driver.switchTo().frame("mainpanel");
        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
        
    }
    
}
