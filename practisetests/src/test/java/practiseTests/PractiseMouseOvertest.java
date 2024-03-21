package practiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.PractiseMouseOver;
import practise.common.utils.Browsersconfig;

public class PractiseMouseOvertest {
	private WebDriver driver;
	private PractiseMouseOver practisepage;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(PractiseMouseOver.loadProperties());
		practisepage = new  PractiseMouseOver(driver);
		PractiseMouseOver.browserSetup(driver);
	}
    @Test 
    public void mouseOverTest() throws InterruptedException
    {
    	
    	practisepage.mouseOver();
    }
    @Test
    public void SelectDate() 
    {
    	practisepage.selectDate("17-07-2024");
    }
    @AfterMethod
    public void tearDown() {	
		driver.quit();
    }

}
