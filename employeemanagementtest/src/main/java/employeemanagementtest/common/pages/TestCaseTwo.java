package employeemanagementtest.common.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestCaseTwo {
	private WebDriver driver;
	
	public static void loginStep(Loginpage loginPage) throws InterruptedException
	{
		loginPage.setUsername("Admin");
    	Thread.sleep(1000);
     	loginPage.setPassword("admin123");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        Thread.sleep(1000);
        
        boolean res=loginPage.isLoginSuccessful();
        System.out.print(res);
        Thread.sleep(1000);
        loginPage.clickPimButton();
	}
	public TestCaseTwo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
	private WebElement employeeName;
	public void setUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeeName));
       employeeName.sendKeys(username);
   }
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	private WebElement button;
	public void clickButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOf(button));
	     button.click();
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
	private WebElement employeeId;
	public void setEmployeeId(String id)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(employeeId));
	    employeeId.sendKeys(id);
	
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]")
	private WebElement jobTitle;
	public void jobTitleset()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(jobTitle));
	    jobTitle.click();
	}
	public void jobTitleselect(int n) throws InterruptedException
	{
		 //4
         Actions actions = new Actions(driver);
         if (jobTitle.isDisplayed() && jobTitle.isEnabled()) {
        	
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
         actions.sendKeys(Keys.ENTER).perform();
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")
	private WebElement employeeStatus;
	public void employeeSatusSelect()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(employeeStatus));
	    employeeStatus.click();
	}
	public void selectEmployeeStatus(int n) throws InterruptedException
	{
		//3;
		 Actions actions = new Actions(driver);
        if (employeeStatus.isDisplayed() && employeeStatus.isEnabled()) {
       	 int i=1;
       	 while(i<=n)
       	 {
       		 actions.sendKeys(Keys.ARROW_DOWN).perform();
   		     Thread.sleep(1000);
   		     i++;
       	 }
       }
        actions.sendKeys(Keys.ENTER).perform();
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")
	private WebElement includeCategory;
	public void clickIncludeCategory()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(includeCategory));
	    includeCategory.click();
	}
	public void selectIncludeCategory(int n) throws InterruptedException
	{
		 //2;
		 Actions actions = new Actions(driver);
         if (includeCategory.isDisplayed() && includeCategory.isEnabled()) {
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
         actions.sendKeys(Keys.ENTER).perform();
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[5]/div/div[2]/div/div/input")
	private WebElement supervisorName;
	public void superVisor(String name) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(supervisorName));
	    supervisorName.sendKeys(name);
	    Thread.sleep(3000);
	    Actions actions=new Actions(driver);
	    actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();    
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]")
	private WebElement subUnitName;
	public void subUnitName(int n) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(subUnitName));
	    subUnitName.click();
	    Actions actions = new Actions(driver);
        if ( subUnitName.isDisplayed() &&  subUnitName.isEnabled()) {
       	 int i=1;
       	 while(i<=n)
       	 {
       		 actions.sendKeys(Keys.ARROW_DOWN).perform();
   		     Thread.sleep(1000);
   		     i++;
       	 }
       }
        actions.sendKeys(Keys.ENTER).perform();
	}
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
	}

}
