package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtilityClass.AbstractComponent;

public class LandingPage extends AbstractComponent {
WebDriver driver;
public LandingPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//input[@type='email']")
WebElement loginIdElement;
@FindBy(xpath = "//input[@type='password']")
WebElement passwordElement;
@FindBy(xpath = "//input[@value='Login']")
WebElement submitBtn;

public void loginApplication(String LoginID,String Password)
{
	loginIdElement.sendKeys(LoginID);
	passwordElement.sendKeys(Password);
	submitBtn.click();
}

}
