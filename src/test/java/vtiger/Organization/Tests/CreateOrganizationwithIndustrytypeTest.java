package vtiger.Organization.Tests;

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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateOrganizationwithIndustrytypeTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws Exception
	{
    	
	 
     
     String ORGNAME=eUtil.readDataFromExcel("Organization",3,2 )+jUtil.getRandomNumber();
     String INDUSTRY = eUtil.readDataFromExcel("Organization",3, 3);
      
     //step 5: click on Organization
     //driver.findElement(By.linkText("Organizations")).click();
     HomePage hp=new HomePage(driver);
     hp.clickOnOrganizationLnk();
    
    //step 6 : click on organization look up image
    
    
    OrganizationPage op=new OrganizationPage(driver);
    op.clickOnCreateOrganizationLookUpImg(); 
    
    /*  driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
     
     */
    
    // step 6: Create new Organization
    CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
    cnop.createOrganization(ORGNAME, INDUSTRY);
    
    // Step 6: validation
    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
    String ORGHEADER = oip.getOrganizationHeader();
   
    Assert.assertTrue(ORGHEADER.contains(ORGNAME));
     
    //Assert.fail();
    
   
     
    
    
    
    
    
    }
 

}
