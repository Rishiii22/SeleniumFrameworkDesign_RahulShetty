package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtilityClass.AbstractComponent;

public class CommonElement extends AbstractComponent {
WebDriver driver;
public CommonElement(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//button[contains(text(),'Cart')]")
WebElement cartBtn;

@FindBy(xpath="//button[contains(text(),'ORDERS')]")
WebElement ordersbtn;
public void clickonCart()
{
	cartBtn.click();
}
public void clickonOrders()
{
	ordersbtn.click();
}
}
