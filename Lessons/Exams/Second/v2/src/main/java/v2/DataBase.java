package v2;

import java.sql.*;

public class DataBase {
  private static final String URL = "jdbc:mysql://localhost:3306/TVShowsDB";
    private static final String USER = "root"; // Cambia 'root' por tu usuario de MySQL
    private static final String PASSWORD = "123456"; // Cambia 'yourpassword' por tu contraseña de MySQL
    private static String table_name;

    public DataBase(String table_name){
      DataBase.table_name = table_name;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void CreateTable() {
      String query = """
          CREATE TABLE IF NOT EXISTS %s (
              id INT PRIMARY KEY,
              name VARCHAR(100) NOT NULL,
              url VARCHAR(100) NOT NULL,
              officialSite VARCHAR(200) NOT NULL,
              language VARCHAR(50) NOT NULL,
              type VARCHAR(50) NOT NULL
          );
          """.formatted(table_name);
      try (Connection connection = getConnection();
           Statement stmt = connection.createStatement()) {
        
            // Usando el método executeUpdate
            int result = stmt.executeUpdate(query);
            System.out.println("Table %s created successfully. Rows affected: %s".formatted(table_name, result));
          
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

  public void insertShow(Show show) {
    String query = "INSERT INTO %s (id, name, url, officialSite, language, type) VALUES (?, ?, ?, ?,?,?)".formatted(table_name);
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, show.id);
        preparedStatement.setString(2, show.name);
        preparedStatement.setString(3, show.url);
        preparedStatement.setString(4, show.officialSite);
        preparedStatement.setString(5, show.language);
        preparedStatement.setString(6, show.type);
        
        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println("Data imported successfully in %s table. Rows affected: %s".formatted(table_name, rowsInserted));
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public void selectAllShows() {
    String query = "SELECT * FROM %s".formatted(table_name);
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean empty = true;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String officialSite = resultSet.getString("officialSite");
            String language = resultSet.getString("language");
            String type = resultSet.getString("type");
            
            Show show = new Show(id, name, url, officialSite, language, type);

            System.out.println(show);
            empty = false;
        }

        if(empty == true){
          System.out.println("The table %s is empty.".formatted(table_name));
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public void deleteShow(Show show) {
    String query = "DELETE FROM %s WHERE id = ?".formatted(table_name);
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, show.id);

        int rowsDeleted = preparedStatement.executeUpdate();
        System.out.println("Record with id %d deleted successfully from table %s. Rows affected: %s ".formatted(show.id, table_name, rowsDeleted));
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
}

