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
    private int cardNumber;
    private Customer cardHolder;
    private PolicyHolder policyOwner;
    private Date expirationDate;
    //constructor

    /**
     * Instantiates a new Insurance card.
     *
     * @param cardNumber     the card number
     * @param cardHolder     the card holder
     * @param policyOwner    the policy owner
     * @param expirationDate the expiration date
     */
    public InsuranceCard(int cardNumber, Customer cardHolder, PolicyHolder policyOwner, Date expirationDate) {
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
    public int getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets card number.
     *
     * @param cardNumber the card number
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets card holder.
     *
     * @return the card holder
     */
    public Customer getCardHolder() {
        return cardHolder;
    }

    /**
     * Sets card holder.
     *
     * @param cardHolder the card holder
     */
    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * Gets policy owner.
     *
     * @return the policy owner
     */
    public PolicyHolder getPolicyOwner() {
        return policyOwner;
    }

    /**
     * Sets policy owner.
     *
     * @param policyOwner the policy owner
     */
    public void setPolicyOwner(PolicyHolder policyOwner) {
        this.policyOwner = policyOwner;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
