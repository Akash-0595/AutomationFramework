package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;
/*
 * this class consists of generic methods related to java
 */
public class JavaUtility {
	/*
	 * this method will return a random number after every run
	 */
	public int getRandomNumber() {
		Random r=new Random();
	return r.nextInt(1000);
 	}
	/*
	 * this method will return the current system date
	 */

	public String getSystemDate() {
	Date d=new Date();
   return d.toString();	
 
	}

   /*
   * this method will return date in specified  format
   * @return
   */

	public String getSystemDateInFormat() {
	Date d=new Date();
	String dArr[]=d.toString().split(" ");
	String date=dArr[2];
	String month=dArr[1];
    String year=dArr[5];
	String time=dArr[3].replace(":","-");
    String value=date+"-"+month+"-"+year+" "+time;
    return value;
    }
}
