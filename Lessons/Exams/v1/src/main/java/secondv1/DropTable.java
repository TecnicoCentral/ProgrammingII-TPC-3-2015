package secondv1;

import java.sql.*;

//Creación de la tabla
public class DropTable {
    public static void Drop() {
        String query = "DROP TABLE IF EXISTS Recordings;";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement()) {
          
              boolean result = stmt.execute(query);
              //System.out.println(result1);
              System.out.println("Table droped!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Drop();
    }
  }