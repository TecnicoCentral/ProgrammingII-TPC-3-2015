package secondv1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertValue {
    public static void Insert(Record record) {
        String query = "INSERT INTO Recordings (id, gen, loc, en, file) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, record.id);
            preparedStatement.setString(2, record.gen);
            preparedStatement.setString(3, record.loc);
            preparedStatement.setString(4, record.name_en);
            preparedStatement.setString(5, record.file_url);
            
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Record inserted sucesfully! Rows inserted:" + rowsInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     insertLicor("Aguardiente Cristal", "Aguardiente", 29.0f, 24000);
    // }
}