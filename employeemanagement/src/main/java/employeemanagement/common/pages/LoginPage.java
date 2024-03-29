package employeemanagement.common.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import employeemanagement.common.utils.BasePage;

public class LoginPage extends BasePage{
private  WebDriver driver;
private WebDriverWait wait;
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
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	 public void setUsername(String username) {	    	
	        wait.until(ExpectedConditions.visibilityOf(usernameElement));
	        usernameElement.sendKeys(username);
	    }

	    public void setPassword(String password) {
	         wait.until(ExpectedConditions.visibilityOf(passwordElement));
	        passwordElement.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        wait.until(ExpectedConditions.visibilityOf(loginButton));
	        loginButton.click();
	    }

	    public void clickPimButton() {
	         wait.until(ExpectedConditions.visibilityOf(pimButton));
	        pimButton.click();
	    }
	    public boolean isLoginPage()
	    {
	    	return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	    public boolean isLoginSuccessful() {
	        return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    }
	    public boolean isAdminPage()
	    {
	    	return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
	    }

}
