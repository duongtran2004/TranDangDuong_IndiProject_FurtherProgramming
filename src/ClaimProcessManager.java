import java.awt.image.AreaAveragingScaleFilter;
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

    void add(Claim claim);
    void update(Claim claim);
    void delete(String id);
    Claim getOne(String id);
   ArrayList<Claim> getAll();

}
