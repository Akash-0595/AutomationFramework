package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
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

public class Tc_01_CreateContact {
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
	   Sheet sh= book.getSheet("Contact");
	  String LASTNAME= sh.getRow(1).getCell(1).getStringCellValue()+num;
	  WebDriver driver=null;
		//step 1: launching browser 
	  if(BROWSER.equalsIgnoreCase("chrome")) { 
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  else if(BROWSER.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();

		  driver=new FirefoxDriver();
	     
	  }
	  else
		  System.out.println("invalid browser");
 	
   driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	
	//step 2: login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step 3: click on contact link 
	driver.findElement(By.linkText("Contacts")).click();
	
	//step 4 : click on create contacts look up image
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	//step 5: create contact with mandatory fields 
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	Select s=new Select(driver.findElement(By.name("leadsource")));
	List<WebElement> op=s.getOptions();
	System.out.println(op.size());
	//step 6: save contacts 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//step 7 : validation 
	String ele=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(ele.contains(LASTNAME)) {
		System.out.println(ele+"----pass----");
		
	}
	
	else 
		System.out.println("----failed----");
	WebDriverUtility wUtil=new WebDriverUtility();
System.out.println(wUtil.takeScreenShot(driver,"abc"));
 
 	//step 8: logout application
   WebElement log=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
   Actions a=new Actions(driver);
   a.moveToElement(log).perform();
   driver.findElement(By.linkText("Sign Out")).click();
   System.out.println("logout succesful");
}
}
