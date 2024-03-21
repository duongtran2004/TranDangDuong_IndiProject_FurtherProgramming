/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 13-Mar-24 2:12 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class BankingInfo {
    private String bankName;
    private String accountOwner;

    private int accountNumber;
//constructor
    public BankingInfo(String bankName, String accountOwner, int accountNumber) {
        this.bankName = bankName;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
    }
    //getter and setter

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

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
