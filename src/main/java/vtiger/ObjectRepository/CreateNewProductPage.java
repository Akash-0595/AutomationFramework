package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {

	@FindBy(name="productname")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement VendorLookupImg;
	
	@FindBy(name="search_text")
	private WebElement VendorSearchEdt;
	
	@FindBy(name="search")
	private WebElement VendorSearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getVendorLookupImg() {
		return VendorLookupImg;
	}

	public WebElement getVendorSearchEdt() {
		return VendorSearchEdt;
	}

	public WebElement getVendorSearchBtn() {
		return VendorSearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * This method will create new product with mandatory field
	 * @param driver
	 * @param PRODUCTNAME
	 */
	public void CreateNewProduct(WebDriver driver,String PRODUCTNAME) {
		ProductNameEdt.sendKeys(PRODUCTNAME);
  		SaveBtn.click();
 		
	}

	 /**
	 * This method will craete new product with vendor
	 * @param driver
	 * @param PRODUCTNAME
	 * @param VENDORNAME
	 */
	public void CreateNewProduct(WebDriver driver,String PRODUCTNAME,String VENDORNAME) {
		ProductNameEdt.sendKeys(PRODUCTNAME);
		VendorLookupImg.click();
 		switchToWindow(driver, "Vendors");
 		VendorSearchEdt.sendKeys(VENDORNAME);
	    VendorSearchBtn.click();
	    driver.findElement(By.xpath("//a[text()='"+VENDORNAME+"']")).click();
 		switchToWindow(driver, "Products");
 		SaveBtn.click();
 		
	}

	 
 	
	
}
