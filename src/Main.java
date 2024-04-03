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
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        SystemAdmin model = new SystemAdmin();
        ClaimView view = new ClaimView();
        ClaimController controller = new ClaimController(view, model, scanner);
        // Set the ClaimController instance in the ClaimView object
        view.setController(controller);

        view.displayMainMenu();
        int choice = view.getUserChoice();
        controller.handleMainMenuInput(choice);
    }
}

