package secondv1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTable {
    public static void Show() {
        String query = "SELECT * FROM Recordings";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String gen = resultSet.getString("gen");
                String loc = resultSet.getString("loc");
                String en = resultSet.getString("en");
                String file = resultSet.getString("file");
                
                Record record = new Record(id, gen, loc, en, file);
                System.out.println(record+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Show();
    }
}