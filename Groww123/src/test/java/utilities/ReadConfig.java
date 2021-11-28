package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	
	public ReadConfig() {
		File src= new File("./Configuration\\config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	public String getBaseURL() {
		String URL= pro.getProperty("baseURL");
		return URL;
	}
	
	public String getUserName() {
		String user= pro.getProperty("userName");
		return user;
	}
	public String getPassword() {
		String Password= pro.getProperty("password");
		return Password;
	}
	public String getChrome() {
		String Chrome= pro.getProperty("chrome");
		return Chrome;
	}
	public String getIE() {
		String IE= pro.getProperty("ie");
		return IE;
	}
	public String getEdge() {
		String Edge= pro.getProperty("edge");
		return Edge;
	}
	public String getExcelPath() {
		String Excel= pro.getProperty("excel");
		return Excel;
	}
	public String saveScreenshot() {
		String screenshot= pro.getProperty("screenshots");
		return screenshot;
	}
	public String getReportPath() {
		String Reports= pro.getProperty("reports");
		return Reports;
	}
	
}
