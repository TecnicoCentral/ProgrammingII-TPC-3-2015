# Taller: Interfaz de Ingreso

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
- IDE con soporte para JavaFX (como IntelliJ IDEA, Eclipse, NetBeans, o VSC).
- Base de datos MySQL configurada y corriendo.

## Desarrollo del Taller

### Paso 0: Configuración del Proyecto

1. Crear un proyecto de java usando Maven y arquetipo `java-archetype-fxml`, `org.javafx`,  groupid `com` y en artefactId, o nombre del proyecto, el que prefieran, por ejemplo `LoginApp`. 
2. Descargar el kit de desarrollo de software (SDK) de openjfx, sección de descargas en la página [JavaFX](https://gluonhq.com/products/javafx/), seleccionar el sistema operativo correcto y descomprimirlo.
3. Eliminar el archivo de configuración del paquete, `/src/main/java/module-info.java`, este no soporta la interacción con mysql.
4. Crear una configuración de lanzamiento, `Run > Add Configuration`, seleccionar java. Esto creara un archivo de configuración de lanzamiento del proyecto en formato json, `.vscode/launch.json`. 
5. Agregar el SDK al entorno de ejecución. Editar el archivo `.vscode/launch.json` creado y agregar `"vmArgs": "--module-path /path/to/SDK-javafx-sdk-23.0.1/lib --add-modules javafx.graphics,javafx.fxml,javafx.controls"` cambiando `/path/to/SDK-javafx-sdk-23.0.1/lib` a la dirección correcta donde están descomprimido los paquetes de java.
 
    Ejemplo:
    ```json
    {
      "version": "0.2.0",
      "configurations": [
        {
          "type": "java",
          "name": "Current File",
          "request": "launch",
          "mainClass": "${file}"
        },
        {
          "type": "java",
          "name": "App",
          "request": "launch",
          "mainClass": "com.App",
          "projectName": "javafx_final",
          "vmArgs": "--module-path /home/saguileran/Downloads/openjfx-23.0.1_linux-x64_bin-sdk/javafx-sdk-23.0.1/lib --add-modules javafx.graphics,javafx.fxml,javafx.controls"
        }
      ]
    }
   ```
6. Agregar la dependencia de Maven para la conexión a la base de datos, `com.mysql`:

    ```xml
    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.1.0</version>
      </dependency>
    ```
    Además, es recomendable actualizar la versión de java de Maven para evitar problemas de compilación y ejecución y las versiones de openjfx:
    ```xml
    <!-- Cambiar versión de Java a 23 -->
    <properties>
      <maven.compiler.source>23</maven.compiler.source>
      <maven.compiler.target>23</maven.compiler.target>
    </properties>
    <!-- JAVAFX -->
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>23.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>23.0.1</version>
    </dependency>
    ```

    Nótese que aquí solo se cambio la versión de las depedencias a `23.0.1`. La versión de java debe ser igual o superior a 21, en otro caso se generarán errores de compilación y/o ejecución. Recuerden que pueden tener más de una versión de java (JDK) instalada.

    También es posible actualizar la versión de `javafx-maven-plugin` a `0.0.8`. 

:::{important}
Todos los archivos `fxml` deben ser almacenados en la carpeta de `resources/com`. Además, **deben eliminar el archivo `module-info.java`** antes de crear el archivo de configuración de lanzamiento,`.vscode/launch.json`, para evitar problemas de configuración del ambiente de java.

Para mayor información sobre la configuración de javaxf en VSC visita el tutorial [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/) sección Modular with Maven.
:::

### Paso 1: Crear la Base de Datos
En MySQL, crea una base de datos llamada `LoginApp`:

```sql
CREATE DATABASE LoginApp;
```

Pueden ejecutar este comando desde MySQL Workbrench o desde la terminal. Para ingresar via terminal a MySQL pueden usar el comando:

```bash
mysql -h 127.0.0.1 -P 3306 -u root -p
```

Después ingresan la contraseña y ejecutan el comando. Para salir ejecute `exit` o cierren la ventana.

:::{note}
`-h` significa host, `-P` puerto, `-u` usuario, y `-p` contraseña.
:::

(estructura)=
### Paso 2: Estructura del Proyecto MVC
Crea un proyecto en tu IDE con la siguiente estructura:

```
LoginApp
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       ├── App.java
│       │       ├── controller
│       │       │   ├── LoginController.java
│       │       └── model
│       │           └── UserModel.java
│       └── resources
│           └── com
│               ├── LoginView.fxml
└── target
    ├── classes
    │   └── com
    │       ├── App.class
    │       ├── controller
    │       │   ├── LoginController.class
    │       ├── model
    │       │   └── UserModel.class
    │       ├── LoginView.fxml
    └── test-classes
```

El proyecto (artifactId) puede llamarse como quieran, para ser coherentes con este ejemplo el groupId debe ser nombrado `com`. 

:::{note}
Los nombres del artefacto y del id del grupo no son relevantes para el funcionamiento del proyecto.
:::

### Paso 3: Implementar el Modelo

El **modelo** maneja la interacción con la base de datos. Es necesario escribir el usuario y contraseña correctos de MySQL.

```java
// Clase UserModel.java
package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserModel {
    private static final String URL_DB = "jdbc:mysql://localhost:3306/LoginApp";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private Connection connection;

    public UserModel() {
        try {
            connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int CreateTable(){
      try{
        String query = "CREATE TABLE IF NOT EXISTS Users ("+
                          "id INT AUTO_INCREMENT PRIMARY KEY,"+
                          "username VARCHAR(50) UNIQUE NOT NULL,"+
                          "password VARCHAR(50) NOT NULL,"+
                          "image VARCHAR(200) NULL"+
                       ");";;

        Statement stmt = connection.createStatement();
        int result = stmt.executeUpdate(query);
        return result;
      } catch (Exception e) {
            e.printStackTrace();
      }
      return -1;
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

    public boolean registerUser(String username, String password, String image) {
        try {
            String query = "INSERT INTO Users (username, password, image) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, image);
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

Usa **Scene Builder** para diseñar la vista o escribe el archivo `LoginView.fxml` directamente, este debe ir en la carpeta `src/main/resources/com`.

### Paso 5: Implementar el Controlador

Crea el controlador `LoginController` utilizando Scene Builder, `view > Show Sample Controller Skeleton`.

### Paso 6: Configurar el Punto de Entrada

Edita la clase `App` para cargar la vista y crear la tabla:

```java
package com;
import com.model.UserModel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = new Scene(loadFXML("LoginView"), 640, 480);
        stage.setTitle("Login Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // Testing mysql conexion by creating a table in the LoginApp schema (database)
        System.out.println(new UserModel().CreateTable());
        // Launch the user interface
        launch();
    }
}
```

Para ejecutar algo antes de inidicar la ventana debe agregarse antes de `launch()`.

:::{note}
Un proyecto puede tener varias vistas, varios archivos fxml, y cada vista debe tener su respectivo controlador. Para cambiar entre vistas basta con crear un método que se ejecute al presionar un botón, un evento. El método del controlador debe ejecutar `App.setRoot("VistaNombre")`, además de importar la clase `com.App`.
:::

## Conclusión

Este taller te permite aprender a diseñar una interfaz funcional con **JavaFX**, aplicar el patrón **MVC**, y conectar tu aplicación a una **base de datos**. Practicarás tanto el diseño visual como la lógica detrás de una aplicación profesional.