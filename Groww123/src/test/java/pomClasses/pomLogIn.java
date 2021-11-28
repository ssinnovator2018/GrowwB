package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pomLogIn {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath="//span[text()='Login/Register']")
	WebElement LoginRegisterBtn;
	
	@FindBy (xpath="//input[contains(@id,'login_email')]")
	WebElement UserName;
	
	@FindBy (xpath="//span[text()='Continue']")
	WebElement ContinueBtn;
	
	@FindBy (xpath="//input[@id='login_password1']")
	WebElement Password;
	
	@FindBy (xpath="//div[text()='Please enter a valid email address']")
	WebElement UserError;
	
	
	@FindBy (xpath="//span[text()='Submit']")
	WebElement Submit;
	
	@FindBy (xpath="//div[text()='Logout']")
	WebElement logoutStartover;
	

	public pomLogIn(WebDriver driver)
	{
		this.driver=driver;
		wait= new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void ClickLoginRegister()
	{
		LoginRegisterBtn.click();
		
	}
	public void ClickUserName( String userN)
	{
		UserName.click();
		UserName.clear();
		UserName.sendKeys(userN);
		
	}
	
	public void SendUserName()
	{
		UserName.click();
		UserName.clear();
		UserName.sendKeys("shubhamsss29296@gmail.com");
	}
	public boolean isContinueDisplayed()
	{
		boolean ContinueDisplayed=ContinueBtn.isDisplayed();
		return ContinueDisplayed;
	}
	
	public void ClickContinue()
	{
		ContinueBtn.click();
	}
	public boolean isUserErrorDisplayed()
	{
		boolean result= UserError.isDisplayed();
		return result;
		
	}
	public void SendPassword()
	{
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.clear();
		Password.sendKeys("Prabhakar123");
	}
	public void SendPasswordFromExcel(String passwordFromExcel)
	{
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.clear();
		Password.sendKeys(passwordFromExcel);
	}
	
	public void startOver()
	{
		logoutStartover.click();
	}
	
	public boolean isSubmitDisplayed()
	{
		boolean result=Submit.isDisplayed();
		return result;
			
	}
	
	public void ClickSubmit()
	{
		Submit.click();
	}
	
	
	
	
}
