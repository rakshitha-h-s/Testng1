package practiseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practise.common.utils.Browsersconfig;

public class CheckBrokenLinkstest {
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
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @Test
  public void checkLinks() throws InterruptedException
  {
	  Thread.sleep(4000);
	  List<WebElement> linkLists=driver.findElements(By.tagName("a"));
	  linkLists.addAll(driver.findElements(By.tagName("img")));
	  System.out.println(linkLists);
	  List<WebElement> activeLinks=new ArrayList<WebElement>();
	  for(int i=0;i<linkLists.size();i++)
	  {
		  if(linkLists.get(i).getAttribute("href")!=null)
		  {
			  activeLinks.add(linkLists.get(i));
		  }
	  }
	  for(int j=0;j<activeLinks.size();j++)
	  {
		  try {
			HttpURLConnection connection=(HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j)+" "+response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		  
	  }
  }
	  @AfterTest
	  public void tearDown()
	  {
		  driver.quit();
	  }
	  
	  

}
