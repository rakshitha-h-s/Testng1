package practiseTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import practise.common.pages.PractiseNavigate;

public class PractiseNavigationsTest extends PractiseNavigate {
	@Test
	public void navigateBrowser() throws InterruptedException
	{
		getDriver().navigate().to("https://www.amazon.com");
		getDriver().navigate().back();
		Thread.sleep(4000);
		getDriver().navigate().forward();
		Thread.sleep(5000);
		getDriver().navigate().refresh();
	}
    @Test
    public void takeScreenShot() throws IOException
    {
    	File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(src,new File("C:\\Users\\Rakshita\\Documents\\google.png"));
    }
  
}
