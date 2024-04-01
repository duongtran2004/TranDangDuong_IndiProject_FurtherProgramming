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


    /**
     * Load dependents from file array list.
     *
     * @param customerFile the customer file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<Dependent> loadDependentsFromFile(File customerFile) throws IOException {
        ArrayList<Dependent> dependents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(","); // Split the line by comma

                // Assuming each part corresponds to the data in the file
                if (parts.length <= 5) { // Assuming there are 5 parts for each line of PolicyHolder, so each line of Dependent has less than 5 parts
                    String cId = parts[0];

                    String fullName = parts[1];
                    String insuranceCard = parts[2];
                    //this ArrayList store the Claim object, but currently listOfClaims for dependent is empty
                    ArrayList<Claim> listOfClaims = new ArrayList<Claim>();
                    // Create a Dependent object using parsed data
                    Dependent dependent = new Dependent(cId, fullName, insuranceCard, listOfClaims);
                    // Add the Dependent objects to the Dependent ArrayList
                    dependents.add(dependent);
                }
            }
        }

        return dependents;
    }

    /**
     * Load policy holders from file array list.
     *
     * @param customerFile the customer file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<PolicyHolder> loadPolicyHoldersFromFile(File customerFile) throws IOException {
        ArrayList<PolicyHolder> policyHolders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split the line by comma

                // Assuming each part corresponds to the data in the file
                if (parts.length >= 5) { // Assuming there are 5 parts for each line of PolicyHolder
                    String cId = parts[0];
                    String fullName = parts[1];
                    String insuranceCard = parts[2];

                    // Parse list of claims
                    String[] claimsData = parts[3].split("\\]\\[");
                    ArrayList<Claim> listOfClaims = new ArrayList<>();
                    for (String claimData : claimsData) {
                        // Parse claim data elements
                        String[] claimParts = claimData.split(",");
                        if (claimParts.length >= 11) { // Assuming there are 11 parts for each claim data
                            try {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                Date claimDate = dateFormat.parse(claimParts[1].trim());
                                Date examDate = dateFormat.parse(claimParts[4].trim());
                                // Create a Claim object using parsed data and add it to the list of claims
                                Claim claim = new Claim(claimParts[0], claimDate, claimParts[2], claimParts[3], examDate,
                                        new ArrayList<>(Arrays.asList(claimParts[5].split(" "))), Double.parseDouble(claimParts[6]),
                                        claimParts[7], claimParts[8], claimParts[9], claimParts[10]);
                                listOfClaims.add(claim);
                            } catch (ParseException e) {
                                e.printStackTrace(); // Handle parsing exception as needed
                            }
                        }
                    }

                    // Parse list of dependents
                    String[] dependentsData = parts[4].split("\\]\\[");
                    ArrayList<Dependent> listOfDependents = new ArrayList<>();
                    for (String dependentData : dependentsData) {
                        // Parse dependent data elements
                        String[] dependentParts = dependentData.split(",");
                        if (dependentParts.length >= 3) { // Assuming there are 3 parts for each dependent data
                            // Create a Dependent object using parsed data and add it to the list of dependents
                            Dependent dependent = new Dependent(dependentParts[0], dependentParts[1], dependentParts[2], new ArrayList<>());
                            listOfDependents.add(dependent);
                        }
                    }

                    // Create a PolicyHolder object using parsed data
                    PolicyHolder policyHolder = new PolicyHolder(cId, fullName, insuranceCard, listOfClaims, listOfDependents);
                    // Add the PolicyHolder object to the policyHolders ArrayList
                    policyHolders.add(policyHolder);
                }
            }
        }
        return policyHolders;
    }


    /**
     * Populate insurance cards from file to array list.
     *
     * @param insuranceCardFile the file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<InsuranceCard> loadInsuranceCardsFromFile(File insuranceCardFile) throws IOException {
        ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(insuranceCardFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(","); // Split the line by comma

                // Assuming each part corresponds to the data in the file
                if (parts.length >= 4) { // Assuming there are 4 parts in each line
                    String cardNumber = parts[0];

                    String cardHolder = parts[1];
                    String policyHolder = parts[2];
                    Date expirationDate = (Main.DATE_FORMAT.parse(parts[3]));

                    // Create a InsuranceCard object using parsed data
                    InsuranceCard insuranceCard = new InsuranceCard(cardNumber, cardHolder, policyHolder, expirationDate);

                    // Add the Claim object to the claims list
                    insuranceCards.add(insuranceCard);
                } else {
                    // Handle lines with incorrect format, if needed
                    System.err.println("Skipping line with incorrect format: " + line);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


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
                    Date claimDate = (Main.DATE_FORMAT.parse(parts[1]));
                    String insuredPerson = parts[2];
                    String insuranceCard = parts[3];
                    Date examDate = (Main.DATE_FORMAT.parse(parts[4]));
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