package practiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.PractiseDropDownBootstrap;
import practise.common.pages.PractiseFrames;
import practise.common.utils.Browsersconfig;

public class PractiseDropDown {
	private WebDriver driver;
	private PractiseDropDownBootstrap practisepage;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(PractiseDropDownBootstrap.loadProperties());
		practisepage = new PractiseDropDownBootstrap(driver);
		PractiseDropDownBootstrap.browserSetup(driver);
	}
	 @AfterMethod
	    public void tearDown() {	
			driver.quit();
	    }
	 @Test
	 public void selectDropDown() throws InterruptedException
	 {
		 practisepage.selectFromDropDown("Angular");
	 }

}
