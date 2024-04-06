import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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
        FileIOManager.dependentsTemporaryArrayList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(","); // Split the line by comma

                // Assuming each part corresponds to the data in the file
                if (parts.length < 5) { // Assuming there are 5 parts for each line of PolicyHolder, so each line of Dependent has less than 5 parts
                    String cId = parts[0];

                    String fullName = parts[1];
                    String insuranceCard = parts[2];
                    //this ArrayList store the Claim object, but currently listOfClaims for dependent is empty
                    ArrayList<Claim> listOfClaims = new ArrayList<Claim>();
                    // Create a Dependent object using parsed data
                    Dependent dependent = new Dependent(cId, fullName, insuranceCard, listOfClaims);
                    // Add the  object to the temporary ArrayList
                    FileIOManager.dependentsTemporaryArrayList.add(dependent);

                }
            }
        }
        System.out.println("Successfully load data from files to objects of Dependents Temporary ArrayList ");

        return FileIOManager.dependentsTemporaryArrayList;
    }

    /**
     * Load policy holders from file array list.
     *
     * @param customerFile the customer file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<PolicyHolder> loadPolicyHoldersFromFile(File customerFile) throws IOException {
        FileIOManager.policyHoldersTemporaryArrayList.clear();

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
                                String claimId = claimParts[0];
                                Date claimDate = dateFormat.parse(claimParts[1].trim());
                                String insuredPerson = claimParts[2];
                                String cardNumber = claimParts[3];
                                Date examDate = dateFormat.parse(claimParts[4].trim());
                                Double claimAmount = Double.valueOf(claimParts[5]);
                                String status = claimParts[6];
                                String bankName = claimParts[7];
                                String accountOwner = claimParts[8];
                                String accountNumber = claimParts[9];
                                String listOfDocumentString = claimParts[10];
                                //convert listOfDocumentString from String to ArrayList<String>
                                String[] listOfDocumentsArray = listOfDocumentString.split(",");
                                //create ArrayList of document list
                                ArrayList<String> listOfDocuments = new ArrayList<>();
                                //add all element from String[] to ArrayList<String>
                                for (String documents : listOfDocumentsArray
                                ) {
                                    listOfDocuments.add(documents);

                                }

                                // Create a Claim object using parsed data and add it to the list of claims
                                Claim claim = new Claim(claimId, claimDate, insuredPerson, cardNumber, examDate, claimAmount, status, bankName, accountOwner, accountNumber, listOfDocuments);
                                //add claim object to listOPfClaims
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

                    // Create a PolicyHolder object using parsed data // co van de
                    PolicyHolder policyHolder = new PolicyHolder(cId, fullName, insuranceCard, listOfClaims, listOfDependents);
                    System.out.println("The policy holder is :");
                    System.out.println(policyHolder);
                    // Add the  object to the temporary ArrayList
                    FileIOManager.policyHoldersTemporaryArrayList.add(policyHolder);
                }
            }
        }
        System.out.println("Successfully load data from files to objects of Policy Holders Temporary ArrayList ");

        return FileIOManager.policyHoldersTemporaryArrayList;
    }


    /**
     * Populate insurance cards from file to array list.
     *
     * @param insuranceCardFile the file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<InsuranceCard> loadInsuranceCardsFromFile(File insuranceCardFile) throws IOException {
       FileIOManager.insuranceCardsTemporaryArrayList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(insuranceCardFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(","); // Split the line by comma

                // Assuming each part corresponds to the data in the file
                if (parts.length >= 4) { // Assuming there are 4 parts in each line
                    String cardNumber = parts[0];

                    String cardHolder = parts[1];
                    String policyHolder = parts[2];
                    Date expirationDate = null;
                    try {
                        expirationDate = FileIOManager.DATE_FORMAT.parse(parts[3]); // Parse the expiration date
                    } catch (ParseException e) {
                        // Handle invalid date format
                        System.err.println("Error parsing expiration date for line: " + line);
                        continue; // Skip to the next line
                    }

                    // Create a InsuranceCard object using parsed data
                    InsuranceCard insuranceCard = new InsuranceCard(cardNumber, cardHolder, policyHolder, expirationDate);

                    // Add the  object to the temporary ArrayList
                   FileIOManager.insuranceCardsTemporaryArrayList.add(insuranceCard);
                }
            }
        }


        System.out.println("Successfully load data from files to objects of Insurance Cards Temporary ArrayList ");

        return FileIOManager.insuranceCardsTemporaryArrayList;
    }

    /**
     * Populate claims from file array list.
     *
     * @param claimFile the file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<Claim> loadClaimsFromFile(File claimFile) throws IOException {
        FileIOManager.claimsTemporaryArrayList.clear(); // Clear the list before use
        try (BufferedReader reader = new BufferedReader(new FileReader(claimFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] claimParts = line.split(","); // Split the line by comma
                // Assuming each part corresponds to the data in the file
                if (claimParts.length >= 11) { // Assuming there are 11 parts for each claim data
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String claimId = claimParts[0];
                        Date claimDate = dateFormat.parse(claimParts[1].trim());
                        String insuredPerson = claimParts[2];
                        String cardNumber = claimParts[3];
                        Date examDate = dateFormat.parse(claimParts[4].trim());
                        Double claimAmount = Double.valueOf(claimParts[5]);
                        String status = claimParts[6];
                        String bankName = claimParts[7];
                        String accountOwner = claimParts[8];
                        String accountNumber = claimParts[9];
                        String listOfDocumentString = claimParts[10];
                        //convert listOfDocumentString from String to ArrayList<String>
                        String[] listOfDocumentsArray = listOfDocumentString.split(",");
                        //create ArrayList of document list
                        ArrayList<String> listOfDocuments = new ArrayList<>();
                        //add all element from String[] to ArrayList<String>
                        for (String documents : listOfDocumentsArray
                        ) {
                            listOfDocuments.add(documents);
                        }

                        // Create a Claim object using parsed data and add it to the list of claims
                        Claim claim = new Claim(claimId, claimDate, insuredPerson, cardNumber, examDate, claimAmount, status, bankName, accountOwner, accountNumber, listOfDocuments);
                        // Add the Claim object to the claims temporary Array list
                        FileIOManager.claimsTemporaryArrayList.add(claim);
                    } catch (ParseException e) {
                        e.printStackTrace(); // Handle parsing exception as needed
                    }
                }

            }
        }
        System.out.println("Successfully load data from files to objects of Claims Temporary ArrayList ");
        return FileIOManager.claimsTemporaryArrayList;
    }
}








