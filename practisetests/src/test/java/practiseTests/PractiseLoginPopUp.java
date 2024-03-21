package practiseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practise.common.utils.Browsersconfig;

public class PractiseLoginPopUp {
	private WebDriver driver;
	  @BeforeTest
	  public void setUp() throws IOException
	  {
		Properties properties = new Properties();
	  	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
	  	properties.load(file);
	  	String browser = properties.getProperty("browser");
	  	driver = Browsersconfig.createDriver(browser);
	  	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/basic_auth");
	  }
	  @Test
	  public void loginPopUp()
	  {
		  driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		  WebDriverWait wait=new WebDriverWait(this.driver, Duration.ofSeconds(10));
		  WebElement element=driver.findElement(By.xpath("//p[contains(text(),'!')]"));
		  wait.until(ExpectedConditions.visibilityOf(element));
		  String s=element.getText();
		  Assert.assertTrue(s.contains("Congratulations!"), "logged in");
	  }
	  @AfterTest
	  public void tearDown()
	  {
		  driver.quit();
	  }

}
