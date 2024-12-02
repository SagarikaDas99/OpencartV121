package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC_06_ProductAddToWishList extends BaseClass{
	
	@Test()
	public void verify_ProductAddToWishList()throws InterruptedException{
		try {
		logger.info("*******TC_06_ProductAddToWishList Starting********");
		HomePage hm=new HomePage(driver);
		hm.enterProduct("imac");
		hm.clickSearchBtn();
		
		SearchProductPage sp=new SearchProductPage(driver);
		
		ProductPage pp=new ProductPage(driver);
		
		if(sp.isProductExist("imac")) {
			sp.selectProduct("imac");
			pp.addWishList();
		}
		
		Assert.assertEquals(pp.wishMessage(),true);
		}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
