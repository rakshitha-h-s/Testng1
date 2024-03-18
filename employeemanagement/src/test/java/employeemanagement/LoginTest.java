package employeemanagement;

import org.testng.annotations.Test;

import employeemanagement.common.pages.LoginPage;
import employeemanagement.common.utils.BasePage;

public class LoginTest extends BasePage {
	private LoginPage login;
	@Test
    public void testLogin() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();       
        boolean res=login.isLoginSuccessful();
        login.clickPimButton() ;
    }
}
