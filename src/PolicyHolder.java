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
    private ArrayList<Dependent> listOfDependents;

    // Constructor with default values for partial arguments
    public PolicyHolder(String cId, String fullName, String insuranceCard, ArrayList<Claim> listOfClaims, ArrayList<Dependent> listOfDependents) {
        super(cId, fullName, insuranceCard, listOfClaims);
        this.listOfDependents = (listOfDependents != null) ? listOfDependents : new ArrayList<>();
    }

    // Constructor with default value, no arguments needed
    public PolicyHolder() {
        super("default", "default", "default", new ArrayList<>());
        this.listOfDependents = new ArrayList<>();
    }
    //getter and setters


    public ArrayList<Dependent> getListOfDependents() {
        return listOfDependents;
    }
    public void setListOfDependents(ArrayList<Dependent> listOfDependents) {
        this.listOfDependents = listOfDependents;
    }
    //toString method

    @Override
    public String toString() {
        return "PolicyHolder{" +
                "listOfDependents=" + listOfDependents +
                '}';
    }




}

