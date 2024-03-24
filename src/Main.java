import UserInterface.TextUI;
import UserInterface.WelcomingScreen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    //filepath format for Window OS: ..\\..\\..
    //define constant variables to store FilePath String for Data Files
    public static final String CUSTOMERS_FILE_PATH = "src\\DataFiles\\CustomersData.txt";
    public static final String INSURANCE_CARDS_FILE_PATH = "src\\DataFiles\\InsuranceCardsData.txt";

    public static final String CLAIMS_FILE_PATH = "src\\DataFiles\\ClaimsData.txt";

    //create files object to store filePath
    private static File customersFile = new File(CUSTOMERS_FILE_PATH);
    private static File insuranceCardsFile = new File(INSURANCE_CARDS_FILE_PATH);
    private static File claimsFile = new File(CLAIMS_FILE_PATH);
    //Create temporary ArrayList to hold File Data, and display to user.
    //Once the user quit the program, these ArrayList would be empty.

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
    private static ArrayList<Claim> claims = new ArrayList<>();

    private static ArrayList<Dependent> dependents = new ArrayList<>();

    private static ArrayList<PolicyHolder> policyHolders = new ArrayList<>();
    //Create DataFileCreator object to create new files for Customers(include both Dependent and Policy Holder), InsuranceCard and Claim.
    //If there exist DataFiles and those DataFiles are not empty => skip the DataFile creation process
    public static DataFileCreator dataFileCreator = new DataFileCreator();
    //Create a DataPopulator object to populate DataFiles with some sample data with specific format if DataFile exist AND DataFile is empty.
    private static DataPopulator dataPopulator = new DataPopulator();

    //Create a DataFileLoader object to populate (load) data from the DataFiles to the temporary ArrayLists.

    private static DataFileLoader dataFileLoader = new DataFileLoader();
    //Create a DataSaver object to save data from temporary ArrayLists to the DataFiles when user quit the program.
    private static DataSaver dataSaver = new DataSaver();

    //Create a welcomingScreen object to display welcoming screen only once when the program start.

    private static WelcomingScreen welcomingScreen = new WelcomingScreen();
    //Create a UserInterface.TextUI object to display menu with options to user.
    private static TextUI textUI = new TextUI();
    // Create 4 methods:
    //1. createNewFile
    //2. populateData
    //3. loadData
    //4. saveData

    /**
     * Method to create new DataFiles  no files ever created or
     */
    public static void createNewEmptyFiles() throws IOException {

        DataFileCreator.createEmptyFile(CUSTOMERS_FILE_PATH);
        DataFileCreator.createEmptyFile(INSURANCE_CARDS_FILE_PATH);
        DataFileCreator.createEmptyFile(CLAIMS_FILE_PATH);
    }

    /**
     * Method to populate data to DataFiles if File exists AND file is empty
     */
    public static void populateDataToEmptyFiles() throws IOException {
    }

    /**
     * Method to load data from file to temporary Collections (ArrayList) that can be shown to user
     */
    private static void loadData() throws IOException {
        customers = DataFileLoader.loadCustomersFromFile(new File(CUSTOMERS_FILE_PATH));
        insuranceCards = DataFileLoader.loadInsuranceCardsFromFile(new File(INSURANCE_CARDS_FILE_PATH));
        claims = DataFileLoader.loadClaimsFromFile(new File(CLAIMS_FILE_PATH));
    }

    /**
     * Method to save and update  data from the temporary ArrayList to DataFiles once the user quit the program.
     */

    private static void saveData() throws IOException {
        DataSaver.saveCustomersToFile(dependents, policyHolders, File(CUSTOMERS_FILE_PATH));
        DataSaver.saveClaimsToFile();
        DataSaver.saveInsuranceCardsToFile();
//        DataFileLoader.saveCustomersToFile(customers, new File(CUSTOMERS_FILE_PATH));
//        dataFileLoader.saveInsuranceCardsToFile(insuranceCards, new File(INSURANCE_CARDS_FILE_PATH));
//        dataFileLoader.saveClaimsToFile(claims, new File(CLAIMS_FILE_PATH));

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            welcomingScreen.displayWelcomeScreen(); //display the welcoming screen only once at start
            createNewEmptyFiles(); //create 3 new DataFiles for Customer, InsuranceCard and Claim if these files are not exist
            //loadData();
            textUI.displayMainMenu(); //display menu of options to users
            //saveData();
        } catch (IOException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }

}
