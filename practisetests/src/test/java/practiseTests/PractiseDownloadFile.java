package practiseTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import practise.common.utils.Browsersconfig;

public class PractiseDownloadFile {
    private WebDriver driver;
    private File folder;
    
	@BeforeTest
	public void setUp() throws IOException
	{
		Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	driver =createDriver(browser);
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=23");		
		
	}
	private WebDriver createDriver(String browser) {
		// TODO Auto-generated method stub
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		WebDriver driver;
		 switch (browser.toLowerCase()) {
	        case "chrome":
	        	ChromeOptions options = new ChromeOptions();
	        	Map<String, Object> prefs = new HashMap<String, Object>();
	        	prefs.put("profile.default_content_settings.popups", 0);
	        	prefs.put("download.default_directory", folder.getAbsolutePath());
	        	options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
	            break;
	        case "firefox":
	        	
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	        default:
	            System.out.println("Invalid browser specified. Defaulting to Chrome.");
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            break;
	    }
	    return driver;
	}
	@Test
	public void downloadFile() throws FindFailed, InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/download");
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Renato.pdf')]"));
		element.click();
		Thread.sleep(3000);
		File[] file=folder.listFiles();
		Assert.assertTrue(file.length != 0,"folder size is zero");
		for(File file1:file)
		{
			Assert.assertTrue(file1.length()!= (long)0,"file size is zero");
		}
	}
	@AfterTest
	public void driverQuit()
	
	{
		driver.quit();
		for(File file:folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}
}
