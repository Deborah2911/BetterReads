package Database;

import java.sql.*;
import java.util.*;

public class DBConnection {
    private static final String urlDeni = "jdbc:postgresql://localhost:5432/betterreads";
    private static final String urlDebo = "jdbc:postgresql://localhost:5432/postgres";
    private static final String passwordDeni = "password";
    private static final String passwordDebo = "Berti2001!";
    public static List<User> getUser() {
        String url = urlDeni;
        String user = "postgres";
        String password = passwordDeni;

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM \"users\"";
            ResultSet resultSet = statement.executeQuery(query);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
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
        String url = urlDeni;
        String user = "postgres";
        String password = passwordDeni;

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

    public static boolean modifyName(String name, String newName) {
        String url = urlDeni; // Database URL
        String user = "postgres"; // Database user
        String password = passwordDeni; // Database password

        // Correct SQL query for updating username
        String query = "UPDATE users SET name = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            // Use PreparedStatement to prevent SQL injection
            PreparedStatement pst = connection.prepareStatement(query);

            // Set the parameters for the query
            pst.setString(1, newName); // New username
            pst.setString(2, name);    // Current username

            // Execute the update
            int rowsAffected = pst.executeUpdate();

            // Provide feedback on the update
            if (rowsAffected > 0) {
                System.out.println("Name updated successfully!");
                return true;
            } else {
                System.out.println("No user found with the provided name.");
                return false;
            }
        } catch (Exception e) {
            // Print the stack trace for debugging purposes
            e.printStackTrace();
        }
        return false;
    }


    public static boolean modifyUsername(String username, String newUsername) {
        String url = urlDeni; // Database URL
        String user = "postgres"; // Database user
        String password = passwordDeni; // Database password

        // Correct SQL query for updating username
        String query = "UPDATE users SET username = ? WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            // Use PreparedStatement to prevent SQL injection
            PreparedStatement pst = connection.prepareStatement(query);

            // Set the parameters for the query
            pst.setString(1, newUsername); // New username
            pst.setString(2, username);    // Current username

            // Execute the update
            int rowsAffected = pst.executeUpdate();

            // Provide feedback on the update
            if (rowsAffected > 0) {
                System.out.println("Username updated successfully!");
                return true;
            } else {
                System.out.println("No user found with the provided username.");
                return false;
            }
        } catch (Exception e) {
            // Print the stack trace for debugging purposes
            e.printStackTrace();
        }
        return false;
    }


    public static List<Book> getBook() {
        String url = urlDeni;
        String user = "postgres";
        String password = passwordDeni;

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM \"books\"";
            ResultSet resultSet = statement.executeQuery(query);

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("genre")
                ));
            }
            return books;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public static List<Reviews> getReviews(){
        String url = urlDeni;
        String user = "postgres";
        String password = passwordDeni;

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "select rating, title, author, name from \"reviews\" join \"books\" on reviews.book_id = books.id join \"users\" on reviews.user_id = users.id";
            ResultSet resultSet = statement.executeQuery(query);

            List<Reviews> reviews = new ArrayList<>();
            while (resultSet.next()) {
                reviews.add(new Reviews(
                        resultSet.getDouble("rating"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("name")
                ));
            }
            return reviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
