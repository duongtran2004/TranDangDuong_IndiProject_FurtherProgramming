/**
 * The Class Banking info.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 2:12 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class BankingInfo {
    private String bankName;
    private String accountOwner;

    private int accountNumber;

    /**
     * Instantiates a new Banking info.
     *
     * @param bankName      the bank name
     * @param accountOwner  the account owner
     * @param accountNumber the account number
     */
//constructor
    public BankingInfo(String bankName, String accountOwner, int accountNumber) {
        this.bankName = bankName;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
    }
    //getter and setter

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
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets account number.
     *
     * @param accountNumber the account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
