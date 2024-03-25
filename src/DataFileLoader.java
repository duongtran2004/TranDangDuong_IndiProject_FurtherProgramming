import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Step 1: Read through the DataFiles

    //Canot have a common fileReader method as the logic for data generation is different from each file

    /**
     * Populate customers from DataFiles to temporary ArrayList to show to user when the program start.
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     */



    //cannot exist general customers
    //need 2 method: load dependents from file AND load policy holde from file  (all read the same customer file
//    public static ArrayList<Customer> loadCustomersFromFile(File file) throws IOException {
//        ArrayList<Customer> customers = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // Parse the line and create Customer objects
//
//                // Add Customer objects to the customers list
//            }
//        }
//        return customers;
//    }

    /**
     * Populate insurance cards from file to array list.
     *
     * @param insuranceCardFile the file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<InsuranceCard> loadInsuranceCardsFromFile(File insuranceCardFile) throws IOException {
        ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();

        return insuranceCards;
    }

    /**
     * Populate claims from file array list.
     *
     * @param claimFile the file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<Claim> loadClaimsFromFile(File claimFile) throws IOException {
        ArrayList<Claim> claims = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(claimFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(","); // Split the line by comma

                // Assuming each part corresponds to the data in the file
                if (parts.length >= 11) { // Assuming there are 11 parts in each line
                    String claimID = parts[0];
                    Date claimDate = dateFormat.parse(parts[1]) ;
                    String insuredPerson = parts[2];
                    String insuranceCard = parts[3];
                    Date examDate = dateFormat.parse(parts[4]) ;
                    String documents = parts[5]; // This part contains a list of documents
                    ArrayList<String> listOfDocuments = new ArrayList<>(Arrays.asList(parts[6]));
//                    // Split the list of documents by comma and remove square brackets
//                    String[] documentArray = documents.substring(1, documents.length() - 1).split(", ");
//                    ArrayList<String> listOfDocuments = new ArrayList<>(List.of(documentArray));
                    double claimAmount = Double.parseDouble(parts[7]);
                    String status = parts[8];
                    String bankName = parts[9];
                    String accountOwner = parts[10];
                    String accountNumber = parts[11];

                    // Create a Claim object using parsed data
                    Claim claim = new Claim(claimID, claimDate, insuredPerson, insuranceCard, examDate,
                            listOfDocuments, claimAmount, status, bankName, accountOwner, accountNumber);
                    // Add the Claim object to the claims list
                    claims.add(claim);
                } else {
                    // Handle lines with incorrect format, if needed
                    System.err.println("Skipping line with incorrect format: " + line);
                }
            }
            } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return claims;
    }


}