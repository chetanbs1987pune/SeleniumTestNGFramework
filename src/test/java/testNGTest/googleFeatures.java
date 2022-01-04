package testNGTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.initialiseDriver;
import utilities.propertiesObj;
import utilities.readExcel;
import org.apache.logging.log4j.*;
public class googleFeatures extends propertiesObj {
	
	ChromeDriver driver;
	Properties pro;
	private static Logger log=LogManager.getLogger(googleFeatures.class.getName());
	
@Test
	public void navigateGoogle() throws IOException {
		try { 
		pro=getPropertyObj();
		 driver =	initialiseDriver.initiatiase();
		 driver.get(pro.getProperty("google_url"));
		 log.error("Successfully opened the website");
		 driver.manage().window().maximize();
		 readExcel.getElement(driver,"google_search").sendKeys("admin",Keys.ENTER);
		 log.debug("Successfully clicked on search button");
		 driver.close();
		 log.info("Successfully closed the driver object");
		}catch(Exception e) {
			e.printStackTrace();
			driver.close();
			log.error("Could not open the site ...please check");
		}
	}

}
