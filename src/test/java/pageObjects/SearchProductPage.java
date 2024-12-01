package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {

	// Constructor
	public SearchProductPage(WebDriver driver) {
		super(driver);

	}

	// Locator
	@FindBy(xpath = "//div[@id='content']/div[3]//img")
	List<WebElement> searchproducts;


	// Action
	public boolean isProductExist(String ProductName) {
		boolean flag = false;

		for (WebElement product : searchproducts) {
			if (product.getAttribute("title").equalsIgnoreCase(ProductName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void selectProduct(String ProductName) {
		for (WebElement product : searchproducts) {
			if (product.getAttribute("title").equalsIgnoreCase(ProductName)) {
				product.click();
			}
		}

	}

}
