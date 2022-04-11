package Assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LearnSelenium.LearnSelenium.ElementUtil;

public class RegisterPageTest {

	public static void main(String[] args)
	{
	
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.launchBrowser("chrome");
		browserUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		System.out.println("Page title is  " + driver.getTitle() + " and URL is " + 
		driver.getCurrentUrl());
		
		//Get all fields locators
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmpassword = By.id("input-confirm");
		
		//Filling all fields
		
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(firstname, "Pooja");
		elementUtil.doSendKeys(lastname, "Srivastava");
		elementUtil.doSendKeys(email, "abc@xyz.com");
		elementUtil.doSendKeys(telephone, "0000000000");
		elementUtil.doSendKeys(password, "abc@123");
		elementUtil.doSendKeys(confirmpassword, "abc@123");
		
		//Quitting the driver
		browserUtil.quitDriver();	
		
	}
	
}
