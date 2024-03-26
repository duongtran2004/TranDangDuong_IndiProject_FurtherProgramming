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
    private ArrayList<String> listOfDocuments;
    private double claimAmount;
    private String status;
    private String bankName;
    private String accountOwner;
    private String accountNumber;
    //constructor


    /**
     * Instantiates a new Claim.
     *
     * @param claimID         the claim id
     * @param claimDate       the claim date
     * @param insuredPerson   the insured person
     * @param cardNumber      the card number
     * @param examDate        the exam date
     * @param listOfDocuments the list of documents
     * @param claimAmount     the claim amount
     * @param status          the status
     * @param bankName        the bank name
     * @param accountOwner    the account owner
     * @param accountNumber   the account number
     */
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


    /**
     * Gets claim id.
     *
     * @return the claim id
     */
    public String getClaimID() {
        return claimID;
    }

    /**
     * Sets claim id.
     *
     * @param claimID the claim id
     */
    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    /**
     * Gets claim date.
     *
     * @return the claim date
     */
    public String getClaimDate() {
        return claimDate;
    }

    /**
     * Sets claim date.
     *
     * @param claimDate the claim date
     */
    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    /**
     * Gets insured person.
     *
     * @return the insured person
     */
    public String getInsuredPerson() {
        return insuredPerson;
    }

    /**
     * Sets insured person.
     *
     * @param insuredPerson the insured person
     */
    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    /**
     * Gets card number.
     *
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets card number.
     *
     * @param cardNumber the card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets exam date.
     *
     * @return the exam date
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * Sets exam date.
     *
     * @param examDate the exam date
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    /**
     * Gets list of documents.
     *
     * @return the list of documents
     */
    public ArrayList<String> getListOfDocuments() {
        return listOfDocuments;
    }

    /**
     * Sets list of documents.
     *
     * @param listOfDocuments the list of documents
     */
    public void setListOfDocuments(ArrayList<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    /**
     * Gets claim amount.
     *
     * @return the claim amount
     */
    public double getClaimAmount() {
        return claimAmount;
    }

    /**
     * Sets claim amount.
     *
     * @param claimAmount the claim amount
     */
    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets bank name.
     *
     * @return the bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets bank name.
     *
     * @param bankName the bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Gets account owner.
     *
     * @return the account owner
     */
    public String getAccountOwner() {
        return accountOwner;
    }

    /**
     * Sets account owner.
     *
     * @param accountOwner the account owner
     */
    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    /**
     * Gets account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets account number.
     *
     * @param accountNumber the account number
     */
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


}