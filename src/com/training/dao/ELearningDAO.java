package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.reguser"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setLoginName(gc.rs1.getString(1));
				temp.setFullName(gc.rs1.getString(2));
				temp.setEmail(gc.rs1.getString(3));
				temp.setBirthday(gc.rs1.getString(4));
				temp.setGender(gc.rs1.getString(5));
				temp.setAddress(gc.rs1.getString(6));
				temp.setPostalCode(gc.rs1.getString(7));
				temp.setCity(gc.rs1.getString(8));
				temp.setArea(gc.rs1.getString(9));
				temp.setPhone(gc.rs1.getString(10));
				temp.setMobPhone(gc.rs1.getString(11));
				temp.setFax(gc.rs1.getString(12));
				temp.setUrl(gc.rs1.getString(13));
				temp.setPassword(gc.rs1.getString(14));
				temp.setConfirmPassword(gc.rs1.getString(15));
				//temp.setCaptcha(gc.rs1.getString(15));
				
				
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new ELearningDAO().getLogins().forEach(System.out :: println);
	}
	
	
}
