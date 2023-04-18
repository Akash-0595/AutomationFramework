package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelfilePractise {
public static void main(String[] args) throws Exception {
   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
   Workbook book=WorkbookFactory.create(fis);
   Sheet sh=book.getSheet("Organization");
   Row r=sh.getRow(1);
   String value=r.getCell(2).getStringCellValue();
   System.out.println(value);	
	
	
	
}
}
