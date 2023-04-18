package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFilePractice {
public static void main(String[] args) throws Exception {
	 //step :1 load the file in java readable format
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	 //step :2 create the object of properties class from java.util
	 Properties pobj=new Properties();
     //step:3 load fileInputStream into properties 
	 pobj.load(fis);
	 //step : 4 using key read the value
	 String BROWSER= pobj.getProperty("browser");
	 System.out.println(BROWSER);
	 
	 String URL=pobj.getProperty("url");
	 System.out.println(URL);
	 
	 String USERNAME=pobj.getProperty("username");
	 System.out.println(USERNAME);
	 
	 String PASSWORD=pobj.getProperty("password");
	 System.out.println(PASSWORD);
	 
	 
	 
}
}
