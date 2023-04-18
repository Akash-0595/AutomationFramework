package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropdown;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn ;

	 public CreateNewOrganizationPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }


	
	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
    }
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	 
	/**
	 * This method will create a new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME) {
		 OrganizationNameEdt.sendKeys(ORGNAME);
		 SaveBtn.click();

	}
	/**
	 * This method will create a new organization with industry type
	 * @param orgName
	 * @param INDUSTRY
	 */
	 public void createOrganization(String ORGNAME,String INDUSTRY) {
		 OrganizationNameEdt.sendKeys(ORGNAME);
		 handleDropdown(IndustryDropdown,INDUSTRY);
		 SaveBtn.click();
	 }
}
