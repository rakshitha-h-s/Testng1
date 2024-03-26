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
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practise.common.utils.Browsersconfig;

public class PractiseSubmenuClick {private WebDriver driver;

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
	driver.get("http://mrbool.com/");		
	
}
@Test
public void subMenu() 
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	WebElement drop=driver.findElement(By.xpath("//ul[@class=\"navspace menucel ativo2 dm-2\"]//li//a[@class='menulink']"));
	wait.until(ExpectedConditions.visibilityOf(drop));
	Actions action=new Actions(driver);
	action.moveToElement(drop).build().perform();	
	WebElement dropElement=driver.findElement(By.xpath("//*[text()='Articles']"));
	wait.until(ExpectedConditions.visibilityOf(dropElement));
	dropElement.click();
	
}
@AfterTest
public void driverQuit()
{
	driver.quit();
}


}
