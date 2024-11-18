# Diagramas UML

## Objetivo

Proporcionar a los estudiantes una comprensión profunda de cómo utilizar UML (Unified Modeling Language) en el diseño de software orientado a objetos, con un enfoque en la implementación en Java. Los estudiantes aprenderán a representar visualmente las estructuras y relaciones dentro de un sistema de software utilizando diagramas de clases UML, lo que les permitirá planificar, comunicar y desarrollar aplicaciones Java de manera más eficiente y efectiva.

## 1. Conceptos Básicos de UML

UML (Unified Modeling Language) es un lenguaje de modelado que permite representar de manera gráfica los elementos y relaciones en un sistema de software. Es un estándar ampliamente utilizado en el desarrollo de software orientado a objetos, proporcionando una serie de diagramas para visualizar diferentes aspectos de un sistema.

**Historia y Evolución del UML:**
UML fue desarrollado a mediados de la década de 1990 por Grady Booch, Ivar Jacobson y James Rumbaugh como un medio para estandarizar los diversos lenguajes de modelado que existían en ese momento. Fue adoptado como estándar por la OMG (Object Management Group) en 1997.

**Importancia del UML en el Desarrollo de Software:**
UML es crucial para el diseño de software porque facilita la comunicación entre los diferentes actores del proyecto (desarrolladores, arquitectos, analistas y clientes) y asegura que todos compartan una comprensión común del sistema que se está construyendo.


## 2. Tipos de Diagramas UML

UML se divide en tres categorías principales de diagramas:

### Diagramas Estructurales:

Estos diagramas se centran en la estructura estática del sistema, mostrando cómo están organizados los elementos del sistema.

- **Diagrama de Clases:** Muestra las clases del sistema, sus atributos, métodos y las relaciones entre ellas.
- **Diagrama de Objetos:** Muestra instancias de clases en un momento específico.
- **Diagrama de Componentes:** Representa la organización y las dependencias entre los componentes físicos de un sistema.
- **Diagrama de Despliegue:** Muestra la arquitectura física del sistema, incluidos los nodos de hardware y los artefactos que se ejecutan en ellos.
- **Diagrama de Paquetes:** Agrupa elementos relacionados del sistema para mostrar su estructura organizativa.

### Diagramas de Comportamiento:
Estos diagramas se centran en cómo los elementos del sistema interactúan entre sí y cómo el sistema se comporta con el tiempo.

- **Diagrama de Casos de Uso:** Describe las funcionalidades que el sistema ofrece a los usuarios y los actores que interactúan con el sistema.
- **Diagrama de Secuencia:** Muestra cómo los objetos interactúan en un orden específico.
- **Diagrama de Colaboración:** Representa las interacciones entre objetos en una forma orientada a la estructura.
- **Diagrama de Actividades:** Describe los flujos de control entre actividades, mostrando los pasos para completar un proceso.
- **Diagrama de Estados:** Representa los estados de un objeto a lo largo del tiempo en respuesta a eventos.

### Diagramas de Interacción:
Estos diagramas detallan las interacciones entre los componentes del sistema.

- **Diagrama de Comunicación:** Similar al diagrama de secuencia, pero se centra en la estructura de la comunicación entre objetos.
- **Diagrama de Tiempo:** Muestra el cambio de estado de los objetos y la interacción en un intervalo de tiempo.
- **Diagrama de Interacción General:** Una combinación de diagramas de secuencia y de actividad, mostrando la interacción en un contexto general.

## 3. Aplicaciones de UML
   
 - **Modelado de Sistemas de Software:** UML permite crear una representación visual y comprensible de un sistema de software, facilitando su diseño y desarrollo.
 - **Diseño y Análisis de Arquitecturas:** Ayuda a los arquitectos de software a visualizar la estructura y el comportamiento del sistema antes de comenzar con la codificación.
 - **Documentación Técnica:** UML proporciona una documentación clara y detallada del sistema, útil para el mantenimiento y la ampliación del software.
 - **Comunicación entre Equipos de Trabajo:** Al estandarizar la representación del sistema, UML facilita la comunicación y la colaboración entre diferentes equipos y departamentos.

