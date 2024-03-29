import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 25-Mar-24 3:41 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
class DataSaverTest {
    //create some sample ArrayLists

    private static ArrayList<Dependent> dependents = new ArrayList<>();
    private static ArrayList<PolicyHolder> policyHolders = new ArrayList<>();

    private static ArrayList<InsuranceCard> insuranceCards = new ArrayList<>();

    private static ArrayList<Claim> claims = new ArrayList<>();


    //add some data for testing


    // Static initializer block to populate the ArrayLists
    static {
        // Adding objects of Dependent
        dependents.add(new Dependent("c-0000001", "Customer 1", "0000000001", new ArrayList<>()));
        dependents.add(new Dependent("c-0000002", "Customer 2", "0000000002", new ArrayList<>()));
        dependents.add(new Dependent("c-0000003", "Customer 3", "0000000003", new ArrayList<>()));
        dependents.add(new Dependent("c-0000004", "Customer 4", "0000000004", new ArrayList<>()));
        dependents.add(new Dependent("c-0000005", "Customer 5", "0000000005", new ArrayList<>()));

        //Adding object of PolicyHolder

        policyHolders.add(new PolicyHolder("c-1001000", "RMIT Vietnam", "2000001000", new ArrayList<Claim>() , new ArrayList<Dependent>()));
        policyHolders.add(new PolicyHolder("c-1002000", "FPT", "2000002000", new ArrayList<Claim>(), new ArrayList<Dependent>()));
        policyHolders.add(new PolicyHolder("c-1003000", "BUV", "2000003000", new ArrayList<Claim>(), new ArrayList<Dependent>()));

        // Adding objects of InsuranceCard
        insuranceCards.add(new InsuranceCard("0000000001", "Customer 1", "FPT", "05-04-2024"));
        insuranceCards.add(new InsuranceCard("0000000002", "Customer 2", "RMIT Vietnam", "06-04-2024"));
        insuranceCards.add(new InsuranceCard("0000000003", "Customer 3", "FPT", "07-04-2024"));
        insuranceCards.add(new InsuranceCard("0000000004", "Customer 4", "RMIT Vietnam", "08-04-2024"));
        insuranceCards.add(new InsuranceCard("0000000005", "Customer 5", "BUV", "09-04-2024"));

        //Adding objects of Claim
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        claims.add(new Claim("f-0000000001", "22-03-2024", "Customer 1", "0000000001", "16-03-2024",
                new ArrayList<>(Arrays.asList("f-0000000001_0000000001_hospitalBill.pdf", "f-0000000001_0000000001_patientRecord.pdf")),
                100.0, "New", "Vietcombank", "Customer 1", "b-0000000001"));

        claims.add(new Claim("f-0000000002", "21-03-2024", "Customer 2", "0000000002", "14-03-2024",
                new ArrayList<>(Arrays.asList("f-0000000002_0000000002_hospitalBill.pdf", "f-0000000002_0000000002_patientRecord.pdf")),
                200.0, "Processing", "Techcombank", "Customer 2", "b-0000000002"));

        claims.add(new Claim("f-0000000003", "20-03-2024", "Customer 3", "0000000003", "12-03-2024",
                new ArrayList<>(Arrays.asList("f-0000000003_0000000003_hospitalBill.pdf", "f-0000000003_0000000003_patientRecord.pdf")),
                300.0, "New", "Vietcombank", "Customer 3", "b-0000000003"));
    }
    //create files objects with correct file path
    File claimsFile = new File(Main.CLAIMS_FILE_PATH);
    File insuranceCardsFile = new File(Main.INSURANCE_CARDS_FILE_PATH);
    File customersFile = new File(Main.CUSTOMERS_FILE_PATH);

    //Now comes to testing methods. Empty the files before testing.
    @Test
    void saveCustomersToFile() throws IOException {
        DataSaver.saveCustomersToFile(dependents,policyHolders,customersFile);
    }

    @Test
    void saveInsuranceCardsToFile() throws IOException {
        DataSaver.saveInsuranceCardsToFile(insuranceCards,insuranceCardsFile);
    }

    @Test
    void saveClaimsToFile() throws IOException {
        DataSaver.saveClaimsToFile(claims,claimsFile);
    }
}