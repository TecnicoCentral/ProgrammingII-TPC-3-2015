# Conexión desde Java

## Objetivos

- Identificar y diferenciar los tipos de bases de datos.
- Conocer las características y usos de cada tipo de base de datos.
- Aprender a conectar una aplicación Java con una base de datos utilizando JDBC.
- Implementar una conexión básica y realizar operaciones simples sobre una base de datos relacional.

## Introducción

En el desarrollo de software, las bases de datos juegan un papel fundamental en el almacenamiento y manejo eficiente de la información. Existen varios tipos de bases de datos, cada uno diseñado para diferentes aplicaciones, y es esencial para los desarrolladores saber cómo conectarse y manipular estas bases de datos desde sus aplicaciones. En Java, la interacción con las bases de datos se realiza a través de la API JDBC (Java Database Connectivity), que proporciona un estándar para conectar aplicaciones Java con bases de datos.

En esta clase, exploraremos cómo realizar una conexión básica a una base de datos utilizando Java.

## Conexión

La conexión a una base de datos en Java se realiza a través de la API Java Database Connectivity (JDBC). JDBC proporciona una forma estandarizada de conectarse a bases de datos relacionales. El flujo básico de conexión es:

1. Cargar el controlador JDBC.
2. Establecer la conexión con la base de datos.
3. Crear una declaración SQL y ejecutarla.
4. Procesar los resultados.
5. Cerrar la conexión.

### Ejemplo de Conexión a MySQL en Java usando JDBC

A continuación, te mostramos cómo realizar una conexión simple a una base de datos MySQL y ejecutar una consulta básica.

### Configuración de la Base de Datos
Antes de empezar, asegúrate de tener MySQL instalado y configurado. Crea una base de datos llamada `universidad` con una tabla `estudiantes`.

```sql
CREATE DATABASE universidad;

USE universidad;

CREATE TABLE estudiantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    edad INT
);
```

### Código Java para Conexión a la Base de Datos

Este es un ejemplo de cómo realizar la conexión:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionDB {
    public static void main(String[] args) {
        // URL de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/universidad"; // Cambiar 'localhost' y 'universidad' según tu configuración
        String usuario = "root"; // Usuario de MySQL
        String contraseña = "password"; // Contraseña de MySQL

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Crear una declaración SQL
            Statement stmt = conexion.createStatement();
            String sql = "SELECT * FROM estudiantes";

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery(sql);

            // Procesar los resultados
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Edad: " + rs.getInt("edad"));
            }

            // Cerrar la conexión
            rs.close();
            stmt.close();
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Explicación del Código

1. **Cargar el controlador JDBC**: Usamos `Class.forName("com.mysql.cj.jdbc.Driver")` para cargar el controlador de MySQL.
2. **Establecer la conexión**: `DriverManager.getConnection(url, usuario, contraseña)` crea una conexión a la base de datos.
3. **Crear una declaración SQL**: Utilizamos un objeto `Statement` para ejecutar consultas SQL.
4. **Procesar los resultados**: El `ResultSet` contiene los datos obtenidos de la consulta.
5. **Cerrar la conexión**: Siempre es importante cerrar la conexión para liberar recursos.

### Inserción de datos

Podemos agregar una inserción de datos a la tabla:

```java
String sqlInsert = "INSERT INTO estudiantes (nombre, edad) VALUES ('Juan Perez', 20)";
stmt.executeUpdate(sqlInsert);
```

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