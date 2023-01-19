package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Doctor;

public class Database {

	

	
		
		 public static Connection connection = null;
		
			static {
			    String databaseName = "doctorhouse";
	            String databaseUser = "root";
			    String databasePassword = "0000";
	            String url = "jdbc:mysql://localhost:3306/"+databaseName+"?autoReconnect=true&useSSL=false&characterEncoding=utf8";
	     
			    
			    
			   try {
				   System.out.println("before connection");
				   Class.forName("com.mysql.cj.jdbc.Driver");
				   connection =  DriverManager.getConnection(url,databaseUser,databasePassword);
				   System.out.println("After connexion");
			   }catch (Exception e) {
				   e.printStackTrace();
				   e.getCause();
			   }
			}
			
			public static Connection getConnection()
		    {
				System.out.println("Connx");
		        return connection;
		    }
	
		       public static ObservableList<Doctor> getDataDoctor() {
		    	   System.out.println("getdata method");
		    	   
		    	   Connection conn = getConnection();
		    	   ObservableList<Doctor> list = FXCollections.observableArrayList();
		    	   try {
		    		   System.out.println("try");
//		    		   PreparedStatement ps = conn.prepareStatement("select * from doctor");
//		    		   ResultSet rs = ps.executeQuery();
		    		   Statement ps = conn.createStatement();
		    		   ResultSet rs = ps.executeQuery("select * from doctor");
		    		   
		    		   while (rs.next()) {
		    			   System.out.println(rs.getInt("ID"));
		    			   list.add(new Doctor(rs.getInt("ID"),rs.getString("username"),rs.getString("speciality"),rs.getBoolean("disponibility")));
		    		   }
		    		    
		    		   } catch (Exception e) {
		    			   
		    		   }
		    	   return list;
		       }

}
