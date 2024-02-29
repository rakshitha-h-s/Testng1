package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestOpenBrowser {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rakshita/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	@Test
	public void searchTest()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Test
	public void googleLogoTest()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
     	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
     	boolean b =element.isDisplayed();
		//boolean b=driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.print(b);
	}
	@Test
	public void linkTest() {
		WebDriverWait wait = new WebDriverWait(driver,10);
     	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Gmail")));
     	boolean b =element.isDisplayed();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
