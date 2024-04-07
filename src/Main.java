
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * The type Main.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 03 -Apr-24 10:25 AM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws ParseException the parse exception
     * @throws IOException    the io exception
     */
    public static void main(String[] args) throws ParseException, IOException {
        FileIOManager.createNewEmptyFiles(); //create empty files if file not exist
        FileIOManager.populateDataToEmptyFiles(); //populate data if file is empty
      FileIOManager.loadData(); //load data from Files to temporary ArrayList
//        System.out.println("Temp ArrayList of insurance cards");
//        for ( InsuranceCard insuranceCard:FileIOManager.insuranceCardsTemporaryArrayList
//             ) {
//            System.out.println(insuranceCard);
//        }
//        System.out.println("Temp ArrayList of dependents");
//        for (Dependent dependent: FileIOManager.dependentsTemporaryArrayList
//             ) {
//            System.out.println(dependent);
//        }
//        System.out.println("Temp ArrayList of policy holder");
//        for (PolicyHolder policyHolder: FileIOManager.policyHoldersTemporaryArrayList
//             ) {
//            System.out.println(policyHolder);
//        }
//        System.out.println("Temp ArrayList of Claims");
//        for (Claim claim: FileIOManager.claimsTemporaryArrayList
//             ) {
//            System.out.println(claim);
//        }

        //display welcoming screen
        WelcomingScreen.displayWelcomeScreen();
        //MVC design pattern for CRUD of claims
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        SystemAdmin model = new SystemAdmin(); //model: the logic for claims CRUD method
        ClaimView view = new ClaimView(); //claimView
        ClaimController controller = new ClaimController(view, model, scanner); //create claim Controller object
        // Set the ClaimController instance in the ClaimView object
        view.setController(controller);
        //display menu to user. User choices would affect the temporary ArrayList
        view.displayMainMenu();
        int choice = DataInputValidator.getValidIntegerInput(scanner);
        controller.handleMainMenuInput(choice);


    }
}

