package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDetails {

	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By clickLogin = By.name("login");

	public LoginDetails(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {

		return driver.findElement(username);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement clickLogin() {

		return driver.findElement(clickLogin);
	}
}
