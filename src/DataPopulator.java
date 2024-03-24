/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 23-Mar-24 9:43 AM
 * @project IndiProject
 * @since ${11.0.18}
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataPopulator {
    // Method to populate sample customer data into a file
    public static void populateSampleCustomerData(File file) throws IOException {
        // Check if the file exists and is empty
        if (file.exists() && file.length() == 0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                // Write sample customer data to the file
                //make listofClaims ArrayList outside the loop so both dependents and policy holders can use it
                ArrayList<String> listOfClaims = new ArrayList<>();
                // Populate sample 15 Dependents customer data
                for (int i = 1; i <= 15; i++) {
                    // id (with the format c-numbers; 7 numbers) => "c-" + 6 formatted numbers + i
                    String cId = "c-" + "100000" + i;
                    String fullName = "Customer " + i;
                    //insurance card:  card number (10 digits) => 9 formatted number + i
                    String insuranceCard = "2000000000" + i;
                    // Write customer data to the file
                    bufferedWriter.write(cId + "," + fullName + "," + insuranceCard + "," + listOfClaims.toString() + "\n");

                }
                //Populate sample 3 PolicyHolder Customer to hold 15 dependents, each hold 5
                // Write customer data to the file
                bufferedWriter.write("c-1001000" + "," + "RMIT Vietnam," + "20000001000" + "," + listOfClaims.toString() + "\n");
                // Write customer data to the file
                bufferedWriter.write("c-1002000" + "," + "FPT" + "," + "20000002000" + "," + listOfClaims.toString() + "\n");
                // Write customer data to the file
                bufferedWriter.write("c-1003000" + "," + "BUV" + "," + "20000003000" + "," + listOfClaims.toString() + "\n");
                System.out.println("Sample " + file.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + file.getName() + " is not empty. Skipping data population.");
        }
    }

    // Method to populate sample insurance card data into a file
    public static void populateSampleInsuranceCardData(File file) throws IOException {
        // Similar implementation as above for insurance card data
    }

    // Method to populate sample claim data into a file
    public static void populateSampleClaimData(File file) throws IOException {
        // Similar implementation as above for claim data
    }
}



