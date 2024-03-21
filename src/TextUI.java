import java.util.Scanner;

public class TextUI implements WelcomingScreen {
    private Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }


    public void displayMainMenu() {
        System.out.println("Welcome to the Insurance Claims Management System!");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage Insurance Cards");
        System.out.println("3. Manage Claims");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        handleMainMenuInput(choice);
    }

    public void handleMainMenuInput(int choice) {
        switch (choice) {
            case 1:
                displayCustomerMenu();
                break;
            case 2:
                displayInsuranceCardMenu();
                break;
            case 3:
                displayClaimMenu();
                break;
            case 4:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
        }
    }

    public void displayCustomerMenu() {
        // Implement logic for managing customers (e.g., add, update, delete)
        System.out.println("Customer Menu");
        // Display appropriate options and handle user input
    }

    public void displayInsuranceCardMenu() {
        // Implement logic for managing insurance cards
        System.out.println("Insurance Card Menu");
        // Display appropriate options and handle user input
    }

    public void displayClaimMenu() {
        // Implement logic for managing claims
        System.out.println("Claim Menu");
        // Display appropriate options and handle user input
    }

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.displayMainMenu();
    }
}