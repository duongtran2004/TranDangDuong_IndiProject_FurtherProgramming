import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 03-Apr-24 10:25 AM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class ClaimController {
    private ClaimView view;
    private SystemAdmin model;
    private Scanner scanner;

    public ClaimController(ClaimView view, SystemAdmin model, Scanner scanner) {
        this.view = view;
        this.model = model;
        this.scanner = scanner;
    }


    /**
     * Handle main menu input.
     *
     * @param choice the choice
     */
    public void handleMainMenuInput(int choice) throws ParseException {
        switch (choice) {
            case 1: //add claim by default value
                model.addClaim();
                view.displayMainMenu();
                break;
            case 2: //add claim by input value
                System.out.println("Please enter values of claim's attributes: ");
                System.out.println("Please enter the claim date (must be the format dd-MM-yyyy, example: 12-04-2024): ");

                String stringClaimDate = scanner.next();
                Date claimDate = FileIOManager.DATE_FORMAT.parse(stringClaimDate); //parse from String input to Date
                System.out.println("Please enter the name of insured person ");
                String insuredPerson = scanner.next();
                System.out.println("Please enter the cardNumber (must be a 10 digits integer");
                String cardNumber = scanner.next(); //check for 10 digit integer
                System.out.println("Please enter the ExamDate (must be the format dd-MM-yyyy, example: 12-04-2024)");
                String stringExamDate = scanner.next();
                //parse input date from String to Date
                Date examDate = FileIOManager.DATE_FORMAT.parse(stringExamDate);
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
                model.addClaim(claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, claimAmount, status, bankName, accountOwner, accountNumber);
                break;

            case 3: //get 1 claim by claim ID

                int updateChoice = scanner.nextInt();
                handleMenuForUpdatingClaims(updateChoice);
                break;
            case 4:

                int deleteChoice = scanner.nextInt();
                handleMenuForDeletingClaims(deleteChoice);
                break;
            case 5:
                System.out.println("Exiting the program...");
                // Perform any necessary cleanup or save operations before exiting
                System.exit(0);
                break;
            case 6:
                System.out.println("Exiting the program...");
                // Perform any necessary cleanup or save operations before exiting
                System.exit(0);
                break;
            case 7:
                System.out.println("Exiting the program...");
                // Perform any necessary cleanup or save operations before exiting
                System.exit(0);
                break;
            case 8:
                System.out.println("Exiting the program...");
                // Perform any necessary cleanup or save operations before exiting
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }


    public void handleMenuForAddingClaims(int choice) throws ParseException {
        SystemAdmin systemAdmin = new SystemAdmin();
        switch (choice) {
            case 1:
                systemAdmin.addClaim();
                break;
            case 2:

            case 3:
                System.out.println("Moving back to main menu ...");
                //do nothing = go back 1 step (The current method would return to the method that call it
                break;

            case 4:
                System.out.println("Exiting the program...");
                System.exit(0); // Exiting with status code 0 indicating successful termination
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

        }

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
                System.exit(0); // Exiting with status code 0 indicating successful termination
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

        }

    }


    public void handleMenuForUpdatingClaims(int choice) throws ParseException {
        SystemAdmin systemAdmin = new SystemAdmin();

        switch (choice) {
            case 1:
                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                String claimIDAsInput = scanner.next();
                // Retrieve the claim by its ID
                Claim claimToUpdate = systemAdmin.getOneClaimById(claimIDAsInput);
                if (claimToUpdate != null) {
                    System.out.println("Please enter values of claim's attributes: ");
                    System.out.println("Please enter the claim date (must be the format dd-MM-yyyy, example: 12-04-2024): ");
                    String stringClaimDate = scanner.next();
                    Date claimDate = FileIOManager.DATE_FORMAT.parse(stringClaimDate); //parse from String input to Date
                    System.out.println("Please enter the name of insured person ");
                    String insuredPerson = scanner.next();
                    System.out.println("Please enter the cardNumber (must be a 10 digits integer");
                    String cardNumber = scanner.next(); //check for 10 digit integer
                    System.out.println("Please enter the ExamDate (must be the format dd-MM-yyyy, example: 12-04-2024)");
                    String stringExamDate = scanner.next();
                    //parse input date from String to Date
                    Date examDate = FileIOManager.DATE_FORMAT.parse(stringExamDate);
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
                    systemAdmin.updateClaimById(claimIDAsInput, claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, claimAmount, status, bankName, accountOwner, accountNumber);

                } else {
                    System.out.println("Claim not found with the provided ID.");
                }

                break;
            case 2:
                System.out.println("Moving back to main menu ...");

                break;

            case 3:
                System.out.println("Exiting the program...");
                System.exit(0); // Exiting with status code 0 indicating successful termination
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;

        }

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
                System.exit(0); // Exiting with status code 0 indicating successful termination
                break;
            default: //handle wrong user input if cannot find choice that match to options
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }
}
