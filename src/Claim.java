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
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private ArrayList<String> listOfDocuments;
    private double claimAmount;
    private String status;
    private String bankName;
    private String accountOwner;
    private String accountNumber;
    //constructor

    // Constructor with default values for partial arguments
    public Claim(String claimID, Date claimDate, String insuredPerson, String cardNumber, Date examDate,
                 ArrayList<String> listOfDocuments, double claimAmount, String status, String bankName,
                 String accountOwner, String accountNumber) {
        this.claimID = (claimID != null && !claimID.isEmpty()) ? claimID : "default";
        this.claimDate = (claimDate != null) ? claimDate : new Date(2024 - 1900, 0, 1);
        this.insuredPerson = (insuredPerson != null && !insuredPerson.isEmpty()) ? insuredPerson : "default";
        this.cardNumber = (cardNumber != null && !cardNumber.isEmpty()) ? cardNumber : "default";
        this.examDate = (examDate != null) ? examDate : new Date(2024 - 1900, 0, 1);
        this.listOfDocuments = (listOfDocuments != null) ? listOfDocuments : new ArrayList<>();
        this.claimAmount = claimAmount; // No default value for claimAmount, it's a double
        this.status = (status != null && !status.isEmpty()) ? status : "default";
        this.bankName = (bankName != null && !bankName.isEmpty()) ? bankName : "default";
        this.accountOwner = (accountOwner != null && !accountOwner.isEmpty()) ? accountOwner : "default";
        this.accountNumber = (accountNumber != null && !accountNumber.isEmpty()) ? accountNumber : "default";
    }

    //constructor with default value, no arguments needed
    public Claim() {
        this.claimID = "default";
        this.claimDate = new Date(2024 - 1900, 0, 1); // January 1, 2024 (Note: Months are 0-based in Date class)
        this.insuredPerson = "default";
        this.cardNumber = "default";
        this.examDate = new Date(2024 - 1900, 0, 1); // January 1, 2024
        this.listOfDocuments = new ArrayList<>(); // Default empty list of documents
        this.claimAmount = 0.0; // Default claim amount
        this.status = "default";
        this.bankName = "default";
        this.accountOwner = "default";
        this.accountNumber = "default";
    }



    //getters and setters

    public String getClaimID() {
        return claimID;
    }

   //do not allow user to set/change claimID

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
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

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
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
                ", claimDate=" + FileIOManager.DATE_FORMAT.format(claimDate) + '\'' +
                ", insuredPerson='" + insuredPerson + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + FileIOManager.DATE_FORMAT.format(examDate) + '\'' +
                ", listOfDocuments=" + listOfDocuments +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}