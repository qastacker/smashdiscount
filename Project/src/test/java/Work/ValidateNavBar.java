package Work;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import resources.base;

public class ValidateNavBar extends base {

	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {

		LoginPage n=new LoginPage(driver);
		Assert.assertTrue(n.getNavBar().isDisplayed());
		log.info("Successfully validated NavBar");
		//System.out.println("Test completed");

	}

	@AfterTest
	public void closeproj() {
		driver.quit();
		driver=null;
	}
}
