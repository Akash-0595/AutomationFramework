package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class GenericUtilityPractice {
public static void main(String[] args) throws Exception {
	PropertyFileUtility pUtil=new PropertyFileUtility();
	String URL=pUtil.readDataFromPropertyFile("url");
	System.out.println(URL);
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
    System.out.println(BROWSER);
   
    ExcelFileUtility EUtil=new ExcelFileUtility();
    String ORGNAME=EUtil.readDataFromExcel("Organization", 2, 2);
    System.out.println(ORGNAME);
    
    String value=EUtil.readDataFromExcel("Organization", 2, 2);
    EUtil.writeDataIntoExcel("Organization", 10, 8,value);
    System.out.println("value added ");
     
    JavaUtility jUtil=new JavaUtility();
   System.out.println(jUtil.getRandomNumber());
    System.out.println(jUtil.getSystemDate());
   System.out.println(jUtil.getSystemDateInFormat());
   WebDriverManager.firefoxdriver().setup();
   WebDriver driver=new FirefoxDriver();
    WebDriverUtility wUtil=new WebDriverUtility();
    wUtil.maximizeWindow(driver);
    Thread.sleep(3000);
    wUtil.minimizeWindow(driver);
    wUtil.waitForPageLoad(driver);
    driver.get(URL);
    
    
    
}
}
