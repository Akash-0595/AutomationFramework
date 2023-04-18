package vtiger.Product.Tests;

 import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductPage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorPage;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateProductWithVendorTest extends BaseClass {

	@Test(groups="RegressionSuite")
	public void createProductWithVendorTest() throws Exception {
	 
   int num=jUtil.getRandomNumber();
   String PRODUCTNAME = eUtil.readDataFromExcel("Product", 2, 2);
   String VENDORNAME = eUtil.readDataFromExcel("Product", 2, 3)+num;

	 //step 5 : click on vendor link
	 HomePage hp=new HomePage(driver);
	 hp.clickOnVendor(driver);
   
	 //Step 6 : click on create vendor look up image
	 VendorPage vp=new VendorPage(driver);
	 vp.clickOnCreateNewVendorLookupImg();
   
     //step 7 : create new vendor with mandatory field 
	 CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
	 cnvp.createNewvendor(VENDORNAME);
	 
	 //step 8 : validate vendor
	 VendorInfoPage vip=new VendorInfoPage(driver);
	 String VENDORHEADER=vip.getVendorHeaderText();
	 Assert.assertTrue(VENDORHEADER.contains(VENDORNAME));
	 
	//step 9 : click on product link
	hp.clickOnProductLnk();
	
	//step 10 : click on create product lookup image
	ProductPage pp=new ProductPage(driver);
	pp.clickOnCreateProductLookupImg();
	
	//step 11 : create new product with vendor 
	CreateNewProductPage cnpp=new CreateNewProductPage(driver);
	cnpp.CreateNewProduct(driver, PRODUCTNAME, VENDORNAME);
	
	//step 12 : validate
	ProductInfoPage pip=new ProductInfoPage(driver);
	String PRODUCTHEADER = pip.getProductHeaderText();
	Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
	 
	
		}
}






















