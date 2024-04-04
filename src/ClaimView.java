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
    public void displayMainMenu() {
        int choice;
        System.out.println("Welcome to the Insurance Claims Management System!");
        System.out.println("Menu of choices: ");
        System.out.println("------------------------------------------------------");
        System.out.println("OPTIONS FOR ADDING CLAIMS");
        System.out.println("1. Add claims by default values");
        System.out.println("2. Add claims by input values");
        System.out.println("------------------------------------------------------");
        System.out.println("OPTIONS FOR GETTING CLAIMS");
        System.out.println("3. Get 1 claim by claim ID");
        System.out.println("4. Get all claims in the system");
        System.out.println("------------------------------------------------------");
        System.out.println("OPTIONS FOR UPDATING CLAIMS");
        System.out.println("5. Updating 1 claim by claim ID");
        System.out.println("OPTIONS FOR DELETING CLAIMS");
        System.out.println("6. Deleting 1 claim by claim ID");
        System.out.println("7. Deleting all claims in the system");
        System.out.println("8. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 8): ");
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


}