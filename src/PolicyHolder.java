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
public class PolicyHolder extends Customer {
    private ArrayList<Dependent> listOfDependents;

    /**
     * Instantiates a new Policy holder.
     *
     * @param cId              the c id
     * @param fullName         the full name
     * @param insuranceCard    the insurance card
     * @param listOfClaims     the list of claims
     * @param listOfDependents the list of dependents
     */
// Constructor with default values for partial arguments
    public PolicyHolder(String cId, String fullName, String insuranceCard, ArrayList<Claim> listOfClaims, ArrayList<Dependent> listOfDependents) {
        super(cId, fullName, insuranceCard, listOfClaims);
        this.listOfDependents = (listOfDependents != null) ? listOfDependents : new ArrayList<>();
    }

    /**
     * Instantiates a new Policy holder.
     */
// Constructor with default value, no arguments needed
    public PolicyHolder() {
        super("default", "default", "default", new ArrayList<>());
        this.listOfDependents = new ArrayList<>();
    }
    //getter and setters


    /**
     * Gets list of dependents.
     *
     * @return the list of dependents
     */
    public ArrayList<Dependent> getListOfDependents() {
        return listOfDependents;
    }

    /**
     * Sets list of dependents.
     *
     * @param listOfDependents the list of dependents
     */
    public void setListOfDependents(ArrayList<Dependent> listOfDependents) {
        this.listOfDependents = listOfDependents;
    }
    //toString method


    @Override
    public String toString() {
        return "PolicyHolder{" +
                "cId='" + super.getcId() + '\'' +
                ", fullName='" + super.getFullName() + '\'' +
                ", insuranceCard='" + super.getInsuranceCard() + '\'' +
                ", listOfClaims=" + super.getListOfClaims() + '\'' +
                ", listOfDependents=" + listOfDependents + '\'' +
                '}';
    }
}

