package Database;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    public static String hashPassword(String plainPassword) {
        // Generate a salt and hash the password
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Method to verify a password
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
