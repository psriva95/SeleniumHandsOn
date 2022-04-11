package LearnSelenium.LearnSelenium;

public class AmazonTest {

	public static void main(String[] args) {
		BrowserUtil browserUtil = new BrowserUtil();
		browserUtil.launchBrowser("chrome");
		browserUtil.launchUrl("www.google.co.in");
		System.out.println(browserUtil.getPageTitle());
	}

}
