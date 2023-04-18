package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
public static void main(String[] args) throws Exception {
	//step :1 load file into input stream in java readable format 
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	//step :2 create a Workbook
	Workbook book=WorkbookFactory.create(fis);
	//step :3 get into sheet
	Sheet sh=book.getSheet("Organization");
	//step :4 get the used row  create cell write data into cell
	sh.getRow(1).createCell(8).setCellValue("akash");
   //step : 5 open the file in java write format and write into workbook
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	//step :6 write data into cell
	book.write(fos);
    System.out.println("data added");
    book.close();
	
	
	
	
	
	
	
}
	
}
