package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtilityClass.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//div[@class='infoWrap']")
	List<WebElement> CheckoutItems;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement CheckoutBtn;
	public boolean checkForElementPresence(String productName)
	{
		return CheckoutItems.stream()
		.anyMatch(element->element.findElement(By.xpath(".//h3")).getText().contains(productName));
	}
	public void CheckoutClick()
	{
		ExplicitWait(CheckoutBtn);
		elmentClickUsingAction(CheckoutBtn);
	}

}
