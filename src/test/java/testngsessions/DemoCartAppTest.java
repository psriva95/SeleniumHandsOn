package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartAppTest extends BaseTest {
	
	
	@Test
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test
	public void urlTest() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("account/login"));
	}
	
	@Test
	public void searchTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
			Assert.assertTrue(driver.findElement
					(By.className("search")).isDisplayed());
	}
	
	
	
}
