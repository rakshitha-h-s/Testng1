package employeemanagementtest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.Loginpage;
import employeemanagementtest.common.utils.Browsersconfig;

public class TestCase1 {
	private Loginpage loginPage;
    private WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(Loginpage.loadProperties());
	    loginPage = new Loginpage(driver);
	    Loginpage.browserSetup(driver);
	}
	@Test
	public void ViewAllEmployee() throws InterruptedException
	{
		loginPage.setUsername("Admin");
    	Thread.sleep(1000);
     	loginPage.setPassword("admin123");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        Thread.sleep(1000);
        boolean res=loginPage.isLoginSuccessful();
        System.out.print(res);
        Thread.sleep(1000);
        loginPage.clickPimButton();
       
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(5000);

        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(8000);
   
        js.executeScript("window.scrollBy(0,900)");
        Thread.sleep(5000);

	}
	  @AfterMethod
	    public void tearDown() {
		  loginPage.closeBrowser();
	    }
}
