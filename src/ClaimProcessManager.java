import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The interface Claim process manager.
 */
public interface ClaimProcessManager {


    /**
     * Add claim.
     *
     * @param claimId         the claim id
     * @param claimDate       the claim date
     * @param insuredPerson   the insured person
     * @param cardNumber      the card number
     * @param examDate        the exam date
     * @param claimAmount     the claim amount
     * @param status          the status
     * @param bankName        the bank name
     * @param accountOwner    the account owner
     * @param accountNumber   the account number
     * @param listOfDocuments the list of documents
     * @throws IOException the io exception
     */
    void addClaim(String claimId, Date claimDate, String insuredPerson, String cardNumber, Date examDate,  double claimAmount, String status, String bankName, String accountOwner, String accountNumber,ArrayList<String> listOfDocuments) throws IOException;

    /**
     * Update claim.
     *
     * @param claimIDAsInput the claim
     */

    /**
     * Gets one Claim object.
     *
     * @param claimID the claim id
     * @return the one
     */
    Claim getOneClaimById(String claimID);

    /**
     * Gets all claim in the system.
     *
     * @return the all claim
     */
    void getAllClaims() ;

    /**
     * Update claim by id.
     *
     * @param claimIDAsInput  the claim id as input
     * @param claimDate       the claim date
     * @param insuredPerson   the insured person
     * @param cardNumber      the card number
     * @param examDate        the exam date
     * @param claimAmount     the claim amount
     * @param status          the status
     * @param bankName        the bank name
     * @param accountOwner    the account owner
     * @param accountNumber   the account number
     * @param listOfDocuments the list of documents
     */
    void updateClaimById(String claimIDAsInput, Date claimDate, String insuredPerson, String cardNumber,
                         Date examDate,  double claimAmount, String status,
                         String bankName, String accountOwner, String accountNumber, ArrayList<String> listOfDocuments);

    /**
     * Delete claim.
     *
     * @param claimIDAsInput the claim id as input
     */
    void deleteClaimById(String claimIDAsInput);

    /**
     * Delete all claim in the system.
     */
    void deleteAllClaimInTheSystem();

    /**
     * Update claim status by id.
     *
     * @param claimIDAsInput the claim id as input
     * @param newStatus      the new status
     */
    void updateClaimStatusById(String claimIDAsInput, String newStatus);

    /**
     * Gets claims by status.
     *
     * @param status the status
     * @return the claims by status
     */
    ArrayList<Claim> getClaimsByStatus(String status);





}
