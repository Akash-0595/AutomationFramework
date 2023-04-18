package vtiger.Organization.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {
   
	
	@Test(priority=-1,groups="SmokeSuite")
	public void createOrganizationTest() throws Exception
	{
		 String ORGNAME=eUtil.readDataFromExcel("Organization",3,2 )+jUtil.getRandomNumber();
 	     
	     //step 5: click on Organization
	     HomePage hp=new HomePage(driver);
	     hp.clickOnOrganizationLnk();
	     Reporter.log("navigated to organization link");
	    
	    //step 6 : click on organization look up image
	    OrganizationPage op=new OrganizationPage(driver);
	    op.clickOnCreateOrganizationLookUpImg(); 
	    Reporter.log("clicked on organization look up image");
	    
	    // step 6: Create new Organization
	    CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	    cnop.createOrganization(ORGNAME);
	    Reporter.log("new organization created");
	    
	    // Step 6: validation
	    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	    String ORGHEADER = oip.getOrganizationHeader();
	    Assert.assertTrue(ORGHEADER.contains(ORGHEADER));
	    Reporter.log("new organization createtion validated");

	    
	}
	 
 
	 @Test
	 public void DemooTest() {
		  System.out.println("success demo");
	 }
}


















