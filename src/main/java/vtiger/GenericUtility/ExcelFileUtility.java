package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
  * this class consist of generic methods related to excel file
  * @author akash kumar bhanja
  *
  */
public class ExcelFileUtility {

	/**
	 * this method will read data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Exception
	 */
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws FileNotFoundException, IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilepath);
	    Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		Row r=sh.getRow(rowNum);
		String value =r.getCell(cellNum).getStringCellValue();
		return value;
		
		}
	/**
	 * this method will write data int excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param cellValue
	 * @throws Exception
	 */
	public void writeDataIntoExcel(String sheetName,int rowNum,int cellNum,String cellValue) throws Exception {
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilepath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);  //if we want to create new sheet will use createSheet() instead of getSheet()
		sh.createRow(rowNum).createCell(cellNum).setCellValue(cellValue);
		
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelfilepath);
       book.write(fos);
	}
	
	/**
	 * This method will provide the data from excel to data provider 
	 * @param sheetName
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public Object[][] getDataFromExcelToDataProvider(String sheetName) throws Exception, IOException {
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilepath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				   data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;

	}
		
		
}	
		
		
		
		
		
		
	


