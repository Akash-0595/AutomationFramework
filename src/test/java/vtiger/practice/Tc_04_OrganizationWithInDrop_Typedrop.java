package vtiger.practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class Tc_04_OrganizationWithInDrop_Typedrop {
	                   
  public static void main(String[] args) throws Exception {
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	/* 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 */
	WebDriverUtility wUtil=new WebDriverUtility();

    wUtil.waitForPageLoad(driver);
    PropertyFileUtility pUtil=new PropertyFileUtility();
    String URL=pUtil.readDataFromPropertyFile("url");
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	System.out.println("login successful!");
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	/*Random r=new Random();
	  int num=r.nextInt(100);
	*/
	JavaUtility jUtil=new JavaUtility();
    int num=	jUtil.getRandomNumber();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Ab solution"+num);
	
	WebElement industryDropdown=driver.findElement(By.xpath("//select[@name='industry']"));
	/* 
	 Select s=new Select(industryDropdown);
	 s.selectByValue("Energy");
	System.out.println("energy dropdown selected"); 
	*/
	wUtil.handleDropdown(industryDropdown,"Energy");
	
    WebElement typeDropdown=driver.findElement(By.xpath("//select[@name='accounttype']"));
	/*Select s1=new Select(typeDropdown);
	s1.selectByValue("Customer");
	System.out.println("customer dropdown selected");
	*/
    wUtil.handleDropdown(typeDropdown,"Customer");
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
	/*
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	*/
/*	wUtil.MoveToElementAction(driver, ele);
    driver.findElement(By.linkText("Sign Out")).click();
    System.out.println("log out successful!");
    driver.quit();
    */
 	}
}
