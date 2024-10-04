package SeleniumDataProviderPractice;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTests {
	
@DataProvider
public String[][] getDataFromJson() throws IOException
{
//		read json then convert to string
		 String jsonfile=FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				 "\\src\\test\\java\\rahulshettyacademy\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
		 
		// convert the string to hashmap
		// String to hashmap jackson databind
		 ObjectMapper mapper=new ObjectMapper();
		 List<HashMap<String,String>> data=mapper.readValue(jsonfile,new TypeReference<List<HashMap<String,String>>>(){
		});
		 // Convert the List of hashmaps into 2d Array
		 
		 return convertListOfHashmapsTo2DArray(data);
}
	public String[][] convertListOfHashmapsTo2DArray(List<HashMap<String,String>> dataHashMaps)
	{
//		get the number of keys and values in hasmap
		String[] keys = dataHashMaps.get(0).keySet().toArray(new String[0]);
		// declaring the 2d String
		 String[][] result = new String[dataHashMaps.size()][keys.length];
		 for (int i = 0; i < dataHashMaps.size(); i++) {
	            HashMap<String, String> map = dataHashMaps.get(i);
	            for (int j = 0; j < keys.length; j++) {
	                result[i][j] = map.get(keys[j]);
	            }
	        }
		 return result;
	}
//	@Test
	public void test() throws IOException
	{
		for(int i=0;i<getDataFromJson().length;i++)
		{
			for(int j=0;j<getDataFromJson()[i].length;j++)
			{
				System.out.print(getDataFromJson()[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
}
