INSURANCE CLAIM MANAGEMENT SYSTEM

Overview
This Java program is designed to manage insurance claims through a text-based user interface. It provides functionalities for creating, reading, updating, and deleting (CRUD) insurance claims stored in data files.

Getting Started
Prerequisites
Java Development Kit (JDK) installed on your system
IDE (Integrated Development Environment) like IntelliJ IDEA or Eclipse
Installation
Clone the repository to your local machine:
git clone <[repository-url](https://github.com/duongtran2004/TranDangDuong_IndiProject_FurtherProgramming)>
Open the project in your preferred IDE.

Usage
Navigate to the src directory in your terminal or command prompt:
cd path/to/project/src

Compile the program:
javac Main.java

Run the compiled program:
java Main


Features

CRUD OPERATION ON CLAIMS

Add new claims with details like claim date, insured person, card number, etc.
View all existing claims in the system.
Update specific claim details such as claim amount, status, etc.
Delete claims based on claim ID.

TEXT-BASED FRIENDLY UI

User-friendly menu-driven interface.
Input validation to ensure data integrity.

PROJECT STRUCTURE 

Main.java: Main entry point of the program.
Claim.java: Represents a claim object.
Customer.java: Abstract class for managing customers.
PolicyHolder.java: Class for managing policy holders.
Dependent.java: Class for managing dependents.
InsuranceCard.java: Class for managing insurance cards.
ClaimProcessManager.java: Interface defining operations for claim management.
ClaimController.java: Controller class for handling user input.
ClaimView.java: View class for displaying information and menus.
SystemAdmin.java: Implements methods from ClaimProcessManager.
DataInputValidator.java: Utility class for input validation.
IDManager.java: Utility class for generating unique IDs.
DataFileCreator.java, PopulateDataFile.java, LoadDataFromFile.java, DataSaver.java: Classes for managing data files and operations.
es.

License
This project is licensed under the RMIT License
