package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	public WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	private By EmailAddress = By.cssSelector("#user_email");
	private By Password = By.cssSelector("#user_password");
	private By LoginButton = By.xpath("//input[@type='submit']");
	private By forgetPassword = By.cssSelector(".link-below-button");

	public WebElement getEmailAddress() {
		return driver.findElement(EmailAddress);
	}

	public WebElement getPassword() {
		return driver.findElement(Password);
	}

	public ForgetPwdPageObjects getforgetPassword() {
		driver.findElement(forgetPassword).click();
		ForgetPwdPageObjects fp = new ForgetPwdPageObjects(driver);
		return fp;
	}

	public WebElement getLoginButton() {
		return driver.findElement(LoginButton);
	}

}
