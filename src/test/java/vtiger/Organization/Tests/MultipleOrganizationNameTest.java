package vtiger.Organization.Tests;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
public class MultipleOrganizationNameTest extends BaseClass{

	 

	@Test(dataProvider="OrgWithIndustry")
	public void multipleOrganizationNameTest(String ORG,String INDUSTRY) throws Exception {
 
		String ORGNAME=ORG+jUtil.getRandomNumber();
 	     
	    //step 5: click on Organization
 	    HomePage hp=new HomePage(driver);
	    hp.clickOnOrganizationLnk();
	    
	    //step 6 : click on organization look up image
	    
	    OrganizationPage op=new OrganizationPage(driver);
	    op.clickOnCreateOrganizationLookUpImg(); 
	    
	    // step 6: Create new Organization
	    CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	    cnop.createOrganization(ORGNAME, INDUSTRY);
	    
	    // Step 6: validation
	    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	    String ORGHEADER = oip.getOrganizationHeader();
	    Assert.assertTrue(ORGHEADER.contains(ORGNAME));
	}
	
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws Exception{
 		Object[][] data=eUtil.getDataFromExcelToDataProvider("DataProviderOrg");
		return data;
	}
}
