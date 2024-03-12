package employeemanagementtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.PractiseBasePopUps;
import employeemanagementtest.common.pages.PractiseFrames;
import employeemanagementtest.common.utils.Browsersconfig;

public class PractiseFramesTest {
	private WebDriver driver;
	private PractiseFrames practisepage;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(PractiseFrames.loadProperties());
		practisepage = new PractiseFrames(driver);
		PractiseFrames.browserSetup(driver);
	}
    @Test 
    public void popUpTest() throws InterruptedException
    {
    	practisepage.setUsernameAndPassword();
    }
    @AfterMethod
    public void tearDown() {	
		driver.quit();
    }

}
