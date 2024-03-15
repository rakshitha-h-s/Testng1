package employeemanagementtest.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseFrames {
	private WebDriver driver;
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	private WebElement username;
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	private WebElement password;
	@FindBy(how=How.XPATH,using="//input[@value='Login' and @type='submit']")
	private WebElement login;
	public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
    	
        }
	public PractiseFrames(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/");
    }
    public void setUsernameAndPassword()
    {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("rakshitha");
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Test@1");
        wait.until(ExpectedConditions.visibilityOf(login));
        login.click();
        driver.switchTo().frame("mainpanel");
        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
        
    }
    public void highLightElement()
    {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(login));
    	JavascriptExecutor js=((JavascriptExecutor) driver);
    	String bgColor=login.getCssValue("backgroundColor");
    	for(int i=0;i<10;i++) {
    		changeColor("rgb(0,200,0)",login,driver);
    		changeColor(bgColor,login,driver);
    	}
    }
    public void changeColor(String color,WebElement element,WebDriver driver)
    {
    	JavascriptExecutor js=((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
    	try {
    		Thread.sleep(2000);
    	}
    	catch(InterruptedException e){
    	
    	}
    }
    public void getTitle()
    {
    	JavascriptExecutor js=((JavascriptExecutor) driver);
    	String title=js.executeScript("return document.title;").toString();
    	System.out.println(title);
    }
    public void selectDateAndMonth(String date1)
    {
    	driver.switchTo().frame("mainpanel");
    	String date2[]=date1.split("-");
    	String day=date2[0];
    	String month=date2[1];
    	String year=date2[2];
    	Select monthXpath=new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
    	monthXpath.selectByVisibleText(month);
    	Select yearxpath=new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
    	yearxpath.selectByVisibleText(year);
    	String beforeXpath="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
    	String afterXpath="]/td[";
    	final int totalWeekDays=7;
    	for(int rowNum=2;rowNum<=7;rowNum++) {
    		for(int colNum=1;colNum<=totalWeekDays;colNum++) {
    			String dayValue=driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
    			
    		}
    	}
    }
}
