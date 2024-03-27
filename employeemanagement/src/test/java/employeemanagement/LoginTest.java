package employeemanagement;

import org.testng.Assert;
import org.testng.annotations.Test;

import employeemanagement.common.pages.LoginPage;
import employeemanagement.common.utils.BasePage;

public class LoginTest extends BasePage {
	private LoginPage login;
	@Test
    public void testLogin() throws InterruptedException {
        login=getLogin(); 
boolean res1=login.isLoginPage();
if(!res1) {
	Assert.fail("Not login page");
}
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();       
        boolean res=login.isLoginSuccessful();
        if(!res) {
        	Assert.fail("Not dashboard");
        }
        login.clickPimButton() ;
    }
}
