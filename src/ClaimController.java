import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The type Claim controller.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 03 -Apr-24 10:25 AM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class ClaimController {
    private ClaimView view;
    private SystemAdmin model;
    private Scanner scanner;

    /**
     * Instantiates a new Claim controller.
     *
     * @param view    the view
     * @param model   the model
     * @param scanner the scanner
     */
    public ClaimController(ClaimView view, SystemAdmin model, Scanner scanner) {
        this.view = view;
        this.model = model;
        this.scanner = scanner;
    }


    /**
     * Handle main menu input.
     *
     * @param choice the choice (user input an integer from 1 to 10)
     * @throws ParseException the parse exception
     * @throws IOException    the io exception
     */
    public void handleMainMenuInput(int choice) throws ParseException, IOException {
        switch (choice) {
            case 1: //add claim by default value
                model.addClaim();
                view.displayMainMenu();
                break;
            case 2: //add claim by input value

                String claimId = IdManager.generateClaimID();
                System.out.println("Please enter values of claim's attributes: ");
                System.out.println("Please enter the claim date (must be the format dd-MM-yyyy, example: 12-04-2024): ");


                Date claimDate = DataInputValidator.getValidClaimDate(scanner); //parse from String input to Date
                System.out.println("Please enter the name of insured person ");
                String insuredPerson = scanner.next();

                String cardNumber = DataInputValidator.getValidInsuranceCardNumber(scanner, FileIOManager.insuranceCardsTemporaryArrayList); //check for 10 digit integer and card exist
                //parse input date from String to Date
                Date examDate = DataInputValidator.getValidExamDate(scanner, claimDate);
                ArrayList<String> listOfDocuments = DataInputValidator.getValidListOfDocuments(scanner);
                double claimAmount = DataInputValidator.getValidClaimAmount(scanner);
                String status = DataInputValidator.getValidStatus(scanner);
                System.out.println("Now please enter the banking info: ");
                System.out.println("Please enter the bank name:");
                String bankName = scanner.next();
                System.out.println("Please enter the account owner:");
                String accountOwner = scanner.next();
                System.out.println("Please enter the account number (must be an integer):");
                String accountNumber = "b-" + scanner.nextInt();
                //pass user input the the method parameter
                model.addClaim(claimId, claimDate, insuredPerson, cardNumber, examDate, claimAmount, status, bankName, accountOwner, accountNumber, listOfDocuments);
                view.displayMainMenu();
                break;

            case 3: //get 1 claim by claim ID

                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                String claimID = scanner.next();
                model.getOneClaimById(claimID);
                view.displayMainMenu();
                break;
            case 4: //get all claims in the system
                model.getAllClaims();
                break;


            case 5: //get all claims in the system by status
                System.out.println("Please enter the status (must be 1 in 3: New, Processing, or Done): ");
                String searchStatus = scanner.next().toLowerCase(); //all to lower case
                model.getClaimsByStatus(searchStatus);
                view.displayMainMenu();
                break;
            case 6: //update claim by ID

                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                String claimIDAsInput = scanner.next();
                // Retrieve the claim by its ID
                Claim claimToUpdate = model.getOneClaimById(claimIDAsInput);
                if (claimToUpdate != null) {
                    System.out.println("Please enter values of claim's attributes: ");
                    System.out.println("Please enter the claim date (must be the format dd-MM-yyyy, example: 12-04-2024): ");
                    claimDate = DataInputValidator.getValidClaimDate(scanner); //parse from String input to Date
                    System.out.println("Please enter the name of insured person ");
                    insuredPerson = scanner.next();
                    cardNumber = DataInputValidator.getValidInsuranceCardNumber(scanner, FileIOManager.insuranceCardsTemporaryArrayList); //check for 10 digit integer
                    examDate = DataInputValidator.getValidExamDate(scanner, claimDate);
                    listOfDocuments = DataInputValidator.getValidListOfDocuments(scanner);
                    claimAmount = DataInputValidator.getValidClaimAmount(scanner);
                    status = DataInputValidator.getValidStatus(scanner);
                    System.out.println("Now please enter the banking info: ");
                    System.out.println("Please enter the bank name:");
                    bankName = scanner.next();
                    System.out.println("Please enter the account owner:");
                    accountOwner = scanner.next();
                    System.out.println("Please enter the account number (must be an integer):");
                    accountNumber = "b-" + scanner.nextInt();
                    model.updateClaimById(claimIDAsInput, claimDate, insuredPerson, cardNumber, examDate, claimAmount, status, bankName, accountOwner, accountNumber, listOfDocuments);

                } else {
                    System.out.println("Claim not found with the provided ID.");
                }

                view.displayMainMenu();
                break;
            case 7: //update claim status by ID
                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                claimID = scanner.next();
                System.out.println("Please enter the new status (must be 1 in 3: New, Processing, or Done): ");
                String newStatus = scanner.next().toLowerCase(); //all to lower case
                model.updateClaimStatusById(claimID, newStatus);
                view.displayMainMenu();
                break;

            case 8: //delete claim by ID
                System.out.println("Please enter the claimID (must be the format f-numbers; 10 numbers)");
                claimID = scanner.next();
                model.deleteClaimById(claimID);
                view.displayMainMenu();
                break;
            case 9: //delete all the claim in the system
                model.deleteAllClaimInTheSystem();

                view.displayMainMenu();
                break;
            case 10:
                System.out.println("Exiting the program...");

                //When user exit the program: save the data from temporary ArrayList back to files
//                FileIOManager.loadData();
                System.out.println("Claim temp ArrayList before saving: ");
                System.out.println("Claim Temporary ArrayList");
                for (Claim claim : FileIOManager.claimsTemporaryArrayList
                ) {
                    System.out.println(claim);
                }
                FileIOManager.saveData();
                System.out.println("Claim temp ArrayList after saving: ");
                System.out.println("Claim Temporary ArrayList");
                for (Claim claim : FileIOManager.claimsTemporaryArrayList
                ) {
                    System.out.println(claim);
                }
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                view.displayMainMenu();
                break;
        }
    }


}
