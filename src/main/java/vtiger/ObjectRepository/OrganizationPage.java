package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationLookupImg;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	public WebElement getCreateOrganizationLookupImg() {
		return CreateOrganizationLookupImg;
		
	}
	
	/**
	 * This method will click on organization look up image
	 * 
	 */
	public void clickOnCreateOrganizationLookUpImg() {
		CreateOrganizationLookupImg.click();
	}
}
