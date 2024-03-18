package practise.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseMouseOver {
	private WebDriver driver;
	public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
    	
        }
	public PractiseMouseOver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://corporate.spicejet.com/default.aspx");
    }
    public void mouseOver() throws InterruptedException
    {
    	//Thread.sleep(3000);
    	WebElement element=driver.findElement(By.id("highlight-addons" ));
    	Actions action=new Actions(driver);
    	action.build().perform();
    	Thread.sleep(6000);
    }
    public void selectDate(String dateValue)
    {
    	WebElement element=driver.findElement(By.xpath("(//button[@class=\"ui-datepicker-trigger\"])[1]"));
    	WebDriverWait wait=new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js=((JavascriptExecutor)driver)  ;  
        js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');",element);
    }
}
