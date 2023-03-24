package config;

public class Constants {

	// This is the list of System Variables
	// Declared as 'public', so that it can be used in other classes of this project
	// Declared as 'static', so that we do not need to instantiate a class object
	// Declared as 'final', so that the value of this variable can be changed
	// 'String' & 'int' are the data type for storing a type of value
	
	public static final String Path_TestData = System.getProperty("user.dir")+"/src/dataEngine/DataEngine_ObjectsActionsToghether.xlsx";
	public static final String File_TestData = "DataEngine.xlsx";
	public static final String URL = "https://rahulshettyacademy.com/client/";

	// List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;
	public static final int Col_TestScenarioID = 1;
	public static final int Col_ActionKeyword = 3;

	// List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";

	// List of Test Data
	public static final String UserName = "chuy@bah.com";
	public static final String Password = "Hello1234!";

}
