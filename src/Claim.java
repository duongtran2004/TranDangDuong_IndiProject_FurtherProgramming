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

    private double claimAmount;
    private String status;
    private String bankName;
    private String accountOwner;
    private String accountNumber;
    private ArrayList<String> listOfDocuments;
    //constructor

    /**
     * Instantiates a new Claim with all arguments.
     *
     * @param claimID         the claim id
     * @param claimDate       the claim date
     * @param insuredPerson   the insured person
     * @param cardNumber      the card number
     * @param examDate        the exam date
     * @param claimAmount     the claim amount
     * @param status          the status
     * @param bankName        the bank name
     * @param accountOwner    the account owner
     * @param accountNumber   the account number
     * @param listOfDocuments the list of documents
     */
// Constructor with default values for partial arguments
    public Claim(String claimID, Date claimDate, String insuredPerson, String cardNumber, Date examDate,
                  double claimAmount, String status, String bankName,
                 String accountOwner, String accountNumber, ArrayList<String> listOfDocuments) {
        this.claimID = (claimID != null && !claimID.isEmpty()) ? claimID : "f-1111111111";
        this.claimDate = (claimDate != null) ? claimDate : new Date(2024 - 1900, 0, 1);
        this.insuredPerson = (insuredPerson != null && !insuredPerson.isEmpty()) ? insuredPerson : "default";
        this.cardNumber = (cardNumber != null && !cardNumber.isEmpty()) ? cardNumber : "1111111111";
        this.examDate = (examDate != null) ? examDate : new Date(2024 - 1900, 0, 1);

        this.claimAmount = claimAmount; // No default value for claimAmount, it's a double
        this.status = (status != null && !status.isEmpty()) ? status : "New";
        this.bankName = (bankName != null && !bankName.isEmpty()) ? bankName : "default";
        this.accountOwner = (accountOwner != null && !accountOwner.isEmpty()) ? accountOwner : "default";
        this.accountNumber = (accountNumber != null && !accountNumber.isEmpty()) ? accountNumber : "1111111111";
        this.listOfDocuments = (listOfDocuments != null) ? listOfDocuments : new ArrayList<>();
    }

    /**
     * Instantiates a new Claim with default value
     */
//constructor with default value, no arguments needed
    public Claim() {
        //generate random unique claimID
        String newClaimID = IdManager.generateClaimID();
        this.claimID = newClaimID;
        this.claimDate = new Date(2024 - 1900, 0, 1); // January 1, 2024 (Note: Months are 0-based in Date class)
        this.insuredPerson = "default";
        this.cardNumber = "1111111";
        this.examDate = new Date(2024 - 1900, 0, 1); // January 1, 2024

        this.claimAmount = 0.0; // Default claim amount
        this.status = "New";
        this.bankName = "default";
        this.accountOwner = "default";
        this.accountNumber = "11111111";
        this.listOfDocuments = new ArrayList<>(); // Default empty list of documents
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

   //do not allow user to set/change claimID

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