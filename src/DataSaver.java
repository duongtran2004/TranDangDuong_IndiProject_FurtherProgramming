/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 21-Mar-24 2:33 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataSaver {

    public static void saveCustomersToFile(ArrayList<Dependent> dependents, ArrayList<PolicyHolder> policyHolders, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Dependent dependent : dependents) {
                writer.println(dependent.getcId() + "," + dependent.getFullName() + "," + dependent.getInsuranceCard() + "," + String.join(",", dependent.getListOfClaims()));
            }
            for (PolicyHolder policyHolder : policyHolders) {
                writer.println(policyHolder.getcId() + "," + policyHolder.getFullName() + "," + policyHolder.getInsuranceCard() + "," + String.join(",", policyHolder.getListOfClaims()));
            }
        }
    }

    public static void saveInsuranceCardsToFile(ArrayList<InsuranceCard> insuranceCards, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (InsuranceCard card : insuranceCards) {
                writer.println(card.getCardNumber() + "," + card.getCardHolder() + "," + card.getPolicyOwner() + "," + card.getExpirationDate());
            }
        }
    }

    public static void saveClaimsToFile(ArrayList<Claim> claims, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Claim claim : claims) {
                String documents = String.join(";", claim.getDocuments());
                writer.println(claim.getId() + "," + claim.getClaimDate() + "," + claim.getInsuredPerson() + "," + claim.getCardNumber() +
                        "," + claim.getExamDate() + "," + documents + "," + claim.getClaimAmount() + "," + claim.getStatus() +
                        "," + claim.getReceiverBankingInfo().getBankName() + "-" + claim.getReceiverBankingInfo().getAccountOwner() +
                        "-" + claim.getReceiverBankingInfo().getAccountNumber());
            }
        }
    }
}
