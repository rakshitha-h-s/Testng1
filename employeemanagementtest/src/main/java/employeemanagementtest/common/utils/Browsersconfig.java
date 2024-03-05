package employeemanagementtest.common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsersconfig {
	public static WebDriver createDriver(String browser){
		WebDriver driver = null;
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