package vtiger.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.WebDriverUtility;

public class Tc_03_OrganizationWithChemicals {
public static void main(String[] args) throws Exception {
	Random r=new Random();
	int num=r.nextInt(1000);
	// read the data from property file 
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER=pobj.getProperty("browser");
	String URL=pobj.getProperty("url");
	String USERNAME=pobj.getProperty("username");
	String PASSWORD=pobj.getProperty("password");
	//read data from excel sheet
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
    Workbook book=WorkbookFactory.create(fise);
   Sheet sh= book.getSheet("Organization");
  String ORGNAME= sh.getRow(1).getCell(1).getStringCellValue()+num;
  WebDriver driver=null;
	//step 1: launching browser 
  WebDriverManager.firefoxdriver().setup();
  if(BROWSER.equalsIgnoreCase("chrome")) 
	  driver=new ChromeDriver();
  else if(BROWSER.equalsIgnoreCase("firefox"))
	  driver=new FirefoxDriver();
  else
	  System.out.println("invalid browser");
	
 	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://localhost:8888/");
    
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	System.out.println("login successful!");
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
 
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Ab solution"+num);
	
	WebElement industryDropdown=driver.findElement(By.xpath("//select[@name='industry']"));
	/*Select s=new Select(industryDropdown);
	s.selectByValue("Chemicals"); 
	*/
	WebDriverUtility wUtil=new WebDriverUtility();
 	wUtil.handleDropdown(industryDropdown, "Chemicals");
	
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	
	String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains("Ab solution")) {
		System.out.println(OrgHeader+"----pass----");
	}
	else {
		System.out.println("----failed----");
	}
	
	//step 7: log out 
	WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
    driver.findElement(By.linkText("Sign Out")).click();
    System.out.println("log out successful!");
    driver.quit();
	
	
	
}
}
