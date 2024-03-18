package practiseTests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.PractiseBasePopUps;
import practise.common.pages.PractisePopUpWindow;
import practise.common.utils.Browsersconfig;

public class PractisePopUpWindowTest {
	private PractisePopUpWindow practisepopup;
	private WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(PractisePopUpWindow.loadProperties());
		practisepopup = new PractisePopUpWindow(driver);
		PractisePopUpWindow.browserSetup(driver);
	}
	
	@Test
	public void windowHandles() throws InterruptedException
	{
		practisepopup.clickButton();
		practisepopup.switchwindow();
		
	}
	@AfterMethod
    public void tearDown() {	
		driver.quit();
    }

}
