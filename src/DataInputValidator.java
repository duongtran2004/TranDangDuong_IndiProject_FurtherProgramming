/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 03-Apr-24 11:17 AM
 * @project IndiProject
 * @since ${11.0.18}
 */
import java.util.Scanner;

public class DataInputValidator {
    public static int getValidIntegerInput(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("Enter your choice (must be an integer): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return choice;
    }
}