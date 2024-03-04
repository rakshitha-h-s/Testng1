package employeemanagementtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	@Test
	public void searchByEmployeeName() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
     	
        WebElement employeename = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")));
        employeename.sendKeys("sanjana");
        WebElement button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
        button.click();
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(6000);
        
	}
	@Test
	public void searchByEmployeeId() throws InterruptedException
	{   
		TestCaseTwo.loginStep(loginPage);
	   WebDriverWait wait = new WebDriverWait(driver,40);
	   WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")));
	   element.sendKeys("0249");
	   Thread.sleep(3000);
	   WebElement button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
       button.click();
       
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,700)");
       Thread.sleep(5000);
	}
	@Test
	public void searchByJobTitle() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
        WebElement drop=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i")));
        drop.click();
         Thread.sleep(4000);
         WebElement drop1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i")));
         int n=4;
         Actions actions = new Actions(driver);
         if (drop1.isDisplayed() && drop1.isEnabled()) {
        	
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
         actions.sendKeys(Keys.ENTER).perform();
         WebElement button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
         button.click();
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,700)");
         Thread.sleep(10000);
        Thread.sleep(1000);
	}
	
	@Test
	public void searchByEmployeeStatus() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
		
		 WebElement drop=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
		 drop.click();
		 Thread.sleep(4000);
		 WebElement drop1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
		 int n=3;
		 Actions actions = new Actions(driver);
         if (drop1.isDisplayed() && drop1.isEnabled()) {
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
         actions.sendKeys(Keys.ENTER).perform();
         Thread.sleep(6000);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))).click();
        
         
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,700)");
         Thread.sleep(5000);
	}
	@Test
	public void searchBySupervisorName() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
		   WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[5]/div/div[2]/div/div/input")));
		   element.sendKeys("Odis");
		   Thread.sleep(3000);
		   Actions actions=new Actions(driver);
		   actions.sendKeys(Keys.ARROW_DOWN).perform();
		   actions.sendKeys(Keys.ENTER).perform();
		   Thread.sleep(3000);
		   WebElement button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
	       button.click();
	       
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,700)");
	       Thread.sleep(8000);
		
	}
	@Test
	public void searchByIncludeCategory() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
		 WebElement drop=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")));
		 drop.click();
		 WebElement drop1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")));
		 int n=2;
		 Actions actions = new Actions(driver);
         if (drop1.isDisplayed() && drop1.isEnabled()) {
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
         actions.sendKeys(Keys.ENTER).perform();
         Thread.sleep(6000);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))).click();
        
         
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,700)");
         Thread.sleep(5000);
	}
	@Test
	public void serchBySubUnit() throws InterruptedException{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
		 WebElement drop=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]")));
		 drop.click();
		 WebElement drop1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]")));
		 int n=2;
		 Actions actions = new Actions(driver);
         if (drop1.isDisplayed() && drop1.isEnabled()) {
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
         actions.sendKeys(Keys.ENTER).perform();
         Thread.sleep(6000);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))).click();
        
         
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,700)");
         Thread.sleep(5000);
		
	}
	@Test
	public void searchByEmployeenameandJobTitle() throws InterruptedException
	{
		TestCaseTwo.loginStep(loginPage);
		WebDriverWait wait = new WebDriverWait(driver,40);
        WebElement employeename = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")));
        employeename.sendKeys("sanjana");
        Thread.sleep(1000);
        WebElement drop=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div")));
        drop.click();
         Thread.sleep(4000);
         WebElement drop1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div")));
         int n=2;
         Actions actions = new Actions(driver);
         if (drop1.isDisplayed() && drop1.isEnabled()) {
        	 
        	 int i=1;
        	 while(i<=n)
        	 {
        		 actions.sendKeys(Keys.ARROW_DOWN).perform();
    		     Thread.sleep(1000);
    		     i++;
        	 }
        }
        actions.sendKeys(Keys.ENTER).perform();
         Thread.sleep(6000);
         WebElement button=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")));
         button.click();
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,700)");
         Thread.sleep(10000);
	}
	
	@AfterMethod
    public void tearDown() {
		 Loginpage.closeBrowser();
    }

}
