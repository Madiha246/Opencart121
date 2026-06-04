package genericUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\opencart_Logindata.xlsx";
		ExcelFileUtility xutil=new ExcelFileUtility(path);
		
		int totalrows=xutil.getRowCount("Sheet1");
		int totalcols=xutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				
				logindata[i-1][j]=xutil.getCellData("Sheet1",i,j);
			}
			
		}
		
		return logindata;	
	}
	
	//DataProvider2
	
	//DataProvider3
	

}
