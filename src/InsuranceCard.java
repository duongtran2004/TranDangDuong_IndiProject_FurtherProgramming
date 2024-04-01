import java.util.Date;

/**
 * The type Insurance card.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:10 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class InsuranceCard {
    private String cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;
    //constructor

    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }
    //constructor with default value, no arguments needed
    public InsuranceCard() {
        this.cardNumber = "default";
        this.cardHolder = "default";
        this.policyOwner = "default";
        this.expirationDate = new Date(2024 - 1900, 0, 1); // January 1, 2024 (Note: Months are 0-based in Date class)
    }

//getters and setters

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    //toString method

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber=" + cardNumber +
                ", cardHolder=" + cardHolder +
                ", policyOwner=" + policyOwner +
                ", expirationDate=" + expirationDate +
                '}';
    }
}


