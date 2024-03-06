package employeemanagementtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import employeemanagementtest.common.pages.Loginpage;
import employeemanagementtest.common.pages.TestCaseTwo;
import employeemanagementtest.common.utils.Browsersconfig;

public class TestCase2 {
	private Loginpage loginPage;
    private WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = Browsersconfig.createDriver(Loginpage.loadProperties());
	    loginPage = new Loginpage(driver);
	    Loginpage.browserSetup(driver);
	}
	//searching employee by their names
	@Test
	public void searchByEmployeeName() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setUsername("sanjana");
        testCaseTwo.clickButton();
        Thread.sleep(6000);
        testCaseTwo.scroll();
        Thread.sleep(6000);
        
	}
	//searching employee by their employee id
	@Test
	public void searchByEmployeeId() throws InterruptedException
	{   
	   TestCaseTwo.loginStep(loginPage);
	   TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
	   testCaseTwo.setEmployeeId("0249");
	   Thread.sleep(3000);
	   testCaseTwo.clickButton();      
	   testCaseTwo.scroll();
       Thread.sleep(5000);
	}
	//searching employee by the employee job title
	@Test
	public void searchByJobTitle() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.jobTitleset();
        testCaseTwo.jobTitleselect(4);
        testCaseTwo.clickButton();
        testCaseTwo.scroll();
         Thread.sleep(10000);
	}
	//searching employee by their employee status
	@Test
	public void searchByEmployeeStatus() throws InterruptedException
	{
		
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.employeeSatusSelect();		
         Thread.sleep(6000);
         testCaseTwo.selectEmployeeStatus(3);
         Thread.sleep(6000);
         testCaseTwo.clickButton();
         testCaseTwo.scroll();
         Thread.sleep(5000);
	}
	//searching employee by their supervisor name
	@Test
	public void searchBySupervisorName() throws InterruptedException{
		  TestCaseTwo.loginStep(loginPage);
		  TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		   testCaseTwo.superVisor("Odis");
		   Thread.sleep(3000);
		   testCaseTwo.clickButton();
		   testCaseTwo.scroll();
	       Thread.sleep(8000);
		
	}
	//searching employee by their include category
	@Test
	public void searchByIncludeCategory() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.clickIncludeCategory();
		testCaseTwo.selectIncludeCategory(2);
         Thread.sleep(6000);
         testCaseTwo.clickButton();    
         testCaseTwo.scroll();
         Thread.sleep(5000);
	}
	//searching employee by their sub unit
	@Test
	public void searchBySubUnit() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.subUnitName(2);
        Thread.sleep(6000);
        testCaseTwo.clickButton();    
        testCaseTwo.scroll();
         Thread.sleep(5000);
		
	}
	//searching employee by both employee name and job title
	@Test
	public void searchByEmployeenameandJobTitle() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setUsername("sanjana");
        Thread.sleep(1000);
        testCaseTwo.jobTitleset();
        testCaseTwo.jobTitleselect(4);
        testCaseTwo.clickButton();
        testCaseTwo.scroll();
         Thread.sleep(10000);
	}
	//search employee by passing all the categories
	@Test
	public void searchByAllCategory() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setUsername("sam");
        Thread.sleep(1000);
        testCaseTwo.setEmployeeId("0391");
        Thread.sleep(1000);
        testCaseTwo.employeeSatusSelect();		
        Thread.sleep(3000);
        testCaseTwo.selectEmployeeStatus(3);
        Thread.sleep(1000);
        testCaseTwo.clickIncludeCategory();
		testCaseTwo.selectIncludeCategory(2);
		Thread.sleep(1000);
		testCaseTwo.superVisor("Anas");
		 Thread.sleep(3000);
        testCaseTwo.jobTitleset();
        testCaseTwo.jobTitleselect(4);
        Thread.sleep(1000);
        testCaseTwo.subUnitName(2);
        Thread.sleep(3000);
        testCaseTwo.clickButton();
        testCaseTwo.scroll();
         Thread.sleep(10000);
        
		
	}
	@AfterMethod
    public void tearDown() {
		loginPage.closeBrowser();
    }

}
