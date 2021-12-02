package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	By signin = By.linkText("My Account");
	By title = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/ul[1]/li[5]/a[1]");
	By navBar = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/ul[1]/li[5]/a[1]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(signin);
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public WebElement getNavBar() {

		return driver.findElement(navBar);
	}

}
