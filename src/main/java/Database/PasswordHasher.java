package Database;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PasswordHasher {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");

            // Step 1: Fetch all users
            String selectQuery = "SELECT id, password FROM users";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStatement.executeQuery()) {

                // Step 2: Loop through each user and hash their password
                String updateQuery = "UPDATE users SET password = ? WHERE id = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    while (resultSet.next()) {
                        int userId = resultSet.getInt("id");
                        String plainPassword = resultSet.getString("password");

                        // Hash the password using Bcrypt
                        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

                        // Update the database
                        updateStatement.setString(1, hashedPassword);
                        updateStatement.setInt(2, userId);
                        updateStatement.executeUpdate();

                        System.out.println("Updated password for user ID: " + userId);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
