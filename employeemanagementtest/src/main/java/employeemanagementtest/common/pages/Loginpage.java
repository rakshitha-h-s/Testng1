package employeemanagementtest.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import employeemanagementtest.common.utils.Browsersconfig;

public class Loginpage {
    private static WebDriver driver;
    private Properties properties;
    
    public static String loadProperties() throws IOException {
    Properties properties = new Properties();
	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
	properties.load(file);
	String browser = properties.getProperty("browser");
	return browser;
	
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public void username(String username) {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
    	usernameElement.sendKeys("Admin");
    }
    public void password(String password) {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
    	usernameElement.sendKeys("admin123");

    }
    public void loginButton() {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
     	WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
     	usernameElement.click();
    }

    public void adminButton()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"))).click();
    }

    public Loginpage(WebDriver driver){
    	    this.driver=driver;
    	    System.out.println(this.driver);
    }


    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
    public static void closeBrowser()
    {
    	
			    try {
					driver.quit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
    }
}
