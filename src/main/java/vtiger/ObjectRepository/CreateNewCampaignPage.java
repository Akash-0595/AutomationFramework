package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility{

	@FindBy(name="campaignname")
	private WebElement CampaignNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ProductLookupImg;
	
	@FindBy(name="search_text")
	private WebElement ProductSearchBarEdt;
	
	@FindBy(name="search")
	private WebElement ProductSearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//craete getters 

	public WebElement getCampaignNameEdt() {
		return CampaignNameEdt;
	}
	
	public WebElement getProductLookupImg() {
		return ProductLookupImg;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	
	public WebElement getProductSearchBarEdt() {
		return ProductSearchBarEdt;
	}

	public WebElement getProductSearchBtn() {
		return ProductSearchBtn;
	}

	/**
	 * This method will craete new campaign with product 
	 * @param driver
	 * @param CAMPAIGNNAME
	 * @param PRODUCTNAME
	 */
	public void createNewCampaign(WebDriver driver,String CAMPAIGNNAME,String PRODUCTNAME) {
		CampaignNameEdt.sendKeys(CAMPAIGNNAME);
		ProductLookupImg.click();
		switchToWindow(driver, "Products");
		ProductSearchBarEdt.sendKeys(PRODUCTNAME);
		ProductSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+PRODUCTNAME+"']")).click();
		switchToWindow(driver,"Campaigns");
		SaveBtn.click();
		
	}

	 	}
	

