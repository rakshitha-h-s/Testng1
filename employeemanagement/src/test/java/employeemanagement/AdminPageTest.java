package employeemanagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import employeemanagement.common.pages.AdminPage;
import employeemanagement.common.pages.LoginPage;
import employeemanagement.common.utils.BasePage;


public class AdminPageTest extends BasePage {
	private static LoginPage login;
	private static WebDriver driver;
	private static AdminPage admin;
	@Test
	public void testAddLanguage() throws InterruptedException
	{
		
		login=getLogin();
		AdminPage.loginStep(login);
		admin=getAdmin();
		admin.clickAdminButton();
		admin.clickQualification();
		admin.clickLanguages();
		admin.addButton();
		admin.inputLanguageField("Kannada");
		admin.saveLanguageButton();
	}
	
	@Test
	public void testEditLanguage() throws InterruptedException
	{
		login=getLogin();
		AdminPage.loginStep(login);
		admin=getAdmin();
		admin.clickAdminButton();
		admin.clickQualification();
		admin.clickLanguages();
		admin.editLanguage("Kannada","Kannada1");
		
	}
	@Test
	public void testDeleteLanguage() throws InterruptedException
	{
		login=getLogin();
		AdminPage.loginStep(login);
		admin=getAdmin();
		admin.clickAdminButton();
		admin.clickQualification();
		admin.clickLanguages();
		admin.deleteLanguage("Tamil");
	}
}
