package SeleniumDataProviderPractice;

import org.testng.annotations.Test;

public class Basictesting extends BaseTests {
//	@Test(dataProvider = "getDataFromJson")
	public void DataProviderTest(String s1,String s2,String s3)
	{
		System.out.println(s1+"\t"+s2+"\t"+s3);
	}
	
	public boolean primeNumberCheck(int n)
	{
		switch (n) {
		case 0:
			return false;

		case 1:
			return false;
		case 2:
			return false;
		case 3:
			return true;
		case 5:
			return true;
		case 7:
			return true;
			default:
				if (n%2==0||n%3==0||n%5==0||n%7==0||Math.sqrt(n)==Math.floor(Math.sqrt(n))) {
					return false;
				}
				return true;
		}
	}
	@Test
	public void primeNumber()
	{
		for(int i=0;i<=1000;i++)
		{
			if (primeNumberCheck(i)) 
				System.out.println("A prime number"+" the num is"+ i);
			
			else 
				System.out.println("Not a prime number"+ " the num is"+ i);
		}
	}
}
