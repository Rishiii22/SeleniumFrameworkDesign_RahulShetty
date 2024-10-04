package ReusableUtilityClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}
	public void ExplicitWait(WebElement LocatorName )
	{
	 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf((LocatorName)));
	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div"))));
		
	}
	public void waitForAllElements(WebElement locElement)
	{
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements((locElement)));
	}
	public void waitForElementToInvisible(WebElement LocatorName)
	{
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOf((LocatorName)));
	}
	public void elmentClickUsingAction(WebElement element)
	{
		actions=new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	
}
