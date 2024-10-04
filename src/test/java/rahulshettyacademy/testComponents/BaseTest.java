package rahulshettyacademy.testComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.CommonElement;
import PageObjects.LandingPage;
import PageObjects.OrderPage;
import PageObjects.ProductCataLogue;

public class BaseTest {
	public static WebDriver driver;
public	 LandingPage landingPage;
	public  ProductCataLogue productCataLogue;
public	 CommonElement commonElement;
public	 CartPage cartPage;
public	 CheckoutPage checkoutPage;
public	 OrderPage orderPage;
public	 ExtentReports extent;

WebDriverDeclaration declareDriver= new WebDriverDeclaration();
	@BeforeMethod
public	void DriverPrerequisite() throws IOException
	{
	
		driver=declareDriver.DeclaringWebDriver(driver, "https://rahulshettyacademy.com/client");
		landingPage=new LandingPage(driver);
		productCataLogue=new ProductCataLogue(driver);
		commonElement=new CommonElement(driver);
		cartPage=new CartPage(driver);
		checkoutPage=new CheckoutPage(driver);
		orderPage=new OrderPage(driver);
	}
	@AfterMethod
public	void TearDown()
	{
		driver.quit();
	}
	@DataProvider
public	Object[][] Getdata() throws IOException
	{
//		HashMap<String,String> loginDetails=new HashMap<String, String>();
//		loginDetails.put("Email","test34@gmail.com");
//		loginDetails.put("Password","Testing21");
		
//		*************************************** Using Json Approach to grab test data******************************
//		read json to string
		 String jsonfile=FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				 "\\src\\test\\java\\rahulshettyacademy\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
		 
		// convert the string to hashmap
		// String to hashmap jackson databind
		 ObjectMapper mapper=new ObjectMapper();
		 List<HashMap<String,String>> data=mapper.readValue(jsonfile,new TypeReference<List<HashMap<String,String>>>(){
		});
		
		 
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	@DataProvider
public	List<HashMap<String,String>> GetdataHash() throws IOException
	{
//		HashMap<String,String> loginDetails=new HashMap<String, String>();
//		loginDetails.put("Email","test34@gmail.com");
//		loginDetails.put("Password","Testing21");
		
//		*************************************** Using Json Approach to grab test data******************************
//		read json to string
		 String jsonfile=FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				 "\\src\\test\\java\\rahulshettyacademy\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
		 
		// convert the string to hashmap
		// String to hashmap jackson databind
		 ObjectMapper mapper=new ObjectMapper();
		 List<HashMap<String,String>> data=mapper.readValue(jsonfile,new TypeReference<List<HashMap<String,String>>>(){
		});
		
		 
		return data;
	}
public	String TakeScrnshot(String TestCaseName,WebDriver driver) throws IOException
	{
//		create current date time
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String formattedDateTime = now.format(formatter);
//		take scrnshot at specified location
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filename=String.format(System.getProperty("user.dir")+"\\Reports\\"+TestCaseName+"_%s.jpg", formattedDateTime);
		File destnFile=new File(filename);
		System.out.println(filename);
		FileUtils.copyFile(src,destnFile);
		return filename;
	}
@DataProvider
public Object[][] getDataFromExcel() throws IOException
{
	dataDriven data =new dataDriven();
	List<List<String>> datalist=new ArrayList<>();
	datalist.add(data.getData("Purchase"));
	datalist.add(data.getData("Login"));
	datalist.add(data.getData("Login2"));
	// Determine the number of rows
    int numRows = datalist.size();
    // Find the maximum number of columns required (max size of inner lists)
    int maxCols = 0;
    for (List<String> arrayList : datalist) {
        maxCols = Math.max(maxCols, arrayList.size());
    }

    // Initialize the 2D array with the determined size
    String[][] array2D = new String[numRows][maxCols];

    // Populate the 2D array
    for (int i = 0; i < numRows; i++) {
        List<String> row = datalist.get(i);
        for (int j = 0; j < row.size(); j++) {
            array2D[i][j] = row.get(j);
        }
    }
    return array2D;
   }
}
