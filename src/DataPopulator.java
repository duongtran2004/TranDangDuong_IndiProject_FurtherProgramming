/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 23-Mar-24 9:43 AM
 * @project IndiProject
 * @since ${11.0.18}
 */

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
                    String dependentDataLine = dependentCId + "," + dependentFullName + "," + dependentInsuranceCard + "," + emptyListOfClaims.toString() ;

                    //add dependent data to listOfDependent
                    listOfDependents.add(dependentDataLine);

                    //Variable to store policyHolder data in a line of String
                    String policyHolderDataLine = policyHolderCId + "," + policyHolderFullName + "," + policyHolderInsuranceCard + "," + listOfClaims.toString() + listOfDependents.toString() ;

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
                    String expirationDate = "";

                    // Determine the policy owner based on the cardNumber (last two digits < 50)
                    if (cardNumber.compareTo("0000000050") <= 0) {
                        policyOwner = cardHolder;

                    } else {
                        // Dependent
                       policyOwner = "PolicyHolder" + " " + (99 - Integer.parseInt(cardNumber));
                    }

                    // Generate expiration date: Today/CurrentDate + 10 days + last 2 digits of Cid
                    LocalDate currentDate = LocalDate.now();
                    LocalDate expirationLocalDate = currentDate.plusDays(10).plusDays(Integer.parseInt(cId.substring(cId.length() - 2)));

                    // Convert CurrentLocalDate to Date
                    Date epxDate = java.sql.Date.valueOf(expirationLocalDate);
                    expirationDate = Main.DATE_FORMAT.format(epxDate);

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
            // Initialize customerClaimsMap by reading customer data from customersFile.
            //Do this before the loop


            //each dependents make 1 claim. Only make claims for dependents
            //read through customersFile
            //write to claimsFile
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(customersFile));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(claimsFile))) {
                String line;
                //variable to hold line-counter. This would be use to identify PolicyHolders
                int lineCounter = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    lineCounter++;


                    //variable to hold list of documents
                    ArrayList<String> listOfDocuments = new ArrayList<>();
                    //String variable to hold 2 defaults documents
                    String hospitalBill = "";
                    String patientRecord = "";
                    String insuranceCard = "";

                    //variable to hold claimAmount
                    double claimAmount = 0;
                    //variable to hold status
                    String status = "";
                    //variable to hold Banking info
                    String bankName = "";
                    String accountOwner = "";
                    String accountNumber = "";

                    //1 line = 1 customer object's data
                    //store each attributes of customer's data as 1 element in the customerData Array, each split by ","
                    String[] customerDataLine = line.split(",");
                    insuranceCard = customerDataLine[2];
                    //skip the current line if a customer is a policy holder, create no claim at first
                    if (lineCounter >= 16) {
                        continue;
                    }
                    //id (with the format f-numbers; 10 numbers)
                    String claimId = "f-" + insuranceCard;
                    String insuredPerson = customerDataLine[1];
                    //store claimId into CustomersData.txt's claimsList ArrayList


                    //ClaimDate: The day when customers fill in claim form
                    String claimDate = "";
                    String examDate = "";
                    //create random positive integer from 1 to 20
                    Random random = new Random();
                    int randomPositiveIntegerClaim = random.nextInt(20) + 1; //bound start from 0
                    LocalDate currentDate = LocalDate.now();
                    //claimDate = currentDate - 2 days - n days (n = last digits of claim ID. ClaimID = InsuranceCard)
                    LocalDate claimLocalDate = currentDate.plusDays(-randomPositiveIntegerClaim);
                    //convert CurrentLocalDate to Date
                    Date clmDate = java.sql.Date.valueOf(claimLocalDate);
                    //convert Date to String

                    claimDate = Main.DATE_FORMAT.format(clmDate);

                    //examDate: The day when customers visit hospital

                    //So examDate would always be smaller than claimDate
                    int randomPositiveIntegerExam = random.nextInt(20) + 1; //bound start from 0
                    LocalDate examLocalDate = claimLocalDate.plusDays(-randomPositiveIntegerExam);
                    //convert CurrentLocalDate to Date
                    Date exaDate = java.sql.Date.valueOf(examLocalDate);
                    //convert Date to String

                    examDate = Main.DATE_FORMAT.format(exaDate);
                    //generate listOfDocuments (with the format ClaimId_CardNumber_DocumentName.pdf)
                    hospitalBill = claimId + "_" + insuranceCard + "_hospitalBill.pdf";
                    patientRecord = claimId + "_" + insuranceCard + "_patientRecord.pdf";
                    //add 2 documents to listOfDocuments
                    listOfDocuments.add(hospitalBill);
                    listOfDocuments.add(patientRecord);
                    //generate claimAmount = last digits of card * 100
                    claimAmount = (Integer.parseInt(insuranceCard) % 10) * 100;
                    //generate random status
                    random = new Random();
                    int randomNumber = random.nextInt(3); //generate randomNumber from 0 to 2
                    switch (randomNumber) {
                        case 0:
                            status = "New";
                            break;
                        case 1:
                            status = "Processing";
                            break;
                        case 2:
                            status = "Done";
                            break;
                        default:
                            status = "New"; // Default to "New" status
                            break;
                    }


                    //generate BankingInfo
                    accountOwner = insuredPerson;
                    accountNumber = "b-" + insuranceCard;
                    //generate bankName: Techcombank for even cards, Vietcombank for odd cards
                    if (((Integer.parseInt(insuranceCard)) % 2) == 0) {
                        bankName = "Techcombank";
                    } else {
                        bankName = "Vietcombank";

                    }
                    //variable to store claimData

                    String claimData = claimId + "," + claimDate + "," + insuredPerson + "," + insuranceCard + "," + examDate + "," + listOfDocuments + "," + claimAmount + "," + status + "," + bankName + "," + accountOwner + "," + accountNumber;
                    // Write claims data to the ClaimData.txt file
                    bufferedWriter.write(claimData + "\n");
                    // Append claim data to the corresponding customer data in the customers file
                    String customerId = customerDataLine[0];
                    String existingCustomerDataLine = line;
                    // Check if the claim data has already been appended
                    if (!existingCustomerDataLine.contains("[" + claimData + "]")) {
                        // Append claim data only if it hasn't been added before
                        String newCustomerDataLine = existingCustomerDataLine + "[" + claimData + "]";
                        replaceLine(customersFile, customerId, newCustomerDataLine);
                    }
                }
                System.out.println("Sample " + claimsFile.getName() + " data populated successfully.");

            }
        } else {
            System.out.println("File " + claimsFile.getName() + " is not empty. Skipping data population.");
        }
    }

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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

}



