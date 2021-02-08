package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPwdPageObjects {

	public WebDriver driver;

	public ForgetPwdPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	private By emailaddress = By.cssSelector("#user_email");

	private By sendinstruction = By.xpath("//input[@value='Send Me Instruction']");

	public WebElement getEmailaddress() {
		return driver.findElement(emailaddress);
	}

	public WebElement getSendinstruction() {
		return driver.findElement(sendinstruction);
	}

}
