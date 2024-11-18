# JavaFX

## Introducción

JavaFX es una biblioteca, también se le llama framework gráfico, de Java que permite desarrollar aplicaciones de interfaz gráfica de usuario (GUI) modernas y visualmente atractivas. Se utiliza para crear aplicaciones de escritorio y proporciona un conjunto de herramientas para construir interfaces visuales interactivas. JavaFX es parte de Java desde JDK 8 y es la alternativa recomendada a la biblioteca Swing.

## Objetivos

- Comprender los conceptos básicos de JavaFX.
- Aprender a configurar y crear una aplicación JavaFX.
- Conocer los comandos y componentes básicos.
- Desarrollar una aplicación de ejemplo con JavaFX.

## 1. Conceptos Básicos de JavaFX

JavaFX funciona mediante una estructura en la que cada componente gráfico es un nodo en un árbol de escenas. La aplicación consiste en varios elementos fundamentales:

- **Stage**: La ventana principal de la aplicación, similar a una ventana de navegador o ventana de diálogo.
- **Scene**: Contenedor que sostiene y organiza los nodos gráficos en la ventana.
- **Nodes**: Componentes gráficos de la GUI, como botones, etiquetas y contenedores.

<figure>
  <img src="../images/Figure14.2.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


JavaFX permite crear aplicaciones que se ejecutan en el escritorio utilizando una interfaz gráfica de usuario (GUI). Entre sus ventajas destacan:
- **Compatibilidad con FXML**: un formato XML que facilita la construcción de interfaces de manera declarativa.
- **Soporte de gráficos avanzados y animaciones**.
- **Componentes visuales** para construir desde aplicaciones simples hasta interfaces complejas.

## 3. Comandos Básicos de JavaFX

Los comandos básicos en JavaFX se centran en crear y manipular componentes GUI. A continuación, explicamos los comandos más comunes:

- `Stage`: representa la ventana principal.
- `Scene`: define el contenido de la ventana.
- `Button`, `Label`, `TextField`: representan elementos interactivos básicos.

<figure>
  <img src="../images/Figure14.3.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


:::{note}
La escena es como un plano cartesiano, es decir, los nodos (componentes) se colocan dado las coordenadas (x,y). Sin embargo, el punto (0,0) esta en la esquina superior izquierda.

<figure>
  <img src="../images/Figure14.6.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

:::

## 2. Configuración de JavaFX

Antes de comenzar a desarrollar en JavaFX, es necesario asegurarse de que JavaFX esté correctamente configurado. Esto generalmente implica añadir las librerías de JavaFX a tu entorno de desarrollo, especialmente en versiones de Java posteriores a JDK 11.

- **Paso 1**: Descarga JavaFX SDK desde [JavaFX SDK](https:/openjfx.io/).
- **Paso 2**: Agrega la biblioteca JavaFX a tu proyecto en el entorno de desarrollo (Eclipse, IntelliJ, NetBeans, etc.).

### Comando para ejecutar una aplicación JavaFX desde consola

Si deseas ejecutar una aplicación JavaFX desde la línea de comandos, puedes hacerlo con:

```bash
java --module-path /ruta/al/sdk/javafx/lib --add-modules javafx.controls,javafx.fxml NombreDeClase
```

Asegúrate de reemplazar `/ruta/al/sdk/javafx/lib` con la ruta correspondiente en tu sistema.

:::{note}
Aunque estas instrucciones son altamente recomendadas, por ahora bastara con crear un proyecto de java y agregar las dependecias de javafx. También se puede crear un proyecto de java con Maven y utilizar el arquetipo de JavaFX. 
:::

## 3. Estructura Básica de una Aplicación JavaFX

