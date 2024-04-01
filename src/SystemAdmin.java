import java.util.ArrayList;
import java.util.Date;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 26-Mar-24 8:58 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class SystemAdmin implements ClaimProcessManager {
    //override methods from ClaimProcessManager Interface


    @Override
    public void addClaim(Date claimDate, String insuredPerson, String cardNumber, Date examDate, ArrayList<String> listOfDocuments, double claimAmount, String status, String bankName, String accountOwner, String accountNumber) {
        //do not allow user to set claimID, so remove the claimID from the parameter
        //generate random unique claimID
        String newClaimID = ClaimIdManager.generateClaimID();
        //create new claim Object to store the random claimID anb user's input as attributes
        Claim claim = new Claim(newClaimID, claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, claimAmount, status, bankName, accountOwner, accountNumber);
        // Add the new claim to the temporary ArrayList
        Main.claimsTemporaryArrayList.add(claim);
        //print the message if success
        System.out.println("Claim added successfully");
    }

    //method overloading  for user to just add claim without any arguments (pass default values)
    public void addClaim() {
        //do not allow user to set claimID, so remove the claimID from the parameter
        //generate random unique claimID
        String newClaimID = ClaimIdManager.generateClaimID();
        //create new claim Object to store the random claimID anb user's input as attributes
        Claim claim = new Claim();
        // Add the new claim to the temporary ArrayList
        Main.claimsTemporaryArrayList.add(claim);
        //print the message if success
        System.out.println("Claim added successfully");
    }
    @Override
    public Claim getOneClaimById(String claimIDAsInput) {
        // Iterate through the temporary claims list
        //Implement getClaim By Id first, then recall it here
        for (Claim c : Main.claimsTemporaryArrayList) {
            // Check if the claim ID matches the input claim ID
            if (c.getClaimID().equals(claimIDAsInput)) {
                System.out.println("Success to find claim by claimID");
                System.out.println("The claim with id " + claimIDAsInput + "is: ");
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
        for (Claim claim : Main.claimsTemporaryArrayList
        ) {
            System.out.println(claim);
        }

    }

    @Override
    public void updateClaimById(String claimIDAsInput, Date claimDate, String insuredPerson, String cardNumber,
                                Date examDate, ArrayList<String> listOfDocuments, double claimAmount, String status,
                                String bankName, String accountOwner, String accountNumber) {

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
            Main.claimsTemporaryArrayList.remove(claimToDelete);
            // Print a message to indicate that the claim was updated
            System.out.println("Claim with ID " + claimIDAsInput + " has been deleted.");
        } else {
            //exception handling, return error message
            System.out.println("ClaimId not found, please try another claimID !");
        }
    }

    @Override
    public void deleteAllClaimInTheSystem() {
        if (Main.claimsTemporaryArrayList.isEmpty()){
            System.out.println("The systems already having 0 claims");
        }
        else {
            Main.claimsTemporaryArrayList.removeAll(Main.claimsTemporaryArrayList);
            System.out.println("Success to empty all claims from the system !");
        }
    }


}
