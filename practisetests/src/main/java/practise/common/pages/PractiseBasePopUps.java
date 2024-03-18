package practise.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseBasePopUps {
	private  WebDriver driver;
	@FindBy(how=How.XPATH,using="//button[@class='toggle' and @value='DailyDozen']")
	private WebElement button;
	@FindBy(how=How.XPATH,using="//input[@class='email' and @type='text' and @placeholder='Enter your email']")
	private WebElement input;
	@FindBy(how=How.XPATH,using="//input[@type='file' and @name='fileupload']")
    private WebElement upload;
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @value='submit']")
	private WebElement submit;
	public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
    	
        }
	public PractiseBasePopUps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://account.forbes.com/newsletters");
    }
    public static void browserSetup1(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://html.com/input-type-file/");
    }
    public void popUp() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(input));
        input.sendKeys("rakshithahs040@gmail.com");
    }
    public void uploadFile() throws InterruptedException
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0, 700);"); 
    	Thread.sleep(3000);
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(upload));
        upload.sendKeys("C:\\Users\\Rakshita\\Documents\\mail.txt");
        wait.until(ExpectedConditions.visibilityOf(submit)).click();
        
    }
}
