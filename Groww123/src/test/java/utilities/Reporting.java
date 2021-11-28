package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestClasses.BaseClass;


// Listeners over rided class

public class Reporting extends TestListenerAdapter {
	ReadConfig com=new ReadConfig();
	public ExtentSparkReporter spark;
	 public ExtentReports extent;
	 public ExtentTest logger;
	 BaseClass Bs= new BaseClass();
	 
//	  ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
	 public void onStart(ITestContext testContext)
	 {
		 String TimeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String repName= "Test-Report"+ TimeStamp+".html";
		 ExtentSparkReporter spark = new ExtentSparkReporter(com.getReportPath()+ repName);//specify location of the report
	  try {
		spark.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  extent=new ExtentReports();
	  
	  extent.attachReporter(spark);
	  extent.setSystemInfo("Host name","localhost");
	  extent.setSystemInfo("Environemnt","SIT");
	  extent.setSystemInfo("user","Shubham");
	  
	  spark.config().setDocumentTitle("Automation internet Banking Report"); // Tile of report
	  spark.config().setReportName("Functional Testing"); // name of the report
//	  spark.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	  spark.config().setTheme(Theme.STANDARD);
	 }
	 
	 public void onTestSuccess(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	 }
	 
	 public void onTestFailure(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
	  
	  String screenshotPath=System.getProperty(com.saveScreenshot())+tr.getName()+".png";
	  try {
	   logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	  } catch (Exception e) {
	    e.printStackTrace();
	  } 
	 }
	 
	 public void onTestSkipped(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.BLUE));
	 }
	 
	 public void onFinish(ITestContext testContext)
	 {
	  extent.flush();
	 }
	 
	 
}
