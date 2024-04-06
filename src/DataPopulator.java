/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 23-Mar-24 9:43 AM
 * @project IndiProject
 * @since ${11.0.18}
 */

import com.sun.jdi.IntegerValue;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * The type Data populator.
 */
public class DataPopulator {


    //variable to format date


    /**
     * Populate sample customer data.
     *
     * @param customersFile the customers file
     * @throws IOException the io exception
     */
// Method to populate sample customer data into a file
    public static void populateSampleCustomerData(File customersFile) throws IOException {
        // Check if the file exists and is empty
        if (customersFile.exists() && customersFile.length() == 0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customersFile))) {
                //generate 15 policyholder objects

                for (int i = 1; i <= 15; i++) {
                    //variables to hold attribute

                    ArrayList<String> listOfClaims = new ArrayList<>();
                    ArrayList<String> emptyListOfClaims = new ArrayList<>();
                    ArrayList<String> listOfDependents = new ArrayList<>();

                    // id (with the format c-numbers; 7 numbers) =>
                    String padded7digitsNumberForPolicyHolder = String.format("%07d", i); // Format the number with leading zeros
                    String policyHolderCId = "c-" + padded7digitsNumberForPolicyHolder; // Concatenate the formatted number and "c-"
                    String policyHolderFullName = "PolicyHolder " + i;
                    //insurance card:  card number (10 digits)
                    //variable to hold padded10dDigitsNumbers
                    String padded10digitsNumberForPolicyHolder = String.format("%010d", i);
                    String policyHolderInsuranceCard = padded10digitsNumberForPolicyHolder;
                    //now generate 1 Dependents object for each PolicyHolder
                    String padded7digitsNumberForDependent = String.format("%07d", 99 - i);
                    String dependentCId = "c-" + padded7digitsNumberForDependent;
                    String dependentFullName = "Dependent " + i;
                    String padded10digitsNumberForDependent = String.format("%010d", 99 - i);
                    String dependentInsuranceCard = padded10digitsNumberForDependent;

                    //Variable to store dependent data in a line of String
                    String dependentDataLine = dependentCId + "," + dependentFullName + "," + dependentInsuranceCard + "," + emptyListOfClaims.toString();

                    //add dependent data to listOfDependent
                    listOfDependents.add(dependentDataLine);

                    //Variable to store policyHolder data in a line of String
                    String policyHolderDataLine = policyHolderCId + "," + policyHolderFullName + "," + policyHolderInsuranceCard + "," + listOfClaims.toString() + "," + listOfDependents.toString();

                    // Write policyHolder data to the file
                    bufferedWriter.write(policyHolderDataLine + "\n");
                    //Write Dependent data to the file
                    bufferedWriter.write(dependentDataLine + "\n");
                }
                System.out.println("Sample " + customersFile.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + customersFile.getName() + " is not empty. Skipping data population.");
        }
    }

    /**
     * Populate sample insurance card data.
     *
     * @param customersFile     the customers file
     * @param insuranceCardFile the insurance card file
     * @throws IOException the io exception
     */
// Method to populate sample insurance card data into a file
    //Copy data from customers file to insurance card file
    public static void populateSampleInsuranceCardData(File customersFile, File insuranceCardFile) throws IOException {
        if (insuranceCardFile.exists() && insuranceCardFile.length() == 0) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(customersFile));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(insuranceCardFile))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    //1 line = 1 customer object's data
                    //store each attributes of customer's data as 1 element in the customerData Array, each split by ","
                    String[] customerData = line.split(",");
                    //cId is 1st element
                    String cId = customerData[0];
                    //cardHolder is 2nd element
                    String cardHolder = customerData[1];
                    //remove comma for 3 policyHolder

                    //cardNumber is 3rd element
                    String cardNumber = customerData[2];
                    String policyOwner = "";


                    // Determine the policy owner based on the numbers of elements in customerData: 5 for Policy Owner, 4 for Dependents
                    if ((customerData.length) > 4) {
                        policyOwner = cardHolder;

                    } else {
                        // Dependent
                        policyOwner = "PolicyHolder" + " " + (99 - (Integer.parseInt(cardNumber)));
                    }

                    String expirationDate = generateRandomExpirationDate(60);

                    // Write insurance card data to the file
                    bufferedWriter.write(cardNumber + "," + cardHolder + "," + policyOwner + "," + expirationDate + "\n");

                }
                System.out.println("Sample " + insuranceCardFile.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + insuranceCardFile.getName() + " is not empty. Skipping data population.");
        }
    }

    // Method to initialize customerClaimsMap by reading customer data from customersFile


    /**
     * Populate sample claim data.
     *
     * @param customersFile the customers file
     * @param claimsFile    the claims file
     * @throws IOException the io exception
     */
