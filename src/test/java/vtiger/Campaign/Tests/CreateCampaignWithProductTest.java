package vtiger.Campaign.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CampaignInfoPage;
import vtiger.ObjectRepository.CampaignPage;
import vtiger.ObjectRepository.CreateNewCampaignPage;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups="RegressionSuite")
	public void createCampaignWithProductTest() throws Exception {
		 
		int num=jUtil.getRandomNumber();
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Campaign", 2, 2);
		String PRODUCTNAME=eUtil.readDataFromExcel("Campaign", 2, 3)+num;
 		//click on product link
		HomePage hp=new HomePage(driver);
        hp.clickOnProductLnk();
        
        //click on create new product look up image
        ProductPage pp=new ProductPage(driver);
        pp.clickOnCreateProductLookupImg();
        
        //craete new product
        CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.CreateNewProduct(driver, PRODUCTNAME);
		 
		 //validation 
		ProductInfoPage pip=new ProductInfoPage(driver);
		String PRODUCTHEADER = pip.getProductHeaderText();
	    Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
		 
		//click on campaign link
		hp.clickOnCampaignLnk(driver);
		
		//click on create new campaign look up image
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateNewCampaignLookupImg();
		
		//create new campaign with product 
		CreateNewCampaignPage cncp=new CreateNewCampaignPage(driver);
		cncp.createNewCampaign(driver, CAMPAIGNNAME, PRODUCTNAME);
		
		//VALIDATE
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		String CAMPAIGNHEADER = cip.getCampaignHeadertext();
		Assert.assertTrue(CAMPAIGNHEADER.contains(CAMPAIGNNAME));
		// Assert.fail();
		 
	}
	}
		