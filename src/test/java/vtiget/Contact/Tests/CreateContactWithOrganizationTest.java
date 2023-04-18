package vtiget.Contact.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactWithOrgTest() throws Exception
	{
    	
	 
	    String LASTNAME=eUtil.readDataFromExcel("Contact", 3, 2);
	    String ORGNAME=eUtil.readDataFromExcel("Contact",3,3)+jUtil.getRandomNumber();
	    //step 4 : naviagate to  organization link
		 HomePage hp=new HomePage(driver);
		 hp.clickOnOrganizationLnk();
		   
		 //step 5: click on organization look up image
		 OrganizationPage op=new OrganizationPage(driver);
		 op.clickOnCreateOrganizationLookUpImg();
		 
		 //step 6: create organization
		 CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		 cnop.createOrganization(ORGNAME);
		 
		 //step 7: validate organization
		  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		  String ORGHEADER = oip.getOrganizationHeader();
		  Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		    
		    //step 8: Navigate to contact link
		    //driver.findElement(By.linkText("Contacts")).click();
		    hp.clickOnContactsLnk();
		    
		    
		    //step 9: click on contact look up image
 		    ContactPage cp=new ContactPage(driver);
		    cp.clickOnContactPageLookUpImg();
		    //step 10: create contact
 		    CreateNewContactPage cncp=new CreateNewContactPage(driver);
		    cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
		    
		   
		    // CONTACT HEADER 
		    ContactInfoPage cip=new ContactInfoPage(driver);
		    String CONTACTHEADER = cip.getContactHeader();
		    
		    //step 17: validate 
		    if(CONTACTHEADER.contains(LASTNAME)) {
		    	System.out.println(CONTACTHEADER+"----pass----");
		    	
		    }
		    else {
		    	System.out.println("----failed");
		    }
		    
		    	
      }
   

}
