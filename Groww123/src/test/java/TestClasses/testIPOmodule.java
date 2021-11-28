package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.pomHome;
import pomClasses.pomIPO;
import pomClasses.pomLogIn;

public class testIPOmodule extends BaseClass {
	pomHome home;
	pomLogIn login;
	@BeforeMethod
	public void LogIn() throws InterruptedException {
		Thread.sleep(5000);
		login=new pomLogIn(driver);
		login.ClickLoginRegister();
		Thread.sleep(3000);
		login.SendUserName();
		login.ClickContinue();
		login.SendPassword();
		login.ClickSubmit();
		Thread.sleep(10000);
		home=new pomHome(driver);
		home.clickIPO();
	}
	@Test (priority=0)
	public void checkCompany1() throws InterruptedException
	{	
		Thread.sleep(3000);
		pomIPO C1= new pomIPO(driver);
		C1.clickCompanyName1();
		Assert.assertEquals(driver.getTitle(), "IPO - Check Latest & Upcoming IPO List, Issue Price and Listing Details");
	}
	@Test (priority=1)
	public void checkCompany2()  throws InterruptedException 
	{	
		Thread.sleep(3000);
		pomIPO C2= new pomIPO(driver);
		C2.clickCompanyName2();
		Assert.assertEquals(driver.getTitle(), "IPO - Check Latest & Upcoming IPO List, Issue Price and Listing Details");
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		home.logout();
	}
	
	
	
	
}
