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
        testCaseTwo.scroll();
        
	}
	//searching employee by their employee id
	@Test
	public void searchByEmployeeId() throws InterruptedException
	{   
	   TestCaseTwo.loginStep(loginPage);
	   TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
	   testCaseTwo.setEmployeeId("0249");
	   testCaseTwo.clickButton();      
	   testCaseTwo.scroll();
	}
	//searching employee by the employee job title
	@Test
	public void searchByJobTitle() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.jobTitleset();
		testCaseTwo.setJobTitle("Automaton Tester");
        testCaseTwo.clickButton();
        testCaseTwo.scroll();
	}
	//searching employee by their employee status
	@Test
	public void searchByEmployeeStatus() throws InterruptedException
	{
		
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.employeeSatusSelect();		
         testCaseTwo.setEmployeeStatus("Full-Time Probation");
         testCaseTwo.clickButton();
         testCaseTwo.scroll();
	}
	//searching employee by their supervisor name
	@Test
	public void searchBySupervisorName() throws InterruptedException{
		  TestCaseTwo.loginStep(loginPage);
		  TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		   testCaseTwo.superVisor("Odis");
		   testCaseTwo.clickButton();
		   testCaseTwo.scroll();
		
	}
	//searching employee by their include category
	@Test
	public void searchByIncludeCategory() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.clickIncludeCategory();
		testCaseTwo.setIncludeCategory("Past Employees Only");
         testCaseTwo.clickButton();    
         testCaseTwo.scroll();
	}
	//searching employee by their sub unit
	@Test
	public void searchBySubUnit() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setSubUnit("Engineering");
        testCaseTwo.clickButton();    
        testCaseTwo.scroll();
		
	}
	//searching employee by both employee name and job title
	@Test
	public void searchByEmployeenameandJobTitle() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setUsername("sanjana");
        testCaseTwo.jobTitleset();
        testCaseTwo.setJobTitle("Automaton Tester");
        testCaseTwo.clickButton();
        testCaseTwo.scroll();
	}
	//search employee by passing all the categories
	@Test
	public void searchJobTitle1() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setJobTitle("Automaton Tester");
		testCaseTwo.clickButton();
	}
	@Test
	public void includeCategory() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setIncludeCategory("Past Employees Only");
		testCaseTwo.clickButton();
	}
	@Test
	public void employeeStatus() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setEmployeeStatus("Full-Time Probation");
		testCaseTwo.clickButton();
	}
	@Test
	public void subUnit() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setSubUnit("Engineering");
		testCaseTwo.clickButton();
	}
	@Test
	public void testAllCategory() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		TestCaseTwo testCaseTwo = new TestCaseTwo(driver);
		testCaseTwo.setUsername("sam");
        testCaseTwo.setEmployeeId("0449");
        testCaseTwo.setEmployeeStatus("Full-Time Probation");
        testCaseTwo.setIncludeCategory("Current and Past Employees");
        testCaseTwo.superVisor("Amit");
		testCaseTwo.setJobTitle("Content Specialist");
		testCaseTwo.setSubUnit("Engineering");
		testCaseTwo.clickButton();
		   
	}
	@AfterMethod
    public void tearDown() {
		
		driver.quit();
    }

}
