package Database;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBConnection {
    //private static final String url = "jdbc:postgresql://localhost:5432/betterreads"; //-- Uncomment this if you are Deni, comment if you are Debo
    private static final String url = "jdbc:postgresql://localhost:5432/postgres"; //-- Uncomment this if you are Debo, comment if you are Deni
    //private static final String password = "password"; //-- Uncomment this if you are Deni, comment if you are Debo
    private static final String password = "Berti2001!"; //--Uncomment this if you are Debo, comment if you are Deni
    private static final String user = "postgres";

    public static int getUserIdByUsername(String username) {
        String query = "SELECT id FROM users WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if the user is not found
    }
    public static List<User> getUser() {

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

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
    public static List<Book> getBook() {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM \"books\" ORDER BY title";
            ResultSet resultSet = statement.executeQuery(query);

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("genre"),
                        resultSet.getBytes("cover")
                ));
            }
            return books;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
    public static List<Reviews> getReviews(int userId){

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

            //Statement statement = connection.createStatement();

            String query = "select rating, title, author, name, cover from \"reviews\" join \"books\" on reviews.book_id = books.id join \"users\" on reviews.user_id = users.id " +
                    "where reviews.user_id IN (\n" +
                    "        SELECT user2_id FROM friendships WHERE user1_id = ?\n" +
                    "        UNION\n" +
                    "        SELECT user1_id FROM friendships WHERE user2_id = ?\n" +
                    "    );";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, userId);
            pst.setInt(2, userId);

            ResultSet resultSet = pst.executeQuery();

            List<Reviews> reviews = new ArrayList<>();
            while (resultSet.next()) {
                reviews.add(new Reviews(
                        resultSet.getDouble("rating"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("name"),
                        resultSet.getBytes("cover")
                ));
            }
            return reviews;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
    public static List<User> getFriendsByUserId(int userId) {
        List<User> friends = new ArrayList<>();
        String query = "SELECT u.id, u.username, u.password, u.name " +
                "FROM friendships f " +
                "JOIN users u ON (f.user1_id = u.id OR f.user2_id = u.id) " +
                "WHERE (f.user1_id = ? OR f.user2_id = ?) AND u.id != ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, userId);
            pst.setInt(2, userId);
            pst.setInt(3, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                User friend = new User(rs.getString("username"), rs.getString("password"), rs.getString("name"));
                friend.setId(rs.getInt("id")); // Set the id for the friend
                friends.add(friend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends;
    }
    public static List<Book> getBooksReleasedThisMonth() {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM books \n" +
                    "WHERE TO_CHAR(releaseDate, 'YYYY-MM') = TO_CHAR(CURRENT_DATE, 'YYYY-MM') \n" +
                    "ORDER BY releaseDate";
            ResultSet resultSet = statement.executeQuery(query);

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("genre"),
                        resultSet.getBytes("cover")
                ));
            }
            return books;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
    public static List<Book> getCategorizedBooks(int userId) {
        List<Book> books = new ArrayList<>();

        String query = "SELECT b.id, b.title, b.author, b.releasedate, b.genre, b.cover, ub.category_id " +
                "FROM userbooks ub " +
                "JOIN books b ON ub.book_id = b.id " +
                "WHERE ub.user_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);  // Set user_id in the query
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                int bookId = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Date releaseDate = rs.getDate("releasedate");
                String genre = rs.getString("genre");
                int categoryId = rs.getInt("category_id");
                byte[] imgBytes = rs.getBytes("cover");

                Book book = new Book(bookId, title, author, releaseDate, genre, imgBytes);
                book.setCategory(categoryId);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
    public static boolean addFriendship(int userId, String friendUsername) {
        // Fetch the friend's ID from the database based on their username
        int friendId = getUserIdByUsername(friendUsername);
        if (friendId == -1) {
            return false; // Friend's username not found
        }

        // Insert friendship relationship into the database
        String query = "INSERT INTO friendships (user1_id, user2_id) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, userId);
            pst.setInt(2, friendId);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void insertUser(String username, String passwordUser, String name) {
        String hashedPassword = PasswordHashing.hashPassword(passwordUser);
        String query = "INSERT INTO users (username, password, name) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, hashedPassword);
            pst.setString(3, name);

            pst.executeUpdate();

            System.out.println("User inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean modifyName(String name, String newName) {

        // Correct SQL query for updating username
        String query = "UPDATE users SET name = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

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

        // Correct SQL query for updating username
        String query = "UPDATE users SET username = ? WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

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

    public static List<Category> getCategory() {
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM \"categories\"";
            ResultSet resultSet = statement.executeQuery(query);

            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                categories.add(new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("category")
                ));
            }
            return categories;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public static int getUserbookCategoryByIds(int bookid, int userid) {
        String query = "SELECT category_id FROM \"userbooks\" where book_id=? and user_id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setInt(1, bookid);
            pst.setInt(2, userid);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("category_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void updateUserbooks(int categoryid, int userid, int bookid){

        String query = "UPDATE \"userbooks\" SET category_id = ? WHERE user_id = ? and book_id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            //System.out.println("Connected to database!");

            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, categoryid);
            pst.setInt(2, userid);
            pst.setInt(3, bookid);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                //System.out.println("Name updated successfully!");
            } else {
                //System.out.println("No user found with the provided name.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertUserbook(int id, int categoryid, int userid, int bookid){

        String query = "INSERT INTO userbooks (id, category_id, user_id, book_id) VALUES (?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, id);
            pst.setInt(2, categoryid);
            pst.setInt(3, userid);
            pst.setInt(4, bookid);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                //System.out.println("Name updated successfully!");
            } else {
                //System.out.println("No user found with the provided name.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUserbook(int userid, int bookid){

        String query = "DELETE FROM userbooks WHERE user_id=? and book_id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, userid);
            pst.setInt(2, bookid);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Name updated successfully!");
            } else {
                System.out.println("No user found with the provided name.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getUserbooksMaxId(){
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            Statement statement = connection.createStatement();

            String query = "SELECT MAX(id) AS max_id FROM userbooks";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next())
                return resultSet.getInt("max_id");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 400;
    }
}
