import java.util.ArrayList;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 13-Mar-24 1:58 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public interface ClaimProcessManager {

    public void addClaim();
    public void updateClaim();
    public void deleteClaim();
    public ArrayList<Claim> getAllClaim();
    public void deleteClaim(Claim claim);

}
