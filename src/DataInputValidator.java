/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 03-Apr-24 11:17 AM
 * @project IndiProject
 * @since ${11.0.18}
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * The type Data input validator.
 */
public class DataInputValidator {
    /**
     * Gets valid integer input.
     *
     * @param scanner the scanner
     * @return the valid integer input
     */
    public static int getValidIntegerInput(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("Enter your choice (must be an integer): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return choice;
    }

    /**
     * Gets valid claim date.
     *
     * @param scanner the scanner
     * @return the valid claim date
     */
    public static Date getValidClaimDate(Scanner scanner) {
        Date claimDate = null;
        boolean validClaimDate = false;
        while (!validClaimDate) {
            try {
                System.out.println("Please enter the claim date (must be in the format dd-MM-yyyy, example: 12-04-2024): ");
                String stringClaimDate = scanner.next();
                claimDate = FileIOManager.DATE_FORMAT.parse(stringClaimDate);
                validClaimDate = true;

                // Additional validation: Claim date must be before today's date
                if (claimDate.after(new Date())) {
                    System.out.println("Claim date cannot be in the future. Please enter a valid date.");
                    validClaimDate = false;
                }
            } catch (ParseException e) {
                System.out.println("Invalid claim date format. Please enter a valid date.");
            }
        }
        return claimDate;
    }

    /**
     * Gets valid exam date.
     *
     * @param scanner   the scanner
     * @param claimDate the claim date
     * @return the valid exam date
     */
    public static Date getValidExamDate(Scanner scanner, Date claimDate) {
        Date examDate = null;
        boolean validExamDate = false;
        while (!validExamDate) {
            try {
                System.out.println("Please enter the exam date (must be in the format dd-MM-yyyy, example: 12-04-2024): ");
                String stringExamDate = scanner.next();
                examDate = FileIOManager.DATE_FORMAT.parse(stringExamDate);
                validExamDate = true;

                // Additional validation: Exam date must be after claim date
                if (examDate.before(claimDate)) {
                    System.out.println("Exam date must be after the claim date. Please enter a valid date.");
                    validExamDate = false;
                }
            } catch (ParseException e) {
                System.out.println("Invalid exam date format. Please enter a valid date.");
            }
        }
        return examDate;
    }

    /**
     * Gets valid status.
     *
     * @param scanner the scanner
     * @return the valid status
     */
    public static String getValidStatus(Scanner scanner) {
        String status = "";
        boolean validStatus = false;
        while (!validStatus) {
            System.out.println("Please enter the status (must be one of: New, Processing, or Done): ");
            status = scanner.next().toLowerCase();
            if (status.equals("new") || status.equals("processing") || status.equals("done")) {
                validStatus = true;
            } else {
                System.out.println("Invalid status. Please enter one of: new, processing, or done.");
            }
        }
        return status;
    }

    /**
     * Gets valid list of documents.
     *
     * @param scanner the scanner
     * @return the valid list of documents
     */
    public static ArrayList<String> getValidListOfDocuments(Scanner scanner) {
        System.out.println("Please enter the list of documents. Each document is separated by a \",\" (comma): ");
        String listOfDocumentContent = scanner.next();
        String[] documentsArray = listOfDocumentContent.split(",");
        return new ArrayList<>(Arrays.asList(documentsArray));
    }

    /**
     * Gets valid insurance card number.
     *
     * @param scanner        the scanner
     * @param insuranceCards the insurance cards
     * @return the valid insurance card number
     */
    public static String getValidInsuranceCardNumber(Scanner scanner, ArrayList<InsuranceCard> insuranceCards) {
        String cardNumber = "";
        boolean validCardNumber = false;
        while (!validCardNumber) {
            System.out.println("Please enter the card number (must be a 10-digit integer): ");
            cardNumber = scanner.next();
            if (cardNumber.length() == 10 && isNumeric(cardNumber) && isCardNumberExist(cardNumber, insuranceCards)) {
                validCardNumber = true;
            } else {
                System.out.println("Invalid card number format or card number does not exist. Please enter a valid 10-digit card number.");
            }
        }
        return cardNumber;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static boolean isCardNumberExist(String cardNumber, ArrayList<InsuranceCard> insuranceCards) {
        for (InsuranceCard insuranceCard : insuranceCards) {
            if (insuranceCard.getCardNumber().equals(cardNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets valid positive double.
     *
     * @param scanner the scanner
     * @return the valid positive double
     */
    public static double getValidClaimAmount(Scanner scanner) {
        double number = 0.0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter a positive number: ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                if (number > 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        return number;
    }


}