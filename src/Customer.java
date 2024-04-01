import java.util.ArrayList;

/**
 * The type Customer.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:10 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public abstract class Customer  {
    private String cId;
    private String fullName;
    private String insuranceCard;
    private ArrayList<Claim> listOfClaims;
    //constructor
    // Constructor with default values for partial arguments
    public Customer(String cId, String fullName, String insuranceCard, ArrayList<Claim> listOfClaims) {
        this.cId = (cId != null && !cId.isEmpty()) ? cId : "default";
        this.fullName = (fullName != null && !fullName.isEmpty()) ? fullName : "default";
        this.insuranceCard = (insuranceCard != null && !insuranceCard.isEmpty()) ? insuranceCard : "default";
        this.listOfClaims = (listOfClaims != null) ? listOfClaims : new ArrayList<>();
    }


    // Constructor with default value, no arguments needed
    public Customer() {
        this.cId = "default";
        this.fullName = "default";
        this.insuranceCard = "default";
        this.listOfClaims = new ArrayList<>();
    }
    //getters and setters

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getcId() {
        return cId;
    }

    /**
     * Sets id.
     *
     * @param cId the c id
     */
    public void setcId(String cId) {
        this.cId = cId;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets insurance card.
     *
     * @return the insurance card
     */
    public String getInsuranceCard() {
        return insuranceCard;
    }

    /**
     * Sets insurance card.
     *
     * @param insuranceCard the insurance card
     */
    public void setInsuranceCard(String insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    /**
     * Gets list of claims.
     *
     * @return the list of claims
     */
    public ArrayList<Claim> getListOfClaims() {
        return listOfClaims;
    }

    /**
     * Sets list of claims.
     *
     * @param listOfClaims the list of claims
     */
    public void setListOfClaims(ArrayList<Claim> listOfClaims) {
        this.listOfClaims = listOfClaims;
    }


    //toString method

    @Override
    public String toString() {
        return "Customer{" +
                "cId='" + cId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard='" + insuranceCard + '\'' +
                ", listOfClaims=" + listOfClaims +
                '}';
    }
}


