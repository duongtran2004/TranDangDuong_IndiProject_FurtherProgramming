import java.io.*;
import java.util.ArrayList;

/**
 * The type Data populator.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 21 -Mar-24 1:32 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class DataFileLoader {
    /**
     * Populate customers from DataFiles to temporary ArrayList to show to user when the program start.
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<Customer> loadCustomersFromFile(File file) throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and create Customer objects
                
                // Add Customer objects to the customers list
            }
        }
        return customers;
    }

    /**
     * Populate insurance cards from file to array list.
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<InsuranceCard> loadInsuranceCardsFromFile(File file) throws IOException {
        ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and create InsuranceCard objects
                // Add InsuranceCard objects to the insuranceCards list
            }
        }
        return insuranceCards;
    }

    /**
     * Populate claims from file array list.
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     */
    public ArrayList<Claim> loadClaimsFromFile(File file) throws IOException {
        ArrayList<Claim> claims = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and create Claim objects
                // Add Claim objects to the claims list
            }
        }
        return claims;
    }


}