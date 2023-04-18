package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractise {

	@Test(invocationCount=2,priority=1)
	public void createUserTest() {
		//Assert.fail();
		System.out.println("created user");
	}
	
	@Test(dependsOnMethods="createUserTest")
	public void modifyUserTest() {
		System.out.println("modify user");
	}
	
	@Test()
	public void deleteUserTest() {
		System.out.println("delete user");
	}
}
