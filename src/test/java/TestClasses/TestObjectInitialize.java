package TestClasses;

import org.testng.annotations.Test;

import rahulshettyacademy.testComponents.BaseTest;

public class TestObjectInitialize extends BaseTest {

	@Test
	public void initializeObjects()
	{
		System.out.println(landingPage);
		
	}
	@Test
	public void LoginScenario()
	{
		landingPage.loginApplication("test34@gmail.com","Testing21");
		productCataLogue.AddProducts("ZARA");
	}
}
