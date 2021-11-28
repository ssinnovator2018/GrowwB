package TestClasses;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pomClasses.pomHome;
import pomClasses.pomLogIn;
import utilities.ReadConfig;
import utilities.XUtils;

public class MultipleDataLogin extends BaseClass {
	
	boolean result;
	pomLogIn logIn;
	XUtils xUtil;
	ReadConfig common;
	pomHome home;
	WebElement passwordBtn;
	
	@BeforeMethod
	public void beforeMethod()
	{
		logIn=new pomLogIn(driver);
		common=new ReadConfig();
		xUtil=new XUtils();
		
	}

	@Test 
	public void dataUsername1Invalid() throws InterruptedException, EncryptedDocumentException, IOException {
		logIn.ClickLoginRegister();
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 2, 0); //invalid
		logIn.ClickUserName(username);
		logIn.ClickContinue();
		Thread.sleep(2000);
//		result= logIn.isSubmitDisplayed();
//		Assert.assertTrue(result);
		if (logIn.isContinueDisplayed()==false)
		{
			Assert.assertTrue(true);
		}
		else
		{
			TestCaseSS(1, driver);
			Assert.assertFalse(true);
		}
		
//		Assert.assertEquals(result, false);
		
		}
	@Test 
	public void dataUsername2Valid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 3, 0); //valid
		logIn.ClickUserName(username);
		logIn.ClickContinue();
		Thread.sleep(2000);
//		result= logIn.isSubmitDisplayed();
//		Assert.assertTrue(result);
		if (logIn.isSubmitDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			TestCaseSS(2, driver);
			Assert.assertFalse(true);
		}
//		Assert.assertNotEquals(result, false);
		}
	@Test 
	public void dataUsername3Invalid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 4, 0); //invalid
		logIn.ClickUserName(username);
		logIn.ClickContinue();
		Thread.sleep(2000);
//		result= logIn.isContinueDisplayed();
//		Assert.assertTrue(result);
		if (logIn.isContinueDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			TestCaseSS(3, driver);
			Assert.assertFalse(true);
		}
//		Assert.assertEquals(result, true);
		
		}
	@Test
	public void dataUsername4Valid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 5, 0); //invalid
		logIn.ClickUserName(username);
		logIn.ClickContinue();
		Thread.sleep(2000);
//		result= logIn.isSubmitDisplayed();
//		Assert.assertTrue(result);
		if (logIn.isSubmitDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			TestCaseSS(4, driver);
			Assert.assertFalse(true);	
		}
//		Assert.assertNotEquals(result, false);
		
		}
	@Test
	public void dataUsername5Invalid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 6, 0); //invalid
		logIn.ClickUserName(username);
		logIn.ClickContinue();
		Thread.sleep(2000);
//		result= logIn.isContinueDisplayed();
//		Assert.assertTrue(result);
		if (logIn.isContinueDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			TestCaseSS(5, driver);
			Assert.assertFalse(true);
			
		}
//		Assert.assertEquals(result, true);
		
		}
	@Test 
	public void dataUsernamePassword1Invalid() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 3, 0); //valid
		String Password =xUtil.Username(common.getExcelPath(), "Groww", 2, 1); //valid

		logIn.ClickUserName(username);
		logIn.ClickContinue();
		logIn.SendPasswordFromExcel(Password);
		logIn.ClickSubmit();
		Thread.sleep(2000);
		
		if(logIn.isSubmitDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else {
				TestCaseSS(6, driver);
				Assert.assertFalse(true);
		}
		Thread.sleep(2000);
		}

	@Test 
	public void dataUsernamePassword2Valid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 3, 0); //valid
		String Password =xUtil.Username(common.getExcelPath(), "Groww", 3, 1); //valid

		logIn.ClickUserName(username);
		logIn.ClickContinue();
		logIn.SendPasswordFromExcel(Password);
		logIn.ClickSubmit();
		
		Thread.sleep(2000);
		if(home.logoutAtEntryIsDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else {
				TestCaseSS(7, driver);
				Assert.assertFalse(true);
				
		}	
		Thread.sleep(2000);
		}
	@Test 
	public void dataUsernamePassword3Valid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 3, 0); //valid
		String Password =xUtil.Username(common.getExcelPath(), "Groww", 4, 1); //valid

		logIn.ClickUserName(username);
		logIn.ClickContinue();
		logIn.SendPasswordFromExcel(Password);
		logIn.ClickSubmit();
		Thread.sleep(2000);
		
		if(home.logoutAtEntryIsDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else {
			TestCaseSS(8, driver);
			Assert.assertFalse(true);		
		}	
		Thread.sleep(2000);
		}
	@Test 
	public void dataUsernamePassword4Invalid() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		String username =xUtil.Username(common.getExcelPath(), "Groww", 3, 0); //valid
		String Password =xUtil.Username(common.getExcelPath(), "Groww", 5, 1); //valid

		logIn.ClickUserName(username);
		logIn.ClickContinue();
		logIn.SendPasswordFromExcel(Password);
		logIn.ClickSubmit();
		Thread.sleep(2000);
		
		if(logIn.isSubmitDisplayed()==true)
		{
			Assert.assertTrue(true);
		}
		else {
				TestCaseSS(9, driver);
				Assert.assertFalse(true);		
		}		
		}



	@AfterMethod
	public void login() throws InterruptedException
	{
		Thread.sleep(2000);
		try {
		home= new pomHome(driver);
		home.logoutAtEntry();
		}catch(Exception e)
		{
			
		}
	}
	}



