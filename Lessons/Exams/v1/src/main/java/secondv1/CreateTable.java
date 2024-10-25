package secondv1;

import java.sql.*;

//Creación de la tabla
public class CreateTable {
    public static void Create() {
        String query = """
            CREATE TABLE IF NOT EXISTS Recordings (
                id INT PRIMARY KEY,
                gen VARCHAR(100) NOT NULL,
                loc VARCHAR(500) NOT NULL,
                en VARCHAR(50) NOT NULL,
                file VARCHAR(50) NOT NULL
            );
            """;;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {
          
              // // Usando el método executeUpdate
              // int result = stmt.executeUpdate(query);
              // System.out.println(result);

              // Usando el método execute
              boolean result = stmt.execute(query);
              //System.out.println(result1);
              System.out.println("Table created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Create();
    }
  }