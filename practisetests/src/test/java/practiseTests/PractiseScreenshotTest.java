package practiseTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practise.common.pages.PractisePopUpWindow;
import practise.common.utils.Browsersconfig;

public class PractiseScreenshotTest {
	private WebDriver driver;

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
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=23");		
		
	}
	@Test
	public void takeImage() throws FindFailed
	{
		Screen s = new Screen();
        Pattern pauseImg=new Pattern("/practisetests/Play.PNG");
		s.wait(pauseImg, 100);
	    s.click();
	    s.click();
		
	}
	@AfterTest
	public void driverQuit()
	{
		driver.quit();
	}

}
