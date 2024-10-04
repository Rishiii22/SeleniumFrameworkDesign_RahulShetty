package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableUtilityClass.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> orderedPrdRowElements;
	
	public boolean CheckForItemAvaliability(String productName) {
		 return orderedPrdRowElements.stream().anyMatch(n->n.findElement(By.xpath(".//td[2]")).getText().contains(productName));
	}
}
