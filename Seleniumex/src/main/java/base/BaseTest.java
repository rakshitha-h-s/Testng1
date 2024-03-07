package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.BrowserConfig;

public class BaseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	@BeforeTest
	public void beforeTestMethod()
	{
		sparkReporter=new ExtentSparkReporter(System.getProperty("use.dir")+File.separator+"reports"+File.separator+"SDETADDAExtentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("AutomationTests Resultsby SDET ADDA");				
	}
   @BeforeMethod
   public void beforeMethod() throws IOException
   {
	    Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
	    properties.load(file);
	    String browser = properties.getProperty("browser");
	    WebDriver driver=BrowserConfig.createDriver(browser);
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://freecrm.com");
   }
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			//logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"-Test code failed", ExtentColor.RED));
		}
	}
	{
		
	}
	

}
