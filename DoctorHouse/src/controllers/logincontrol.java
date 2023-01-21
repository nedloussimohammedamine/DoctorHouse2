package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import application.Database;
import database.DoctorDatabase;
import database.PatientDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Doctor;
import models.Patient;
import javafx.scene.Node;

public class logincontrol {
	
	@FXML
    private Button register;
	
	@FXML
	private Button login;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
    private static Patient pt;
    
    public static Patient getPt() {
		return pt;
	}

	public static void setPt(Patient pt) {
		logincontrol.pt = pt;
	}

	Patient patient ;
    PatientDatabase patientDB = new PatientDatabase();
    
    @FXML
    void forgetpassword(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent e) throws IOException, SQLException {
    	//System.out.println("login");
    	if(patientDB.getPatient(username.getText())==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
   	    	alert.setTitle("Invalid Input");
   	    	alert.setHeaderText("Your username is incorrect ");
   	    	alert.setContentText("Make sure you enter your correct username");
   	    	alert.getDialogPane().getStylesheets().add("/application/application.css");
   	    	alert.showAndWait();	
    	}else if(patientDB.getPatient(username.getText())!=null) {
    		pt = patientDB.getPatient(username.getText());
    		if(pt.getPassword().compareTo(password.getText())==0) {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Accueil.fxml"));
    	        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
    	        stage.setScene(new Scene(loader.load()));
    	    	stage.show();
    		}else {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
       	    	alert.setTitle("Invalid Input");
       	    	alert.setHeaderText("Your password is incorrect ");
       	    	alert.setContentText("Make sure you enter your correct password");
       	    	alert.getDialogPane().getStylesheets().add("/application/application.css");
       	    	alert.showAndWait();	
    		}
    	}
    	
    	//System.out.println((dr.getDoctor(username.getText(), password.getText())).getUsername());
    	
    }

    @FXML
    void register(ActionEvent e) throws IOException {    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Registration.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();
    	

    }


}
