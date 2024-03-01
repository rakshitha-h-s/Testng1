package employeemanagementtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }
	
	@Test
	public void login() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
     	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        element.sendKeys("Admin");
        Thread.sleep(1000);
     	WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        element1.sendKeys("admin123");
        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

        loginButton.click();
        Thread.sleep(1000);
        
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", "Redirected to the login page.");
        
        Thread.sleep(1000);
        
        WebElement adminicon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
        adminicon.click();
      
        WebElement employeename = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")));
        employeename.sendKeys("joker");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))).click(); 
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

     // Scroll down by a certain pixel value (e.g., 500 pixels)
     js.executeScript("window.scrollBy(0,700)");

     Thread.sleep(2000);
     js.executeScript("window.scrollBy(0,-700)");
     
   
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))).click();
Thread.sleep(3000); 
js.executeScript("window.scrollBy(0,700)");
Thread.sleep(10000); 
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
