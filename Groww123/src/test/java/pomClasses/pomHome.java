package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pomHome {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath="(//div[@class='dropdown '])[1]")
	WebElement profileBtn;
	
	@FindBy (xpath="//div[text()='Log Out']")
	WebElement Logout;
	
	@FindBy (xpath="//div[text()='Logout']")
	WebElement LogoutBeforeEntry;
	
	@FindBy (xpath="//div[text()='IPO - Initial Public Offerings']")
	private WebElement IPO;
	
	public pomHome(WebDriver driver) {
		this.driver= driver;
		wait= new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
		
	}
	public void clickIPO() {
		IPO.click();
	}
	public boolean logoutAtEntryIsDisplayed()
	{
		boolean logOutbtn=LogoutBeforeEntry.isDisplayed();
		return logOutbtn;
	}
	public void logoutAtEntry()
	{
		LogoutBeforeEntry.click();
	}
	public void logout()
	{
		profileBtn.click();
		Logout.click();
	}
	
	
}
