package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	/*
	 * Global Pre-conditions
	 * Pre-conditions
	 * test steps + actual vs exp results
	 * post steps
	 *
	 *  Before Suite -- Connect with DB........
		Before Test -- Create User
		Before class ---  launch browser
		
		Before method ---  loginToApp
		Verify Header...
		after method ---  logout
		
		Before method ---  loginToApp
		Verify login...
		after method ---  logout
		
		Before method ---  loginToApp
		Verify Title...
		after method ---  logout
		
		After class ---  close browser
		After test ---  delete the user
		After suite --- close db conenction


		before method before every test method
	 *
	 *
	 */
	
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("Before Suite -- Connect with DB........");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("Before Test -- Create User");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Before class ---  launch browser");
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("Before method ---  loginToApp");
	}
	
	/*
	 * by default -- alphabetically tests are picked up
	 */
	
	@Test
	public void titleTest() {
		System.out.println("Verify Title...");
	}

	@Test
	public void headerTest() {
		System.out.println("Verify Header...");
	}
	
	@Test
	public void isLoginSuccessful() {
		System.out.println("Verify login...");
	}

	@AfterMethod
	public void logoutFromApp() {
		System.out.println("after method ---  logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("After class ---  close browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("After test ---  delete the user");
	}
	
	@AfterSuite
	public void closeDBConnection() {
		System.out.println("After suite --- close db conenction");
	}
	
	/*
	 * Before Suite -- Connect with DB........
		Before Test -- Create User
		Before class ---  launch browser
		
		Before method ---  loginToApp
		Verify Header...
		after method ---  logout
		
		Before method ---  loginToApp
		Verify login...
		after method ---  logout
		
		Before method ---  loginToApp
		Verify Title...
		after method ---  logout
		
		After class ---  close browser
		After test ---  delete the user
		
		Before Test -- Create User
		Before class ---  launch browser
		
		Before method ---  loginToApp
		Verify Header...
		after method ---  logout
		
		Before method ---  loginToApp
		Verify login...
		after method ---  logout
		
		Before method ---  loginToApp
		Verify Title...
		after method ---  logout
		
		After class ---  close browser
		After test ---  delete the user
	After suite --- close db conenction

	 */
}
