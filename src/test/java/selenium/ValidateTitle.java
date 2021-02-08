package selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepository.LandingPageObjects;
import resources.Base;

public class ValidateTitle extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPageObjects landing;

	@BeforeTest
	public void initialise() throws IOException {
		driver = InitialSetup();
		log.info("Driver is initialised");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test(priority = 1)
	public void VerifyTitle() throws IOException, InterruptedException {
		// 1- By inheritance
		// 2-create object to that class to invoke/call methods of particular class
		landing = new LandingPageObjects(driver);
		Assert.assertEquals(landing.getFeaturedCourses().getText(), "FEATURED COURSES");
		Thread.sleep(2000);
		log.info("succesfully validated text message");
	}

	@Test(priority = 2)
	public void VerifyHeader() {
		LandingPageObjects landing = new LandingPageObjects(driver);
		Assert.assertEquals(landing.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("succesfully validated text message");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
