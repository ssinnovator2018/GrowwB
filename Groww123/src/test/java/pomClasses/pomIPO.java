package pomClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pomIPO {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath="//span[text()='Fino Payments Bank']")
	private WebElement Company1;
	
	@FindBy (xpath="//span[text()='Nykaa']")
	private WebElement Company2;
	
	public pomIPO(WebDriver driver) {
		this.driver= driver;
		wait= new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
		
	}
	public void clickCompanyName1() {
		Company1.click();
	}
	public void clickCompanyName2() {
		Company2.click();
	}
}
