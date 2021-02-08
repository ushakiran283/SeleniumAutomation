package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

	public WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	private By login = By.cssSelector("a[href*='sign_in']");
	private By featuredCourses = By.xpath("//h2[text()='Featured Courses']");
	private By header = By.xpath("//h3[text()='An Academy to learn Everything about Testing']");
	private By links = By.tagName("a");

	public LoginPageObjects getLogin() {
		driver.findElement(login).click();
		LoginPageObjects log = new LoginPageObjects(driver);
		return log;
	}

	public WebElement getFeaturedCourses() {
		return driver.findElement(featuredCourses);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public List<WebElement> getLinks() {
		return driver.findElements(links);
	}

}
