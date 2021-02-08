package selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.ForgetPwdPageObjects;
import objectRepository.LandingPageObjects;
import objectRepository.LoginPageObjects;
import resources.Base;

public class HomePageTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialise() throws IOException {
		driver = InitialSetup();
	}

	@Test(dataProvider = "loginData")
	public void testPageNavigation(String Username, String Password) throws IOException {
		// 1- By inheritance
		// 2-create object to that class to invoke/call methods of particular class
		driver.get(prop.getProperty("url"));
		log.info("succesfully Navigated to home page");
		LandingPageObjects landing = new LandingPageObjects(driver);
		LoginPageObjects log = landing.getLogin();
		log.getEmailAddress().sendKeys(Username);
		log.getPassword().sendKeys(Password);
		log.getLoginButton().click();
		ForgetPwdPageObjects forget = log.getforgetPassword();
		forget.getEmailaddress().sendKeys(Username);
		forget.getSendinstruction().click();

	}

	@DataProvider()
	public Object[][] loginData() {
		// row stands for how many different data types test should run
		// column stands for how many values per each test
		// array size is 2
		// i.e index starts from 0,1
		Object[][] obj = new Object[2][2];
		// Invalid data
		obj[0][0] = "nimmagaddaushakiran@gmai.com";
		obj[0][1] = "ushaprasad3";
		// Invalid data
		obj[1][0] = "nimmagaddaushakiran@gmail.com";
		obj[1][1] = "ushaprasad3";
		return obj;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
