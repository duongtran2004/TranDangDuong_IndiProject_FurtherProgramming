import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type System admin.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 26 -Mar-24 8:58 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class SystemAdmin implements ClaimProcessManager {
    //override methods from ClaimProcessManager Interface


    @Override
    public void addClaim(String claimId, Date claimDate, String insuredPerson, String cardNumber, Date examDate, double claimAmount, String status, String bankName, String accountOwner, String accountNumber, ArrayList<String> listOfDocuments) throws IOException {
        //do not allow user to set claimID, so remove the claimID from the parameter
        //generate random unique claimID
        String newClaimID = IdManager.generateClaimID();
        //create new claim Object to store the random claimID anb user's input as attributes
        Claim claim = new Claim(newClaimID, claimDate, insuredPerson, cardNumber, examDate, claimAmount, status, bankName, accountOwner, accountNumber, listOfDocuments);
        // Add the new claim to the temporary ArrayList
        FileIOManager.claimsTemporaryArrayList.add(claim);
        FileIOManager.loadData();
        //print the message if success
        System.out.println("Claim added successfully");
    }

    /**
     * Add claim.
     */
//method overloading  for user to just add claim without any arguments (pass default values)
    public void addClaim() {
        //do not allow user to set claimID, so remove the claimID from the parameter

        //create new claim Object to store the random claimID anb user's input as attributes
        Claim claim = new Claim();
        // Add the new claim to the temporary ArrayList
        FileIOManager.claimsTemporaryArrayList.add(claim);
        //print the message if success
        System.out.println("Claim added successfully");
    }

    @Override
    public Claim getOneClaimById(String claimIDAsInput) {
        // Iterate through the temporary claims list
        //Implement getClaim By Id first, then recall it here
        for (Claim c : FileIOManager.claimsTemporaryArrayList) {
            // Check if the claim ID matches the input claim ID
            if (c.getClaimID().equals(claimIDAsInput)) {
                System.out.println("Success to find claim by claimID");
                System.out.println("The claim with id " + c + "is: ");
                return c;
            }
        }
        //exception handling errors
        //claimID not found
        System.out.println("ClaimId not found, please try another claimID !");
        return null;
    }

    //overload getOne to getClaims by all the attributes, return ArrayList of similar claims if overlapping attributes, else if find only 1, return 1 calim Object
    //get AllClaims from the System
    @Override
    public void getAllClaims() {
        System.out.println("List of all claims");
        for (Claim claim : FileIOManager.claimsTemporaryArrayList
        ) {
            System.out.println(claim);
        }

    }

    @Override
    public void updateClaimById(String claimIDAsInput, Date claimDate, String insuredPerson, String cardNumber,
                                Date examDate, double claimAmount, String status,
                                String bankName, String accountOwner, String accountNumber, ArrayList<String> listOfDocuments) {

        // Variable to store the claim object with the specified claim ID
        Claim claimToUpdate = getOneClaimById(claimIDAsInput);
        if (claimToUpdate != null) {
            // Update claim details if the respective argument is not null
            if (claimDate != null) claimToUpdate.setClaimDate(claimDate);
            if (insuredPerson != null) claimToUpdate.setInsuredPerson(insuredPerson);
            if (cardNumber != null) claimToUpdate.setCardNumber(cardNumber);
            if (examDate != null) claimToUpdate.setExamDate(examDate);
            if (listOfDocuments != null) claimToUpdate.setListOfDocuments(listOfDocuments);
            if (claimAmount != 0) {
                claimToUpdate.setClaimAmount(claimAmount);
            }
            if (status != null) claimToUpdate.setStatus(status);
            if (bankName != null) claimToUpdate.setBankName(bankName);
            if (accountOwner != null) claimToUpdate.setAccountOwner(accountOwner);
            if (accountNumber != null) claimToUpdate.setAccountNumber(accountNumber);
            // Print a message to indicate that the claim was updated
            System.out.println("Claim with ID " + claimIDAsInput + " has been updated.");
        } else {
            //exception handling, return error message
            System.out.println("ClaimId not found, please try another claimID !");
        }

    }

    @Override
    public void deleteClaimById(String claimIDAsInput) {
        // Variable to store the claim object with the specified claim ID
        Claim claimToDelete = getOneClaimById(claimIDAsInput);
        if (claimToDelete != null) {
            // Remove the claim from the list of claims
            FileIOManager.claimsTemporaryArrayList.remove(claimToDelete);
            // Print a message to indicate that the claim was updated
            System.out.println("Claim with ID " + claimIDAsInput + " has been deleted.");
        } else {
            //exception handling, return error message
            System.out.println("ClaimId not found, please try another claimID !");
        }
    }

    @Override
    public void deleteAllClaimInTheSystem() {
        if (FileIOManager.claimsTemporaryArrayList.isEmpty()) {
            System.out.println("The systems already having 0 claims");
        } else {
            FileIOManager.claimsTemporaryArrayList.clear();
            System.out.println("Success to empty all claims from the system !");
        }
    }

    @Override
    public void updateClaimStatusById(String claimIDAsInput, String newStatus) {
        // Find the claim by ID
        Claim claimToUpdate = getOneClaimById(claimIDAsInput);

        if (claimToUpdate != null) {
            // Update the status of the claim
            claimToUpdate.setStatus(newStatus);
            System.out.println("Claim with ID " + claimIDAsInput + " has been updated with new status: " + newStatus);
        } else {
            System.out.println("ClaimId not found, please try another claimID !");
        }
    }

    @Override
    public ArrayList<Claim> getClaimsByStatus(String status) {
        ArrayList<Claim> claimsWithStatus = new ArrayList<>();

        for (Claim claim : FileIOManager.claimsTemporaryArrayList) {
            if (claim.getStatus().equalsIgnoreCase(status)) {
                claimsWithStatus.add(claim);
            }
        }

        if (claimsWithStatus.isEmpty()) {
            System.out.println("No claims found with status: " + status);
        }

        return claimsWithStatus;
    }


}
