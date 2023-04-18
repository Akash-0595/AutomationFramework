package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement VendorHeader;
	
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorHeader() {
		return VendorHeader;
	}
	
	/**
	 * This method will get the vendor header text and return to caller of it 
	 * @return
	 */
	public String getVendorHeaderText() {
		return VendorHeader.getText();
	}
}
