package testngsessions;

import org.testng.annotations.Test;

public class MyTest {

	@Test
	public void test1() {
		System.out.println("Test1 method");
	}
	
	/*
	 *     Before Suite -- Connect with DB........
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
			Test1 method
			After test ---  delete the user
			After suite --- close db conenction
	 
	 *
	 *
	 *
	 *
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
				Test1 method
				After suite --- close db conenction 
				
	*/
}
