package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import application.Database;
import database.DoctorDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Doctor;
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
    
    DoctorDatabase dr = new DoctorDatabase();
    Doctor doctor ;
    
    @FXML
    void forgetpassword(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent e) throws IOException {
    	//System.out.println("login");
    	//doctor = dr.getDoctor(username.getText(), password.getText());
    	
    	//System.out.println((dr.getDoctor(username.getText(), password.getText())).getUsername());
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Accueil.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();
    }

    @FXML
    void register(ActionEvent e) throws IOException {    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Registration.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();
    	

    }


}
