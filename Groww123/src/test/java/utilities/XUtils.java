package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XUtils {
	FileInputStream fis;
	Workbook OpenFile;
	Sheet openSheet;
	
	public int getRowCOunt(String path, String sheet) throws EncryptedDocumentException, IOException {
		
		fis= new FileInputStream(path);
		OpenFile= WorkbookFactory.create(fis);
		openSheet= OpenFile.getSheet(sheet);
		int rowCount=openSheet.getLastRowNum();
		return rowCount;
	}
	public int getCellCOunt(String path, String sheet, int row) throws EncryptedDocumentException, IOException {
		
		fis= new FileInputStream(path);
		OpenFile= WorkbookFactory.create(fis);
		openSheet= OpenFile.getSheet(sheet);
		int cellCount=openSheet.getRow(row).getLastCellNum();
		return cellCount;
	}
	
//public String[][] getUserPass(String path, String sheet, int rowCount, int cellCount) throws EncryptedDocumentException, IOException {
//	String [][] loginData = new String[rowCount][cellCount];
//		fis= new FileInputStream(path);
//		OpenFile= WorkbookFactory.create(fis);
//		openSheet= OpenFile.getSheet(sheet);
//		for (int a=0; a<rowCount; a++)
//		{
//				loginData[a][0]=openSheet.getRow(a).getCell(0).getStringCellValue();
//				loginData[a][1]=openSheet.getRow(a).getCell(1).getStringCellValue();
//		}
//		return loginData;
//	}
public String Username(String path, String sheet, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		String UserName1=new String();
		double UsernNameNum;
		fis= new FileInputStream(path);
		OpenFile= WorkbookFactory.create(fis);
		openSheet= OpenFile.getSheet(sheet);
		try{
				UserName1=openSheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		}
		catch(Exception e)
		{
			UsernNameNum=openSheet.getRow(rowNo).getCell(cellNo).getNumericCellValue();
			UserName1=Double.toString(UsernNameNum);
//			e.printStackTrace();
//			e.toString();
		}
		return UserName1;
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
//	String Path="C:\\shubham\\Testing\\Automation\\DataFetchInEclipse.xlsx";
//	FileInputStream file1= new FileInputStream(Path);
//	Workbook OpenFile1=WorkbookFactory.create(file1);
//	Sheet OpenSheet1= OpenFile1.getSheet("U&P");
//	int LastRowNum=OpenSheet1.getLastRowNum();
//	int LastCellNum=OpenSheet1.getRow(0).getLastCellNum();
//	
//	for(int a=0; a<=LastRowNum; a++)
//	{
//		try
//		{
//			for(int b=0; b<LastCellNum; b++)
//			{
//					String GetValue=OpenSheet1.getRow(a).getCell(b).getStringCellValue();
//					System.out.print(GetValue +", ");
//			}
//		}catch(Exception e)
//		{
//
//		}
//		System.out.println();
//	}
	
	
	
}
