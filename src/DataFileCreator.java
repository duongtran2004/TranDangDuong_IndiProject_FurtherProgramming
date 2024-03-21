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

public class DataFileCreator {
    private static void createEmptyFile(String filePath) {
        try {
            // Create a File object
            File file = new File(filePath);
            //avoid losing data when restarting the program
            if (file.exists() && file.length() > 0) {
                System.out.println("File " + filePath + " already contains data. Skipping population.");
                return;
            }

            // Create a BufferedWriter to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Close the BufferedWriter
            writer.close();
        } catch (IOException e) {
            System.err.println("Error occurred while creating the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Specify the file paths for customers, insurance cards, and claims
        String customersFilePath = "src\\DataFiles\\CustomersData.txt";
        String insuranceCardsFilePath = "src\\DataFiles\\InsuranceCardsData.txt";
        String claimsFilePath = "src\\DataFiles\\ClaimsData.txt";

        // Create empty data files
        createEmptyFile(customersFilePath);
        createEmptyFile(insuranceCardsFilePath);
        createEmptyFile(claimsFilePath);

        System.out.println("Data files created successfully.");
    }


}
