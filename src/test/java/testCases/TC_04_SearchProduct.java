package testCases;

import pageObjects.HomePage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_SearchProduct extends BaseClass {

	@Test()
	public void verify_SearchProduct()throws InterruptedException{

		logger.info("******TC_04_SearchProduct starting*******");
		try {
			HomePage hm = new HomePage(driver);
			hm.enterProduct("macbook");

			logger.info("Passing the Product name in Search Textbox");

			hm.clickSearchBtn();
			logger.info("click on the search button");

			SearchProductPage sp = new SearchProductPage(driver);
			sp.isProductExist("MacBook");

			Assert.assertEquals(sp.isProductExist("MacBook"),true);
		} catch (Exception e) {
			Assert.fail();
		}
       logger.info("*****TC_04_SearchProduct Ending*******");
	}
}
