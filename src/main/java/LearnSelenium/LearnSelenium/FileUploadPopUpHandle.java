package LearnSelenium.LearnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUpHandle {
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\pooja\\Downloads\\tRAIN.pdf");
		
	}
}
