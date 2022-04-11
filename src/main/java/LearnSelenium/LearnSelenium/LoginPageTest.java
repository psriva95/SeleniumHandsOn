package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.launchBrowser("chrome");
		browserUtil.launchUrl("");
		String title = browserUtil.getPageTitle();
		System.out.println(browserUtil.getPageUrl());

		By byemail1 = By.id("input-email");
		By pass1 = By.id("input-password");

		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(pass1, "abac");

		// https://demo.opencart.com/index.php?route=account/register

	}

}
