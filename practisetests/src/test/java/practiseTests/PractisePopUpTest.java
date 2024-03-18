package practiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.Loginpage;
import practise.common.pages.PractiseBase;
import practise.common.pages.PractiseBasePopUps;
import practise.common.utils.Browsersconfig;

public class PractisePopUpTest {
	private PractiseBasePopUps practisePage;
	private WebDriver driver;
	
    @BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(PractiseBasePopUps.loadProperties());
		practisePage = new PractiseBasePopUps(driver);
		PractiseBasePopUps.browserSetup(driver);
	}
    @Test 
    public void popUpTest() throws InterruptedException
    {
    	practisePage.popUp();
    }
    @AfterMethod
    public void tearDown() {	
		driver.quit();
    }
}
