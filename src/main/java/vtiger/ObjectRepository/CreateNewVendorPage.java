package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	@FindBy(name="vendorname")
	private WebElement VendorNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * this method will create a new vendor 
	 * @param VENDORNAME
	 */
	public void createNewvendor(String VENDORNAME) {
		VendorNameEdt.sendKeys(VENDORNAME);
		SaveBtn.click();
	}
}
