public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = encrypt(password);
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return password;
    }

    public static String encrypt(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) ((c + 3 - 32) % 95 + 32)); // Caesar Cipher
        }
        return encrypted.toString();
    }

    public static String decrypt(String encryptedPassword) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedPassword.toCharArray()) {
            decrypted.append((char) ((c - 3 - 32 + 95) % 95 + 32));
        }
        return decrypted.toString();
    }
}
