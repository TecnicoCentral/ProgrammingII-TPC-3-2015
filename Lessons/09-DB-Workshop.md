# Taller: Operaciones CRUD

## Objetivos
1. Comprender cómo conectar una aplicación Java a una base de datos utilizando JDBC.
2. Realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) desde Java.
3. Conocer las diferencias entre los métodos `executeUpdate()`, `execute()`, y `prepareStatement()`.

## Requisitos Previos
- Conocimiento básico de SQL.
- Java SDK y MySQL (o cualquier gestor de bases de datos relacional).

## 1. Introducción a JDBC

### ¿Qué es JDBC?

JDBC es una API que permite a las aplicaciones Java interactuar con bases de datos relacionales. A través de JDBC, podemos ejecutar consultas SQL directamente desde código Java para manipular datos almacenados en bases de datos.

### Componentes Clave:
- **DriverManager**: Gestiona la conexión a la base de datos.
- **Connection**: Representa una conexión activa a la base de datos.
- **Statement**: Se utiliza para ejecutar consultas SQL.
- **ResultSet**: Almacena el resultado de una consulta SQL.
- **PreparedStatement**: Una subclase de `Statement` que permite consultas precompiladas y más seguras.

### Diferencias entre `executeUpdate()`, `execute()`, y `prepareStatement()`

- **`executeUpdate()`**: Este método se utiliza para ejecutar consultas que modifican la base de datos, como `INSERT`, `UPDATE` o `DELETE`. Retorna un entero que indica el número de filas afectadas por la consulta.

   ```java
   int rowsAffected = statement.executeUpdate("UPDATE users SET age = 30 WHERE id = 1");
   ```

- **`execute()`**: Este método se utiliza para ejecutar cualquier tipo de consulta SQL. Puede devolver diferentes tipos de resultados, dependiendo de la consulta (puede ser un `ResultSet` o un entero que indica cuántas filas fueron afectadas). Se usa cuando no sabes de antemano si tu consulta es una `SELECT` o una operación que modifica la base de datos.

   ```java
   boolean hasResultSet = statement.execute("SELECT * FROM users");
   ```

   Retorna `true` si la consulta genera un `ResultSet`, o `false` si fue una operación como `INSERT`, `UPDATE` o `DELETE`.

- **`prepareStatement()`**: Se utiliza para crear consultas SQL precompiladas y parametrizadas, que permiten mayor seguridad (evitando inyecciones SQL) y optimización. Las consultas precompiladas son más eficientes en consultas repetitivas.

   ```java
   PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
   pstmt.setString(1, "Juan");
   pstmt.setInt(2, 25);
   pstmt.executeUpdate();
   ```


## 2. Operaciones CRUD