## 4. Diseño Básico de Clases en UML
   
 - **Conceptos Básicos de una Clase en UML:** Una clase en UML se representa como un rectángulo dividido en tres partes: el nombre de la clase, los atributos y los métodos.
 - **Relaciones entre Clases:** 
   - **Asociación:** Relación general entre dos clases.
   - **Agregación:** Relación "todo-parte", donde la parte puede existir independientemente del todo.
   - **Composición:** Relación "todo-parte" más fuerte, donde la parte no puede existir sin el todo.
   - **Herencia:** Representa la relación de especialización entre clases.

 - **Visibilidad:** 
   - **Pública (+):** Atributos y métodos accesibles desde cualquier parte del sistema.
   - **Privada (-):** Solo accesibles dentro de la clase misma.
   - **Protegida (#):** Accesibles dentro de la clase y sus subclases.

 - **Ejemplo Práctico:**
   - Modelado de una biblioteca en UML, donde se representan clases como `Libro`, `Usuario`, `Préstamo`, y sus relaciones.
 - **Implementación en Java:**
     ```java
     public class Libro {
         private String titulo;
         private String autor;
         private boolean disponible;

         public Libro(String titulo, String autor) {
             this.titulo = titulo;
             this.autor = autor;
             this.disponible = true;
         }

         public void prestar() {
             if (disponible) {
                 disponible = false;
                 System.out.println("El libro ha sido prestado.");
             } else {
                 System.out.println("El libro no está disponible.");
             }
         }

         public void devolver() {
             disponible = true;
             System.out.println("El libro ha sido devuelto.");
         }
     }
     ```
     
### Diagrama de Clases

El diagrama de clases es una de las representaciones más importantes en UML, ya que muestra la estructura estática de un sistema, es decir, las clases que lo componen y las relaciones entre ellas.

- **Proceso de Diseño de Clases:**
  1. **Identificación de Clases:** Las clases se identifican a partir de los requisitos del sistema. Se seleccionan las entidades que tienen una importancia significativa en el dominio del problema.
  2. **Definición de Atributos y Métodos:** Cada clase identificada debe tener atributos que representen sus propiedades y métodos que definan su comportamiento.
  3. **Relaciones entre Clases:** Las relaciones entre las clases, como la herencia, la asociación, la agregación, y la composición, se definen para modelar cómo interactúan las clases entre sí.

**Ejemplo en UML:**

- **Clases:** `Vehiculo`, `Motor`, `Coche`, `Camion`.
- **Relaciones:** 
  - `Coche` y `Camion` heredan de `Vehiculo`.
  - `Vehiculo` contiene una instancia de `Motor` (composición).

```java
// Ejemplo en Java que refleja un diseño UML
public class Motor {
    private String tipo;
    
    public Motor(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
}

public class Vehiculo {
    private String marca;
    private String modelo;
    private Motor motor;
    
    public Vehiculo(String marca, String modelo, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }
    
    public void mostrarDetalles() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Motor: " + motor.getTipo());
    }
}

public class Coche extends Vehiculo {
    private int numPuertas;
    
    public Coche(String marca, String modelo, Motor motor, int numPuertas) {
        super(marca, modelo, motor);
        this.numPuertas = numPuertas;
    }
    
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Número de puertas: " + numPuertas);
    }
}
```

En el diagrama de clases UML, `Coche` sería una subclase de `Vehiculo`, y `Vehiculo` tendría una composición con `Motor`.

## 5. Taller UML: Aplicación Práctica

En este taller, los estudiantes diseñarán un sistema de gestión para una tienda en línea utilizando diagramas UML y luego implementarán el diseño en Java.

**Objetivos:**
- Aplicar los conceptos de UML para modelar un sistema real.
- Desarrollar habilidades para traducir un diseño UML a código Java.

**Instrucciones:**

1. **Identificación de Clases:** Identificar las clases principales del sistema, como `Producto`, `Cliente`, `Pedido`, `CarritoDeCompras`.
   
2. **Diseño del Diagrama de Clases UML:**
   - Crear el diagrama de clases que incluya atributos, métodos y relaciones.
   - Definir asociaciones entre clases, como `Cliente` tiene `Pedido`, `Pedido` contiene `Producto`.
   - Establecer la herencia si es aplicable, por ejemplo, `PedidoOnline` y `PedidoTiendaFisica` heredan de `Pedido`.

3. **Implementación en Java:**
   - Escribir el código Java correspondiente para las clases diseñadas.
   - Asegurarse de implementar las relaciones y métodos definidos en el diagrama UML.
   
4. **Pruebas:** Probar el sistema mediante la creación de instancias de las clases y la ejecución de los métodos para asegurar que el diseño y la implementación son coherentes.


## Conclusión

El uso de UML es esencial en el diseño de software orientado a objetos, ya que permite a los desarrolladores visualizar y comunicar el diseño del sistema de manera estructurada y clara. Los diagramas de clases, en particular, son herramientas poderosas para definir la estructura estática del sistema, incluyendo las clases, sus atributos, métodos, y las relaciones entre ellas.

A lo largo de esta clase, los estudiantes han adquirido habilidades prácticas en la creación y lectura de diagramas UML y en la implementación de estos diseños en Java. El ejercicio práctico no solo reforzó los conceptos teóricos, sino que también demostró la importancia de un diseño cuidadoso antes de escribir el código, asegurando que el software resultante sea robusto, mantenible y escalable.

## Ejercicio 

::::{admonition} Taller 3
Crear el diagrama de clases correspondiente al código del [taller 2](taller2).

**Entregables**
- Diagrama de clases UML del sistema de gestión de inventarios, formato png.
- Código fuente en Java que implementa el sistema.
::::

## Recursos Adicionales

### Guías

- [UML Class Diagram Tutorial](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/)
- [UML 2.5 Diagrams Overview](https://www.uml-diagrams.org/uml-25-diagrams.html)
- [UML - Overview](https://www.tutorialspoint.com/uml/uml_overview.htm)
- [UML Diagrams Full Course (Unified Modeling Language) ](https://www.youtube.com/watch?v=WnMQ8HlmeXc)
- [Documentación oficial de UML](https://www.uml.org/)
  
### Libros

- *UML Distilled: A Brief Guide to the Standard Object Modeling Language* por Martin Fowler.
- *The Unified Modeling Language User Guide* por Grady Booch, James Rumbaugh, Ivar Jacobson.

### Diagramas

- [Class Diagrams](https://mermaid.js.org/syntax/classDiagram.html)
- [Diagrams](https://app.diagrams.net/)
- [Lucid](https://lucid.app/lucidchart/5abff1a4-9b1b-4733-beac-12ba84090954/edit?invitationId=inv_84d69e5b-1ed5-463e-be69-63a6ebdf9f51&page=0_0#)
- [yFiles - UML](https://live.yworks.com/demos/showcase/uml/)
