package LearnSelenium.LearnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {
	public static void main( String[] args )
    {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\pooja\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch
		driver.get("https://www.google.co.in");
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		System.out.println( driver.getTitle());
		
	//	ChromeDriver: chrome on WINDOWS (e0be42b9c1f69470ee389f77233a2ba3)
	//	ChromeDriver: chrome on WINDOWS (e0be42b9c1f69470ee389f77233a2ba3)
    }
}
