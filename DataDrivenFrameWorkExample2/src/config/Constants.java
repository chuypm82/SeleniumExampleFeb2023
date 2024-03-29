package config;

public class Constants {

	// List of System Variables
	public static final String URL = "https://rahulshettyacademy.com/client/";
	public static final String Path_TestData = "src/dataEngine/DataEngine.xlsx";
	public static final String File_TestData = "DataEngine.xlsx";
	public static final String Path_OR = "src/config/OR.txt";
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";


	// List of Data Sheet Column Numbers for Test Steps Sheet
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1 ;
	public static final int Col_PageObject =4 ;
	public static final int Col_ActionKeyword =5 ;
	public static final int Col_DataSet =6 ;
	public static final int Col_TestStepResult =7 ;
	// List of Data Sheet Column Numbers for Test Cases Sheet
	public static final int Col_RunMode = 2;
	public static final int Col_Result =3 ;

	// List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
    public static final String Sheet_TestCases = "Test Cases";


}