La estructura básica de una aplicación JavaFX incluye al menos una clase que extiende `Application` y un método `start()` que establece el escenario (Stage) principal.

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HolaJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        / Crear un botón y configurar su texto
        Button btn = new Button();
        btn.setText("¡Haz clic aquí!");
        
        / Añadir una acción al botón
        btn.setOnAction(event -> System.out.println("¡Botón presionado!"));

        / Crear un contenedor para el botón
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        / Crear una escena y agregarla al escenario
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Primera aplicación JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  / Lanza la aplicación JavaFX
    }
}
```

### Explicación del Código

1. **Importación de Paquetes**: Se importan las clases necesarias de JavaFX.
2. **Método `start`**: Configura el escenario principal, donde se definen todos los elementos gráficos.
3. **Creación de un Botón**: Se crea un botón que imprime un mensaje en consola cuando es presionado.
4. **Configuración de la Escena**: El botón es añadido a un contenedor, y este contenedor se convierte en el contenido de la escena principal.
5. **Ejecución de la Aplicación**: El método `launch(args)` inicia la aplicación.

## 4. Comandos y Componentes Básicos en JavaFX

JavaFX ofrece diversos componentes gráficos para construir interfaces. Aquí hay algunos de los más utilizados:

### Botones

El botón es uno de los elementos interactivos principales en JavaFX.

```java
Button miBoton = new Button("Presiona aquí");
miBoton.setOnAction(event -> System.out.println("Botón presionado"));
```

### Campos de Texto

Los campos de texto permiten al usuario ingresar datos.

```java
TextField campoTexto = new TextField();
campoTexto.setPromptText("Escribe algo aquí");
```

**Diagrama de clases**

<figure>
  <img src="../images/Figure14.26.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

<figure>
  <img src="../images/Figure14.27.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


### Etiquetas

Coloca los nodos en las regiones superior, derecha, inferior, izquierda y centro.Las etiquetas son textos que sirven para mostrar información.

```java
Label etiqueta = new Label("¡Hola, JavaFX!");
```

### Contenedores de Disposición

JavaFX ofrece varios contenedores para organizar elementos gráficos. Algunos de los más comunes son:

- **StackPane**: Superpone elementos uno sobre otro.
- **VBox**: Coloca elementos en una columna vertical.

<figure>
  <img src="../images/Figure14.23.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

- **HBox**: Coloca elementos en una fila horizontal.

<figure>
  <img src="../images/Figure14.22.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


- **GridPane**: Organiza elementos en una cuadrícula.

<figure>
  <img src="../images/Figure14.18.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


- **FlowPane**: Organiza elementos como un flujo flexible.

<figure>
  <img src="../images/Figure14.15.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


<figure>
  <img src="../images/Figure14.17.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


- **BorderPane**: Organiza los nodos en las regiones superior, derecha, inferior, izquierda y centro.
<figure>
  <img src="../images/Figure14.20.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

<figure>
  <img src="../images/Figure14.21.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

En resumen,

<figure>
  <img src="../images/table14.1.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 


### Ejemplo con varios componentes

Aquí tienes un ejemplo de código que utiliza `VBox` para organizar un botón, una etiqueta y un campo de texto.

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfazConVBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label etiqueta = new Label("Escribe tu nombre:");
        TextField campoTexto = new TextField();
        Button boton = new Button("Saludar");

        boton.setOnAction(event -> {
            String nombre = campoTexto.getText();
            System.out.println("¡Hola, " + nombre + "!");
        });

        VBox vbox = new VBox(10);  / 10 es el espacio entre los nodos
        vbox.getChildren().addAll(etiqueta, campoTexto, boton);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Ejemplo de VBox en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```
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

        / Añadir botones en posiciones específicas
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


## 5. Usando CSS en JavaFX

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

También es posible utilizar las clases `javafx.scene.text.Font` y `javafx.scene.paint.Color` para cambiar las propiedades de los textos y figuras:
<figure>
  <img src="../images/table14.9.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

<figure>
  <img src="../images/table14.10.png" alt="" style="width:80%">
  <figcaption> </figcaption>
</figure> 

## 6. Ejemplo Práctico: Crear una Calculadora Simple

**Objetivo**: Construir una calculadora básica usando JavaFX que pueda sumar, restar, multiplicar y dividir dos números.

