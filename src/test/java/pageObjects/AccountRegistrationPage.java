package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	//constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);	
	}

	//Locator
	@FindBy(id="input-firstname")
	WebElement txtfname;
	@FindBy(id="input-lastname")
	WebElement txtlname;
	@FindBy(id="input-email")
	WebElement txtemail;
	@FindBy(id="input-telephone")
	WebElement txttelephone;
	@FindBy(id="input-password")
	WebElement txtpwd;
	@FindBy(id="input-confirm")
	WebElement txtconpwd;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	@FindBy(xpath="//input[@type='submit']")
	WebElement continuebtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action Method
	public void setFirstName(String fname){
		txtfname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtlname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setTelePhone(String telephone) {
		txttelephone.sendKeys(telephone);
	}
	public void setPassword(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	public void setConformPassword(String conpwd) {
		txtconpwd.sendKeys(conpwd);
	}
	public void clickAgree() {
		chkdPolicy.click();
	}
	public void clickContinuebtn() {
		continuebtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
}
