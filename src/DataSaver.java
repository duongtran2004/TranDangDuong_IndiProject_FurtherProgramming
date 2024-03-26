/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 21-Mar-24 2:33 PM
 * @project IndiProject
 * @since ${11.0.18}
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The DataSaver Class
 */
public class DataSaver {
    //Define desired date format dd-MM-yy

   //loop through each element/ object of the ArrayList
    //write them to the file, 1 line each, with comma
    //unit test

    //wrong time format for Claim
    //lacking of time format for InsuranceCard


    /**
     * Save customers objects' information from the temporary ArrayList to the DataFiles, after the user exit the program.
     *
     * @param dependents    the dependents
     * @param policyHolders the policy holders
     * @param customerFile  the DataFile
     * @throws IOException the io exception                     <p> Using PrintWriter is more convenience for immediate flushing,                     like  writing data from file to temporary ArrayList to show to user</p>                     <p>Methods like println(), printf(), and format() can help to write data directly without converting to String</p>
     */
    public static void saveCustomersToFile(ArrayList<Dependent> dependents, ArrayList<PolicyHolder> policyHolders, File customerFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(customerFile))) {
            // Save Dependent Objects' info to file
            for (Dependent dependent : dependents) {
                String listOfClaims = "[" + String.join(", ", dependent.getListOfClaimsById()) + "]";
                writer.println(dependent.getcId() + "," + dependent.getFullName() + "," + dependent.getInsuranceCard() + "," + listOfClaims);
            }
            // Save PolicyHolder Objects' info to file
            for (PolicyHolder policyHolder : policyHolders) {
                String listOfClaims = "[" + String.join(", ", policyHolder.getListOfClaimsById()) + "]";
                String listOfDependents = "[" + String.join(", ", policyHolder.getListOfDependentsByID()) + "]";
                writer.println(policyHolder.getcId() + "," + policyHolder.getFullName() + "," + policyHolder.getInsuranceCard() + "," + listOfClaims + "," + listOfDependents);
            }
            System.out.println("Success to save data to " + customerFile.getName());
        }
    }

    /**
     * Save insuranceCards objects' information from the temporary ArrayList to the DataFiles.
     *
     * @param insuranceCards    the insurance cards
     * @param insuranceCardFile the file
     * @throws IOException the io exception
     */
    public static void saveInsuranceCardsToFile(ArrayList<InsuranceCard> insuranceCards, File insuranceCardFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(insuranceCardFile))) {

            for (InsuranceCard card : insuranceCards) { //loop through each insurance object in the ArrayList
                writer.println(card.getCardNumber() + "," + card.getCardHolder() + "," + card.getPolicyOwner() + "," + card.getExpirationDate()); //format to write 1 line (append not re-write)
            }
            System.out.println("Success to save data to " + insuranceCardFile.getName());
        }
    }

    /**
     * Save Claim objects' information from the temporary ArrayList to the DataFiles.
     *
     * @param claims    the claims
     * @param claimFile the file
     * @throws IOException the io exception
     */
    public static void saveClaimsToFile(ArrayList<Claim> claims, File claimFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(claimFile))) {

            for (Claim claim : claims) { //loop through each claim object in the ArrayList
                String formattedClaimDate = Main.DATE_FORMAT.format(claim.getClaimDate()); // Format the claim date
                String formattedExamDate = Main.DATE_FORMAT.format(claim.getExamDate()); // Format the exam date
                String documents = "[" + String.join(";", claim.getListOfDocuments()) + "]" ; //variable to store documents and add square brackets around the listOfDocuments
                writer.println(claim.getClaimID() + "," + formattedClaimDate+ "," + claim.getInsuredPerson() + "," + claim.getCardNumber() +
                        "," + formattedExamDate + "," + documents + "," + claim.getClaimAmount() + "," + claim.getStatus() +
                        "," + claim.getBankName() + "-" + claim.getAccountOwner() +
                        "-" + claim.getAccountNumber()); //format to write 1 line (append not re-write)
            }
            System.out.println("Success to save data to " + claimFile.getName());
        }
    }
    //remember notification when sucess.
    // Remmber [] to wrap ArrayList even if empty
}
