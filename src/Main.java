import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * The  Main Class (Entry point for the whole program. Please start executing from this file.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:10 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class Main {

    //naming convention for final variable : cap locks + underscore
    //file name format for Window OS: ..\\..\\..
    //define constant path for Data Files
    private static final String CUSTOMERS_FILE_PATH = "src\\DataFiles\\CustomersData.txt";
    private static final String INSURANCE_CARDS_FILE_PATH = "src\\DataFiles\\InsuranceCardsData.txt";

    private static final String CLAIMS_FILE_PATH = "src\\DataFiles\\ClaimsData.txt";
    //Create temporary ArrayList to hold File Data, and display to user.
    //Once the user quit the program, these ArrayList would be empty.

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
    private static ArrayList<Claim> claims = new ArrayList<>();
    //Create a dataPopulator object to populate data from the DataFiles to the temporary ArrayLists.

    private static DataPopulator dataPopulator = new DataPopulator();

    //Create a welcomingScreen object to display welcoming screen only once when the program start.

    private static WelcomingScreen welcomingScreen = new WelcomingScreen();
    //Create a TextUI object to display menu with options to user.
    private static TextUI textUI = new TextUI();




    /**
     * Method to load data from file to temporary Collections (ArrayList) that can be shown to user
     *
     *
     */
    private static void loadData() throws IOException {
        customers = dataPopulator.populateCustomersFromFile(new File(CUSTOMERS_FILE_PATH));
        insuranceCards = dataPopulator.populateInsuranceCardsFromFile(new File(INSURANCE_CARDS_FILE_PATH));
        claims = dataPopulator.populateClaimsFromFile(new File(CLAIMS_FILE_PATH));
    }
    /**
     *save and update  data from the temporary ArrayList to DataFiles once the user quit the program. So the change
     */

    private static void saveData() throws IOException {
        dataPopulator.saveCustomersToFile(customers, new File(CUSTOMERS_FILE_PATH));
        dataPopulator.saveInsuranceCardsToFile(insuranceCards, new File(INSURANCE_CARDS_FILE_PATH));
        dataPopulator.saveClaimsToFile(claims, new File(CLAIMS_FILE_PATH));

    }
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            welcomingScreen.displayWelcomeScreen(); //display the welcoming screen only once at start
            loadData();
            textUI.displayMainMenu(); //display menu of options to users
            saveData();
        } catch (IOException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }
//In this main class:
//
//Defined file paths for storing and loading data.
//Initialize empty lists for customers, insurance cards, and claims.
//DataPopulator and TextUI instances to handle data population and user interface.
//main method: load data from files, display the main menu using the text-based UI, and save data upon program exit.
//loadData method loads data from files into the respective lists.
//saveData method saves data from lists back to files.
// implement the DataPopulator class to populate and save data from/to files according to your file format and implement the TextUI class to display the user interface and handle user interactions.
}
