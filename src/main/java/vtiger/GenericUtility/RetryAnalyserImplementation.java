package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is an implementation class for IRetryAnalyser interface of testNG
 * @author akash kumar bhanja
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
    
	int count=0;
	int retryCount=4;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
