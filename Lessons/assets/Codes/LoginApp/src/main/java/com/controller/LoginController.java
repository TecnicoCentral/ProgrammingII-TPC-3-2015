package com.controller;

/**
 * Sample Skeleton for 'LoginApp.fxml' Controller Class
 */


 import java.net.URL;
 import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
 

 /**
 * Sample Skeleton for 'LoginApp.fxml' Controller Class
 */

public class LoginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="User1"
    private TextField User1; // Value injected by FXMLLoader

    @FXML // fx:id="imagen"
    private ImageView imagen; // Value injected by FXMLLoader

    @FXML // fx:id="password1"
    private TextField password1; // Value injected by FXMLLoader

    @FXML // fx:id="preguntar"
    private Button preguntar; // Value injected by FXMLLoader

    @FXML // fx:id="login"
    private Button login; // Value injected by FXMLLoader

    @FXML // fx:id="register"
    private Button register; // Value injected by FXMLLoader


    @FXML
    void buttom_register(ActionEvent event) {

    }

    @FXML
    void login_buttom(ActionEvent event) {

    }

    @FXML
    void Buscar(ActionEvent event) {
        imagen.setImage(new Image("https://www.tutorialspoint.com/javafx/images/alert.jpg"));
        System.out.print("asdasd");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert User1 != null : "fx:id=\"User1\" was not injected: check your FXML file 'LoginApp.fxml'.";
        assert imagen != null : "fx:id=\"imagen\" was not injected: check your FXML file 'LoginApp.fxml'.";
        assert password1 != null : "fx:id=\"password1\" was not injected: check your FXML file 'LoginApp.fxml'.";
        assert preguntar != null : "fx:id=\"preguntar\" was not injected: check your FXML file 'LoginApp.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'LoginApp.fxml'.";
        assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'LoginApp.fxml'.";

    }
}
