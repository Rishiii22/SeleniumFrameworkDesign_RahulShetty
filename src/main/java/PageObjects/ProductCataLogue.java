package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ReusableUtilityClass.AbstractComponent;
import net.bytebuddy.asm.Advice.This;

public class ProductCataLogue extends AbstractComponent {
	WebDriver driver;
	public ProductCataLogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath = "//div[@class='card-body']")
	List<WebElement> ProductDetails;
	@FindBy(xpath = "//div[@class='card-body']")
	WebElement ProductDetail;
	By Products=By.xpath("//div[@class='card-body']");
	By AddToCartBtn=By.xpath("button[text()=' Add To Cart']");
	@FindBy(css ="#toast-container" )
	WebElement AddingCartLoad;
	
	 public void AddProducts(String productName)
		{
		ExplicitWait(ProductDetail);
			WebElement exatElement=ProductDetails.stream()
					.filter(element->element.findElement(By.xpath(".//h5/b")).getText().contains(productName)).findFirst().orElse(null);
					exatElement.findElement(AddToCartBtn).click();				
						ExplicitWait(AddingCartLoad);
						waitForElementToInvisible(AddingCartLoad);
		}
	
	
	

}
