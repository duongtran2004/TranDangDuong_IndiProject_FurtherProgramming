import java.util.ArrayList;
/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 13-Mar-24 1:10 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public abstract class Customer {
    private String cId;
    private String fullName;
    private String insuranceCard;
    private ArrayList<String> listOfClaims;
    //constructor

    public Customer(String cId, String fullName, String insuranceCard, ArrayList<String> listOfClaims) {
        this.cId = cId;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.listOfClaims = listOfClaims;
    }
    //getters and setters


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(String insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public ArrayList<String> getListOfClaims() {
        return listOfClaims;
    }

    public void setListOfClaims(ArrayList<String> listOfClaims) {
        this.listOfClaims = listOfClaims;
    }
}
