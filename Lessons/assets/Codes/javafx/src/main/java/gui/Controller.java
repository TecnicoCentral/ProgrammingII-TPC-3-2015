/**
 * Sample Skeleton for 'main3.fxml' Controller Class
 */

 package gui;

 import java.net.URL;
 import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
 
 public class Controller {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="password"
     private TextField password; // Value injected by FXMLLoader
 
     @FXML // fx:id="user"
     private TextField user; // Value injected by FXMLLoader
 
     @FXML
     void print(ActionEvent event) {
      String usuario = user.getText();
      String contraseña = password.getText();
      System.out.printf("Usuario: %s. Contraseña: %s%n",usuario, contraseña);
     }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'main3.fxml'.";
         assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'main3.fxml'.";
 
     }
 }
 