// Method to populate sample claim data into a file
    public static void populateSampleClaimData(File customersFile, File claimsFile) throws IOException {
        if (claimsFile.exists() && claimsFile.length() == 0) {


            //read through customersFile
            //write to claimsFile
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(customersFile));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(claimsFile))) {
                String line;
                //variable to hold line-counter. This would be use to identify PolicyHolders
                while ((line = bufferedReader.readLine()) != null) {

                    //variable to hold list of documents
                    ArrayList<String> listOfDocuments = new ArrayList<>();
                    //variable to hold claimAmount
                    double claimAmount = 0;
                    //variable to hold status
                    String status = generateRandomStatus();


                    //1 line = 1 customer object's data
                    //store each attributes of customer's data as 1 element in the customerData Array, each split by ","
                    String[] customerDataLine = line.split(",");
                    //store claimId into CustomersData.txt's claimsList ArrayList
                    String insuredPerson = customerDataLine[1];
                    String insuranceCard = customerDataLine[2];
                    //skip the current line if a customer is a dependent, create no claim at first
                    //dependent line has only 4 elements
                    if ((customerDataLine.length) < 5) {
                        continue;
                    }
                    //make claims for PolicyHolders only
                    //id (with the format f-numbers; 10 numbers)
                    String claimId = "f-" + insuranceCard;
                    String examDate = generateRandomExamDate(30);
                    String claimDate = generateRandomClaimDate(examDate, 10);

                    //generate listOfDocuments (with the format ClaimId_CardNumber_DocumentName.pdf)
                    String hospitalBill = claimId + "_" + insuranceCard + "_hospitalBill.pdf";
                    String patientRecord = claimId + "_" + insuranceCard + "_patientRecord.pdf";
                    //add 2 documents to listOfDocuments
                    listOfDocuments.add(hospitalBill);
                    listOfDocuments.add(patientRecord);
                    //generate claimAmount
                    claimAmount = generateRandomClaimAmount(100, 1000);
                    //generate BankingInfo
                    //variables to hold Banking info
                    String bankName = generateRandomBankName();
                    String accountOwner = insuredPerson;
                    String accountNumber = "b-" + insuranceCard;

                    //variable to store claimDataLine
                    String claimDataLine = claimId + "," + claimDate + "," + insuredPerson + "," + insuranceCard + "," + examDate + "," + claimAmount + "," + status + "," + bankName + "," + accountOwner + "," + accountNumber + "," + listOfDocuments;
                    // Write claims data to the ClaimData.txt file
                    bufferedWriter.write(claimDataLine);
                    bufferedWriter.newLine();

                    // After finishing writing ClaimData.txt, Append claim data to the corresponding customer data in the customers file
                    String customerId = customerDataLine[0];

                    //another try catch block
                    //read the customer files and write to customer files
                    String existingCustomerDataLine = line;
                    // Split the existing customer data line into an array
                    String[] existingCustomerDataArray = existingCustomerDataLine.split(",");
                    // Check the condition to append claimData:
                    // 1. if the claim data has NOT already been appended
                    // 2. if the current CustomerDataLine is a PolicyHolder ( 5 attributes instead of 4, so 5 elements)
//                    if (!existingCustomerDataLine.contains("[" + claimDataLine + "]") && (existingCustomerDataArray.length > 4)) {
//                        // Append claim data only if it hasn't been added before
//                        String newCustomerDataLine = existingCustomerDataLine + "[" + claimDataLine + "]";
//                        replaceLine(customersFile, customerId, newCustomerDataLine);
//                    }
                }
                System.out.println("Sample " + claimsFile.getName() + " data populated successfully.");

            }
        } else {
            System.out.println("File " + claimsFile.getName() + " is not empty. Skipping data population.");
        }
    }
    // Helper method to construct a claim data line


    // Method to replace a line in a file
    private static void replaceLine(File file, String targetId, String newLine) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(targetId)) {
                    lines.add(newLine);
                } else {
                    lines.add(line);
                }
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static double generateRandomClaimAmount(double minAmount, double maxAmount) {
        //create random object
        Random random = new Random();
        //random.nextDouble return values from 0.0 and 1.0
        double generateRandomValue = random.nextDouble();
        // Generate a random double within the specified range ex: [100,1000)
        double unRoundedClaimAmount = minAmount + (maxAmount - minAmount) * generateRandomValue;
        // Round the  value to two decimal places
        double claimAmount = Math.round(unRoundedClaimAmount * 100.0) / 100.0;

        return claimAmount;

    }
    // Method to generate a random LocalDate within a specified range


    public static String generateRandomExamDate(int maxDaysBeforeToday) {
        LocalDate currentDate = LocalDate.now(); //get the date of today
        Random random = new Random();
        int randomDays = random.nextInt(maxDaysBeforeToday) + 1; // Generate random days from 1 to maxDaysBeforeToday
        LocalDate examDateLocalDate = currentDate.minusDays(randomDays);
        // Convert LocalDate to Date (for formatting purposes)
        Date examDateDateObject = java.sql.Date.valueOf(examDateLocalDate);
        // Format the expiration date as a string in the desired format (e.g., "dd-MM-yyyy")
        String formattedExamDate = FileIOManager.DATE_FORMAT.format(examDateDateObject);
        return formattedExamDate;
    }

    public static String generateRandomClaimDate(String examDate, int maxDaysBeforeExamDate) {
        Random random = new Random(); //new Random object
        //convert examDate from String type to LocalDate type
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate examDateLocalDate = LocalDate.parse(examDate, dateFormat);
        int randomDays = random.nextInt(maxDaysBeforeExamDate) + 1; // Generate random days from 1 to maxDaysAheadOfExamDate
        LocalDate claimDateLocalDate = examDateLocalDate.minusDays(randomDays);
        // Convert LocalDate to Date (for formatting purposes)
        Date claimDateDateObject = java.sql.Date.valueOf(claimDateLocalDate);
        // Format the expiration date as a string in the desired format (e.g., "dd-MM-yyyy")
        String formattedClaimDate = FileIOManager.DATE_FORMAT.format(claimDateDateObject);
        return formattedClaimDate;
    }


    public static String generateRandomExpirationDate(int maxDaysAheadOfToday) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Generate a random number of days between 0 and maxDaysAhead
        Random random = new Random();
        int randomDays = random.nextInt(maxDaysAheadOfToday + 1); // Generate random days from 0 to maxDaysAhead

        // Calculate the expiration date by adding the random number of days to the current date
        LocalDate expirationDateLocalDate = currentDate.plusDays(randomDays);
        // Convert LocalDate to Date (for formatting purposes)
        Date expirationDateDateObject = java.sql.Date.valueOf(expirationDateLocalDate);
        // Format the expiration date as a string in the desired format (e.g., "dd-MM-yyyy")
        String formattedExpirationDate = FileIOManager.DATE_FORMAT.format(expirationDateDateObject);

        return formattedExpirationDate;
    }

    public static String generateRandomStatus() {
        //generate random status
        String status;
        Random random = new Random(); //create Random object
        int randomNumber = random.nextInt(3); //generate randomNumber from 0 to 2

        if (randomNumber == 0) {
            status = "New";
        } else if (randomNumber == 1) {
            status = "Processing";

        } else if (randomNumber == 2) {
            status = "Done";
        } else {
            status = "New";
        }
        return status;
    }

    public static String generateRandomBankName() {
        String bankName;
        Random random = new Random(); //create Random object
        int randomNumber = random.nextInt(4); //generate randomNumber from 0 to 4
        switch (randomNumber) {
            case 0:
                bankName = "Techcombank";
                break;
            case 1:
                bankName = "Vietcombank";
                break;
            case 2:
                bankName = "VPBank";
                break;
            case 3:
                bankName = "AgriBank";
                break;
            case 4:
                bankName = "OceanBank";
                break;
            default:
                bankName = "TechcomBank";
                break;
        }
        return bankName;
    }

}



