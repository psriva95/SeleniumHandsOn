package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	//avoid dependency in tests
	//test cases should be independent
	
	@Test
	public void loginTest() {
		System.out.println("loginTest");
		int i =9/2;
	}
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("homePageTest");
		int i = 9/0;
	}
	@Test(dependsOnMethods = {"loginTest","homePageTest"})
	public void searchPageTest() {
		System.out.println("searchPageTest");
	}
}
