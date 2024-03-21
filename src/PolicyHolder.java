import java.util.ArrayList;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 13-Mar-24 1:57 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class PolicyHolder  extends  Customer{
    private ArrayList<Dependent> listOfDependents;

    public PolicyHolder(String cId, String fullName, String insuranceCard, ArrayList<String> listOfClaims, ArrayList<Dependent> listOfDependents) {
        super(cId, fullName, insuranceCard, listOfClaims);
        this.listOfDependents = listOfDependents;
    }
}
