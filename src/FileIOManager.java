import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The  FileIOManager Class (Entry point for the whole program. Please start executing from this file.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:10 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class FileIOManager {

    /**
     * The constant CUSTOMERS_FILE_PATH.
     */
//naming convention for final variable : cap locks + underscore
    //filepath format for Window OS: ..\\..\\..
    //define constant variables to store FilePath String for Data Files
    public static final String CUSTOMERS_FILE_PATH = "src\\DataFiles\\CustomersData.txt";
    /**
     * The constant INSURANCE_CARDS_FILE_PATH.
     */
    public static final String INSURANCE_CARDS_FILE_PATH = "src\\DataFiles\\InsuranceCardsData.txt";

    /**
     * The constant CLAIMS_FILE_PATH.
     */
    public static final String CLAIMS_FILE_PATH = "src\\DataFiles\\ClaimsData.txt";
    /**
     * The constant DATE_FORMAT.
     */
// Define the desired date format object
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");


    /**
     * The constant customerFile.
     */
//create files object to store filePath
    public static File customerFile = new File(CUSTOMERS_FILE_PATH);
    /**
     * The constant insuranceCardsFile.
     */
    public static File insuranceCardsFile = new File(INSURANCE_CARDS_FILE_PATH);
    /**
     * The constant claimFiles.
     */
    public static File claimFiles = new File(CLAIMS_FILE_PATH);
    //Create temporary ArrayList to hold File Data, and display to user.
    //Once the user quit the program, these ArrayList would be empty.


    /**
     * The constant insuranceCardsTemporaryArrayList.
     */
    public static ArrayList<InsuranceCard> insuranceCardsTemporaryArrayList = new ArrayList<>();
    /**
     * The constant claimsTemporaryArrayList.
     */
    public static ArrayList<Claim> claimsTemporaryArrayList = new ArrayList<>();

    /**
     * The constant dependentsTemporaryArrayList.
     */
    public static ArrayList<Dependent> dependentsTemporaryArrayList = new ArrayList<>();

    /**
     * The constant policyHoldersTemporaryArrayList.
     */
    public static ArrayList<PolicyHolder> policyHoldersTemporaryArrayList = new ArrayList<>();

    // Create 4 methods:
    //1. createNewFile
    //2. populateData
    //3. loadData and empty files
    //4. saveData

    /**
     * Method to create new DataFiles  no files ever created or
     *
     * @throws IOException the io exception
     */
    public static void createNewEmptyFiles() throws IOException {

        DataFileCreator.createEmptyFile(CUSTOMERS_FILE_PATH);
        DataFileCreator.createEmptyFile(INSURANCE_CARDS_FILE_PATH);
        DataFileCreator.createEmptyFile(CLAIMS_FILE_PATH);
    }

    /**
     * Method to populate data to DataFiles if File exists AND file is empty
     *
     * @throws IOException the io exception
     */
    public static void populateDataToEmptyFiles() throws IOException {
        DataPopulator.populateCustomerData(customerFile);
        DataPopulator.populateSampleClaimData(customerFile,claimFiles);
        DataPopulator.populateSampleInsuranceCardData(customerFile, insuranceCardsFile);
        System.out.println("Update CustomerData.txt by adding claims to list of claims");

    }

    /**
     * Method to load data from file to temporary Collections (ArrayList) that can be shown to user
     *
     * @throws IOException the io exception
     */
    public static void loadData() throws IOException {


        claimsTemporaryArrayList = DataFileLoader.loadClaimsFromFile(claimFiles);
        dependentsTemporaryArrayList = DataFileLoader.loadDependentsFromFile(customerFile);
        policyHoldersTemporaryArrayList = DataFileLoader.loadPolicyHoldersFromFile(customerFile);
        insuranceCardsTemporaryArrayList = DataFileLoader.loadInsuranceCardsFromFile(insuranceCardsFile);

    }


    /**
     * Method to save and update  data from the temporary ArrayList to DataFiles once the user quit the program.
     *
     * @throws IOException the io exception
     */
    public static void saveData() throws IOException {

        DataSaver.saveCustomersToFile(dependentsTemporaryArrayList, policyHoldersTemporaryArrayList, customerFile);
        DataSaver.saveInsuranceCardsToFile(insuranceCardsTemporaryArrayList, insuranceCardsFile);
        DataSaver.saveClaimsToFile(claimsTemporaryArrayList, claimFiles);
    }


}
