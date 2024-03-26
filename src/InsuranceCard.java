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
    private String expirationDate;
    //constructor

    /**
     * Instantiates a new Insurance card.
     *
     * @param cardNumber     the card number
     * @param cardHolder     the card holder
     * @param policyOwner    the policy owner
     * @param expirationDate the expiration date
     */
    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

//getters and setters

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
     * Gets card holder.
     *
     * @return the card holder
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * Sets card holder.
     *
     * @param cardHolder the card holder
     */
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * Gets policy owner.
     *
     * @return the policy owner
     */
    public String getPolicyOwner() {
        return policyOwner;
    }

    /**
     * Sets policy owner.
     *
     * @param policyOwner the policy owner
     */
    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(String expirationDate) {
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


