import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 13-Mar-24 1:10 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class Main {
    private static final String CUSTOMERS_FILE_PATH = "customers.txt";
    private static final String INSURANCE_CARDS_FILE_PATH = "insurance_cards.txt";
    private static final String CLAIMS_FILE_PATH = "claims.txt";

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
    private static ArrayList<Claim> claims = new ArrayList<>();

    private static DataPopulator dataPopulator = new DataPopulator();
    private static TextUI textUI = new TextUI();

    public static void main(String[] args) {
        try {
            loadData();
            textUI.displayMainMenu();
            saveData();
        } catch (IOException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }

    private static void loadData() throws IOException {
        customers = dataPopulator.populateCustomersFromFile(new File(CUSTOMERS_FILE_PATH));
        insuranceCards = dataPopulator.populateInsuranceCardsFromFile(new File(INSURANCE_CARDS_FILE_PATH));
        claims = dataPopulator.populateClaimsFromFile(new File(CLAIMS_FILE_PATH));
    }

    private static void saveData() throws IOException {
        dataPopulator.saveCustomersToFile(customers, new File(CUSTOMERS_FILE_PATH));
        dataPopulator.saveInsuranceCardsToFile(insuranceCards, new File(INSURANCE_CARDS_FILE_PATH));
        dataPopulator.saveClaimsToFile(claims, new File(CLAIMS_FILE_PATH));

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