Para ejecutar los siguiente códigos deben primero agrega la clase [DatabaseConnection](#a-conexión-a-la-base-de-datos).

### a) Insertar Registros (`INSERT`)

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecord {
    public static void insertRecord(String name, int age) {
        String query = "INSERT INTO users (name, age) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Registros insertados: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertRecord("Juan", 25);
    }
}
```

### b) Consultar Registros (`SELECT`)

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectRecords {
    public static void selectAllRecords() {
        String query = "SELECT * FROM users";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        selectAllRecords();
    }
}
```

### c) Actualizar Registros (`UPDATE`)

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecord {
    public static void updateRecord(int id, String newName, int newAge) {
        String query = "UPDATE users SET name = ?, age = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newAge);
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Registros actualizados: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateRecord(1, "Carlos", 30);
    }
}
```

### d) Eliminar Registros (`DELETE`)

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {
    public static void deleteRecord(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Registros eliminados: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deleteRecord(1);
    }
}
```

## 3. Mejores Prácticas

1. **Uso de `PreparedStatement`**: Siempre usa `PreparedStatement` en lugar de `Statement` para evitar inyecciones SQL, especialmente cuando trabajas con datos ingresados por el usuario.
   
2. **Cerrar Conexiones y Recursos**: Usa bloques `try-with-resources` para asegurarte de que los recursos como `Connection`, `PreparedStatement` y `ResultSet` se cierren automáticamente, incluso si ocurre una excepción.

## Conclusión del Taller:
Este taller introduce a los estudiantes en el uso de JDBC para realizar operaciones CRUD. Aprendieron a conectar una base de datos MySQL a Java, realizar inserciones, consultas, actualizaciones y eliminaciones, y cómo usar métodos como `executeUpdate()`, `execute()`, y `prepareStatement()` de manera eficiente y segura.


## Ejercicio Práctico: Base de Datos de Licores Colombianos

### Objetivo:
Crear una base de datos para almacenar información de licores colombianos y realizar operaciones CRUD utilizando JDBC desde una aplicación Java.

### 1. Creación de la Base de Datos y Tablas en MySQL

Primero, debes crear una base de datos llamada `licores_colombianos` con una tabla llamada `licores`. Cada licor debe tener un ID, nombre, tipo (ron, aguardiente, cerveza, etc.), grado de alcohol, y precio.

#### SQL para la creación de la base de datos:

```sql
-- Crear la base de datos
CREATE DATABASE licores_colombianos;

-- Usar la base de datos creada
USE licores_colombianos;

-- Crear la tabla 'licores'
CREATE TABLE licores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    grado_alcohol FLOAT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);
```

#### Explicación del SQL:
- **Base de datos `licores_colombianos`**: Es la base de datos donde almacenaremos toda la información de los licores.
- **Tabla `licores`**:
  - `id`: Es el identificador único de cada licor, que se genera automáticamente con cada inserción.
  - `nombre`: Almacena el nombre del licor (ejemplo: "Aguardiente Antioqueño").
  - `tipo`: Almacena el tipo de licor (ejemplo: "Aguardiente", "Ron").
  - `grado_alcohol`: Almacena el porcentaje de alcohol por volumen (ejemplo: 29.5%).
  - `precio`: Almacena el precio del licor en la moneda local (COP).


### 2. Insertar Datos de Ejemplo

Insertamos algunos datos iniciales en la tabla `licores` para comenzar a trabajar.

```sql
-- Insertar algunos registros en la tabla 'licores'
INSERT INTO licores (nombre, tipo, grado_alcohol, precio) 
VALUES ('Aguardiente Antioqueño', 'Aguardiente', 29.5, 25000),
       ('Ron Medellín', 'Ron', 37.5, 55000),
       ('Club Colombia', 'Cerveza', 4.7, 3000),
       ('Old Parr', 'Whisky', 40.0, 120000),
       ('Tequila 1800', 'Tequila', 38.0, 75000);
```


### 3. Operaciones CRUD en Java

#### a) Conexión a la Base de Datos

Antes de realizar cualquier operación, primero debemos conectarnos a la base de datos. El siguiente código Java establece la conexión usando JDBC.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/licores_colombianos";
    private static final String USER = "root"; // Cambia 'root' por tu usuario de MySQL
    private static final String PASSWORD = "yourpassword"; // Cambia 'yourpassword' por tu contraseña de MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```
#### b) Crear y poblar la tabla

```java
import java.sql.*;

//Creación de la tabla
public class CreateTable {
    public static void Create() {
        String query = """
            CREATE TABLE licores (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(100) NOT NULL,
                tipo VARCHAR(50) NOT NULL,
                grado_alcohol FLOAT NOT NULL,
                precio DECIMAL(10, 2) NOT NULL
            );
            """;;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {
          
              // Usando el método executeUpdate
              int result = stmt.executeUpdate(query);
              System.out.println(result);

              // Usando el método execute
              boolean result1 = stmt.execute(query);
              System.out.println(result1);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Create();
    }
  }
```

```java
//Poblar la tabla
import java.sql.*;

public class PoblateTable {

  public static void Poblate(){
    String query = """
        INSERT INTO licores (nombre, tipo, grado_alcohol, precio) VALUES 
                            ('Aguardiente Antioqueño', 'Aguardiente', 29.5, 25000),
                            ('Ron Medellín', 'Ron', 37.5, 55000),
                            ('Club Colombia', 'Cerveza', 4.7, 3000),
                            ('Old Parr', 'Whisky', 40.0, 120000),
                            ('Tequila 1800', 'Tequila', 38.0, 75000);
        """;
    try(Connection connection = DatabaseConnection.getConnection();
        Statement stmt = connection.createStatement();) {
          int result = stmt.executeUpdate(query);
          System.out.printf("%d rows where updated.", result);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public static void main(String[] args) {
    Poblate();
  }
}
```

#### c) Insertar un nuevo licor

Este método permite agregar un nuevo licor a la tabla `licores`.

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertLicor {
    public static void insertLicor(String nombre, String tipo, float gradoAlcohol, double precio) {
        String query = "INSERT INTO licores (nombre, tipo, grado_alcohol, precio) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, tipo);
            preparedStatement.setFloat(3, gradoAlcohol);
            preparedStatement.setDouble(4, precio);

            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Licor insertado correctamente: " + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertLicor("Aguardiente Cristal", "Aguardiente", 29.0f, 24000);
    }
}
```

#### d) Consultar los licores

Este método consulta y muestra todos los licores almacenados en la base de datos.

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectLicores {
    public static void selectAllLicores() {
        String query = "SELECT * FROM licores";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                float gradoAlcohol = resultSet.getFloat("grado_alcohol");
                double precio = resultSet.getDouble("precio");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Tipo: " + tipo + 
                                   ", Grado de Alcohol: " + gradoAlcohol + ", Precio: " + precio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        selectAllLicores();
    }
}
```

#### e) Actualizar información de un licor

El siguiente código actualiza el precio de un licor específico.

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateLicor {
    public static void updateLicorPrice(int id, double nuevoPrecio) {
        String query = "UPDATE licores SET precio = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, nuevoPrecio);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Licor actualizado correctamente: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateLicorPrice(1, 26000);  // Cambia el precio del licor con id=1
    }
}
```

#### f) Eliminar un licor

Este código elimina un registro de la tabla `licores` por su ID.

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLicor {
    public static void deleteLicor(int id) {
        String query = "DELETE FROM licores WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Licor eliminado correctamente: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        deleteLicor(5);  // Elimina el licor con id=5
    }
}
```

## Ejercicio

:::{admonition} Taller
Realizar todo el taller en un notebook de java o un proyecto para un tema de intereses: anime, peliculas, carros, motos, etc. La solución debe mostrar como se pueden realizar las operaciones de crear, leer, actualizar y eliminar, también conocidas como operaciones CRUD.
:::