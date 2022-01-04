package utilities;

import org.openqa.selenium.chrome.ChromeDriver;

public class initialiseDriver {

	public static ChromeDriver initiatiase() {
		System.setProperty("webdriver.chrome.driver","C://Users//Rahul Zagade//Downloads//chromedriver_win32 (2)//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		return driver;
		
	}
}
