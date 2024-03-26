/**
 * The interface Claim process manager.
 */
public interface ClaimProcessManager {

    /**
     * Add claim.
     *
     * @param claim the claim
     */
    void addClaim(Claim claim);

    /**
     * Update claim.
     *
     * @param claim the claim
     */
    void updateClaim(Claim claim );

    /**
     * Delete claim.
     *
     * @param claim the claim
     */
    void deleteClaim(Claim claim);

    /**
     * Gets one.
     *
     * @param claimID the claim id
     * @return the one
     */
    Claim getOne(String claimID);

    /**
     * Gets all.
     *
     * @return the all
     */
     void getAllClaims() ;




}
