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
    public void populateSampleCustomerData(File file) throws IOException {
        // Check if the file exists and is empty
        if (file.exists() && file.length() == 0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                // Write sample customer data to the file
                // Populate sample 15 Dependents customer data
                for (int i = 1; i <= 15; i++) {
                    String cId = "C" + i;
                    String fullName = "Customer " + i;
                    String insuranceCard = "IC" + i;//
                    ArrayList<String> listOfClaims = new ArrayList<>();

                    // Add sample claims for each customer if needed
                    listOfClaims.add("Claim " + i + "-1");
                    listOfClaims.add("Claim " + i + "-2");
                    // Write customer data to the file
                    bufferedWriter.write(cId + "," + fullName + "," + insuranceCard + "," + listOfClaims.toString() + "\n");

                }
                //Populate sample 3 PolicyHolder Customer to hold 15 dependents, each hold 5
                // Write customer data to the file
                bufferedWriter.write(100 + "," + "RMIT Vietnam," + insuranceCard + "," + listOfClaims.toString() + "\n");
                // Write customer data to the file
                bufferedWriter.write(200 + "," + fullName + "," + insuranceCard + "," + listOfClaims.toString() + "\n");
                // Write customer data to the file
                bufferedWriter.write(300 + "," + fullName + "," + insuranceCard + "," + listOfClaims.toString() + "\n");
                System.out.println("Sample " + file.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + file.getName() + " is not empty. Skipping data population.");
        }
    }

    // Method to populate sample insurance card data into a file
    public void populateSampleInsuranceCardData(File file) throws IOException {
        // Similar implementation as above for insurance card data
    }

    // Method to populate sample claim data into a file
    public void populateSampleClaimData(File file) throws IOException {
        // Similar implementation as above for claim data
    }
}



