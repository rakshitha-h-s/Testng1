package practiseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practise.common.utils.Browsersconfig;

public class PractiseDragandDrop {
	WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		driver = Browsersconfig.createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");		
		
	}
	@Test
	public void subMenu() 
	{
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
       Actions action=new Actions(driver);
       wait.until(ExpectedConditions.visibilityOf(drag));
       wait.until(ExpectedConditions.visibilityOf(drop));
       action.clickAndHold(drag).moveToElement(drop).release().build().perform();;
		
		
		
	}
	@AfterTest
	public void driverQuit()
	{
		driver.quit();
	}


}
