package objRepJson;

import java.io.File;
import java.io.IOException;

import com.jayway.jsonpath.JsonPath;

public class JsonReader {

	static File jsonFile;

	public static void main(String[] args) throws IOException {

		jsonFile = new File("src/objRepJson/ObjectRepository.json");
		String strVar=JsonPath.read(jsonFile,"$."+"FirstName");
		System.out.println(strVar);
		strVar=JsonPath.read(jsonFile,"$."+"LastName");
		System.out.println(strVar);
		strVar=JsonPath.read(jsonFile,"$."+"PartialLink");
		System.out.println(strVar);
	}

}
