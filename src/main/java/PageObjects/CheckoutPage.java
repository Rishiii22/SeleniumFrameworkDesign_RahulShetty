package PageObjects;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtilityClass.AbstractComponent;
import net.bytebuddy.asm.Advice.This;

public class CheckoutPage extends AbstractComponent {
WebDriver driver;
public CheckoutPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//input[@placeholder='Select Country']")
WebElement DynmicCountryCombobox;

@FindBy(xpath = "//button[contains(@class,'ta-item')]/span")
List<WebElement> CountryDropdownValues;

@FindBy(xpath = "//a[text()='Place Order ']")
WebElement placeOrder;
public void ClickonCountryDropdown(String countryName)
{
	DynmicCountryCombobox.click();
	DynmicCountryCombobox.sendKeys(countryName);
}
public void SelectCountry(String countryName)
{
	waitForAllElements(DynmicCountryCombobox);
Optional<WebElement> countryNamElement=CountryDropdownValues.stream().filter(n->n.getText().equalsIgnoreCase("India")).findFirst();
	countryNamElement.ifPresent(WebElement::click);
}
public void placeTheorder() {
	elmentClickUsingAction(placeOrder);
}

}
