package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	 
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@input='submit']")})
	private WebElement SubmitBtn;
    
	//create a constructor to initialize web elements 
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//create getters 
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD) {
		UsernameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
}
