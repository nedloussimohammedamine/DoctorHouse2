package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class registrationcontroll {

    @FXML
    private Button Login;
    @FXML
    private Button cblog;

    @FXML
    private TextField confmdp;

    @FXML
    private TextField mail;

    @FXML
    private TextField mdp;

    @FXML
    private TextField name;

    @FXML
    private TextField username;

    @FXML
    void Login(ActionEvent event) {
    	

    }



    @FXML
    void cb	(ActionEvent e) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Login.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();

    }

}
