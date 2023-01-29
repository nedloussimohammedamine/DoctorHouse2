package controllers;

import java.io.IOException;
import java.sql.SQLException;
import database.PatientDatabase;
import models.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegistrationController {
	
	
	
	@FXML
    private Button cblog;
	
    @FXML
    private TextField mail;
    
    @FXML
    private TextField mdp;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField username;
    
    @FXML
    private Button inscription;
    
    
	PatientDatabase dbpat = new PatientDatabase();
	@FXML   
	 public void Inscriptionn(ActionEvent event) throws SQLException, IOException {
		 if(mail.getText().isBlank()||mdp.getText().isBlank()||name.getText().isBlank()||username.getText().isBlank() ) {
		 Alert alert = new Alert(AlertType.ERROR, "Please fill the hole form", ButtonType.CANCEL);
		 alert.setContentText("There is some fields missing on the form ");
		 alert.getDialogPane().getStylesheets().add("/application/application.css");
		 alert.showAndWait();
		 }else if((dbpat.getPatient(username.getText()))!=null)
		 {
			 Alert alert = new Alert(AlertType.ERROR, "Username has to be unique", ButtonType.CANCEL);
			 alert.setHeaderText("Username has to be unique");
			 alert.setContentText("Username already exist please choose an other");
			 alert.getDialogPane().getStylesheets().add("/application/application.css");
			 alert.showAndWait();
			 
		 }else{
		 Patient patient = new Patient(mail.getText(),mdp.getText(),name.getText(),username.getText());
		 dbpat.addPatient(patient);
		 //logincontrol.(dbpat.getPatient(patient.getUsername()));
		 //logincontrol(dbpat);
		 Node node = (Node) event.getSource();
		 Stage thisStage = (Stage) node.getScene().getWindow();
		 Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
		 Scene scene = new Scene(root);
//		 scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 thisStage.setScene(scene);
		 }
     }
	 public void cb(ActionEvent event) throws IOException {
		 Node node = (Node) event.getSource();
		 Stage thisStage = (Stage) node.getScene().getWindow();
		 Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Login.fxml"));
		 Scene scene = new Scene(root);
//		 scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 thisStage.setScene(scene);
     }
	 
}