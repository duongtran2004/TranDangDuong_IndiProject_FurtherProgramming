import java.util.ArrayList;
import java.util.Date;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 13-Mar-24 1:58 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
public class Claim {

    private String fId;
    private Date claimDate;
    private Customer insuredPerson;

    private InsuranceCard cardNumber;
    private Date examDate;
    private ArrayList<String> listOfDocuments;
    private double claimAmount;
    private String status;

    private BankingInfo receiverBankingInfo;

}
