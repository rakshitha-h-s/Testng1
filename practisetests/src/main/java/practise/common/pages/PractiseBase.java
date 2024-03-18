package practise.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseBase {
	private  WebDriver driver;
	//Identifying by Name attribute 
	@FindBy(how=How.NAME,using="username")
	WebElement username1;
	//Identifying by Css selector
	@FindBy(how=How.CSS,using="[name='password']")
	WebElement password1;
	//Identifying by classname
	@FindBy(how = How.CLASS_NAME, using = "oxd-button")
	private WebElement loginButton;
	//Identifying by tagname
	@FindBy(how=How.TAG_NAME,using="input")
	private WebElement search;
	//Identifying by Link text
	@FindBy(how=How.LINK_TEXT,using="Admin")
	private WebElement adminIcon;
	@FindBy(how=How.ID,using="gh-cat")
	WebElement cat;
	public void clickCheckBox() {
	WebDriverWait wait1 = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	Select select = new Select(driver.findElement(By.id("gh-cat")));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-cat")));
	select.selectByVisibleText("Automotive");
}
	public void setUsername(String username) {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username1));
        username1.sendKeys(username);
    }
	public PractiseBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setPassword(String password) {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(password1));
         password1.sendKeys(password);
    }
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
    public void loginButton() {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(loginButton));
         loginButton.click();
    }
    public void search()
    {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(search));
        search.sendKeys("ADMIN");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
    }
    public void adminBar()
    {
    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminIcon));
        adminIcon.click();
    }

}
