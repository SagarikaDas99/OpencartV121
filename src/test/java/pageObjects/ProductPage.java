package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
		
	}
	//Locator
	@FindBy(id="input-quantity")
	WebElement txtquantity;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnaddtocart;

	@FindBy(xpath = "//div[contains(text(),'Success: You have added' )]")
	WebElement cfnmsg;
	
	@FindBy(xpath="//button[@data-original-title='Add to Wish List']")
	WebElement btnWish;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement wishmsg;
	
	//Action
	public void setQuantity(String qty) {
		txtquantity.clear();
		txtquantity.sendKeys(qty);
	}

	public void addToCart() {
		btnaddtocart.click();
	}

	public boolean checkMessage() {
		try {
			return cfnmsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void addWishList() {
		btnWish.click();
	}
	
	public boolean wishMessage() {
		try {
			return wishmsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
