import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The Class for Text ui.
 */
public class TextUI {
    /**
     * Attribute:
     * Create scanner attribute for TextUI class
     */
    private Scanner scanner;

    /**
     * Constructor:
     * Instantiates a new Text ui object
     * new Scanner(System.in): Create scanner objects to read keyboard input
     * this.scanner = ...: assign new scanner objects to TextUI's scanner attributes
     */
    public TextUI() {
        this.scanner = new Scanner(System.in);
    }


    /**
     * Display main menu with choices
     */
    public void displayMainMenu() {
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
                displayMenuForAddingClaims();
                break;
            case 2:
                displayMenuForGettingClaims();
                break;
            case 3:
                displayMenuForUpdatingClaims();
                break;
            case 4:
                displayMenuForDeletingClaims();
                break;
            case 5:
                System.out.println("Exiting the program...");
                System.exit(0); // exit status code of 0
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

        }

    }

    //remember has option to move back to previous step
    public void displayMenuForAddingClaims() {
        int choice = 0;
        System.out.println("Menu of choices for adding claims: ");
        System.out.println("1. Add claims by default values");
        System.out.println("2. Add claims with values from your input");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 4): ");
        choice = scanner.nextInt();
        handleMainMenuInput(choice);
    }

    public void handleMenuForAddingClaims(int choice) throws ParseException {
        SystemAdmin systemAdmin = new SystemAdmin();
        switch (choice) {
            case 1:
                systemAdmin.addClaim();
                break;
            case 2:
                System.out.println("Please enter values of claim's attributes: ");
                System.out.println("Please enter the claim date (must be the format dd-MM-yyyy, example: 12-04-2024): ");
                String stringClaimDate = scanner.next();
                Date claimDate = Main.DATE_FORMAT.parse(stringClaimDate); //parse from String input to Date
                System.out.println("Please enter the name of insured person ");
                String insuredPerson = scanner.next();
                System.out.println("Please enter the cardNumber (must be a 10 digits integer");
                String cardNumber = scanner.next(); //check for 10 digit integer
                System.out.println("Please enter the ExamDate (must be the format dd-MM-yyyy, example: 12-04-2024)");
                String stringExamDate = scanner.next();
                //parse input date from String to Date
                Date examDate = Main.DATE_FORMAT.parse(stringExamDate);
                System.out.println("Please enter the list of documents. Each document is separated by a \",\" (comma): ");
                ArrayList<String> listOfDocuments = new ArrayList<>();
                String listOfDocumentContent = scanner.next();
                //divide the string above into elements separate by comma (,) then add them to listOfDocument
                // Split the input string by comma and trim each element to remove leading/trailing spaces
                String[] documentsArray = listOfDocumentContent.split(",");

                // Add each document to the ArrayList
                for (String document : documentsArray) {
                    listOfDocuments.add(document.trim());
                }

                // Print the list of documents
                System.out.println("List of documents:");
                for (String document : listOfDocuments) {
                    System.out.println(document);
                }
                System.out.println("Please enter the claim amount (must be a positive integer): ");
                double claimAmount = scanner.nextDouble();
                System.out.println("Please enter the status (must be 1 in 3: New, Processing, or Done): ");
                String status = scanner.next().toLowerCase(); //all to lower case
                System.out.println("Now please enter the banking info: ");
                System.out.println("Please enter the bank name:");
                String bankName = scanner.next();
                System.out.println("Please enter the account owner:");
                String accountOwner = scanner.next();
                System.out.println("Please enter the account number (must be an integer):");
                String accountNumber = "b-" + scanner.nextInt();
                //pass user input the the method parameter
                systemAdmin.addClaim(claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, claimAmount, status, bankName, accountOwner, accountNumber);
                break;
            case 3:
                System.out.println("Moving back to main menu ...");
                //do nothing = go back 1 step (The current method would return to the method that call it
                break;

            case 4:
                System.out.println("Exiting the program...");
                System.exit(0); // exit status code of 0
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

        }

    }

    public void displayMenuForGettingClaims() {
        int choice = 0;
        System.out.println("Menu of choices for getting/viewing claims: ");
        System.out.println("1. Get claims by claim ID");
        System.out.println("2. Get all claims in the system");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 4): ");
        choice = scanner.nextInt();
        handleMainMenuInput(choice);
    }

    public void handleMenuForGettingClaims(int choice) {
        SystemAdmin systemAdmin = new SystemAdmin();
        switch (choice) {
            case 1:
                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                String claimID = scanner.next();
                systemAdmin.getOneClaimById(claimID);
                break;
            case 2:
                systemAdmin.getAllClaims();
                break;
            case 3:
                System.out.println("Moving back to main menu ...");
                break;

            case 4:
                System.out.println("Exiting the program...");
                System.exit(0); // exit status code of 0
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

        }

    }

    public void displayMenuForUpdatingClaims() {
        int choice = 0;
        System.out.println("Menu of choices for updating/changing claims: ");
        System.out.println("1. Update claims by claim ID");
        System.out.println("2. Back to main menu");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (must be integer from 1 to 3): ");
        choice = scanner.nextInt();
        handleMainMenuInput(choice);
    }

    public void handleMenuForUpdatingClaims(int choice) throws ParseException {
        SystemAdmin systemAdmin = new SystemAdmin();
        System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
        String claimID = scanner.next();
        switch (choice) {
            case 1:
                System.out.println("Please enter values of claim's attributes: ");
                System.out.println("Please enter the claim date (must be the format dd-MM-yyyy, example: 12-04-2024): ");
                String stringClaimDate = scanner.next();
                Date claimDate = Main.DATE_FORMAT.parse(stringClaimDate); //parse from String input to Date
                System.out.println("Please enter the name of insured person ");
                String insuredPerson = scanner.next();
                System.out.println("Please enter the cardNumber (must be a 10 digits integer");
                String cardNumber = scanner.next(); //check for 10 digit integer
                System.out.println("Please enter the ExamDate (must be the format dd-MM-yyyy, example: 12-04-2024)");
                String stringExamDate = scanner.next();
                //parse input date from String to Date
                Date examDate = Main.DATE_FORMAT.parse(stringExamDate);
                System.out.println("Please enter the list of documents. Each document is separated by a \",\" (comma): ");
                ArrayList<String> listOfDocuments = new ArrayList<>();
                String listOfDocumentContent = scanner.next();
                //divide the string above into elements separate by comma (,) then add them to listOfDocument
                // Split the input string by comma and trim each element to remove leading/trailing spaces
                String[] documentsArray = listOfDocumentContent.split(",");

                // Add each document to the ArrayList
                for (String document : documentsArray) {
                    listOfDocuments.add(document.trim());
                }

                // Print the list of documents
                System.out.println("List of documents:");
                for (String document : listOfDocuments) {
                    System.out.println(document);
                }
                System.out.println("Please enter the claim amount (must be a positive integer): ");
                double claimAmount = scanner.nextDouble();
                System.out.println("Please enter the status (must be 1 in 3: New, Processing, or Done): ");
                String status = scanner.next().toLowerCase(); //all to lower case
                System.out.println("Now please enter the banking info: ");
                System.out.println("Please enter the bank name:");
                String bankName = scanner.next();
                System.out.println("Please enter the account owner:");
                String accountOwner = scanner.next();
                System.out.println("Please enter the account number (must be an integer):");
                String accountNumber = "b-" + scanner.nextInt();
                //pass user input the the method parameter
                systemAdmin.addClaim(claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, claimAmount, status, bankName, accountOwner, accountNumber);
                break;
            case 2:
                System.out.println("Moving back to main menu ...");

                break;

            case 3:
                System.out.println("Exiting the program...");
                System.exit(0); // exit status code of 0
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

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
        handleMainMenuInput(choice);
    }

    public void handleMenuForDeletingClaims(int choice) {
        SystemAdmin systemAdmin = new SystemAdmin();
        switch (choice) {
            case 1:
                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                String claimID = scanner.next();
                systemAdmin.deleteClaimById(claimID);
                break;
            case 2:
                systemAdmin.deleteAllClaimInTheSystem();
                break;
            case 3:
                System.out.println("Moving back to main menu ...");

                break;

            case 4:
                System.out.println("Exiting the program...");
                System.exit(0); // exit status code of 0
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }
//Finish menu by traditional way
//MCV to display menu?
}
