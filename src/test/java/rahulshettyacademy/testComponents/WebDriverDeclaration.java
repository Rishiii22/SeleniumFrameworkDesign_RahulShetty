package rahulshettyacademy.testComponents;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;

public class WebDriverDeclaration {
	static String browser;
	static WebDriver driver;
	
public static WebDriver  DeclaringWebDriver(WebDriver driver,String url) throws IOException

{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")
			+"\\src\\test\\java\\rahulshettyacademy\\resources\\globalParameters.properties");
	Properties prop=new Properties();
	prop.load(fis);
	browser=prop.getProperty("browser");
	if (browser=="Chrome") {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
	}
	else if(browser.contains("Edge")){
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
	}
	else if (browser.contains("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
	}
	else {
		ChromeOptions options =new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	driver.manage().window().maximize();
	return driver;
}
}
