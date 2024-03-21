import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * The interface Claim process manager.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:58 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public interface ClaimProcessManager {

    /**
     * Add Claims Objects.
     *
     * @param claim the Claim
     */
    void add(Claim claim);

    /**
     * Update Claims Objects.
     *
     * @param claim the Claim
     */
    void update(Claim claim );

    /**
     * Delete Claims Objects by ID.
     *
     * @param claimID the id
     */
    void delete(String claimID);

    /**
     * Gets one Claims Object by ID.
     *
     * @param claimID the id
     * @return the one claim with the correspond ID
     */
    Claim getOne(String claimID);

    /**
     * Gets all Claims Objects.
     *
     * @return the ArrayList of Claims
     */
    ArrayList<Claim> getAll();

}
