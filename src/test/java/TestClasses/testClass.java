package TestClasses;

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

public class testClass {
	@Test
	void Getdata() throws IOException
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
		System.out.println(data.get(0));
	}

}
