package employeemanagementtest.common.pages;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import employeemanagementtest.common.utils.Browsersconfig;

public class BasePage {
	private  WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		WebDriver driver = Browsersconfig.createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Loginpage loginPage = new Loginpage(driver);
	}
	@AfterMethod
	public void tearDown()
	{
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   
}
