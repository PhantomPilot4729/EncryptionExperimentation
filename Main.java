import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encryptor encryptor = new Encryptor();
        System.out.println("Enter the message to encrypt:");
        String message = scanner.nextLine();
        System.out.println("Enter the encryption key");
        String key = scanner.nextLine();
        System.out.println("Choose the encryption method: 1 for basic, 2 for grid, 3 for Mac series");
        int method = scanner.nextInt();
        if(method == 1) {
            String encryptedMessage = encryptor.encryptBasic(key, message);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if(method == 2) {
            String encryptedMessage = encryptor.encryptGrid(key, message);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if(method == 3) {
        String encryptedMessage = encryptor.encryptMacSeries(key, message);
        System.out.println("Encrypted message: " + encryptedMessage);
        } else {
            System.out.println("Invalid method selected.");
        }
    }
}
