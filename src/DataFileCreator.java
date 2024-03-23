/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 21-Mar-24 2:17 PM
 * @project IndiProject
 * @since ${11.0.18}
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The DataFileCreator Class
 * Create the 3 DataFiles: CustomersData.txt; InsuranceCardsData.txt and ClaimsData.txt if files NOT exist
 */
public class DataFileCreator {
    public static void createEmptyFile(String filePath) throws IOException {
        // Create a File object to store filepath
        File file = new File(filePath);
        if (file.exists()) { //condition to check if file exist
            //files already exist, skipping File Creation
            System.out.println(filePath + " already exist, skipping File Creation !");
            return;
        }
        //create new file
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully " + filePath);

            } else {
                System.out.println("Failed to create file " + filePath);
            } //exception handling
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}



