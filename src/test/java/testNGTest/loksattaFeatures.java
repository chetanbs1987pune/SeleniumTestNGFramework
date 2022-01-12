package testNGTest;

import java.io.IOException;
import java.util.Properties;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.initialiseDriver;
import utilities.propertiesObj;
import utilities.readExcel;

public class loksattaFeatures extends propertiesObj {
	
	ChromeDriver driver;
	Properties obj;
	private static Logger log=LogManager.getLogger(loksattaFeatures.class.getName());
	@Test
	public void openLoksatta() throws IOException, InterruptedException {
		obj = getPropertyObj();
		log.error("This is the class to test the loksatta.com website");
		driver= initialiseDriver.initiatiase();
		driver.get(obj.getProperty("loksatta_url"));
		Thread.sleep(4000);
		log.error("Site is loaded successfully");
		WebElement elment =readExcel.getElement(driver, "web_stories_lok");
		if(elment.isDisplayed()){
			log.error("web stories options is displayed successfully");
		}else {
			log.error("web stories option is not  displayed. Please check.");
		}
		driver.close();
		log.info("Driver object is closed successfully");
	  
		
	}


}
