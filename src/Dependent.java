import java.util.ArrayList;

/**
 * The type Dependent.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 1:59 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class Dependent  extends Customer{
    /**
     * Instantiates a new Dependent.
     *
     * @param cId           the customer's id (c-numbers format)
     * @param fullName      the customer's full name
     * @param insuranceCard the insurance card
     * @param listOfClaims  the list of claims
     */
    public Dependent(String cId, String fullName, String insuranceCard, ArrayList<String> listOfClaims) {
        super(cId, fullName, insuranceCard, listOfClaims);
    }
}
