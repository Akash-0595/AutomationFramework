package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement FirstNameDropdown;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstNameEdt;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastNameEdt ;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement OrganizationLookupImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement LeadSourceDropdown ;
	
	@FindBy(id="title")
	private WebElement TitleEdt ;
	
	@FindBy(id="email")
	private WebElement EmailEdt ;
	
	@FindBy(xpath="//input[@name='emailoptout']")
	private WebElement EmailOptOutCheckBox ;
	
	@FindBy(id="jscal_field_birthday")
	private WebElement BirthdayCalenderEdt ;
	
	@FindBy(id="jscal_trigger_birthday")
	private WebElement BirthdayCalenderPopup;
	
	@FindBy(xpath="//input[@name='imagename']")
	private WebElement ChooseFileBtn ;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn ;
 
	
	//initilise every web element using a constructor
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	 public WebElement getFirstNameDropdown() {
		return FirstNameDropdown;
	}


	public WebElement getFirstNameEdt() {
		return FirstNameEdt;
	}


	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}


	public WebElement getOrganizationLookupImg() {
		return OrganizationLookupImg;
	}


	public WebElement getLeadSourceDropdown() {
		return LeadSourceDropdown;
	}


	public WebElement getTitleEdt() {
		return TitleEdt;
	}


	public WebElement getEmailEdt() {
		return EmailEdt;
	}


	public WebElement getEmailOptOutCheckBox() {
		return EmailOptOutCheckBox;
	}


	public WebElement getBirthdayCalenderEdt() {
		return BirthdayCalenderEdt;
	}


	public WebElement getBirthdayCalenderPopup() {
		return BirthdayCalenderPopup;
	}


	public WebElement getChooseFileBtn() {
		return ChooseFileBtn;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	/**
	 * This method will create new contact with mandatory data
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact with birthday calender
	 * @param LASTNAME
	 * @param DATE
	 */
	public void createNewContact(String LASTNAME,String DATE) {
		LastNameEdt.sendKeys(LASTNAME);
		BirthdayCalenderEdt.sendKeys(DATE);
		SaveBtn.click();
	}
 
    /**
     * This method will craete contact with organization
     * @param driver
     * @param LASTNAME
     * @param ORGNAME
     */
	public void CreateNewContact(WebDriver driver,String LASTNAME,String ORGNAME) {
		 LastNameEdt.sendKeys(LASTNAME);
		 OrganizationLookupImg.click();
		 switchToWindow(driver, "Accounts");
		 OrgSearchEdt.sendKeys(ORGNAME);
		 OrgSearchBtn.click();
		 driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		 switchToWindow(driver, "Contacts");
		 SaveBtn.click();
		 
 	 }
	
	
	
	
	
}
