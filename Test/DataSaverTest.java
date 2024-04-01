import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 25-Mar-24 3:41 PM
 * @project IndiProject
 * @since ${11.0.18}
 */import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

class DataSaverTest {
    private static ArrayList<Dependent> dependents = new ArrayList<>();
    private static ArrayList<PolicyHolder> policyHolders = new ArrayList<>();
    private static ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();
    private static ArrayList<Claim> claims = new ArrayList<>();

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    static {
        dependents.add(new Dependent("c-0000001", "Customer 1", "0000000001", new ArrayList<>()));
        dependents.add(new Dependent("c-0000002", "Customer 2", "0000000002", new ArrayList<>()));
        dependents.add(new Dependent("c-0000003", "Customer 3", "0000000003", new ArrayList<>()));
        dependents.add(new Dependent("c-0000004", "Customer 4", "0000000004", new ArrayList<>()));
        dependents.add(new Dependent("c-0000005", "Customer 5", "0000000005", new ArrayList<>()));

        policyHolders.add(new PolicyHolder("c-1001000", "RMIT Vietnam", "2000001000", new ArrayList<Claim>(), new ArrayList<>()));
        policyHolders.add(new PolicyHolder("c-1002000", "FPT", "2000002000", new ArrayList<Claim>(), new ArrayList<>()));
        policyHolders.add(new PolicyHolder("c-1003000", "BUV", "2000003000", new ArrayList<Claim>(), new ArrayList<>()));

        insuranceCards.add(new InsuranceCard("0000000001", "Customer 1", "FPT", parseDate("05-04-2024")));
        insuranceCards.add(new InsuranceCard("0000000002", "Customer 2", "RMIT Vietnam", parseDate("06-04-2024")));
        insuranceCards.add(new InsuranceCard("0000000003", "Customer 3", "FPT", parseDate("07-04-2024")));
        insuranceCards.add(new InsuranceCard("0000000004", "Customer 4", "RMIT Vietnam", parseDate("08-04-2024")));
        insuranceCards.add(new InsuranceCard("0000000005", "Customer 5", "BUV", parseDate("09-04-2024")));

        claims.add(new Claim("f-0000000001", parseDate("22-03-2024"), "Customer 1", "0000000001", parseDate("16-03-2024"),
                new ArrayList<>(Arrays.asList("f-0000000001_0000000001_hospitalBill.pdf", "f-0000000001_0000000001_patientRecord.pdf")),
                100.0, "New", "Vietcombank", "Customer 1", "b-0000000001"));

        claims.add(new Claim("f-0000000002", parseDate("21-03-2024"), "Customer 2", "0000000002", parseDate("14-03-2024"),
                new ArrayList<>(Arrays.asList("f-0000000002_0000000002_hospitalBill.pdf", "f-0000000002_0000000002_patientRecord.pdf")),
                200.0, "Processing", "Techcombank", "Customer 2", "b-0000000002"));

        claims.add(new Claim("f-0000000003", parseDate("20-03-2024"), "Customer 3", "0000000003", parseDate("12-03-2024"),
                new ArrayList<>(Arrays.asList("f-0000000003_0000000003_hospitalBill.pdf", "f-0000000003_0000000003_patientRecord.pdf")),
                300.0, "New", "Vietcombank", "Customer 3", "b-0000000003"));
    }

    File claimsFile = new File(Main.CLAIMS_FILE_PATH);
    File insuranceCardsFile = new File(Main.INSURANCE_CARDS_FILE_PATH);
    File customersFile = new File(Main.CUSTOMERS_FILE_PATH);

    @Test
    public void saveCustomersToFile() throws IOException {
        DataSaver.saveCustomersToFile(dependents, policyHolders, customersFile);
    }

    @Test
    public void saveInsuranceCardsToFile() throws IOException {
        DataSaver.saveInsuranceCardsToFile(insuranceCards, insuranceCardsFile);
    }

    @Test
    public void saveClaimsToFile() throws IOException {
        DataSaver.saveClaimsToFile(claims, claimsFile);
    }
}
