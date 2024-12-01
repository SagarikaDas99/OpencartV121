package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC_05_ProductAddToCart extends BaseClass{
	
	@Test()
	public void verify_ProductAddToCart() {
		logger.info("******TC_05_ProductAddToCart Starting********");
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProduct("iphone");
		hp.clickSearchBtn();
		
		SearchProductPage sp=new SearchProductPage(driver);
		ProductPage pp=new ProductPage(driver);
		
		if(sp.isProductExist("iphone")) {
			sp.selectProduct("iphone");
			pp.setQuantity("2");
			pp.addToCart();
		}
		
		Assert.assertEquals(pp.checkMessage(),true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***********TC_05_ProductAddToCart Ending**********");
	}

}
