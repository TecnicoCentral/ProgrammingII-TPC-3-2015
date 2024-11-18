# Introducción y Clasificación

## Objetivos

- Identificar y diferenciar los tipos de bases de datos.
- Conocer las características y usos de cada tipo de base de datos.
- Aprender a conectar una aplicación Java con una base de datos utilizando JDBC.
- Implementar una conexión básica y realizar operaciones simples sobre una base de datos relacional.

## Introducción

En el desarrollo de software, las bases de datos juegan un papel fundamental en el almacenamiento y manejo eficiente de la información. Existen varios tipos de bases de datos, cada uno diseñado para diferentes aplicaciones, y es esencial para los desarrolladores saber cómo conectarse y manipular estas bases de datos desde sus aplicaciones. En Java, la interacción con las bases de datos se realiza a través de la API JDBC (Java Database Connectivity), que proporciona un estándar para conectar aplicaciones Java con bases de datos.

En esta clase, exploraremos los diferentes tipos de bases de datos y aprenderemos cómo realizar una conexión básica a una base de datos utilizando Java.

::::{grid}

:::{grid-item}
:margin: auto auto 0 0
:columns: 6

<iframe width="100%" height="280px" src="https://www.youtube.com/embed/X7v0O8yiUuY?si=2PvfSTOUsvwKThDE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

:::
:::{grid-item}
:margin: auto auto 0 0
:columns: 6

<iframe width="100%" height="280px" src="https://www.youtube.com/embed/W2Z7fbCLSTw?si=tvuFBCFLvtGHlw2d" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

:::
::::

## 1. Bases de Datos Relacionales (RDBMS)
Son las más comunes y se basan en el modelo relacional. Los datos se almacenan en tablas organizadas en filas y columnas, y se utilizan para aplicaciones que requieren estructuras de datos bien definidas.
   
   - **Ejemplos**: MySQL, PostgreSQL, Oracle, SQL Server.
   - **Ventajas**: Estructuras de datos bien organizadas, soporte ACID (Atomicidad, Consistencia, Aislamiento, Durabilidad), amplia compatibilidad.
   - **Uso**: Sistemas de gestión empresarial, aplicaciones web, etc.

## 2. Bases de Datos NoSQL
Están diseñadas para manejar grandes volúmenes de datos no estructurados o semi-estructurados. No siguen el modelo relacional y son altamente escalables.
   
   - **Ejemplos**: MongoDB, Cassandra, Redis.
   - **Ventajas**: Escalabilidad horizontal, alta disponibilidad, soporte para datos no estructurados.
   - **Uso**: Big Data, aplicaciones en tiempo real, redes sociales.

## 3. Bases de Datos Orientadas a Objetos
Almacenan datos en forma de objetos, como en la programación orientada a objetos, y permiten almacenar clases completas con atributos y métodos.
   
   - **Ejemplos**: db4o, ObjectDB.
   - **Ventajas**: Integración natural con lenguajes de programación orientados a objetos, persistencia de objetos complejos.
   - **Uso**: Aplicaciones científicas y de ingeniería.

## 4. Bases de Datos Distribuidas
Almacenan datos en varios nodos o ubicaciones geográficas, manteniendo la coherencia de los datos entre ellos.
   
   - **Ejemplos**: Google Spanner, Amazon DynamoDB.
   - **Ventajas**: Resiliencia ante fallos, escalabilidad global.
   - **Uso**: Servicios globales, plataformas de datos distribuidos.

## 5. Bases de Datos en Memoria
Almacenan datos principalmente en la memoria principal, lo que les permite ofrecer tiempos de respuesta extremadamente rápidos.
   
   - **Ejemplos**: Redis, Memcached.
   - **Ventajas**: Velocidad de acceso rápido, adecuado para cachés.
   - **Uso**: Almacenamiento en caché, aplicaciones en tiempo real.

## 6. Bases de Datos Serverless
Las bases de datos serverless permiten a los desarrolladores centrarse en sus aplicaciones sin preocuparse por la administración del servidor, escalabilidad o configuraciones complejas. En este tipo de bases de datos, el proveedor del servicio gestiona automáticamente los recursos y la infraestructura en función de las necesidades de la aplicación.

