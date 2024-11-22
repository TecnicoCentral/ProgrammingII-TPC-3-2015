# Taller Práctico: Creación de una Interfaz de Ingreso con JavaFX y MVC

## Introducción

En este taller aprenderás a implementar una interfaz gráfica básica para el ingreso a una aplicación, utilizando **JavaFX** y aplicando el **patrón de diseño MVC** (Modelo-Vista-Controlador). La interfaz estará dividida en dos secciones:  
1. Una imagen grande a la izquierda.  
2. Dos campos de texto para ingresar usuario y contraseña, junto con botones para iniciar sesión y registrar un nuevo usuario, ubicados a la derecha.  

Además, la funcionalidad estará conectada a una base de datos que permitirá verificar si un usuario existe o registrarlo.

## Objetivos

1. Diseñar una interfaz gráfica con **JavaFX**.
2. Implementar el patrón **MVC** para separar la lógica de la vista y el modelo.
3. Conectar la interfaz a una base de datos MySQL para gestionar usuarios.
4. Aplicar buenas prácticas en el diseño y desarrollo del proyecto.

## Requisitos Previos

- Conocimiento básico de **JavaFX**.
- Familiaridad con **bases de datos MySQL** y conexión mediante JDBC.
- IDE con soporte para JavaFX (como IntelliJ IDEA, Eclipse, o NetBeans).
- Base de datos MySQL configurada y corriendo.

## Desarrollo del Taller

### Paso 1: Crear la Base de Datos
En MySQL, crea una base de datos llamada `LoginApp` y una tabla llamada `Users`:

```sql
CREATE DATABASE LoginApp;

USE LoginApp;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
);
```

### Paso 2: Estructura del Proyecto MVC
Crea un proyecto en tu IDE con la siguiente estructura:

```
src/
├── controller/
│   └── LoginController.java
├── model/
│   └── UserModel.java
├── view/
│   └── LoginView.fxml
├── Main.java
```

### Paso 3: Implementar el Modelo

El **modelo** maneja la interacción con la base de datos. Crea la clase `UserModel`:

```java
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {
    private Connection connection;

    public UserModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginApp", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(String username, String password) {
        try {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerUser(String username, String password) {
        try {
            String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
```

### Paso 4: Crear la Vista

Usa **Scene Builder** para diseñar la vista o escribe el archivo `LoginView.fxml` directamente:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>

<BorderPane xmlns:fx="http://javafx.com/fxml" fx:controller="controller.LoginController">
    <left>
        <ImageView fitWidth="300" fitHeight="400">
            <Image url="https://via.placeholder.com/300x400" />
        </ImageView>
    </left>
    <center>
        <VBox alignment="CENTER" spacing="20" prefWidth="300" padding="20">
            <TextField fx:id="usernameField" promptText="Username" />
            <PasswordField fx:id="passwordField" promptText="Password" />
            <Button text="Login" onAction="#handleLogin" prefWidth="100" />
            <Button text="Register" onAction="#handleRegister" prefWidth="100" />
        </VBox>
    </center>
</BorderPane>
```

### Paso 5: Implementar el Controlador

Crea el controlador `LoginController`:

```java
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.UserModel;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    private UserModel userModel;

    public LoginController() {
        userModel = new UserModel();
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (userModel.validateUser(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (userModel.registerUser(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "User registered successfully!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "Username already exists.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
```

### Paso 6: Configurar el Punto de Entrada

Crea la clase `Main` para cargar la vista:

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
        primaryStage.setTitle("Login Application");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

## Conclusión

Este taller te permite aprender a diseñar una interfaz funcional con **JavaFX**, aplicar el patrón **MVC**, y conectar tu aplicación a una base de datos. Practicarás tanto el diseño visual como la lógica detrás de una aplicación profesional.