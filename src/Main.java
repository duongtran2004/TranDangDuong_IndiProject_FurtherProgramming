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
        FileIOManager.createNewEmptyFiles(); //create empty files if file not exist
        FileIOManager.populateDataToEmptyFiles(); //populate data to files if file is empty
        FileIOManager.loadData(); //load data from Files to temporary ArrayList
        //display welcoming screen
        WelcomingScreen.displayWelcomeScreen();
        //MVC design pattern for CRUD of claims
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        SystemAdmin model = new SystemAdmin(); //model: the logic for claims CRUD method
        ClaimView view = new ClaimView(); //claimView
        ClaimController controller = new ClaimController(view, model, scanner); //claim Controller
        // Set the ClaimController instance in the ClaimView object
        view.setController(controller);
        //display menu to user. User choices would affect the temporary ArrayList
       
        view.displayMainMenu();
        int choice = DataInputValidator.getValidIntegerInput(scanner);
        controller.handleMainMenuInput(choice);
        //When user exit the program: save the data from temporary ArrayList back to files
        FileIOManager.saveData();

    }
}

