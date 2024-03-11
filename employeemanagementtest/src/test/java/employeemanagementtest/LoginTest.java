package employeemanagementtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.BasePage;
import employeemanagementtest.common.pages.Loginpage;
import employeemanagementtest.common.utils.Browsersconfig;

public class LoginTest {
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
    public void testLogin() throws InterruptedException {
    	loginPage.setUsername("Admin");
    	loginPage.setPassword("admin123");
        loginPage.clickLoginButton();       
        boolean res=loginPage.isLoginSuccessful();
        System.out.print(res);
        loginPage.clickPimButton() ;
    }
   @AfterMethod
    public void tearDown() {
	  driver.quit();
    }
}



   

