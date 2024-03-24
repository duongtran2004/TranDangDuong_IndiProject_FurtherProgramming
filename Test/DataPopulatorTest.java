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

    @Test
    public void populateSampleCustomerData() throws IOException {
        File file = new File("src/DataFiles/CustomersData.txt");
        DataPopulator.populateSampleCustomerData(new File(file.getAbsolutePath()));
    }
}