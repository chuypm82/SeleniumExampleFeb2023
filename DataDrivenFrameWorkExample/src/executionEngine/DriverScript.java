package executionEngine;

import java.lang.reflect.Method;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {

	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method method[];

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {
		
		DriverScript ds= new DriverScript();

		String sPath = Constants.Path_TestData;
		ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestSteps);

		for (int iRow = 1; iRow <= 8; iRow++) {

			sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
			//ds.execute_Actions();
			execute_Actions();
		}
	}

	private static void execute_Actions() throws Exception {

		for (int i = 0; i < method.length; i++) {
			// This is now comparing the method name with the ActionKeyword value got from
			// excel
			if (method[i].getName().equals(sActionKeyword)) {
				// In case of match found, it will execute the matched method
				method[i].invoke(actionKeywords);
				// Once any method is executed, this break statement will take the flow outside
				// of for loop
				break;
			}
		}
	}
}
