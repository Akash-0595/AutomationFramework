package vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class consists of generic methods related to web driver actions
 * @author akash kumar bhanja
 *
 */
public class WebDriverUtility {
	
	/**
	 * this method will maximize the window
	 * @param driver
	 */
    public void maximizeWindow(WebDriver driver) {
	 driver.manage().window().maximize();
    }
    /**
    * @param driver                                                  
    */
    public void minimizeWindow(WebDriver driver) {
	 driver.manage().window().minimize();
    }                                                                              
    /**
    * This methos will wait for 20 seconds for the page load  
    * @param driver
    */
    public void waitForPageLoad(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
    /**
    * This method will wait until a particular element is visible
    * @param driver
    * @param element
    */
    public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
    * This method will wait until a particular webElement is clickable
    * @param driver
    * @param element
    */
    public void waitForElemenetToBeClickable(WebDriver driver,WebElement element) {
	
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
    * This method will handle drop down by index
    * @param element
    * @param index
    */
    public void handleDropdown(WebElement element,int index) {
	
    	Select s=new Select(element);
	    s.selectByIndex(index);
    }
    /**
    * This method will handle drop down by value
    * @param element
    * @param value
    */
    public void handleDropdown(WebElement element,String value) {
    Select s=new Select(element);	
	s.selectByValue(value);
    }
    /**
    * This method will handle dropdown by visible tesxt
    * @param text
    * @param element
    */
    public void handleDropdown(String text,WebElement element) {
	Select s=new Select(element);
	s.selectByVisibleText(text);
    }
    /**
    * This method will perform mouse hover action on a particular element
    * @param driver
    * @param element
    */
    public void mouseHoverAction(WebDriver driver,WebElement element) {
	  Actions act=new Actions(driver);
	  act.moveToElement(element).perform();
    }
    /**
    * this method will perform right click anywhere on page 
    * @param driver
    */
    public void rightClickAction(WebDriver driver) {
	  Actions act=new Actions(driver);
	  act.contextClick().perform();
    }
    /**
    * This method will perform right click on particular web element
    * @param driver
    * @param element
    */
    public void rightClickAction(WebDriver driver,WebElement element) {
	  Actions act=new Actions(driver);
	  act.contextClick(element).perform();
    }
    /**
    * this method will perform double click anywhere on webpage
    * @param driver
    */
    public void doubleClickAction(WebDriver driver) {
	  Actions act=new Actions(driver);
	  act.doubleClick().perform();
    }
    /**
    * This method will perform double click on particular web element
    * @param driver
    * @param element
    */
    public void doubleClickAction(WebDriver driver,WebElement element) {
 	  Actions act=new Actions(driver);
	  act.doubleClick(element).perform();
    }    /**
    * This method will perform drag and drop from one element to another
    * @param driver
    * @param srcelement
    * @param destelement
    */
    public void dragAndDropAction(WebDriver driver,WebElement srcelement,WebElement destelement) {
	  Actions act=new Actions(driver);
	  act.dragAndDrop(srcelement, destelement).perform();
    }
    /**
    * This method will perform drag and drop by of a  web element from one place to a particular point
    * @param driver
    * @param srcelement
    * @param xoffset
    * @param yoffset
    */
    public void dragAndDropBy(WebDriver driver,WebElement srcelement,int xoffset,int yoffset) {
	  Actions act=new Actions(driver);
	  act.dragAndDropBy(srcelement, xoffset, yoffset).perform();
    }
  
    /**
    * This method will press the enter key
    * @throws AWTException
    */
    public void pressEnterKey() throws AWTException {
	  Robot r=new Robot();
	  r.keyPress(KeyEvent.VK_ENTER);
    }
    /**
    * This method will release enter key
    * @throws AWTException
    */
    public void releaseEnterKey() throws AWTException {
	  Robot r=new Robot();
	  r.keyRelease(KeyEvent.VK_ENTER);
    }
  
    /**This method will handle frame with index
    * @param driver
    * @param index
    */
    public void handleFrame(WebDriver driver,int index) {
	  driver.switchTo().frame(index);
    }

    /**
    * This method will handle frame with name or id
    * @param driver
    * @param nameOrId
    */
    public void handleFrame(WebDriver driver,String nameOrId) {
	 driver.switchTo().frame(nameOrId);
    }
    /**
    * This method will handle frame with web element
    * @param driver
    * @param element
    */
    public void handleFrame(WebDriver driver,WebElement element ) {
	 driver.switchTo().frame(element);
    } 
    /**
    * this method will switch to parent frame
    * @param driver
    */
    public void handleParentFrame(WebDriver driver) {
	 driver.switchTo().parentFrame();
    }
    /**
    * This method will switch to default frame
    * @param driver
    */
    public void handleDefaultFrame(WebDriver driver) {
	  driver.switchTo().defaultContent();
    }

    /**
    * This method will accept alert pop up
    * @param driver
    */
    public void acceptAlert(WebDriver driver) {
	 driver.switchTo().alert().accept();
    }
    /**
    * This method will dismiss alert popup
    * @param driver
    */
    public void dismissAlert(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
    }
    /**
    * This method will capture and return the alert text
    * @param driver
    * @return
    */
    public String getAlertText(WebDriver driver) {
	 return driver.switchTo().alert().getText();
    }
    
      /**
     * This method will take screen shot and save it in ScreenShot folder
     * @param driver
     * @param methodName
     * @return
     * @throws IOException
     */
    public String takeScreenShot(WebDriver driver,String methodName ) throws IOException {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File(".\\ScreenShots\\"+methodName+".png");
    	FileUtils.copyFile(src, dest);
    	return dest.getAbsolutePath();
    }
    /**
     * This method will switch to window based on partial window title
     * @param driver
     * @param partialWinTitle
     */
    public void switchToWindow(WebDriver driver,String partialWinTitle) {
     //Step 1: capture all the window ids
     Set<String> winIds=	driver.getWindowHandles();
     //Step 2: create a for each loop and navigate to each window
     for(String win:winIds)
     {
    	//Step 3: capture the title of each window
    	String currentTitle=driver.switchTo().window(win).getTitle();
    	//step 4: compare the current title with partial window title
    	if(currentTitle.contains(partialWinTitle))
    	{
    		break;
    	}
     }
    }
    /**
     * This method will scroll randomly downwards
     * @param driver
     */
     public void scrollAction(WebDriver driver) {
    	JavascriptExecutor jsc=(JavascriptExecutor) driver; 
    	jsc.executeScript("window.scrollBy(0,500)", "");
     }
   /**
    * This method will scroll down until the particular web element
    */
    public void scrollAction(WebDriver driver,WebElement element) {
    	JavascriptExecutor jse=(JavascriptExecutor) driver;
    	int y=element.getLocation().getY();
    	jse.executeScript("window.scrollBy(0,"+y+")", element);
    	 
    }
  
    /**
     * This method will return current date in date format
     * @return
     */
    public String calendar() {
    	
    	Calendar cal=Calendar.getInstance();
 	    Date d=cal.getTime();
	    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
	    String date=sdf.format(d);
	    return date;
	 
    }
    /**
     * This method will return Customize date with respect to day
     * @param day
     * @return
     */
    public String calendarDay(int addDay) {
	
    	Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, addDay);
	    Date d=cal.getTime();
	    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
	    String date=sdf.format(d);
	    return date;
	 
    }
   
    /**
     * This method will return date with customize year
     * @param addYear
     * @return
     */
    public String calendarYear(int addYear) {
    	
    	Calendar cal=Calendar.getInstance();
        cal.add(Calendar.YEAR, addYear);
	    Date d=cal.getTime();
	    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
	    String date=sdf.format(d);
	    return date;
	 
 }
    
 
 
 
 
 
}


















