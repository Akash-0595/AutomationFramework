package vtiger.GenericUtility;

import java.io.FileInputStream;
 import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of generic methods related to property file
 * @author akash kumar bhanja
 *
 */
public class PropertyFileUtility {
	 /**
	  * this method can read data from property file
	  * @param key
	  * @return
	 * @throws IOException 
	 * @throws Exception
	  */
    public String readDataFromPropertyFile(String key) throws Exception  {
    	
	FileInputStream fis=new FileInputStream(IConstantsUtility.propertyfilepath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String value= pObj.getProperty(key);
	return value;
	
	}
}
