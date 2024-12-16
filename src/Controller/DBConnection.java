package Controller;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class DBConnection {
    public static List<User> getUser() {
        String url = "jdbc:postgresql://localhost:5432/betterreads";
        String user = "postgres";
        String password = "password";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM \"users\"";
            ResultSet resultSet = statement.executeQuery(query);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name")
                ));
            }

            return users;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public static void insertUser(String username, String passwordUser, String name) {
        String url = "jdbc:postgresql://localhost:5432/betterreads";
        String user = "postgres";
        String password = "password";

        String query = "INSERT INTO users (username, password, name) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, passwordUser);
            pst.setString(3, name);

            pst.executeUpdate();

            System.out.println("User inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
