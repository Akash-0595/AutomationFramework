
package vtiger.Product.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

 import vtiger.GenericUtility.BaseClass;
    import vtiger.ObjectRepository.CreateNewProductPage;
 import vtiger.ObjectRepository.HomePage;
 import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductPage;
 
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {
	
	@Test
     public void createProductTest() throws Exception {
    	 
         String PRODUCTNAME = eUtil.readDataFromExcel("Product", 1, 2);
         
        //step 5 : click on product link
    	HomePage hp=new HomePage(driver);
    	hp.clickOnProductLnk();
    	
    	//step 10 : click on create product lookup image
    	ProductPage pp=new ProductPage(driver);
    	pp.clickOnCreateProductLookupImg();
    	
    	//step 11 : create new product 
    	CreateNewProductPage cnpp=new CreateNewProductPage(driver);
    	cnpp.CreateNewProduct(driver, PRODUCTNAME);
    	
    	//step 12 : validate
    	ProductInfoPage pip=new ProductInfoPage(driver);
    	String PRODUCTHEADER = pip.getProductHeaderText();
    	Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
    	 
    	
    }
     
         
 }
