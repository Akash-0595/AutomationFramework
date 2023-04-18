package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement ProductHeader;
	
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeader() {
		return ProductHeader;
	}
	
	/**
	 * This method will get product header text nad return to caller of it 
	 * @return
	 */
	public String getProductHeaderText() {
	
		return	ProductHeader.getText();
	}
}
