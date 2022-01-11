package utilities;

import org.openqa.selenium.chrome.ChromeDriver;

public class initialiseDriver {

	public static ChromeDriver initiatiase() {
		System.setProperty("webdriver.chrome.driver","src//chromedriver_win32//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		return driver;
		
	}
}
