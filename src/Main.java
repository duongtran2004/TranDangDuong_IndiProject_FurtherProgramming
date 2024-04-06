
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 03-Apr-24 10:25 AM
 * @project IndiProject
 * @since ${11.0.18}
 */

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        System.out.println(FileIOManager.claimsTemporaryArrayList);
        FileIOManager.createNewEmptyFiles(); //create empty files if file not exist
        FileIOManager.populateDataToEmptyFiles(); //populate data to files if file is empty
        //print temp claim arrayList
        System.out.println("Claim Temporary ArrayList");
        for (Claim claim: FileIOManager.claimsTemporaryArrayList
             ) {
            System.out.println(claim);
        }
        FileIOManager.loadData(); //load data from Files to temporary ArrayList
        //print temp claim arrayList
        System.out.println("Claim Temporary ArrayList after loading");
        for (Claim claim: FileIOManager.claimsTemporaryArrayList
        ) {
            System.out.println(claim);
        }
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

