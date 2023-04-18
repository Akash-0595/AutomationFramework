package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	//Identifying web elements and keeping as private
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CreateNewCampaignLookupImg;
	
	//initialising web element by creating a constructor
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//create getters for all the web elements 
	public WebElement getCreateNewCampaignLookupImg() {
		return CreateNewCampaignLookupImg;
	}

	//Business libraries 

	/**
	 * This method will click on create new campaign look up img
	 */
	public void clickOnCreateNewCampaignLookupImg() {
		CreateNewCampaignLookupImg.click();
	}

	
}
