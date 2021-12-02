package Work;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Work.ValidateTitle;
import PageObject.LoginPage;
import resources.base;

public class ValidateTitle extends base {

	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver =initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void basePageNavigation() throws IOException {

		LoginPage t=new LoginPage(driver);
		Assert.assertEquals(t.getTitle().getText(), "Contact Us");
		log.info("Successfully validated Title");
		//System.out.println("Test completed");

	}

	@AfterTest
	public void closeproj() {
		driver.quit();
		driver=null;
	}
}
