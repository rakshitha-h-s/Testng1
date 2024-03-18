package practiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.PractiseBasePopUps;
import practise.common.pages.PractiseFrames;
import practise.common.utils.Browsersconfig;

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
    @Test
    public void highLight() throws InterruptedException
    {
    	practisepage.getTitle();
    	practisepage.highLightElement();
    }
    @Test
    public void selectDate() throws InterruptedException
    {
    	practisepage.selectDateAndMonth("31-September-2018");
    }
    @AfterMethod
    public void tearDown() {	
		driver.quit();
    }

}
