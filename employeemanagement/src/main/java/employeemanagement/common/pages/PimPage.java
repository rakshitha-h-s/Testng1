package employeemanagement.common.pages;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PimPage {
	private WebDriver driver;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Type for hints...']")
	private WebElement employeeName;
	@FindBy(how=How.XPATH,using="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-408b665e='']")
	private WebElement button;
	@FindBy(how=How.XPATH,using="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement employeeId;
	@FindBy(how=How.XPATH,using="(//div[@class='oxd-select-text-input' and @data-v-67d2aedf=''])[3]")
	private WebElement jobTitle;
	@FindBy(how=How.XPATH,using="//div[@class='oxd-select-text-input' and @data-v-67d2aedf='']")
	private WebElement employeeStatus;	
	//div[@class='oxd-select-text-input' and text()='Current Employees Only']
	@FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")
	private WebElement includeCategory;
	@FindBy(how=How.XPATH,using="(//input[@placeholder='Type for hints...'])[2]")
	private WebElement supervisorName;
	@FindBy(how=How.XPATH,using="(//div[@class='oxd-select-text-input' and @data-v-67d2aedf=''])[4]")
	private WebElement subUnitName;
	 @FindBy(how=How.XPATH,using="(//div[@class='oxd-select-text-input' and @data-v-67d2aedf=''])[3]")
	 private List<WebElement> selectElements;
	public static void loginStep(LoginPage loginPage) throws InterruptedException
	{
		loginPage.setUsername("Admin");
     	loginPage.setPassword("admin123");
        loginPage.clickLoginButton();        
        boolean res=loginPage.isLoginSuccessful();
        System.out.print(res);
        loginPage.clickPimButton();
	}
	public PimPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void setUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeeName));
       employeeName.sendKeys(username);
   }
		
	public void clickButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(button));
	    button.click();
	    
	}
	
	public void setEmployeeId(String id)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(employeeId));
	    employeeId.sendKeys(id);
	
	}
	
			
	
	public void jobTitleset()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(jobTitle));
	    jobTitle.click();
	}
	
	
	
	public void employeeSatusSelect()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(employeeStatus));
	    employeeStatus.click();
	}

	public void clickIncludeCategory()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(includeCategory));
	    includeCategory.click();
	}
	
	
	
	public void superVisor(String name) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(supervisorName));
	    supervisorName.clear();
	    supervisorName.sendKeys(name);
	    Actions actions=new Actions(driver);
	    Thread.sleep(3000);
	    actions.sendKeys(Keys.ARROW_DOWN).perform();    
		actions.sendKeys(Keys.ENTER).perform(); 
	}
	
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
	}
	public void setJobTitle(String string1) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(jobTitle));
	    jobTitle.click();
	    Actions actions = new Actions(driver);
	    if ( jobTitle.isDisplayed() &&  jobTitle.isEnabled()) {
	    	actions.sendKeys(Keys.ARROW_DOWN).perform();
	    	while(!jobTitle.getText().equals(string1)) {
	    		String initialText=jobTitle.getText();
	    		actions.sendKeys(Keys.ARROW_DOWN).perform();
	    		String finalText=jobTitle.getText();
	    		if (initialText.equals(finalText)) fail("No such job title");
	    	}
	    	actions.sendKeys(Keys.ENTER).perform();
	    }
		
	}

	public void setIncludeCategory(String string) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(includeCategory));
	    includeCategory.click();
	    Actions actions = new Actions(driver);
	    if (  includeCategory.isDisplayed() &&   includeCategory.isEnabled()) {
	    	actions.sendKeys(Keys.ARROW_DOWN).perform();
	    	while(!includeCategory.getText().equals(string)) {
	    		String initialText=includeCategory.getText();
	    		actions.sendKeys(Keys.ARROW_DOWN).perform();
	    		String finalText=includeCategory.getText();
	    		if(initialText.equals(finalText)) fail("no such category");
	    	}
	    	actions.sendKeys(Keys.ENTER).perform();
	    }		
	}
	public void setEmployeeStatus(String string) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(employeeStatus));
	    employeeStatus.click();
	    Actions actions = new Actions(driver);
	    if ( employeeStatus.isDisplayed() &&  employeeStatus.isEnabled()) {
	    	actions.sendKeys(Keys.ARROW_DOWN).perform();
	    	while(! employeeStatus.getText().equals(string)) {
	    		String initialString=employeeStatus.getText();
	    		actions.sendKeys(Keys.ARROW_DOWN).perform();
	    		String finalString=employeeStatus.getText();
	    		if(initialString.equals(finalString)) fail("no such employee status");
	    	}
	    	actions.sendKeys(Keys.ENTER).perform();
	    }
		
	}
	public void setSubUnit(String string) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(subUnitName));
	    subUnitName.click();
	    Actions actions = new Actions(driver);
	    if ( subUnitName.isDisplayed() &&  subUnitName.isEnabled()) {
	    	actions.sendKeys(Keys.ARROW_DOWN).perform();
	    	while(! subUnitName.getText().equals(string)) {
	    		String initialText= subUnitName.getText();
	    		actions.sendKeys(Keys.ARROW_DOWN).perform();
	    		String finalText=subUnitName.getText();
	    		if(initialText.equals(finalText)) fail("no such sub unit ");
	    	}
	    	actions.sendKeys(Keys.ENTER).perform();
	    }		
	}
	public void setEmployeeStatus1(String status) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(employeeStatus));
	    employeeStatus.click();
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + status + "')]")));
	    element.click();
	}
	public void setIncludeCategory1(String category)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(includeCategory));
	    includeCategory.click();
	    WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +category+ "')]")));
	    element.click();		
	}
	public void setJobTitle1(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(jobTitle));
	    jobTitle.click();
	    WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +title+ "')]")));
	    element.click();
	}
	public void setSubUnit1(String unit)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(subUnitName));
	    subUnitName.click();
	    WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +unit+ "')]")));
	    element.click();
	}
}

