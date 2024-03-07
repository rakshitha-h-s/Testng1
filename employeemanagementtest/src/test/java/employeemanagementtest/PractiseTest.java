package employeemanagementtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.Loginpage;
import employeemanagementtest.common.pages.PractiseBase;
import employeemanagementtest.common.utils.Browsersconfig;

public class PractiseTest {
	private PractiseBase practisePage;
	private WebDriver driver;
	
    @BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(Loginpage.loadProperties());
		practisePage = new PractiseBase(driver);
	    Loginpage.browserSetup(driver);
	}

    @Test
    public void testLogin() throws InterruptedException {
    	practisePage.setUsername("Admin");
    	practisePage.setPassword("admin123");
    	practisePage.loginButton();
    	practisePage.search();
    	practisePage.adminBar();
    	Thread.sleep(4000);
    	//practisePage.clickLoginButton();       
        //boolean res=loginPage.isLoginSuccessful();
        //System.out.print(res);
        //loginPage.clickPimButton() ;
    }
   @AfterMethod
    public void tearDown() {
	  driver.quit();
    }
    

	   }


