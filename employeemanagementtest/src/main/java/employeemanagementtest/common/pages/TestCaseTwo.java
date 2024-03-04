package employeemanagementtest.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestCaseTwo {
	private static WebDriver driver;
	
	public static void loginStep(Loginpage loginPage) throws InterruptedException
	{
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

}
