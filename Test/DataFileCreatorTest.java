import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 01-Apr-24 12:41 PM
 * @project IndiProject
 * @since ${11.0.18}
 */
class DataFileCreatorTest {

    @Test
    void createEmptyFile() throws IOException {

        DataFileCreator.createEmptyFile(FileIOManager.CUSTOMERS_FILE_PATH);
        DataFileCreator.createEmptyFile(FileIOManager.INSURANCE_CARDS_FILE_PATH);
        DataFileCreator.createEmptyFile(FileIOManager.CLAIMS_FILE_PATH);
    }
}