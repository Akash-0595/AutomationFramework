package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.WebDriverUtility;

public class Tc_05_ContactsWithorgLook {
public static void main(String[] args) throws Exception {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.get("http://localhost:8888/");
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Chaitanya");
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
	/*String parentId=driver.getWindowHandle();
	Set<String> childIds=driver.getWindowHandles();
	for(String allids:childIds) {
		if(!allids.equals(parentId)) {
			driver.switchTo().window(allids);
 		}
		}
	
	driver.findElement(By.xpath("//a[@id='1']")).click();
	driver.switchTo().window(parentId);
	*/
	
 	
	WebDriverUtility wUtil=new WebDriverUtility();
	wUtil.switchToWindow(driver, "Organizations");
	driver.findElement(By.id("1")).click();

  	String parentTitle=driver.getTitle();
  	System.out.println(parentTitle);
  	
 	wUtil.switchToWindow(driver, "Contacts");
 	
	 driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	 String ContactHeader=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(ContactHeader.contains("Chaitanya"))
	    	System.out.println(ContactHeader+"----pass----");
	    else
	    	System.out.println("----failed----");
	    
	   WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 	Actions act=new Actions(driver);
	 	act.moveToElement(ele).perform();
	    
	     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.quit(); 
	  
  	
		 
		
}
}
