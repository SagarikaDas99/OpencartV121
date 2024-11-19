package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h2[text()='My Account']")   //my Account heading
	WebElement msgHeadline;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logout;
	
	public boolean isMyAccountPageExists()   //my account page heading display status
	{
		try {
			return(msgHeadline.isDisplayed());
		}catch(Exception e) {
			return(false);
		}		
	}
	
	public void clickLogout() {
		logout.click();
	}

}
