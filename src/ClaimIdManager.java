import java.util.Random;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 01-Apr-24 4:27 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class ClaimIdManager {
    private static final String CLAIM_ID_PREFIX = "f-";
    private static final int CLAIM_ID_LENGTH = 10;
    private static final int MAX_CLAIM_ID = 1000;
    private static final Random random = new Random();


    // Method to generate a unique claim ID from 1 to 1000 (must be difference from existing claimID)
    //Do not allow user to enter claimID themselves
    public static String generateClaimID() {
        String claimID;
        do {
            claimID = CLAIM_ID_PREFIX + String.format("%010d", random.nextInt(MAX_CLAIM_ID) + 1);
        } while (FileIOManager.claimsTemporaryArrayList.contains(claimID));
        return claimID;
    }
}
