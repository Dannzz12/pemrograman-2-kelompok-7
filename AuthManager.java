import java.io.*;
import java.util.*;

public class AuthManager {
    private String filename;

    public AuthManager(String filename) {
        this.filename = filename;
    }

    public void register(String username, String password) throws IOException {
        if (userExists(username)) {
            System.out.println("❌ Username sudah terdaftar.");
            return;
        }

        User user = new User(username, password);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(user.getUsername() + "," + user.getEncryptedPassword());
        writer.newLine();
        writer.close();
        System.out.println("✅ Registrasi berhasil!");
    }

    public void login(String username, String password) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("❌ Tidak ada data user. Silakan register.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].equals(username)) {
                String encryptedPassword = parts[1];
                if (encryptedPassword.equals(User.encrypt(password))) {
                    System.out.println("✅ Login berhasil!");
                } else {
                    System.out.println("❌ Password salah.");
                }
                reader.close();
                return;
            }
        }
        reader.close();
        System.out.println("❌ Username tidak ditemukan.");
    }

    private boolean userExists(String username) throws IOException {
        File file = new File(filename);
        if (!file.exists()) return false;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 1 && parts[0].equals(username)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }
}
