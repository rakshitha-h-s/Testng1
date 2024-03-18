package practise.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import practise.common.utils.Browsersconfig;

public class PractisePopUpWindow {
	private WebDriver driver;

	@FindBy(how=How.XPATH,using="//button[@id='newWindowBtn']")
	private WebElement button;
	public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
    	
        }
	public PractisePopUpWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    }
	public PractisePopUpWindow() {
        PageFactory.initElements(driver, this);
    }
    public WebDriver getDriver()
    {
    	return driver;
    }
    public void clickButton()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }
	public void switchwindow() throws InterruptedException {
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String windowId=it.next();
		String childId=it.next();
		Thread.sleep(4000);
		driver.switchTo().window(childId);
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(windowId);
		System.out.println(driver.getTitle());
	}

}
