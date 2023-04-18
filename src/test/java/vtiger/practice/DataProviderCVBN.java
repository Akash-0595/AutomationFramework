package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.IConstantsUtility;

public class DataProviderCVBN {

	public Object[][] getDataFromExcelToDataProvider(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilepath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh= book.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data ;
	}
	
	@Test(dataProvider="OrgWithIndustry")
	public void TestPeform(String ORG,String INDUSTRY) {
		System.out.println(ORG+"--"+INDUSTRY);
	}
	
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data=getDataFromExcelToDataProvider("DataProviderOrg");
		return data;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
