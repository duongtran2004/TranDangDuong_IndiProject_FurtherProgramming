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
import java.util.ArrayList;
import java.util.Objects;

public class DataPopulator {
    // add listOfDependents that store Cid as String for policy Owner
    private static ArrayList<String> RMITListOfDependents = new ArrayList<>();
    private static ArrayList<String> FPTListOfDependents = new ArrayList<>();
    private static ArrayList<String> BUVListOfDependents = new ArrayList<>();

    //add

    // Method to populate sample customer data into a file
    public static void populateSampleCustomerData(File customersFile) throws IOException {
        // Check if the file exists and is empty
        if (customersFile.exists() && customersFile.length() == 0) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customersFile))) {
                // Write sample customer data to the file
                //declare listofClaims ArrayList, cId and insuranceCard variables outside the loop so both dependents and policy holders can use it
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
                    String padded10digitsNumber = String.format("%010d", i);
                    insuranceCard = padded10digitsNumber;
                    // Write customer data to the file
                    bufferedWriter.write(cId + "," + fullName + "," + insuranceCard + "," + listOfClaims.toString() + "\n");

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
    public static void populateSampleInsuranceCardData(File customerFile, File insuranceCardFile) throws IOException {
        if (customerFile.exists() && customerFile.isFile() && customerFile.length() > 0) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(customerFile));
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
                    //cardNumber is 3rd element
                    String cardNumber = customerData[2];
                    String policyOwner = "";
                    String expirationDate = "";

                    // Determine the policy owner based on the cId
                    if (cId.compareTo("c-1001000") >= 0) {

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
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    expirationDate = expirationLocalDate.format(formatter);

                    // Write insurance card data to the file
                    bufferedWriter.write(cardNumber + "," + cardHolder + "," + policyOwner + "," + expirationDate + "\n");

                }
                System.out.println("Sample " + insuranceCardFile.getName() + " data populated successfully.");
            }
        } else {
            System.out.println("File " + insuranceCardFile.getName() + " is not empty. Skipping data population.");
        }
    }

    // Similar implementation as above for insurance card data
//        //An insurance card contains card number (10 digits), card holder, policy owner, and an expiration date (Note that one card can only have one holder).
    //1 insurance card for every customer => 18 insurance card

    //read through each line of customer file => copy to insurance file (i is the counter = last 2 digits of Cid)
    //copy the insurance card id
    //copy the customer name => card holder
    //if cId >= 1001000 (Policy Holder) => Policy Owner = Card Holder
    //
    //if CId <= 1001000 (dependent), then:
//        if (Cid % 5 == 0) { //i is divisible by 5
//              PolicyOwner = BUV
//        } else if (Cid % 2 == 0) { // i is even
//              PolicyOwner = RMIT Vietnam
//
//        } else { //i is odd AND not divisible by 5
//            PolicyOwner = FPT
//
//        }
    //Expiration data: Today/CurrentDate + 10 days + i


    // Method to populate sample claim data into a file
    public static void populateSampleClaimData(File file) throws IOException {
//A claim contains the following information:
//
//- id (with the format f-numbers; 10 numbers)
//
//- Claim date
//
//- Insured person
//
//- Card number
//
//- Exam date
//
//- List of documents (with the format ClaimId_CardNumber_DocumentName.pdf)
//
//- Claim amount
//
//- Status (New, Processing, Done)
//
//- Receiver Banking Info (Bank – Name – Number)

        //"f-" + 9 formatted numbers if i <10
        //claimID = "f-" + "300000000" + i;
        //"f-" + 8 formatted numbers if i>=10
        //claimID = "f-" + "300000000" + i;

        //claimDate = currentDate - 5 days - i


    }
}



