package vtiger.practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractise {

	@Test(retryAnalyzer=vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void retry() {
		Assert.fail();
		System.out.println("hi");
	}
	
}
