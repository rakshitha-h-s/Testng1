package employeemanagementtest.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import employeemanagementtest.common.utils.Browsersconfig;

public class PractiseNavigate {
	private WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
	Properties properties = new Properties();
	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
	properties.load(file);
	String browser = properties.getProperty("browser");
	driver = Browsersconfig.createDriver(browser);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	public PractiseNavigate() {
        PageFactory.initElements(driver, this);
    }
    public WebDriver getDriver()
    {
    	return driver;
    }
}
