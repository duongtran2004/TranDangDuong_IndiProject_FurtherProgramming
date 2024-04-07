import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Data saver.
 */
public class DataSaver {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Save customers to file.
     *
     * @param dependents    the dependents
     * @param policyHolders the policy holders
     * @param customerFile  the customer file
     * @throws IOException the io exception
     */
// Save customers' information to file while skipping duplicates
    public static void saveCustomersToFile(ArrayList<Dependent> dependents, ArrayList<PolicyHolder> policyHolders, File customerFile) throws IOException {
        Set<String> existingLines = readExistingLines(customerFile);

        try (PrintWriter writer = new PrintWriter(new FileWriter(customerFile, true))) {
            for (Dependent dependent : dependents) {
                String listOfClaims = formatList(dependent.getListOfClaims());
                String newLine = dependent.getcId() + "," + dependent.getFullName() + "," + dependent.getInsuranceCard() + "," + listOfClaims;
                if (!existingLines.contains(newLine)) {
                    writer.println(newLine);
                    existingLines.add(newLine); // Add new line to existingLines set
                }
            }
            for (PolicyHolder policyHolder : policyHolders) {
                String listOfClaims = formatList(policyHolder.getListOfClaims());
                String listOfDependents = formatList(policyHolder.getListOfDependents());
                String newLine = policyHolder.getcId() + "," + policyHolder.getFullName() + "," + policyHolder.getInsuranceCard() + "," + listOfClaims + "," + listOfDependents;
                if (!existingLines.contains(newLine)) {
                    writer.println(newLine);
                    existingLines.add(newLine); // Add new line to existingLines set
                }
            }
            System.out.println("Successfully saved data to " + customerFile.getName());
        }
    }

    /**
     * Save insurance cards to file.
     *
     * @param insuranceCards    the insurance cards
     * @param insuranceCardFile the insurance card file
     * @throws IOException the io exception
     */
// Save insurance cards' information to file while skipping duplicates
    public static void saveInsuranceCardsToFile(ArrayList<InsuranceCard> insuranceCards, File insuranceCardFile) throws IOException {
        Set<String> existingLines = readExistingLines(insuranceCardFile);

        try (PrintWriter writer = new PrintWriter(new FileWriter(insuranceCardFile, true))) {
            for (InsuranceCard card : insuranceCards) {
                String formattedExpirationDate = DATE_FORMAT.format(card.getExpirationDate());
                String newLine = card.getCardNumber() + "," + card.getCardHolder() + "," + card.getPolicyOwner() + "," + formattedExpirationDate;
                if (!existingLines.contains(newLine)) {
                    writer.println(newLine);
                    existingLines.add(newLine); // Add new line to existingLines set
                }
            }
            System.out.println("Successfully saved data to " + insuranceCardFile.getName());
        }
    }

    /**
     * Save claims to file.
     *
     * @param claims    the claims
     * @param claimFile the claim file
     * @throws IOException the io exception
     */
// Save claims' information to file while skipping duplicates
    public static void saveClaimsToFile(ArrayList<Claim> claims, File claimFile) throws IOException {
        Set<String> existingLines = readExistingLines(claimFile);

        try (PrintWriter writer = new PrintWriter(new FileWriter(claimFile, false))) {
            for (Claim claim : claims) {
                String formattedClaimDate = DATE_FORMAT.format(claim.getClaimDate());
                String formattedExamDate = DATE_FORMAT.format(claim.getExamDate());
                String documents = "[" + String.join(";", claim.getListOfDocuments()) + "]";
                String newLine = claim.getClaimID() + "," + formattedClaimDate + "," + claim.getInsuredPerson() + "," +
                        claim.getCardNumber() + "," + formattedExamDate + "," + documents + "," + claim.getClaimAmount() +
                        "," + claim.getStatus() + "," + claim.getBankName() + "-" + claim.getAccountOwner() + "-" +
                        claim.getAccountNumber();
                if (!existingLines.contains(newLine)) {
                    writer.println(newLine);
                    existingLines.add(newLine); // Add new line to existingLines set
                }
            }
            System.out.println("Successfully saved data to " + claimFile.getName());
        }
    }

    // Read existing lines from a file and store them in a set
    private static Set<String> readExistingLines(File file) throws IOException {
        Set<String> existingLines = new HashSet<>();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    existingLines.add(line.trim());
                }
            }
        }
        return existingLines;
    }

    // Format list of objects to a string representation
    private static String formatList(ArrayList<?> arrayList) {
        if (arrayList.isEmpty()) {
            return "[]";
        } else {
            ArrayList<String> stringArrayList = new ArrayList<>();
            for (Object item : arrayList) {
                stringArrayList.add(item.toString());
            }
            return "[" + String.join(", ", stringArrayList) + "]";
        }
    }
}
