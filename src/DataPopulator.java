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

public class DataPopulator {


    //variable to format date


    // Method to populate sample customer data into a file
    public static void populateSampleCustomerData(File customersFile) throws IOException {
        // Check if the file exists and is empty
        if (customersFile.exists() && customersFile.length() == 0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customersFile))) {

                // add listOfDependents that store Cid as String for policy Owner
                ArrayList<String> RMITListOfDependents = new ArrayList<>();
                ArrayList<String> FPTListOfDependents = new ArrayList<>();
                ArrayList<String> BUVListOfDependents = new ArrayList<>();

                ArrayList<String> listOfClaims = new ArrayList<>();

                String cId = "";
                String insuranceCard = "";


                // Populate sample 15 Dependents customer data
                for (int i = 1; i <= 15; i++) {
                    // id (with the format c-numbers; 7 numbers) =>

                    String padded7digitsNumber = String.format("%07d", i); // Format the number with leading zeros
                    cId = "c-" + padded7digitsNumber; // Concatenate the formatted number and "c-"
                    //add dependents's Cid into policy owner listOfDependents
                    if (i % 5 == 0) { //i is divisible by 5
                        BUVListOfDependents.add(cId);
                    } else if (i % 2 == 0) { // i is even
                        RMITListOfDependents.add(cId);

                    } else { //i is odd AND not divisible by 5
                        FPTListOfDependents.add(cId);

                    }

                    String fullName = "Customer " + i;
                    //insurance card:  card number (10 digits)
                    //variable to hold padded10dDigitsNumbers
                    String padded10digitsNumber = String.format("%010d", i);

                    insuranceCard = padded10digitsNumber;

                    //each customers would automatically generate 1 claimID. claimID = insuranceCardNumber
                    String claimID = "f-" + insuranceCard;
                    //add claimID to listOfClaims.

                    listOfClaims.add(claimID);
                    // Write customer data to the file
                    bufferedWriter.write(cId + "," + fullName + "," + insuranceCard + "," + listOfClaims.toString() + "\n");
                    //empty listOfClaims for the next Customer's object line
                    listOfClaims.removeAll(listOfClaims);

                }
                //Populate sample 3 PolicyHolder Customer to hold 15 dependents,
                //A Customer is A Policy Holder if cId >= 1001000, otherwise dependent

                //So PolicyHolder store 2 ArrayList
                // Write 1st Policy Owner to the file
                bufferedWriter.write("c-1001000" + "," + "RMIT Vietnam," + "2000001000" + "," + listOfClaims.toString() + RMITListOfDependents.toString() + "\n");
                // Write 2nd Policy Owner to the file
                bufferedWriter.write("c-1002000" + "," + "FPT" + "," + "2000002000" + "," + listOfClaims.toString() + FPTListOfDependents.toString() + "\n");
                // Write 3rd Policy Owner to the file
                bufferedWriter.write("c-1003000" + "," + "BUV" + "," + "2000003000" + "," + listOfClaims.toString() + BUVListOfDependents.toString() + "\n");

                System.out.println("Sample " + customersFile.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + customersFile.getName() + " is not empty. Skipping data population.");
        }
    }

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

                    // Determine the policy owner based on the cId
                    if (cId.compareTo("c-1001000") >= 0) {
                        policyOwner = cardHolder;

                    } else {
                        // Dependent
                        //same logic as  populateSampleCustomerData
                        if (Integer.parseInt(cardNumber) % 5 == 0) {
                            policyOwner = "BUV";
                        } else if (Integer.parseInt(cardNumber) % 2 == 0) {
                            policyOwner = "RMIT Vietnam";
                        } else {
                            policyOwner = "FPT";
                        }
                    }

                    // Generate expiration date: Today/CurrentDate + 10 days + last 2 digits of Cid
                    LocalDate currentDate = LocalDate.now();
                    LocalDate expirationLocalDate = currentDate.plusDays(10).plusDays(Integer.parseInt(cId.substring(cId.length() - 2)));


                    expirationDate = Main.DATE_FORMAT.format(expirationLocalDate);

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
                while ((line = bufferedReader.readLine()) != null) {

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
                    //skip the current line if a customer is a policy holder
                    if (Integer.parseInt(insuranceCard) >= 2000001000) {
                        continue;
                    }
                    //id (with the format f-numbers; 10 numbers)
                    String claimId = "f-" + insuranceCard;
                    String insuredPerson = customerDataLine[1];
                    //store claimId into CustomersData.txt's claimsList ArrayList


                    //ClaimDate: The day when customers fill in claim form
                    String claimDate = "";
                    String examDate = "";
                    LocalDate currentDate = LocalDate.now();
                    //claimDate = currentDate - 2 days - n days (n = last digits of claim ID. ClaimID = InsuranceCard)
                    LocalDate claimLocalDate = currentDate.plusDays(-2).plusDays(-(Integer.parseInt(insuranceCard) % 10));


                    claimDate = Main.DATE_FORMAT.format(claimLocalDate);

                    //examDate: The day when customers visit hospital
                    //examDate = claimDate - 5 days - n days (n = last digits of claim ID. ClaimID = InsuranceCard).
                    //So examDate would always be smaller than claimDate
                    LocalDate examLocalDate = claimLocalDate.plusDays(-5).plusDays(-(Integer.parseInt(insuranceCard) % 10));


                    examDate = Main.DATE_FORMAT.format(examLocalDate);
                    //generate listOfDocuments (with the format ClaimId_CardNumber_DocumentName.pdf)
                    hospitalBill = claimId + "_" + insuranceCard + "_hospitalBill.pdf";
                    patientRecord = claimId + "_" + insuranceCard + "_patientRecord.pdf";
                    //add 2 documents to listOfDocuments
                    listOfDocuments.add(hospitalBill);
                    listOfDocuments.add(patientRecord);
                    //generate claimAmount = last digits of card * 100
                    claimAmount = (Integer.parseInt(insuranceCard) % 10) * 100;
                    //generate random status
                    Random random = new Random();
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


                    // Write claims data to the ClaimData.txt file
                    bufferedWriter.write(claimId + "," + claimDate + "," + insuredPerson + "," + insuranceCard + "," + examDate + "," + listOfDocuments + "," + claimAmount + "," + status + "," + bankName + "," + accountOwner + "," + accountNumber + "\n");
                }
                System.out.println("Sample " + claimsFile.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + claimsFile.getName() + " is not empty. Skipping data population.");
        }
    }


}



