package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateNewProductLookupImg;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewProductLookupImg() {
		return CreateNewProductLookupImg;
	}
	
	/**
	 * This method will click on Create new Product look up img
	 */
	public void clickOnCreateProductLookupImg() {
		CreateNewProductLookupImg.click();
	}
}
