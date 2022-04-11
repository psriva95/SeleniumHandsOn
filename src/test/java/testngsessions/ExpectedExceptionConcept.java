package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	@Test(expectedExceptions = {NullPointerException.class, 
			ArithmeticException.class})
	public void loginTest() {
		System.out.println("loginTest");
		int i =9/0;
	}
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("homePageTest");
	}
}
