package employeemanagementtest.common.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestCaseThree {
	private WebDriver driver;
	@FindBy(how=How.XPATH,using="//a[@href='/web/index.php/admin/viewAdminModule']")
	private WebElement admin;
	@FindBy(how=How.XPATH,using="//ul[@data-v-5327b38a]/li[4]")
	private WebElement qualification;
	@FindBy(how=How.XPATH,using="//ul[@class='oxd-dropdown-menu']/li[4]/a")
	private WebElement languages;
	@FindBy(how=How.XPATH,using="(//button[@type=\"button\"])[3]")
	private WebElement addButton;
	@FindBy(how=How.XPATH,using="(//input[@class='oxd-input oxd-input--active' and @data-v-1f99f73c=''])[2]")
	private WebElement inputLanguage;
	@FindBy(how=How.XPATH,using="(//button[@data-v-10d463b7=''])[2]")
	private WebElement saveLanguage;
    @FindBy(how=How.XPATH,using="//button[contains(@class, 'oxd-button--label-danger')]")
    private WebElement deleteSelected;
    @FindBy(how=How.XPATH, using="(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement editLanguage;
    @FindBy(how=How.XPATH,using="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])")
    private WebElement saveEditButton;
	public static void loginStep(Loginpage loginPage) throws InterruptedException
	{
		loginPage.setUsername("Admin");
     	loginPage.setPassword("admin123");
        loginPage.clickLoginButton();  
        boolean res=loginPage.isLoginSuccessful();
        if(res) {
	    	System.out.println("Successfully Logged into Orange HRM");
	    }else {
	    	System.out.println("Failure ! couldn't login");
	    }
	}
	public TestCaseThree(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void clickAdminButton(Loginpage loginPage)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(admin));
	    admin.click();
	    boolean res=loginPage.isAdminPage();
	    if(res) {
	    	System.out.println("Successfully Logged into Admin Page");
	    }else {
	    	System.out.println("Failure ! Redirected to some other page ");
	    }
	    
	}
	public void clickQualification() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(qualification));
	    qualification.click();
	}
	public void clickLanguages() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(languages));
	    languages.click();
	    Thread.sleep(2000);
	}
	public void addButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(addButton));
	    addButton.click();
	}
	public void inputLanguageField(String language) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(inputLanguage));
	    inputLanguage.sendKeys(language);
	    Thread.sleep(3000);
	    try {
	    	WebElement alreadyexists=driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
	    	wait.until(ExpectedConditions.visibilityOf(alreadyexists));
	    	if(alreadyexists.getText().contains("Already exists"))
	    	{
	    		Assert.fail("Language already exists");
	    	}
	    }catch(TimeoutException e) {
		       
		    }
	    catch(NoSuchElementException e) {
	    	
	    }

	  
	}
	public void saveLanguageButton() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(saveLanguage));
	    saveLanguage.click();
	    WebElement popUp = driver.findElement(By.xpath("//*[@id='oxd-toaster_1']"));
	    wait.until(ExpectedConditions.visibilityOf(popUp));
	    String message = popUp.getText();
	    System.out.println("Popup message: " + message);   
        Thread.sleep(3000);
	    }

	public void deleteLanguage(String language) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String xpath = String.format("//div[contains(text(),'%s')]/ancestor::div[contains(@class,'oxd-table-row')]/descendant::input[@type='checkbox']", language);
		WebElement checkbox = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
		wait.until(ExpectedConditions.visibilityOf(deleteSelected));
		deleteSelected.click();
	    WebElement deleteConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@class, 'oxd-button--label-danger')])[2]")));
	    deleteConfirm.click();
	    WebElement popUp=driver.findElement(By.xpath("//*[@id='oxd-toaster_1']"));
	    wait.until(ExpectedConditions.visibilityOf(popUp));
	    String message=popUp.getText();
	    System.out.println("Popup message: " + message);
	    Thread.sleep(3000);
	}
	public void editLanguage(String language,String newString) throws InterruptedException
	{
		String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][2]", language);
		WebElement edit = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(edit));
		edit.click();
        Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOf(editLanguage));
	    Actions action=new Actions(driver);
	    action.moveToElement(editLanguage).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(newString).perform();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOf(saveEditButton));
	    saveEditButton.click();
	    WebElement popUp=driver.findElement(By.xpath("//*[@id='oxd-toaster_1']"));
	    wait.until(ExpectedConditions.visibilityOf(popUp));
	    String message=popUp.getText();
	    System.out.println("Popup message: " + message);    
	    Thread.sleep(3000);
	}
}
