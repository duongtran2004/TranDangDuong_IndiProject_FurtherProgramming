

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 24-Mar-24 2:18 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class DataFileCreatorTest {

    @Test
    public void testCreateEmptyFile() throws IOException {
      DataFileCreator.createEmptyFile(Main.CUSTOMERS_FILE_PATH);
      DataFileCreator.createEmptyFile((Main.INSURANCE_CARDS_FILE_PATH));
      DataFileCreator.createEmptyFile(Main.CLAIMS_FILE_PATH);
    }
}