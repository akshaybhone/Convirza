package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	//DataProvider  1
	
	@DataProvider(name="Logindata")
	public String [][] getLogindata() throws IOException
	{
		String path = ".\\testdata\\Convirza_Logindata.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				logindata [i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata; //returning two dimensional array	
	}
	
	@DataProvider(name="groupAndUserData")
	public String [][] getdata() throws IOException
	{
		String path = ".\\testdata\\group_and_user.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.

		int totalrows = xlutil.getRowCount("group_details");
		int totalcols = xlutil.getCellCount("group_details", 1);
		
		String groupdata [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				groupdata [i-1][j]= xlutil.getCellData("group_details", i, j);
			}
		}
		
		return groupdata; //returning two dimensional array
	}
	
	@DataProvider(name="UserData")
	public String [][] getuserdata() throws IOException
	{
		String path = ".\\testdata\\group_and_user.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.

		int totalrows = xlutil.getRowCount("user_details");
		int totalcols = xlutil.getCellCount("user_details", 1);
		
		String userdata [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				userdata [i-1][j]= xlutil.getCellData("user_details", i, j);
			}
		}
		
		return userdata; //returning two dimensional array
	}
	
	@DataProvider(name="CampaignsData")
	public String [][] getcampaignsdata() throws IOException
	{
		String path = ".\\testdata\\campaigns_page.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("campaign_details");
		int totalcols = xlutil.getCellCount("campaign_details", 1);
		
		String campaigndata [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				campaigndata [i-1][j]= xlutil.getCellData("campaign_details", i, j);
			}
		}
		
		return campaigndata; //returning two dimensional array
	}
	
	@DataProvider(name="TrackingNumberData")
	public String [][] getTrackingNumberdata() throws IOException
	{
		String path = ".\\testdata\\TrackingNumber_data.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("TN_details");
		System.out.println(totalrows);
		int totalcols = xlutil.getCellCount("TN_details", 1);
		System.out.println(totalcols);
		
		String TNdata [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				TNdata [i-1][j]= xlutil.getCellData("TN_details", i, j);
			}
		}
		
		return TNdata; //returning two dimensional array
	}
	
	@DataProvider(name="EditTrackingNumberData")
	public String [][] editTrackingNumberdata() throws IOException
	{
		String path = ".\\testdata\\TrackingNumber_data.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("Edit_TN_details");
		System.out.println(totalrows);
		int totalcols = xlutil.getCellCount("Edit_TN_details", 1);
		System.out.println(totalcols);
		
		String TNdata [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				TNdata [i-1][j]= xlutil.getCellData("Edit_TN_details", i, j);
			}
		}
		
		return TNdata; //returning two dimensional array
	}
	
	@DataProvider(name="ScorecardData")
	public String [][] scorecradsdata() throws IOException
	{
		String path = ".\\testdata\\Scorecards.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("Scorecards_details");
		System.out.println(totalrows);
		int totalcols = xlutil.getCellCount("Scorecards_details", 1);
		System.out.println(totalcols);
		
		String Scorecard_data [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				Scorecard_data [i-1][j]= xlutil.getCellData("Scorecards_details", i, j);
			}
		}
		
		return Scorecard_data; //returning two dimensional array
	}
	
	@DataProvider(name="InsightsData")
	public String [][] insightsdata() throws IOException
	{
		String path = ".\\testdata\\Insights.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("Keyword_details");
		System.out.println(totalrows);
		int totalcols = xlutil.getCellCount("Keyword_details", 1);
		System.out.println(totalcols);
		
		String Scorecard_data [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				Scorecard_data [i-1][j]= xlutil.getCellData("Keyword_details", i, j);
			}
		}
		
		return Scorecard_data; //returning two dimensional array
	}
	
	@DataProvider(name="LLM_InsightsData")
	public String [][] insightsdataLLM() throws IOException
	{
		String path = ".\\testdata\\Insights.xlsx"; //Taking Excel file from testdata.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for ExcelUtility.
		
		int totalrows = xlutil.getRowCount("UltimateAI_details");
		System.out.println(totalrows);
		int totalcols = xlutil.getCellCount("UltimateAI_details", 1);
		System.out.println(totalcols);
		
		String Scorecard_data [][]= new String[totalrows][totalcols];	//created for two dimension array 
		
		for (int i = 1; i <= totalrows; i++) {		//i=rows and i=1 coz data is starting from row 2
			
			for (int j = 0; j < totalcols; j++) {		// j=columns
				Scorecard_data [i-1][j]= xlutil.getCellData("UltimateAI_details", i, j);
			}
		}
		
		return Scorecard_data; //returning two dimensional array
	}

}