- **Ejemplos**: Amazon Aurora Serverless, Google Firestore.
- **Ventajas**: Escalabilidad automática, pago por uso, sin necesidad de administrar servidores.
- **Uso**: Aplicaciones web con patrones de tráfico variables, microservicios.

En una base de datos serverless, el escalado es completamente gestionado por el proveedor, lo que la hace ideal para aplicaciones que experimentan fluctuaciones en la carga de trabajo. Este enfoque es especialmente útil en aplicaciones con demanda impredecible o variable, ya que el costo y los recursos se ajustan dinámicamente.

## 7. Bases de Datos de Series Temporales (Time Series)
Las bases de datos de series temporales están diseñadas para manejar grandes volúmenes de datos indexados por un parámetro temporal. Estos sistemas son ideales para aplicaciones que deben almacenar, consultar y analizar datos a lo largo del tiempo.

- **Ejemplos**: InfluxDB, TimescaleDB.
- **Ventajas**: Optimización para la lectura y almacenamiento de datos temporales, excelente para manejar grandes cantidades de datos que evolucionan con el tiempo.
- **Uso**: Monitoreo de rendimiento de aplicaciones, sensores IoT, datos financieros, análisis de logs.

Estas bases de datos ofrecen una arquitectura optimizada para consultas sobre rangos de tiempo y proporcionan herramientas analíticas específicas para tendencias temporales, lo que las hace esenciales en la observación y análisis de eventos cronológicos.


<div align="center">
  <img src="https://media.licdn.com/dms/image/v2/D4D12AQFM_Fq9NG-9ag/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1700373279164?e=1733961600&v=beta&t=ByKDWT9nfAB_ZhYbfxXDAJ1QDHbLWKul7B3qB0QUNb8" width=80%>
</div>

Tomadas de [Choosing the right type of dB is important, different types of dB](https://www.linkedin.com/pulse/choosing-right-type-db-important-different-types-paresh-nayak-i9shf/).

<div align="center">
  <img src="https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2Fffd5e3dc-215c-4f89-8336-6aa835022693_1984x1188.png" width=80%>
</div>

Tomada de [15 Types of Databases and When to Use Them](https://blog.algomaster.io/p/15-types-of-databases).

## Conclusión

Conectar Java con bases de datos es una habilidad crucial en el desarrollo de aplicaciones robustas y escalables. Con JDBC, Java puede interactuar con casi cualquier base de datos relacional, permitiendo a los desarrolladores manipular grandes cantidades de datos de manera eficiente. Al dominar tanto los tipos de bases de datos como la conexión con ellas, los programadores pueden garantizar que sus aplicaciones manejen datos de manera correcta y eficiente.

## Recursos Adicionales

### Documentación
- Oracle Documentation: [JDBC Overview](https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html)
- MySQL Documentation: [MySQL Connector/J](https://dev.mysql.com/doc/connector-j/8.0/en/)

### Guías y Tutoriales

- [7.1 Connecting to MySQL Using the JDBC DriverManager Interface](https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-connect-drivermanager.html)
- [Introduction to JDBC](https://www.baeldung.com/java-jdbc)
- [Java Database Connectivity - Wikipedia](https://en.wikipedia.org/wiki/Java_Database_Connectivity)
- [Java Database Connectivity with MySQL](https://www.javatpoint.com/example-to-connect-to-the-mysql-database)
- [Java Database Programming (JDBC) An Intermediate Tutorial - NTU](https://www3.ntu.edu.sg/home/ehchua/programming/java/JDBC_Intermediate.html)
- [Java Database Programming (JDBC) by Examples with MySQL - NTU](https://personal.ntu.edu.sg/ehchua/programming/java/JDBC_Basic.html)


### Videos

- [Types of Databases: Relational vs. Columnar vs. Document vs. Graph vs. Vector vs. Key-value & more ](https://www.youtube.com/watch?app=desktop&v=VfcRxtBKI54)