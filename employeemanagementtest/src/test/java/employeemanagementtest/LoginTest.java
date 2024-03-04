package employeemanagementtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.Loginpage;
import employeemanagementtest.common.utils.Browsersconfig;
import employeemanagementtest.common.pages.Loginpage.*;
public class LoginTest {
 
    private Loginpage loginPage;
     private WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {	
    	
    	   // String browser = Loginpage.loadProperties();
    	    driver = Browsersconfig.createDriver(Loginpage.loadProperties());
    	    loginPage = new Loginpage(driver);
    	    Loginpage.browserSetup(driver);
    	    //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    } 

    @Test
    public void testLogin() throws InterruptedException {
    	loginPage.username("Admin");
    	Thread.sleep(1000);
     	loginPage.password("admin123");
        Thread.sleep(1000);
        loginPage.loginButton();
        Thread.sleep(1000);
        
        boolean res=loginPage.isLoginSuccessful();
        System.out.print(res);
        Thread.sleep(1000);
        loginPage.adminButton();
    }

    @AfterMethod
    public void tearDown() {
        Loginpage.closeBrowser();
    }
}
