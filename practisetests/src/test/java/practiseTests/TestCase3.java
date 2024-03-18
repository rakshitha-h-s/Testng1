package practiseTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practise.common.pages.Loginpage;
import practise.common.pages.TestCaseThree;
import practise.common.utils.Browsersconfig;

public class TestCase3 {
	private Loginpage loginPage;
    private WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(Loginpage.loadProperties());
	    loginPage = new Loginpage(driver);
	    Loginpage.browserSetup(driver);
	}
	@AfterMethod
    public void tearDown() {	
		driver.quit();
    }
	@Test
	public void testAddLanguage() throws InterruptedException
	{
		TestCaseThree.loginStep(loginPage);
		TestCaseThree testCaseTwo = new TestCaseThree(driver);
		testCaseTwo.clickAdminButton(loginPage);
		testCaseTwo.clickQualification();
		testCaseTwo.clickLanguages();
		testCaseTwo.addButton();
		testCaseTwo.inputLanguageField("Kannada");
		testCaseTwo.saveLanguageButton();
	}
	
	@Test
	public void testEditLanguage() throws InterruptedException
	{
		TestCaseThree.loginStep(loginPage);
		TestCaseThree testCaseTwo = new TestCaseThree(driver);
		testCaseTwo.clickAdminButton(loginPage);
		testCaseTwo.clickQualification();
		testCaseTwo.clickLanguages();
		testCaseTwo.editLanguage("Kannada","Kannada1");
		
	}
	@Test
	public void testDeleteLanguage() throws InterruptedException
	{
		TestCaseThree.loginStep(loginPage);
		TestCaseThree testCaseTwo = new TestCaseThree(driver);
		testCaseTwo.clickAdminButton(loginPage);
		testCaseTwo.clickQualification();
		testCaseTwo.clickLanguages();
		testCaseTwo.deleteLanguage("Tamil");
	}

}
