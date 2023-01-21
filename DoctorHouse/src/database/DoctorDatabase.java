package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Doctor;

public class DoctorDatabase {
	static Connection con = Database.getConnection();
	Doctor dr = new Doctor(0, null, null, null, false);
	ObservableList<Doctor> Doctors;
	public  Doctor getDoctor(String username, String Psw) throws SQLException {
		 String query = "select * from doctor where username = ? and password = ?";
		 
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setString(1, username);
	        ps.setString(2, Psw);
	        ResultSet rs = ps.executeQuery();
	     
	      boolean isnotnull=false;
	        while (rs.next()) {
	        	isnotnull=true;
	        	dr.setId(rs.getInt("ID"));
	        	dr.setUsername(rs.getString("username"));
	        	dr.setPassword(rs.getString("password"));
	        	dr.setSpeciality(rs.getString("speciality"));
	        	dr.setDisponibilite(rs.getBoolean("disponibility"));
		
	         }
	        if(isnotnull) {
	        	return dr;
	        }else {
	        	return null;
	        }
	      

		
	}
	public void isDispo(Doctor doctor) throws SQLException {
		String query = "update doctor set disponibility=? "
		          + " where ID = ?";
				PreparedStatement ps
					= con.prepareStatement(query);
				
				ps.setBoolean(1, doctor.isDisponibilite());
				ps.setInt(2, doctor.getId());
				ps.executeUpdate();
				System.out.println("Doctor updated");
	}
	public ObservableList<Doctor> getDataDoctor() {
 	   System.out.println("getdata method");
 	   
 	   
 	  Doctors = FXCollections.observableArrayList();
 	   try {
 		   System.out.println("try");
// 		   PreparedStatement ps = conn.prepareStatement("select * from doctor");
// 		   ResultSet rs = ps.executeQuery();
 		   Statement ps = con.createStatement();
 		   ResultSet rs = ps.executeQuery("select * from doctor");
 		   
 		   while (rs.next()) {
 			   System.out.println(rs.getInt("ID"));
 			  Doctors.add(new Doctor(rs.getInt("ID"),rs.getString("username"),rs.getString("speciality"),rs.getBoolean("disponibility")));
 		   }
 		    
 		   } catch (Exception e) {
 			   
 		   }
 	   return Doctors;
    }

	
	
}
