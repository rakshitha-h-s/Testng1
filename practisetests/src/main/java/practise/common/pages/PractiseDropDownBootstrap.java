package practise.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractiseDropDownBootstrap {
	private WebDriver driver;
	@FindBy(how=How.XPATH,using="//button[@data-toggle='dropdown']")
	private WebElement dropdown;
	public static String loadProperties() throws IOException {
        Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return browser;
 }

	public PractiseDropDownBootstrap(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void browserSetup(WebDriver driver)
    {
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_3");
    }
    public void selectFromDropDown(String option) throws InterruptedException
    {
    	WebDriverWait wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(dropdown));
    	dropdown.click();
    	List<WebElement> elements=driver.findElements(By.xpath("//ul[@class=\"multiselect-container dropdown-menu\"]//li//a//label"));
    	for(int i=0;i<elements.size();i++)
    	{
    		String s=elements.get(i).getText();
    		if(option.equals(s))
    		{
    			elements.get(i).click();
    			break;
    		}
    	}
    	Thread.sleep(3000);
    }
}
