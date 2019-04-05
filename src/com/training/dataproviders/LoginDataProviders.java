package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[15]; 
			obj[0] = temp.getLoginName(); 
			 obj[1] = temp.getFullName(); 
			 obj[2] = temp.getEmail();
			 obj[3] = temp.getBirthday();
			 obj[4] = temp.getGender();
			 obj[5] = temp.getAddress();
			 obj[6]  = temp.getPostalCode();
			 obj[7] = temp.getCity();
			 obj[8] = temp.getArea();
			 obj[9] = temp.getPhone();
			 obj[10] = temp.getMobPhone();
			 obj[11] = temp.getFax();
			 obj[12] = temp.getUrl();
			 obj[13] = temp.getPassword();
			 obj[14] = temp.getConfirmPassword();
			 //obj[15]=temp.getCaptcha();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="D:/Swetha selenium/Cyclos/Testdata.xlsx"; 
		String SheetName="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="D:/Swetha selenium/Cyclos/Testdata.xlsx"; 
		String SheetName="Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="D:/Swetha selenium/Cyclos/Testdata.xlsx"; 
		String SheetName="Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("D:/Swetha selenium/Cyclos/Testdata.xlsx", "Sheet1"); 
	}
}
