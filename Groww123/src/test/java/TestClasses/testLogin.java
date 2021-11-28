package TestClasses;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.pomHome;
import pomClasses.pomLogIn;



public class testLogin extends BaseClass {
	pomLogIn login;

	@BeforeMethod
	public void LogIn() throws InterruptedException {
		Thread.sleep(5000);
		login=new pomLogIn(driver);
		login.ClickLoginRegister();
		login.SendUserName();
		login.ClickContinue();
		login.SendPassword();
		login.ClickSubmit();
		Thread.sleep(10000);
		
	}
	@Test 
	public void LoginSuccesful() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://groww.in/stocks/user/explore");
	}
	@Test
	public void Title() throws InterruptedException
	{
		if(driver.getTitle().contains("invest in stocks"))
		{
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		pomHome home=new pomHome(driver);
		home.logout();
	}
	
	
	
	
	
}
