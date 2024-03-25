import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 25-Mar-24 2:31 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
class DataFileLoaderTest {
    //create files objects with correct file path
    File claimsFile = new File(Main.CLAIMS_FILE_PATH);
    File insuranceCardsFile = new File(Main.INSURANCE_CARDS_FILE_PATH);
    File customersFile = new File(Main.CUSTOMERS_FILE_PATH);
    //@Test
    void testLoadClaimsFromFile() throws IOException {


        // Call the method to be tested
        ArrayList<Claim> result = DataFileLoader.loadClaimsFromFile(claimsFile);


        System.out.println(result.toString());
    }

    //@Test
    void testLoadInsuranceCardsFromFile() throws IOException {


        // Call the method to be tested
        ArrayList<InsuranceCard> result = DataFileLoader.loadInsuranceCardsFromFile(insuranceCardsFile);


        System.out.println(result.toString());
    }
    //@Test

    void testLoadPolicyHoldersFromFile() throws IOException {
        // Call the method to be tested
        ArrayList<PolicyHolder> result = DataFileLoader.loadPolicyHoldersFromFile(customersFile);

        System.out.println(result.toString());
    }
    @Test

    void testLoadDependentsFromFile() throws IOException {
        // Call the method to be tested
        ArrayList<Dependent> result = DataFileLoader.loadDependentsFromFile(customersFile);

        System.out.println(result.toString());
    }



}


