# Scene Builder

## Introducción

Scene Builder es una herramienta visual que permite diseñar interfaces gráficas de usuario (GUI) para aplicaciones JavaFX. Con esta herramienta, puedes arrastrar y soltar componentes para crear tus vistas de forma rápida y eficiente, generando automáticamente el archivo **FXML** correspondiente. Esto facilita separar el diseño de la lógica del programa, siguiendo principios como el patrón MVC.

Puedes encontrar algunos ejemplos en [Samples - Gluon](https://gluonhq.com/developers/samples/). Para descargar Scene Builder primero deben instalarlo en VSC siguiendo la guía Non-modular with Maven que pueden encontrar en la guía de [Getting Started with JavaFX](https://openjfx.io/openjfx-docs/).

## Objetivos

- **Instalar** Scene Builder en tu sistema.
- **Diseñar** una interfaz gráfica básica usando Scene Builder.
- **Vincular** el archivo FXML con tu proyecto JavaFX.
- **Entender** la interacción entre el diseño visual y la lógica en JavaFX.

## Instalación de Scene Builder

### Requisitos Previos

1. **JDK**: Debes tener instalado Java Development Kit 8 o superior.
2. **JavaFX SDK**: Asegúrate de tener configurado JavaFX en tu proyecto.
3. **IDE**: Se recomienda IntelliJ IDEA o Eclipse con soporte para JavaFX.

### Pasos de Instalación

1. **Descargar Scene Builder**:
   - Ve al sitio oficial de Gluon: [JavaFX](https://gluonhq.com/products/javafx/), o utiliza la versión oficial de Oracle: [JavaFX Scene Builder Archive](https://www.oracle.com/java/technologies/javafxscenebuilder-1x-archive-downloads.html).
   - Descarga el instalador adecuado para tu sistema operativo.

2. **Instalar**:
   - Ejecuta el instalador y sigue las instrucciones en pantalla.
   - Verifica que la instalación fue exitosa abriendo Scene Builder.

3. **Configurar Scene Builder en el IDE**:
   - En IntelliJ IDEA: 
     - Ve a `File > Settings > Languages & Frameworks > JavaFX`.
     - Configura la ruta del ejecutable de Scene Builder.
   - En Eclipse:
     - Ve a `Window > Preferences > JavaFX`.
     - Configura la ruta del ejecutable de Scene Builder.
   - En VSC:
     - La opción recomendada es agregar una dependencia con es Maven o directamente crear el Arquetipo tipo JavaFX, `org.openjfx` . También se puede crear el proyecto sin ninguna herramienta e importar el SDK, después se deben agregar configuraciones al ambiente de trabajo para ejecutar archivos, `Ejecutar > Agregar Configuración`, también se agrega una configuración `"vmArgs": "--module-path /path/to/SDK-javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml"`, video tutorial referencia  [How to setup JavaFX in Visual Studio Code 2021 ](https://www.youtube.com/watch?v=AubJaosfI-0).

## Diseño de una Interfaz Gráfica Básica

### Crear el Proyecto JavaFX

1. **Configura un Proyecto JavaFX**:
   - Crea un nuevo proyecto en tu IDE.
   - Asegúrate de incluir la biblioteca JavaFX.

2. **Crea el Archivo FXML**:
   - Crea un archivo llamado `MainView.fxml` en la carpeta `resources`.
   - Abre el archivo en Scene Builder.

### Diseñar en Scene Builder

1. **Abrir Scene Builder**:
   - Abre el archivo `MainView.fxml` en Scene Builder.

2. **Agregar Componentes**:
   - Arrastra un `AnchorPane` desde el panel izquierdo al área de diseño.
   - Agrega un botón (`Button`) y un campo de texto (`TextField`) al AnchorPane.
   - Cambia las propiedades de los componentes desde el panel derecho:
     - **Botón**: Cambia el texto a `Enviar`.
     - **TextField**: Cambia el `Prompt Text` a `Escribe algo...`.

3. **Guardar los Cambios**:
   - Guarda el archivo `FXML` después de realizar el diseño.

## Vincular la Interfaz con el Código Java

### Crear el Controlador

Crea una clase llamada `MainController` para manejar los eventos de la interfaz.

```java
// MainController.java
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Button enviarButton;

    @FXML
    private TextField inputTextField;

    @FXML
    private void onEnviarButtonClick() {
        String texto = inputTextField.getText();
        System.out.println("Texto ingresado: " + texto);
    }
}
```

### Configurar el Archivo FXML

Vincula el controlador y los eventos en el archivo `MainView.fxml`. Ábrelo en Scene Builder y sigue estos pasos:

1. **Asignar el Controlador**:
   - Ve a `Controller` en el menú derecho.
   - Especifica el nombre del controlador como `MainController`.

2. **Vincular Componentes**:
   - Selecciona cada componente y vincúlalo con las variables y métodos del controlador:
     - **Botón**: Asigna la acción `onEnviarButtonClick`.

### Clase Principal

Crea la clase principal para cargar la interfaz.

```java
// Main.java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(loader.load());
        
        primaryStage.setTitle("Ejemplo Scene Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

## Ejecución del Proyecto

1. **Corre la Aplicación**:
   - Ejecuta la clase `Main.java` desde tu IDE.

2. **Prueba la Interfaz**:
   - Escribe algo en el campo de texto.
   - Haz clic en el botón `Enviar`.
   - Observa el resultado en la consola.


## Conclusiones

Scene Builder facilita el diseño de interfaces gráficas en JavaFX, separando el diseño visual de la lógica del programa. Con esta herramienta, puedes ahorrar tiempo y esfuerzo al crear GUIs intuitivas y profesionales. Su integración con JavaFX permite desarrollar aplicaciones modernas y escalables.

## Recursos Adicionales

- [Scene Builder Official Page](https://gluonhq.com/products/scene-builder/)
- [JavaFX Documentation](https://openjfx.io/)
- [IntelliJ IDEA JavaFX Configuration](https://www.jetbrains.com/help/idea/javafx.html)
- [Eclipse JavaFX Configuration](https://marketplace.eclipse.org/content/efxclipse)