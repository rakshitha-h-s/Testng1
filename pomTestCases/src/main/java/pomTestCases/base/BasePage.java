package pomTestCases.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	static WebDriver driver;
    static Properties property;
    public BasePage(){
    	try {
    	property = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		property.load(file);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public static void createDriverSetUp(){
    	String browser1 = property.getProperty("browser");
        driver = createDriver(browser1);
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(property.getProperty("url"));
		
}
    public static WebDriver createDriver(String browser){
		 switch (browser.toLowerCase()) {
	        case "chrome":
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            break;
	        case "firefox":
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	        default:
	            System.out.println("Invalid browser specified. Defaulting to Chrome.");
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            break;
	    }
	    return driver;
}
}
