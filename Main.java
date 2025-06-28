import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AuthManager auth = new AuthManager("users.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                auth.register(username, password);
            } else if (choice.equals("2")) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                auth.login(username, password);
            } else if (choice.equals("3")) {
                System.out.println("👋 Keluar dari aplikasi.");
                break;
            } else {
                System.out.println("❌ Pilihan tidak valid.");
            }
        }
    }
}
