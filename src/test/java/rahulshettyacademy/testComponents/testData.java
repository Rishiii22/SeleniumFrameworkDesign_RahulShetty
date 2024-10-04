package rahulshettyacademy.testComponents;

import java.io.IOException;

import org.testng.annotations.Test;

public class testData {

	dataDriven data =new dataDriven();
	@Test
	public void printData() throws IOException
	{
		data.getData("Purchase").stream().forEach(n->System.out.println(n));
	}
}
