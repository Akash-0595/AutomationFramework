package vtiger.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
/**
 * This class consists of basic annotations configurations 
 * @author akash kumar bhanja
 *
 */
public class BaseClass {

	//creating object of utility clases 
			public PropertyFileUtility pUtil=new PropertyFileUtility();
			public ExcelFileUtility eUtil=new ExcelFileUtility();
			public JavaUtility jUtil=new JavaUtility();
			public WebDriverUtility wUtil=new WebDriverUtility();
			
			public WebDriver driver=null;
			public static WebDriver sDriver;
			//reading required data from external resource
			
			 
			
			@BeforeSuite(alwaysRun=true)
			public void bsConfig() {
				System.out.println("database connect successful");
			}
		  //@Parameters("browser")
		  //@BeforeTest
			@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
			public void bcConfig() throws Exception {
				String URL = pUtil.readDataFromPropertyFile("url");
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				//launching broswer
				if(BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
 					System.out.println(BROWSER+"browser launched successfully!");
				}
				
				if(BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
 					System.out.println(BROWSER+"browser launched successfully!");

				}
				else 
				{
					System.out.println("invalid browser name");
				}
				sDriver=driver;
				wUtil.waitForPageLoad(driver);
				wUtil.maximizeWindow(driver);
				driver.get(URL);
			}
			
			@BeforeMethod(alwaysRun=true)
			public void bmConfig() throws Exception {
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				LoginPage lp=new LoginPage(driver);
	            lp.loginToApp(USERNAME, PASSWORD);
	            System.out.println("login to app successful!");
	            
			}
			
			@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
			public void afConfig() {
				HomePage hp=new HomePage(driver);
				hp.logoutOfApp(driver);
				System.out.println("Logout of app successful!");
			}
		  //@AfterTest
			@AfterClass(groups={"SmokeSuite","RegressionSuite"})
			public void acConfig() { 
				driver.quit();
				System.out.println("browser closed");
			}
			@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
			public void asConfig() {
				System.out.println("database closed successfully!");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
}
