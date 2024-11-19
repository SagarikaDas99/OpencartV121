package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_01_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_AccountRegister() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try {
		//1st Objectpage class
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		//2nd Objectpage Class
		AccountRegistrationPage arpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		arpage.setFirstName(randomString().toUpperCase());
		arpage.setLastName(randomString().toUpperCase());
		arpage.setEmail(randomString()+"@gmail.com"); //randomly generated the email
		arpage.setTelePhone(randomNumeric());
		
		String pass=randomAlphanumeric();
		arpage.setPassword(pass);
		arpage.setConformPassword(pass);
		
		arpage.clickAgree();
		arpage.clickContinuebtn();
		
		logger.info("Validating expected message..");
		
		String conmsg=arpage.getConfirmationMsg();
		Assert.assertEquals(conmsg,"Your Account Has Been Created!");
		
		logger.info("Test passed");
		}
		catch(Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());	
		}
		finally
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}


}
