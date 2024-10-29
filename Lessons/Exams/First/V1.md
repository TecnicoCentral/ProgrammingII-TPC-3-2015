# Primer Parcial - V1

---

- [Primer Parcial - V1](#primer-parcial---v1)
  - [Instrucciones](#instrucciones)
  - [Punto 1: Clases, Objetos y Pilares de la Programación Orientada a Objetos (POO)](#punto-1-clases-objetos-y-pilares-de-la-programación-orientada-a-objetos-poo)
  - [Punto 2: Diagramas UML y Aplicación Completa](#punto-2-diagramas-uml-y-aplicación-completa)
  - [Punto 3: De Diagrama UML a Código](#punto-3-de-diagrama-uml-a-código)
  - [Evaluación](#evaluación)

---

## Instrucciones

El parcial consta de 3 puntos donde deben resolver solo 2 de los 3, el tercero es obligatorio y eligen entre el primer y segundo punto, en ambos deben crear el diagrama UML. Responde a cada uno de manera detallada, implementando la solución solicitada en el lenguaje de programación Java. Asegúrate de utilizar los conceptos solicitados en cada pregunta. En el punto 3, incluye un diagrama UML de la solución que propongas.

## Punto 1: Clases, Objetos y Pilares de la Programación Orientada a Objetos (POO)
**Objetivo:**
Crear una aplicación simple que ilustre los cuatro pilares de la POO: abstracción, encapsulamiento, herencia y polimorfismo. El ejemplo debe estar relacionado con una tienda de libros.

**Requerimientos:**
- Crea una clase o interfaz `Producto` que represente los atributos básicos de un producto (nombre, precio, agrega uno más).
- Crea tres subclases `Libro`, `Revista`, `Video` que hereden de `Producto` y agregue atributos específicos como autor, número de páginas, editorial, volumen, etc. En total cada clase debe tener 2 atributos adicionales.
- Implementa los conceptos de encapsulamiento en ambas clases (usa `private` para los atributos y métodos `getters` y `setters`).
- Usa el polimorfismo en un método `mostrarInfo()` que se defina en `Producto` y sea sobrescrito en `Libro` para mostrar detalles adicionales.
  
**Indicaciones adicionales:**
- Explica cómo tu código cumple con los cuatro pilares de la POO.
- Implementa un método `main` o una clase de prueba en donde crees instancias de `Producto` y `Libro`, y utilices polimorfismo para mostrar la información.

**Diagrama UML:**
Dibuja el diagrama UML de clases que muestre la relación entre `Producto`, `Libro`, `Revista`. Asegúrate de incluir las clases, atributos, métodos, y las relaciones de herencia y uso de la interfaz.

## Punto 2: Diagramas UML y Aplicación Completa

**Objetivo:**
Desarrollar una solución completa para un sistema que gestione una flota de vehículos utilizando herencia e interfaces. Luego, realizar el diagrama UML de clases correspondiente.

**Requerimientos:**
- Crea una clase `Vehiculo` con los atributos `marca`, `modelo`, y `año`.
- Crea dos subclases: `Auto` y `Moto`. `Auto` tiene atributos adicionales como `numeroDePuertas`, y `Moto` tiene `cilindrada`.
- Crea una interfaz `Conducible` que tenga el método `conducir()`. Tanto `Auto` como `Moto` deben implementar esta interfaz.
- En el método `main`, crea instancias de `Auto` y `Moto` y utiliza polimorfismo para llamar al método `conducir()`.

**Diagrama UML:**
Dibuja el diagrama UML de clases que muestre la relación entre `Vehiculo`, `Auto`, `Moto`, y la interfaz `Conducible`. Asegúrate de incluir las clases, atributos, métodos, y las relaciones de herencia y uso de la interfaz.

## Punto 3: De Diagrama UML a Código

Implementen el código del siguiente diagrama UML de clases

<div align="center">
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20240308165524/Class-Diagram-example.webp" width=90%>
</div>


## Evaluación

- Correcta implementación de clases, encapsulamiento, herencia y polimorfismo.
- Uso correcto de clases abstractas, interfaces, y polimorfismo .
- Diagrama UML preciso y solución completa con herencia e interfaces..

Recuerda que la claridad y la correcta implementación de los conceptos serán evaluadas cuidadosamente.