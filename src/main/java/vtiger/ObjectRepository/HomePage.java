package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText=("Calendar"))
	private WebElement CalanderLnk;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
 	@FindBy(linkText="Contacts" )
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OppertunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Documents")
	private WebElement RoubleTicketLnk;
	
	@FindBy(linkText="Dashboard")
	private WebElement DashboardLnk;
	
	@FindBy(id="qccombo")
	private WebElement QuickCreateDropdown;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorBtn;
	
	@FindBy(linkText="My Preferences")
	private WebElement MyPreferencesLnk;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/info.PNG']")
	private WebElement IconImg;
	
	@FindBy(linkText="Help")
	private WebElement HelpLnk;
	
	@FindBy(linkText="Feedback")
	private WebElement FeedbackLnk;
	
	@FindBy(linkText="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement SettingBtn;
	
	@FindBy(linkText="CRM Settings")
	private WebElement CrmSettingLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreBtn;
	
	@FindBy(linkText="SMSNotifier")
	private WebElement SmsNotifierLnk;
	
 	@FindBy(linkText="Our Sites")
 	private WebElement OurSitesLnk;
 	
 	@FindBy(linkText="Integration")
 	private WebElement IntegrationLnk;
 	
 	@FindBy(linkText="Mail Manager")
 	private WebElement MailManagerLnk;
 	
 	@FindBy(linkText="PBX Manager")
 	private WebElement PbxManagerLnk;
 	
 	@FindBy(linkText="Comments")
 	private WebElement CommentsLnk;
 	
 	@FindBy(linkText="Recycle Bin")
 	private WebElement RecycleBinLnk;
 	
 	@FindBy(linkText="RSS")
 	private WebElement RssLnk;
 	
 	@FindBy(linkText="Reports")
 	private WebElement ReportsLnk;
 	
 	@FindBy(linkText="Campaigns")
 	private WebElement CampaignsLnk;
 	
 	@FindBy(linkText="Service Contracts")
 	private WebElement ServiceContractsLnk;
 	
 	@FindBy(linkText="Project Milestones")
 	private WebElement ProjectMilestonesLnk ;
 	
 	@FindBy(linkText="Project Tasks")
 	private WebElement ProjectTasksLnk;
 	
 	@FindBy(linkText="Projects")
 	private WebElement ProjectsLnk;
 	
 	@FindBy(linkText="FAQ")
 	private WebElement FaqLnk;
 	
 	@FindBy(linkText="Services")
 	private WebElement ServicesLnk;
 	
 	@FindBy(linkText="Assets")
 	private WebElement AssetsLnk ;
 	
 	@FindBy(linkText="Purchase Order")
 	private WebElement PurchaseOrderLnk ;
 	
 	@FindBy(linkText="Price Books")
 	private WebElement PriceBooksLnk;
 	
 	@FindBy(linkText="Vendors")
 	private WebElement VendorsLnk ;
 	
 	@FindBy(linkText="Invoice")
 	private WebElement InvoiceLnk;
 	
 	@FindBy(linkText="Sales Order")
 	private WebElement SalesOrderLnk;
 	
 	@FindBy(linkText="Quotes")
 	private WebElement QuotesLnk;
 	
 	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
 	private WebElement AddLookUpDropdown;
 	
 	@FindBy(id="addmodule")
 	private WebElement AddModuleLnk;
 	
 	@FindBy(id="adddash")
 	private WebElement AddDashLnk;
 	
 	@FindBy(id="addNotebook")
 	private WebElement AddNoteBookLnk;
 	
 	@FindBy(id="addReportCharts")
 	private WebElement AddReportChartsLnk;
 	
 	@FindBy(id="defaultwidget")
 	private WebElement DefaultwidgetLnk;
 	
 	public HomePage(WebDriver driver) {
 		PageFactory.initElements(driver, this);
 	}

	 
 	
 	public WebElement getCalanderLnk() {
		return CalanderLnk;
	}



	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}



	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}



	public WebElement getContactsLnk() {
		return ContactsLnk;
	}



	public WebElement getOppertunitiesLnk() {
		return OppertunitiesLnk;
	}



	public WebElement getProductsLnk() {
		return ProductsLnk;
	}



	public WebElement getRoubleTicketLnk() {
		return RoubleTicketLnk;
	}



	public WebElement getDashboardLnk() {
		return DashboardLnk;
	}



	public WebElement getQuickCreateDropdown() {
		return QuickCreateDropdown;
	}



	public WebElement getAdministratorBtn() {
		return AdministratorBtn;
	}



	public WebElement getMyPreferencesLnk() {
		return MyPreferencesLnk;
	}



	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}



	public WebElement getIconImg() {
		return IconImg;
	}



	public WebElement getHelpLnk() {
		return HelpLnk;
	}



	public WebElement getFeedbackLnk() {
		return FeedbackLnk;
	}



	public WebElement getSettingBtn() {
		return SettingBtn;
	}



	public WebElement getCrmSettingLnk() {
		return CrmSettingLnk;
	}



	public WebElement getMoreBtn() {
		return MoreBtn;
	}



	public WebElement getSmsNotifierLnk() {
		return SmsNotifierLnk;
	}



	public WebElement getOurSitesLnk() {
		return OurSitesLnk;
	}



	public WebElement getIntegrationLnk() {
		return IntegrationLnk;
	}



	public WebElement getMailManagerLnk() {
		return MailManagerLnk;
	}



	public WebElement getPbxManagerLnk() {
		return PbxManagerLnk;
	}



	public WebElement getCommentsLnk() {
		return CommentsLnk;
	}



	public WebElement getRecycleBinLnk() {
		return RecycleBinLnk;
	}



	public WebElement getRssLnk() {
		return RssLnk;
	}



	public WebElement getReportsLnk() {
		return ReportsLnk;
	}



	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}



	public WebElement getServiceContractsLnk() {
		return ServiceContractsLnk;
	}



	public WebElement getProjectMilestonesLnk() {
		return ProjectMilestonesLnk;
	}



	public WebElement getProjectTasksLnk() {
		return ProjectTasksLnk;
	}



	public WebElement getProjectsLnk() {
		return ProjectsLnk;
	}



	public WebElement getFaqLnk() {
		return FaqLnk;
	}



	public WebElement getServicesLnk() {
		return ServicesLnk;
	}



	public WebElement getAssetsLnk() {
		return AssetsLnk;
	}



	public WebElement getPurchaseOrderLnk() {
		return PurchaseOrderLnk;
	}



	public WebElement getPriceBooksLnk() {
		return PriceBooksLnk;
	}



	public WebElement getVendorsLnk() {
		return VendorsLnk;
	}



	public WebElement getInvoiceLnk() {
		return InvoiceLnk;
	}



	public WebElement getSalesOrderLnk() {
		return SalesOrderLnk;
	}



	public WebElement getQuotesLnk() {
		return QuotesLnk;
	}



	public WebElement getAddLookUpDropdown() {
		return AddLookUpDropdown;
	}
	



	public WebElement getAddNoteBookLnk() {
		return AddNoteBookLnk;
	}



	public WebElement getAddReportChartsLnk() {
		return AddReportChartsLnk;
	}



	public WebElement getDefaultwidgetLnk() {
		return DefaultwidgetLnk;
	}



	/**
 	 * This method will click on organizations Link
 	 */
 	public void clickOnOrganizationLnk() {
 		OrganizationsLnk.click();
 	}
 	
 	/**
 	 * This method will click on contacts Link
 	 * 
 	 */
 	public void clickOnContactsLnk() {
 		ContactsLnk.click();
 	}
 	
 	
 	/**
 	 * This method will click on products link
 	 */
 	public void clickOnProductLnk() {
 		ProductsLnk.click();
 	}
 	
 	/**
 	 * This method will click on vendors link
 	 * @param driver
 	 */
 	public void clickOnVendor(WebDriver driver) {
 		mouseHoverAction(driver, MoreBtn);
 		VendorsLnk.click();
 	}

 	/**
 	 * This method will click on campaign link
 	 * @param driver
 	 */
 	public void clickOnCampaignLnk(WebDriver driver) {
 		mouseHoverAction(driver,MoreBtn);
 		CampaignsLnk.click();
 	}
 	
	/**
 	 * This method will perform sign out operation on web page
 	 * @param driver
 	 */
 	public void logoutOfApp(WebDriver driver) {
 		mouseHoverAction(driver, AdministratorBtn);
 		SignOutBtn.click();		
 	}
 	
 	}
