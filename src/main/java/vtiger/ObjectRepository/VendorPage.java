package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement CreateNewVendorLookupImg;
	
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewVendorLookupImg() {
		return CreateNewVendorLookupImg;
	}
	
	/**
	 * This method will click on create new vendor img
	 */
	public void clickOnCreateNewVendorLookupImg() {
		CreateNewVendorLookupImg.click();
	}
	
}
