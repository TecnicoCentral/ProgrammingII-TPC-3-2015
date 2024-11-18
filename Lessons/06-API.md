# Introducción a las APIs

## Objetivo
Comprender los fundamentos de la API en Java, cómo utilizarla eficientemente, y cómo aplicar el patrón Factory en sus aplicaciones. Los estudiantes conocerán los beneficios del patrón Factory, su aplicabilidad en proyectos de software, y su implementación práctica en Java mediante ejemplos de código.

## 1. Fundamentos de la API en Java

### ¿Qué es una API en Java?

Una **API (Application Programming Interface)** en Java es un conjunto de clases, interfaces y métodos predefinidos que facilitan la interacción con el entorno de ejecución de Java. Estas APIs permiten a los desarrolladores construir aplicaciones reutilizando código existente en la biblioteca estándar de Java.

Las APIs más comunes en Java incluyen:
- **API de colecciones**: Proporciona estructuras de datos como listas, conjuntos, mapas, y más.
- **API de entrada/salida (java.io, java.nio)**: Maneja la entrada/salida de datos, como leer y escribir archivos.
- **API de concurrencia (java.util.concurrent)**: Facilita la creación y manejo de hilos y procesos en paralelo.
- **API de red (java.net)**: Permite el acceso a recursos de red y el manejo de conexiones.

El uso eficiente de la API de Java permite reducir el tiempo de desarrollo y mejorar la calidad del código al reutilizar componentes probados.

::::{grid}

:::{grid-item}
:margin: auto auto 0 0
:columns: 6

<iframe width="100%" height="280px" src="https://www.youtube.com/embed/IwnIxk8DdHs?si=5nCHG1X0ukFNngdS" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

:::

:::{grid-item}
:margin: auto auto 0 0
:columns: 6

<iframe width="100%" height="280px" src="https://www.youtube.com/embed/JD6VNRdGl98?si=ngRST0LM3VIshG_9" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
:::
::::

## Ejemplo

Vamos a crear una clase que ejemplifique un cliente que hace dos cosas dada un nombre de una ciudad:

1. Consulta la longitud y latitud de la ciudad.
2. Dada la longitud y latitud, consulta datos del clima de la ciudad

Este ejemplo es basado en el siguiente tutorial:

<div align="center">
<iframe width="80%" height="420px" src="https://www.youtube.com/embed/WS_H44tvZMI?si=IGEfz4uk3GahSJwx" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
</div>

:::{note}
Puedes encontrar el código del vídeo, consulta de clima, en [WeatherAPIData.java](WeatherAPIData.java).
:::

## Ejercicio

:::{admonition} Taller 2

Buscar un API publico y hacer consultas a este API. Aqui dejo algunos enlaces de donde pueden sacar el API:

Algunos endpoints de APIs públicos:
- [public-apis](https://github.com/public-apis/public-apis?tab=readme-ov-file)
- [PokeAPI](https://pokeapi.co/)
- [public-api-lists ](https://github.com/public-api-lists/public-api-lists)
- [public-apis ](https://github.com/marcelscruz/public-apis)
- [Free API – 90+ Public APIs For Testing [No Key] ](https://apipheny.io/free-api/)

Este trabajo lo pueden hacer solos, con lo cual solo implementan un API, o en parejas, donde deberan consultar dos APIs diferentes.
:::

## Conclusión

El Patrón Factory es una herramienta poderosa en el diseño de software que permite la creación de objetos de manera flexible y desacoplada. Además de facilitar la extensibilidad del sistema, este patrón mejora la mantenibilidad del código al centralizar la lógica de creación de instancias. En combinación con las APIs de Java, este patrón es esencial para diseñar soluciones escalables y modulares en aplicaciones de software.

## Recursos Adicionales

- Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
- Oracle Documentation: [Java Factory Pattern](https://docs.oracle.com/javase/tutorial/designpatterns/factory.html)
- Eckel, B. (2006). *Thinking in Java*. Pearson.