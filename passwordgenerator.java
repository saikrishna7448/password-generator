import java.util.Random;
import java.util.Scanner;

public class passwordgenerator {
    // Define the character sets
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        System.out.println("Choose the character set:");
        System.out.println("1. Uppercase letters only");
        System.out.println("2. Lowercase letters only");
        System.out.println("3. Numbers only");
        System.out.println("4. Special characters only");
        System.out.println("5. All characters");

        int choice = scanner.nextInt();
        String charSet = "";

        switch (choice) {
            case 1:
                charSet = UPPERCASE_CHARS;
                break;
            case 2:
                charSet = LOWERCASE_CHARS;
                break;
            case 3:
                charSet = NUMBERS;
                break;
            case 4:
                charSet = SPECIAL_CHARS;
                break;
            case 5:
                charSet = UPPERCASE_CHARS + LOWERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
                break;
            default:
                System.out.println("Invalid choice. Using all characters by default.");
                charSet = UPPERCASE_CHARS + LOWERCASE_CHARS + NUMBERS + SPECIAL_CHARS;
        }

        String password = generatePassword(length, charSet);
        System.out.println("Generated Password: " + password);
    }

    // Function to generate a random password
    private static String generatePassword(int length, String charSet) {
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            char randomChar = charSet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
