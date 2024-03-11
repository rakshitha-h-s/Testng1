package employeemanagementtest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.Loginpage;
import employeemanagementtest.common.pages.PractiseBase;
import employeemanagementtest.common.utils.Browsersconfig;

public class PractiseTestTwo {
	private WebDriver driver;
	private PractiseBase practisePage;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(Loginpage.loadProperties());
		practisePage = new PractiseBase(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.ebay.in/n/all-categories/");
	}
	@Test
	public void dropDown() throws InterruptedException
	{
		practisePage.clickCheckBox();	
		Thread.sleep(4000);	
	}
		
	
	@AfterMethod
    public void tearDown() {
	  driver.quit();
    }
}
