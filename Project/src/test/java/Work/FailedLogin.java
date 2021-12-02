package Work;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginDetails;
import PageObject.LoginPage;
import resources.base;

public class FailedLogin extends base {

	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver =initializeDriver();
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		LoginPage l=new LoginPage(driver);
		l.getLogin().click();
		LoginDetails lp=new LoginDetails(driver);
		lp.getUsername().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		lp.clickLogin().click();

	}

	@AfterTest
	public void closeproj() {
		driver.quit();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {

		Object[][] data=new Object[2][3];

		data[0][0] = "azhar@adolmedia.com";
		data[0][1] = "Azharhot04@";
		data[0][2] = "azharin adol";

		data[1][0] = "testing@adolmedia.com";
		data[1][1] = "Adol@175";
		data[1][2] = "testing in Adol";

		return data;

	}
	
}
