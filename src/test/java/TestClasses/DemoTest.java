package TestClasses;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import rahulshettyacademy.testComponents.BaseTest;

public class DemoTest extends BaseTest {
@Test(dataProvider = "getDataFromExcel")
public void testingDataProvider(String data1,String data2,String data3)
{
	System.out.println(data1+"\t"+data2+"\t"+data3);
	
}
@Test
public void test() throws IOException
{
	for (int i=0;i<getDataFromExcel().length;i++)
	{
		for(int j=0;j<getDataFromExcel()[i].length;j++)
		{
			System.out.print(getDataFromExcel()[i][j]+" ");
		}
		System.out.println();
	}
}
}
