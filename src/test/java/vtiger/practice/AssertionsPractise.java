package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractise {

	@Test
	public void Practise() {
		System.out.println("1-pass");
		Assert.assertTrue(true);
		System.out.println("2-pass");
		Assert.assertTrue(false);
		System.out.println("3-pass");
		Assert.assertEquals(true, false);
	}
	@Test
	public void Practise1() {
		SoftAssert sa=new SoftAssert();
		System.out.println("1-passed");
		sa.assertTrue(true);
        System.out.println("2-passed");
        sa.assertTrue(false);
        System.out.println("pass");
        sa.assertAll();
		
	}
}
