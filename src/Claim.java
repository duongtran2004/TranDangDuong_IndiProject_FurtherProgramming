import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type Claim.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:58 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class Claim {
    private String claimID;
    private String claimDate;
    private String insuredPerson;
    private String cardNumber;
    private String examDate;
    private ArrayList<String> listOfDocuments; // Using ArrayList
    private double claimAmount;
    private String status;
    private String bankName;
    private String accountOwner;
    private String accountNumber;
    //constructor


    public Claim(String claimID, String claimDate, String insuredPerson, String cardNumber, String examDate, ArrayList<String> listOfDocuments, double claimAmount, String status, String bankName, String accountOwner, String accountNumber) {
        this.claimID = claimID;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.listOfDocuments = listOfDocuments;
        this.claimAmount = claimAmount;
        this.status = status;
        this.bankName = bankName;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
    }
    //getters and setters


    public String getClaimID() {
        return claimID;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getListOfDocuments() {
        return listOfDocuments;
    }

    public void setListOfDocuments(ArrayList<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //toString method


    @Override
    public String toString() {
        return "Claim{" +
                "claimID='" + claimID + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson='" + insuredPerson + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + examDate +
                ", listOfDocuments=" + listOfDocuments +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

//    public String getFormattedClaimDate() {
//        // Create a SimpleDateFormat object with desired date format
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        // Format the claimDate
//        return sdf.format(claimDate);
//    }
}