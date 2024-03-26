import java.util.ArrayList;

/**
 * The type Policy holder.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:57 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class PolicyHolder  extends  Customer{
    private ArrayList<String> listOfDependentsByID;
    //constructor

    /**
     * Instantiates a new Policy holder.
     *
     * @param cId              the customer's id (c-numbers format)
     * @param fullName         the customer's full name
     * @param insuranceCard    the insurance card
     * @param listOfClaims     the list of claims
     * @param listOfDependentsByID the list of dependents
     */
    public PolicyHolder(String cId, String fullName, String insuranceCard, ArrayList<String> listOfClaims, ArrayList<String> listOfDependentsByID) {
        super(cId, fullName, insuranceCard, listOfClaims);
        this.listOfDependentsByID = listOfDependentsByID;
    }
    //getters and setters

    public ArrayList<String> getListOfDependentsByID() {
        return listOfDependentsByID;
    }

    public void setListOfDependentsByID(ArrayList<String> listOfDependentsByID) {
        this.listOfDependentsByID = listOfDependentsByID;
    }

    @Override
    public void add(Claim claim) {

    }

    @Override
    public void update(Claim claim) {

    }

    @Override
    public void delete(String claimID) {

    }

    @Override
    public Claim getOne(String claimID) {
        return null;
    }

    @Override
    public ArrayList<Claim> getAll() {
        return null;
    }
}
