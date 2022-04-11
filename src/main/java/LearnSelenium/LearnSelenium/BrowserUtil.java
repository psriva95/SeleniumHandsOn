package LearnSelenium.LearnSelenium;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser Name is: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\pooja\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver",
//					"C:\\Users\\pooja\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			// will not work in Windows
			// ,exe is managed internally by selenium
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please Pass correct browser : " + browserName);
		}

		return driver;

	}

	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("Please pass correct url");
			return;
		}

		if (url.contains("https") || url.contains("http")) {
			driver.get(url);
		} else {
			driver.close();
			try {
				throw new Exception("InvalidUrlException");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please pass the right url with https or http");
			}
		}

	}

	public void launchUrl(URL url)	{
		driver.navigate().to(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

}
