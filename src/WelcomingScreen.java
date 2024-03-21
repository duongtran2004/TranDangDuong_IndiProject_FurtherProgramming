/**
 * The interface Welcoming screen.
 *
 * @author Tran Dang Duong Student ID: s3979381
 * @version $ {11.0.18}
 * @created 13 -Mar-24 2:01 PM
 * @project IndiProject
 * @since $ {11.0.18}
 */
public class WelcomingScreen {
    /**
     * Display welcome screen.
     * Course code
     * Assignment name
     * Project name
     * Lecturer
     * Tutorial Session
     * Student ID - Student Name
     */
    public static void displayWelcomeScreen() {
        System.out.println("******************************************************************************");
        System.out.println("                      COSC 2440: FURTHER PROGRAMMING");
        System.out.println("                 INDIVIDUAL PROJECT: Build A Console App: ");
        System.out.println("                        INSURANCE CLAIM SYSTEM");
        System.out.println("                        LECTURER: Minh Vu Thanh");
        System.out.println("                    TUTORIAL: 12:30 PM Friday - SGS");
        System.out.println("                    STUDENT: s3979381, Tran Dang Duong");
        System.out.println("******************************************************************************");
    }

    /**
     * The entry point of the WelcomingScreen Class.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
displayWelcomeScreen();
    }
}
