package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.JavaUtility;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationPage;

public class POMClassContactWithOrgNAme {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLnk();
        ContactPage cp=new ContactPage(driver);
        cp.clickOnContactPageLookUpImg();
 	}
}
