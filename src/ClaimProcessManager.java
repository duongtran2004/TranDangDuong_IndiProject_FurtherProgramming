import java.util.ArrayList;
import java.util.Date;

/**
 * The interface Claim process manager.
 */
public interface ClaimProcessManager {

    /**
     * Add claim.
     *
     * @param
     * @param claimId
     */


    void addClaim(String claimId, Date claimDate, String insuredPerson, String cardNumber, Date examDate, ArrayList<String> listOfDocuments, double claimAmount, String status, String bankName, String accountOwner, String accountNumber);

    /**
     * Update claim.
     *
     * @param claimIDAsInput the claim
     */

    /**
     * Gets one.
     *
     * @param claimID the claim id
     * @return the one
     */
    Claim getOneClaimById(String claimID);

    /**
     * Gets all.
     *
     * @return the all
     */
    void getAllClaims() ;
    void updateClaimById(String claimIDAsInput, Date claimDate, String insuredPerson, String cardNumber,
                         Date examDate, ArrayList<String> listOfDocuments, double claimAmount, String status,
                         String bankName, String accountOwner, String accountNumber);

    /**
     * Delete claim.
     *
     * @param
     */
    void deleteClaimById(String claimIDAsInput);

    void deleteAllClaimInTheSystem();





}
