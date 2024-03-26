import UserInterface.TextUI;
import UserInterface.WelcomingScreen;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    // Define the desired date format object
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    //create files object to store filePath
    private static  File customerFile = new File(CUSTOMERS_FILE_PATH);
    private static  File insuranceCardsFile = new File(INSURANCE_CARDS_FILE_PATH);
    private static  File claimFiles = new File(CLAIMS_FILE_PATH);
    //Create temporary ArrayList to hold File Data, and display to user.
    //Once the user quit the program, these ArrayList would be empty.


    private static ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
    private static ArrayList<Claim> claims = new ArrayList<>();

    private static ArrayList<Dependent> dependents = new ArrayList<>();

    private static ArrayList<PolicyHolder> policyHolders = new ArrayList<>();

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
        DataPopulator.populateSampleCustomerData(customerFile);
        DataPopulator.populateSampleInsuranceCardData(customerFile,insuranceCardsFile);
        DataPopulator.populateSampleClaimData(customerFile,claimFiles);
    }

    /**
     * Method to load data from file to temporary Collections (ArrayList) that can be shown to user
     */
    private static void loadData() throws IOException {
        //customers = DataFileLoader.loadCustomersFromFile(new File(CUSTOMERS_FILE_PATH));
        //cannot exist general customers
        //need 2 method: load dependents from file AND load policy holde from file

        insuranceCards = DataFileLoader.loadInsuranceCardsFromFile(new File(INSURANCE_CARDS_FILE_PATH));
        claims = DataFileLoader.loadClaimsFromFile(new File(CLAIMS_FILE_PATH));
    }

    /**
     * Method to save and update  data from the temporary ArrayList to DataFiles once the user quit the program.
     */

    private static void saveData() throws IOException {
        DataSaver.saveCustomersToFile(dependents, policyHolders, customerFile);
        DataSaver.saveInsuranceCardsToFile(insuranceCards,insuranceCardsFile);
        DataSaver.saveClaimsToFile(claims,claimFiles);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            WelcomingScreen.displayWelcomeScreen(); //display the welcoming screen only once at start
            createNewEmptyFiles(); //create 3 new DataFiles for Customer, InsuranceCard and Claim if these files are not exist
            populateDataToEmptyFiles();
            loadData();
            TextUI.displayMainMenu(); //display menu of options to users
            saveData();
        } catch (IOException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }

}
