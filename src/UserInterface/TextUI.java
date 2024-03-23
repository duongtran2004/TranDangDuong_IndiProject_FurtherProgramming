package UserInterface;

import java.util.Scanner;

/**
 * The Class for Text ui.
 */
public class TextUI  {
    /**
     * Attribute:
     * Create scanner attribute for UserInterface.TextUI class
     */
    private Scanner scanner;

    /**
     * Constructor:
     * Instantiates a new Text ui object
     * new Scanner(System.in): Create scanner objects to read keyboard input
     * this.scanner = ...: assign new scanner objects to UserInterface.TextUI's scanner attributes
     */
    public TextUI() {
        this.scanner = new Scanner(System.in);
    }


    /**
     * Display main menu with choices
     */
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

    /**
     * Handle main menu input.
     *
     * @param choice the choice
     */
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

    /**
     * Display customer menu.
     */
    public void displayCustomerMenu() {
        // Implement logic for managing customers (e.g., add, update, delete)
        System.out.println("Customer Menu");
        // Display appropriate options and handle user input
    }

    /**
     * Display insurance card menu.
     */
    public void displayInsuranceCardMenu() {
        // Implement logic for managing insurance cards
        System.out.println("Insurance Card Menu");
        // Display appropriate options and handle user input
    }

    /**
     * Display claim menu.
     */
    public void displayClaimMenu() {
        // Implement logic for managing claims
        System.out.println("Claim Menu");
        // Display appropriate options and handle user input
    }

    /**
     * The entry point of the textUI class.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.displayMainMenu();
    }
}