import java.util.ArrayList;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 26-Mar-24 8:58 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class SystemAdmin  implements ClaimProcessManager{
    //override methods from ClaimProcessManager Interface


    @Override
    public void addClaim(Claim claim) {

    }

    @Override
    public void updateClaim(Claim claim) {
//        String claimIDToUpdate = claim.getClaimID(); // Get the claim ID to update
//        // Implement logic to update a claim for the policy holder
//        // For example:
//        for (String c :getListOfClaimsById()) {
//            if (c.get().equals(claim.getClaimID())) {
//                // Update claim details
//                // e.g., c.setClaimDate(claim.getClaimDate());
//                break;
//            }
//        }
    }

    @Override
    public void deleteClaim(Claim claim) {
        // Implement logic to delete a claim for the policy holder
//        // For example:
//        getClaims().removeIf(claim -> claim.getClaimID().equals(claimID));
    }

    @Override
    public Claim getOne(String claimID) {
//        // Implement logic to get a specific claim of the policy holder
//        // For example:
//        for (Claim c : getClaims()) {
//            if (c.getClaimID().equals(claimID)) {
//                return c;
//            }
//        }
        return null; // Claim not found
    }

    @Override
    public ArrayList<Claim> getAll() {
//        // Implement logic to get all claims of the policy holder
//        // For example:
//        return getClaims();
        ArrayList<Claim> hello = new ArrayList<>();
        return hello ;
    }
}
