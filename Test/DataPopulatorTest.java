import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 24-Mar-24 2:40 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
class DataPopulatorTest {
    File customerFile = new File(Main.CUSTOMERS_FILE_PATH);
    File insuranceCardsFile = new File(Main.INSURANCE_CARDS_FILE_PATH);
    File claimsFile = new File(Main.CLAIMS_FILE_PATH);

    @Test
    public void populateSampleCustomerData() throws IOException {


        DataPopulator.populateSampleCustomerData(customerFile);
    }

    @Test
    public void populateSampleInsuranceCardsData() throws IOException {

        DataPopulator.populateSampleInsuranceCardData(customerFile, insuranceCardsFile);
    }

    @Test
    public void populateSampleClaimsData() throws IOException {
        DataPopulator.populateSampleClaimsData(customerFile, claimsFile);
    }
}