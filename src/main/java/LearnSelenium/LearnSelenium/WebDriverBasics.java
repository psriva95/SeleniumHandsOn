package LearnSelenium.LearnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics 
{
    
	public static void main( String[] args )
    {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\pooja\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch
		driver.get("https://www.google.co.in");
		
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
		
    }
	
}
