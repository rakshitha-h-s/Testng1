package employeemanagement.common.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
private  WebDriver driver;
    
    @FindBy(how = How.CSS, using = "[name='username']")
    private WebElement usernameElement;

    @FindBy(how = How.CSS, using = "[name='password']")
    private WebElement passwordElement;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(how = How.XPATH, using = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElement pimButton;


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 public void setUsername(String username) {
	    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(usernameElement));
	        usernameElement.sendKeys(username);
	    }

	    public void setPassword(String password) {
	    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	         wait.until(ExpectedConditions.visibilityOf(passwordElement));
	        passwordElement.sendKeys(password);
	    }

	    public void clickLoginButton() {
	    	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(loginButton));
	        loginButton.click();
	    }

	    public void clickPimButton() {
	    	 WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	         wait.until(ExpectedConditions.visibilityOf(pimButton));
	        pimButton.click();
	    }

	    public boolean isLoginSuccessful() {
	        return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    }
	    public boolean isAdminPage()
	    {
	    	return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
	    }

}
