package vtiget.Contact.Tests;

 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateContactTest extends BaseClass {
 
	@Test
	public void createContactTest() throws Exception
    {
     
    String LASTNAME=eUtil.readDataFromExcel("Contact", 1, 2)+jUtil.getRandomNumber();
    
	     //step 4: navigate to contact links
 	     
	     HomePage hp=new HomePage(driver);
	     hp.clickOnContactsLnk();
	     
	     //step 5: click on contact look up image
 	      ContactPage cp=new ContactPage(driver);
	      cp.clickOnContactPageLookUpImg();
	     
	     // step 6:  create contact with mandatory field
	     
	     CreateNewContactPage cncp=new CreateNewContactPage(driver);
	     cncp.createNewContact(LASTNAME );
	     
	     //step 7 : validation
	     ContactInfoPage cip=new ContactInfoPage(driver);
	     String CONTACTHEADER = cip.getContactHeader();
	     Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
	      
}
}
