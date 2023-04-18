package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.JavaUtility;
import vtiger.ObjectRepository.LoginPage;

public class POMClassPractise {

	public static void main(String[] args) {
	 
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage lp=new LoginPage(driver);
		
		 lp.getUsernameEdt().sendKeys("admin");
		 lp.getPasswordEdt().sendKeys("admin");
		 lp.getSubmitBtn().click();
		 
		 
		//code optimization
		
	//	lp.loginToApp("admin","admin");
		
		 
	}
}
