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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_02_Organization {
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
	//step 1: launching browser runtime polymorphism driver
  if(BROWSER.equalsIgnoreCase("chrome")) {
	  WebDriverManager.chromedriver().setup();
 	  driver=new ChromeDriver();
  }
  else if(BROWSER.equalsIgnoreCase("firefox")) {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
  }
  else {
	  System.out.println("invalid browser");
  }
 	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	
	//step 2: login to application
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	System.out.println("login successful!");
	
	//step 3: navigate to organizations link
	driver.findElement(By.linkText("Organizations")).click();
	
	//step 4: create organizations look up image 
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//step 5: create organization with mandatory fields
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
	//step 5: save
 	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 	//step 6: validation 
	String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains(ORGNAME)) {
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
