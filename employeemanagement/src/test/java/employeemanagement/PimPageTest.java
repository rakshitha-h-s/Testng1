package employeemanagement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import employeemanagement.common.pages.LoginPage;
import employeemanagement.common.pages.PimPage;
import employeemanagement.common.utils.BasePage;

public class PimPageTest extends BasePage {
	private PimPage pim;
	private static LoginPage login;
	private static WebDriver driver;
	@Test
	public void searchByEmployeeName() throws InterruptedException
	{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setUsername("sanjana");
        pim.clickButton();
        pim.scroll();
        
	}
	@Test
	public void searchByEmployeeId() throws InterruptedException
	{   
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setEmployeeId("0249");
		pim.clickButton();      
		pim.scroll();
	}
	//searching employee by the employee job title
	@Test
	public void searchByJobTitle() throws InterruptedException{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.jobTitleset();
		pim.setJobTitle("Automaton Tester");
		pim.clickButton();
		pim.scroll();
	}
	@Test
	public void searchByJobTitle1() throws InterruptedException{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setJobTitle("Non-existent Job Title");
		        
	}
	//searching employee by their employee status
	@Test
	public void searchByEmployeeStatus() throws InterruptedException
	{
		
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		//testCaseTwo.employeeSatusSelect();		
		pim.setEmployeeStatus1("Full-Time Probation");
		pim.clickButton();
		pim.scroll();
	}
	//searching employee by their supervisor name
	@Test
	public void searchBySupervisorName() throws InterruptedException{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.superVisor("Bob");
		pim.clickButton();
		pim.scroll();
		
	}
	//searching employee by their include category
	@Test
	public void searchByIncludeCategory() throws InterruptedException{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim.setIncludeCategory("Past Employees Only123432");
		pim.clickButton();    
		pim.scroll();
	}
	//searching employee by their sub unit
	@Test
	public void searchBySubUnit() throws InterruptedException{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setSubUnit("Engineering");
		pim.clickButton();    
		pim.scroll();
		
	}
	//searching employee by both employee name and job title
	@Test
	public void searchByEmployeenameandJobTitle() throws InterruptedException
	{
		login=getLogin(); 
	PimPage.loginStep(login);
	pim=getPimPage();
	pim.setUsername("sanjana");
	pim.jobTitleset();
	pim.setJobTitle("Automaton Tester");
	pim.clickButton();
	pim.scroll();
	}
	//search employee by passing all the categories
	@Test
	public void searchJobTitle1() throws InterruptedException
	{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setJobTitle1("Automation Tester");
		pim.clickButton();
	}
	@Test
	public void includeCategory() throws InterruptedException
	{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setIncludeCategory1("Past Employees Only");
		pim.clickButton();
	}
	@Test
	public void employeeStatus() throws InterruptedException
	{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
	pim.setEmployeeStatus1("Full-Time Contract1");
		pim.clickButton();
	}
	@Test
	public void subUnit() throws InterruptedException
	{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setSubUnit1("Engineering");
		pim.clickButton();
	}
	@Test
	public void testAllCategory() throws InterruptedException	{
		login=getLogin(); 
		PimPage.loginStep(login);
		pim=getPimPage();
		pim.setUsername("sam");
		pim.setEmployeeId("0449");
		pim.setEmployeeStatus1("Full-Time Probation");
		pim.setIncludeCategory1("Current Employees Only");
		pim.superVisor("Odis Adalwin");
		pim.setJobTitle1("Database Administrator");
		pim.setSubUnit1("Engineering");
		pim.clickButton();
		   
	}

}