### Instrucciones

1. Crea una nueva clase llamada `CalculadoraJavaFX`.
2. Agrega los campos de texto y botones para ingresar los números y las operaciones.
3. Muestra el resultado en una etiqueta.
4. Usa `VBox` o `HBox` para organizar los elementos.

### Ejemplo de Estructura

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField numero1 = new TextField();
        TextField numero2 = new TextField();
        Label resultado = new Label("Resultado:");
        Button botonSuma = new Button("Sumar");

        botonSuma.setOnAction(event -> {
            double num1 = Double.parseDouble(numero1.getText());
            double num2 = Double.parseDouble(numero2.getText());
            resultado.setText("Resultado: " + (num1 + num2));
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(numero1, numero2, botonSuma, resultado);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Calculadora JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

También pueden revisar en GitHub donde pueden encontrar cientos de ejemplos, [Repositorios](repositorios_javafx).

## Ejercicio

:::{admonition} Taller 6
Diseñar y crear una interfaz gráfica (ui) para el acceso de usuarios. Esta interfaz debe tener la capacidad de registrar usuarios y verificar su identidad por medio del nombre y la contraseña. Además, esta contraseña debe ser guardad en una base de datos llamada `usuarios`, si la contraseña no encaja con el usuario debe salir un mensaje y solicitar que se intente de nuevo. 
:::

## Conclusión

JavaFX permite crear aplicaciones de escritorio con interfaces atractivas y funcionales. En esta clase, exploramos los conceptos básicos y los componentes más utilizados, y construimos ejemplos prácticos para comprender su funcionamiento. Con práctica, se puede dominar JavaFX y crear interfaces complejas de forma eficiente.

## Recursos Adicionales

### Guías y Tutoriales

- [OpenjFX](https:/openjfx.io/)
- [Openjfx v23 - Javadoc](https:/openjfx.io/javadoc/23/)
- [Introduction to JavaFX - Codespindle](https:/codespindle.com/Java/Java_JavaFX_introduction.html)
- [Documentación oficial de JavaFX](https:/openjfx.io)
- [JavaFX Tutorial](https:/www.tutorialspoint.com/javafx/index.htm)
- [Guía de JavaFX para principiantes](https:/code.makery.ch/library/javafx-tutorial/)


### Videos

- [Introduction to JavaFX - Stage, Scene, Layout, Control and Events - Java Programming - CSE1007](https:/www.youtube.com/watch?v=j1wauUbMJ3w&list=PLqfPEK2RTgCgcdrn6QZh3s--3AaejoHX4&index=71)
- [JavaFX Login Example - Scene builder and Netbeans](https:/www.youtube.com/watch?v=HqjeeTMjMTU)
- [JavaFX Tutorial for Beginners - CRUD Application Part 1](https:/www.youtube.com/watch?v=CGWRwpeihE8)
- [► 1. ✅ CURSO PRÁCTICO JAVAFX: Introducción y Características clave - Hola mundo con JAVAFX.](https:/www.youtube.com/watch?v=VMOJ33m0Ooc)

(repositorios_javafx)=
### Repositorios

- [javaFX-Calculator](https:/github.com/joiro/javaFX-Calculator)
- [JavaFX-Calculator](https:/github.com/surfinglizards/JavaFX-Calculator)
- [java-javafx](https:/github.com/codeandcoke/java-javafx)
- [Java-JavaFx-Swing-Projects-Desktop-Application-GUI-Software](https:/github.com/soumyadip007/Java-JavaFx-Swing-Projects-Desktop-Application-GUI-Software)
- [Library-Assistant](https:/github.com/afsalashyana/Library-Assistant)
- [DashboardFx](https:/github.com/gleidsonmt/DashboardFx)
- [School-Management-System-JavaFX](https:/github.com/k33ptoo/School-Management-System-JavaFX)
- [Topic javaxf](https:/github.com/topics/javafx?l=java&o=asc&s=stars)