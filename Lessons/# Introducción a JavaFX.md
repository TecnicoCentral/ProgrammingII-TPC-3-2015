# Introducción a JavaFX

JavaFX es un framework gráfico para Java que permite crear interfaces de usuario avanzadas, incluyendo componentes gráficos, animaciones, y efectos visuales. Es una excelente opción para construir aplicaciones de escritorio debido a su capacidad de personalización y su arquitectura moderna basada en modelos.

## Objetivos

1. Conocer los conceptos básicos de JavaFX.
2. Aprender a configurar y utilizar JavaFX en proyectos.
3. Entender los comandos básicos de JavaFX para crear interfaces gráficas.
4. Practicar con ejemplos prácticos de interfaz gráfica en JavaFX.

## 1. Conceptos Básicos de JavaFX

JavaFX permite crear aplicaciones que se ejecutan en el escritorio utilizando una interfaz gráfica de usuario (GUI). Entre sus ventajas destacan:
- **Compatibilidad con FXML**: un formato XML que facilita la construcción de interfaces de manera declarativa.
- **Soporte de gráficos avanzados y animaciones**.
- **Componentes visuales** para construir desde aplicaciones simples hasta interfaces complejas.

JavaFX está estructurado en términos de escenas y nodos:
- **Stage**: el contenedor principal de la aplicación, similar a una ventana.
- **Scene**: la "escena" o área donde se ubican los elementos visuales.
- **Node**: cada elemento visual dentro de la escena, como botones, etiquetas, etc.

## 2. Configuración Inicial

Antes de comenzar, asegúrate de tener JavaFX en tu entorno de desarrollo. JavaFX no viene incluido en el JDK a partir de Java 11, por lo que necesitas agregar la biblioteca de JavaFX manualmente o utilizar un IDE como IntelliJ que facilita esta configuración.

## 3. Comandos Básicos de JavaFX

Los comandos básicos en JavaFX se centran en crear y manipular componentes GUI. A continuación, explicamos los comandos más comunes:

- `Stage`: representa la ventana principal.
- `Scene`: define el contenido de la ventana.
- `Button`, `Label`, `TextField`: representan elementos interactivos básicos.

### Ejemplo: Hola Mundo en JavaFX

Este es el ejemplo más sencillo para iniciar en JavaFX. Se muestra cómo crear una ventana con un texto de "Hola, JavaFX".

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HolaMundoJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear una etiqueta
        Label label = new Label("Hola, JavaFX");

        // Crear una escena y agregar la etiqueta
        Scene scene = new Scene(label, 300, 200);

        // Configurar el escenario principal
        primaryStage.setTitle("Hola Mundo en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

**Explicación del código:**
1. `Stage primaryStage`: es el escenario principal.
2. `Label label`: crea un objeto de texto.
3. `Scene scene`: asigna una escena al escenario principal.
4. `primaryStage.show()`: muestra la ventana.

## 4. Componentes Básicos en JavaFX

### Botones y Eventos

Para manejar eventos en JavaFX, como un clic en un botón, utilizamos los **event listeners**. Aquí, crearemos un botón que cambia el texto de una etiqueta cuando es presionado.

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonEvento extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Texto inicial");
        Button button = new Button("Presioname");

        // Configuración del evento
        button.setOnAction(e -> label.setText("Botón presionado!"));

        // Configuración del layout
        VBox layout = new VBox(10);  // VBox con espacio de 10px entre componentes
        layout.getChildren().addAll(label, button);

        // Crear y mostrar la escena
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Eventos con Botón");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

**Explicación del código:**
1. `Button button`: se crea un botón con un evento.
2. `button.setOnAction`: se define un evento que cambia el texto de la etiqueta.
3. `VBox layout`: organiza los elementos en vertical.

## 5. Layouts en JavaFX

Los layouts permiten organizar los componentes gráficos en JavaFX. Los tipos más comunes son:

- **VBox**: organiza los elementos verticalmente.
- **HBox**: organiza los elementos horizontalmente.
- **GridPane**: organiza elementos en una cuadrícula.

### Ejemplo de GridPane

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneEjemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Añadir botones en posiciones específicas
        grid.add(new Button("Botón 1"), 0, 0);
        grid.add(new Button("Botón 2"), 1, 0);
        grid.add(new Button("Botón 3"), 0, 1);
        grid.add(new Button("Botón 4"), 1, 1);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Ejemplo de GridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

**Explicación del código:**
1. `GridPane grid`: se crea una cuadrícula.
2. `grid.add`: se colocan botones en posiciones específicas.

## 6. Usando CSS en JavaFX

JavaFX permite estilizar los componentes utilizando CSS para mejorar el diseño de las aplicaciones.

1. Crear un archivo `styles.css`.
2. En el archivo CSS:
    ```css
    .boton-personalizado {
        -fx-background-color: #4CAF50;
        -fx-text-fill: white;
        -fx-font-size: 16px;
    }
    ```
3. Vincular el estilo a los componentes en el código Java.

```java
button.getStyleClass().add("boton-personalizado");
scene.getStylesheets().add("path/to/styles.css");
```

## 7. Ejercicio Práctico

Implementa una aplicación en JavaFX que tenga:
- Un campo de texto donde el usuario pueda ingresar su nombre.
- Un botón que, al ser presionado, muestre un mensaje de bienvenida en una etiqueta.

**Sugerencia**: Usa un `VBox` para organizar los componentes y `TextField`, `Label`, y `Button` para los elementos interactivos.

## Referencias

- [Documentación oficial de JavaFX](https://openjfx.io)
- [Tutorial de JavaFX en Oracle](https://docs.oracle.com/javase/8/javase-clienttechnologies.htm)
- [Ejemplos en GitHub](https://github.com/openjfx/samples)
