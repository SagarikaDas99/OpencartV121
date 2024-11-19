package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verify_Login() {
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try {
		// Home page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin(); // Login link under MyAccount
		logger.info("clicked on login link under myaccount..");
		
		// Login page
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); // Login button
		logger.info("clicked on ligin button..");
		
		//MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true,"Login failed");
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_002_LoginTest  ****");
	}

}