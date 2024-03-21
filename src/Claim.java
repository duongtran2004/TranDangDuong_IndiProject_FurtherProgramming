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
    private ArrayList<String> documents; // Using ArrayList
    private double claimAmount;
    private String status;
    private BankingInfo receiverBankingInfo;
    //constructor

    /**
     * Instantiates a new Claim.
     *
     * @param claimID              the Claim id. Specifically name it claimID to distinguish from Customer's cID.
     * @param claimDate           the claim date
     * @param insuredPerson       the insured person
     * @param cardNumber          the card number
     * @param examDate            the exam date
     * @param documents           the documents
     * @param claimAmount         the claim amount
     * @param status              the status
     * @param receiverBankingInfo the receiver banking info
     */
    public Claim(String claimID, Date claimDate, String insuredPerson, String cardNumber, Date examDate,
                 ArrayList<String> documents, double claimAmount, String status, BankingInfo receiverBankingInfo) {
        this.claimID = claimID;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo; // Assigning receiverBankingInfo
    }

    //getter and setters

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return claimID;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.claimID = id;
    }

    /**
     * Gets claim date.
     *
     * @return the claim date
     */
    public Date getClaimDate() {
        return claimDate;
    }

    /**
     * Sets claim date.
     *
     * @param claimDate the claim date
     */
    public void setClaimDate(Date claimDate) {
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
    public Date getExamDate() {
        return examDate;
    }

    /**
     * Sets exam date.
     *
     * @param examDate the exam date
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * Gets documents.
     *
     * @return the documents
     */
    public ArrayList<String> getDocuments() {
        return documents;
    }

    /**
     * Sets documents.
     *
     * @param documents the documents
     */
    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
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
     * Gets receiver banking info.
     *
     * @return the receiver banking info
     */
    public BankingInfo getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    /**
     * Sets receiver banking info.
     *
     * @param receiverBankingInfo the receiver banking info
     */
    public void setReceiverBankingInfo(BankingInfo receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }
}