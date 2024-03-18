package practiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.PractiseBasePopUps;
import practise.common.utils.Browsersconfig;

public class PractiseUploadfile {
	private PractiseBasePopUps practisePage;
	private WebDriver driver;
	
    @BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(PractiseBasePopUps.loadProperties());
		practisePage = new PractiseBasePopUps(driver);
		PractiseBasePopUps.browserSetup1(driver);
	}
    @Test
    public void popUpTest() throws InterruptedException
    {
    	practisePage.uploadFile();
    }
    @AfterMethod
    public void tearDown() {	
		driver.quit();
    }

}
