package TestClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	ReadConfig common= new ReadConfig();
	public String url=common.getBaseURL();
	public String username=common.getUserName();
	public String password=common.getPassword();
	
	
	public void TestCaseSS(int TestCaseId, WebDriver driver) throws IOException {
		File TestCase=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String TimeStamp= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		File Dest= new File(common.saveScreenshot()+TestCaseId+" "+TimeStamp +".jpg");
		FileHandler.copy(TestCase, Dest);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void SetUp(String Br)
	{
		if(Br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", common.getEdge());	
		driver=new EdgeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (Br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", common.getChrome());	
			driver=new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		}
		else if (Br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", common.getIE());	
			driver=new InternetExplorerDriver();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	@AfterClass
	public void closingAct()
	{
		driver.quit();
	}
}
