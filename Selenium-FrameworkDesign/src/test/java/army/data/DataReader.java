package army.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		//Get file into a string
		String JsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\army\\data\\PurchaseOrder.json"),
				StandardCharsets.UTF_8);
		
		//convert string into hashmap - we need to get another dependency called Jackson Databind
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data =  mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		// return the list of hash map
		return data;
		// {map1, map2 }
	}

}
