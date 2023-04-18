package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement CampaignHeader;
	
	public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignHeader() {
		return CampaignHeader;
	}
	
	/**
	 * This method will get campaign header text and return it to caller of it
	 * @return
	 */
	public String  getCampaignHeadertext() {
		return CampaignHeader.getText();
	}
}
