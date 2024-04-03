/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 03-Apr-24 10:18 AM
 * @project IndiProject
 * @since ${11.0.18}
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClaimView {
    private Scanner scanner;
    private ClaimController controller;

    public ClaimView() {

        this.scanner = new Scanner(System.in);
    }

    // Setter method for ClaimController
    public void setController(ClaimController controller) {
        this.controller = controller;
    }


    /**
     * Display main menu with choices
     */
    public void displayMainMenu() throws ParseException {
        int choice = 0;
        System.out.println("Welcome to the Insurance Claims Management System!");
        System.out.println("Menu of choices: ");
        System.out.println("1. Add claims");
        System.out.println("2. Get/View claims");
        System.out.println("3. Update claims");
        System.out.println("4. Delete claims");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 5): ");
        choice = scanner.nextInt();
        // Handle the user's choice using the ClaimController

        try {
            if (controller != null) {
                controller.handleMainMenuInput(choice);
            } else {
                System.out.println("Error: ClaimController not set.");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing user input: " + e.getMessage());
        }

    }


    //remember has option to move back to previous step
    public void displayMenuForAddingClaims() throws ParseException {
        int choice = 0;
        System.out.println("Menu of choices for adding claims: ");
        System.out.println("1. Add claims by default values");
        System.out.println("2. Add claims with values from your input");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 4): ");
        choice = scanner.nextInt();
        // Handle the user's choice using the ClaimController

        try {
            if (controller != null) {
                controller.handleMainMenuInput(choice);
            } else {
                System.out.println("Error: ClaimController not set.");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing user input: " + e.getMessage());
        }
    }



    public void displayMenuForGettingClaims() throws ParseException {
        int choice = 0;
        System.out.println("Menu of choices for getting/viewing claims: ");
        System.out.println("1. Get claims by claim ID");
        System.out.println("2. Get all claims in the system");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 4): ");
        choice = scanner.nextInt();
        // Handle the user's choice using the ClaimController

        try {
            if (controller != null) {
                controller.handleMainMenuInput(choice);
            } else {
                System.out.println("Error: ClaimController not set.");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing user input: " + e.getMessage());
        }
    }


    public void displayMenuForUpdatingClaims() throws ParseException {
        int choice = 0;
        System.out.println("Menu of choices for updating/changing claims: ");
        System.out.println("1. Update claims by claim ID");
        System.out.println("2. Back to main menu");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 3): ");
        choice = scanner.nextInt();
        // Handle the user's choice using the ClaimController

        try {
            if (controller != null) {
                controller.handleMainMenuInput(choice);
            } else {
                System.out.println("Error: ClaimController not set.");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing user input: " + e.getMessage());
        }
    }


    public void displayMenuForDeletingClaims() {
        int choice = 0;
        System.out.println("Menu of choices for deleting claims: ");
        System.out.println("1. Delete 1 claim by claim ID");
        System.out.println("2. Delete all claims in the system");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 4): ");
        choice = scanner.nextInt();
        // Handle the user's choice using the ClaimController

        try {
            if (controller != null) {
                controller.handleMainMenuInput(choice);
            } else {
                System.out.println("Error: ClaimController not set.");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing user input: " + e.getMessage());
        }

    }



    public int getUserChoice() {
        return scanner.nextInt();
    }
}