/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 23-Mar-24 9:43 AM
 * @project IndiProject
 * @since ${11.0.18}
 */

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * The type Data populator.
 */
public class DataPopulator {

    /**
     * The constant claimsToBeAddedBackToCustomerFile.
     */
    public static ArrayList<Claim> claimsToBeAddedBackToCustomerFile = new ArrayList<>();


    //variable to format date


    /**
     * Populate sample insurance card data.
     *
     * @param customersFile     the customers file
     * @param insuranceCardFile the insurance card file
     * @param customersFile     the customers file
     * @throws IOException the io exception
     *                     <p>
     *                     Populate sample customer data.
     * @throws IOException the io exception
     */
/**
     * Populate sample customer data.
     *
     * @param customersFile the customers file
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
                    ArrayList<String> listOfDocuments = generateListOfDocuments(claimId, insuranceCard);
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
                }
                System.out.println("Sample " + claimsFile.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + claimsFile.getName() + " is not empty. Skipping data population.");
        }
    }

    /**
     * Populate customer data.
     *
     * @param customersFile the customers file
     * @throws IOException the io exception
     */
    public static void populateCustomerData(File customersFile) throws IOException {
        if (customersFile.exists() && customersFile.length() == 0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customersFile, false))) {
                //generate 15 policyholder objects

                for (int i = 1; i <= 15; i++) {
                    //variables to hold attribute

                    ArrayList<String> policyHolderListOfClaims = new ArrayList<>();
                    ArrayList<String> dependentListOfClaims = new ArrayList<>();
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
                    String dependentDataLine = dependentCId + "," + dependentFullName + "," + dependentInsuranceCard + "," + dependentListOfClaims;
                    //add dependent data to listOfDependent
                    listOfDependents.add(dependentDataLine);

                    //build list of claims for PolicyHolder
                    //make claims for PolicyHolders only
                    //id (with the format f-numbers; 10 numbers)
                    String claimId = "f-" + policyHolderInsuranceCard;
                    String examDate = generateRandomExamDate(30);
                    String claimDate = generateRandomClaimDate(examDate, 10);

                    //generate listOfDocuments (with the format ClaimId_CardNumber_DocumentName.pdf)
                    ArrayList<String> listOfDocuments = generateListOfDocuments(claimId, policyHolderInsuranceCard);
                    //generate claimAmount
                    double claimAmount = generateRandomClaimAmount(100, 1000);
                    //generate BankingInfo
                    //variables to hold Banking info
                    String bankName = generateRandomBankName();
                    String accountOwner = policyHolderFullName;
                    String accountNumber = "b-" + policyHolderInsuranceCard;
                    String insuredPerson = policyHolderFullName;
                    String insuranceCard = policyHolderInsuranceCard;
                    String status = generateRandomStatus();

                    //variable to store claimDataLine
                    String claimDataLine = claimId + "," + claimDate + "," + insuredPerson + "," + insuranceCard + "," + examDate + "," + claimAmount + "," + status + "," + bankName + "," + accountOwner + "," + accountNumber + "," + listOfDocuments;
                    policyHolderListOfClaims.add(claimDataLine);

                    //Variable to store policyHolder data in a line of String
                    String policyHolderDataLine = policyHolderCId + "," + policyHolderFullName + "," + policyHolderInsuranceCard + "," + policyHolderListOfClaims + "," + listOfDependents;

                    // Write policyHolder data to the file
                    bufferedWriter.write(policyHolderDataLine + "\n");
                    //Write Dependent data to the file
                    bufferedWriter.write(dependentDataLine + "\n");
                }

            }

        } else {
            System.out.println("The file" + FileIOManager.customerFile.getName() + "is not empty, skipping data population");

        }

    }


    /**
     * Generate list of documents array list.
     *
     * @param claimId       the claim id
     * @param insuranceCard the insurance card
     * @return the array list
     */
    public static ArrayList<String> generateListOfDocuments(String claimId, String insuranceCard) {
        ArrayList<String> listOfDocuments = new ArrayList<>();
        String hospitalBill = claimId + "_" + insuranceCard + "_hospitalBill.pdf";
        String patientRecord = claimId + "_" + insuranceCard + "_patientRecord.pdf";
        listOfDocuments.add(hospitalBill);
        listOfDocuments.add(patientRecord);
        return listOfDocuments;
    }

    /**
     * Generate random claim amount double.
     *
     * @param minAmount the min amount
     * @param maxAmount the max amount
     * @return the double
     */
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


    /**
     * Generate random exam date string.
     *
     * @param maxDaysBeforeToday the max days before today
     * @return the string
     */
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

    /**
     * Generate random claim date string.
     *
     * @param examDate              the exam date
     * @param maxDaysBeforeExamDate the max days before exam date
     * @return the string
     */
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


    /**
     * Generate random expiration date string.
     *
     * @param maxDaysAheadOfToday the max days ahead of today
     * @return the string
     */
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

    /**
     * Generate random status string.
     *
     * @return the string
     */
    public static String generateRandomStatus() {
        //generate random status
        String status;
        Random random = new Random(); //create Random object
        int randomNumber = random.nextInt(3); //generate randomNumber from 0 to 2

        if (randomNumber == 0) {
            status = "new";
        } else if (randomNumber == 1) {
            status = "processing";

        } else if (randomNumber == 2) {
            status = "done";
        } else {
            status = "new";
        }
        return status;
    }

    /**
     * Generate random bank name string.
     *
     * @return the string
     */
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



