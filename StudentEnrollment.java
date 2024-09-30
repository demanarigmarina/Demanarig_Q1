import java.util.Scanner;

public class StudentEnrollment {

    // Constants
    static final int MAX_SUBJECTS = 10; // Maximum number of subjects allowed
    static final int FEE_PER_UNIT = 1000; // Fee per unit

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Input student details
        System.out.println("Enter Student Name: ");
        String studentName = scanner.nextLine(); // Get student name
        
        System.out.println("Enter Course: ");
        String course = scanner.nextLine(); // Get course name
        
        System.out.println("Enter Course Code: ");
        String courseCode = scanner.nextLine(); // Get course code
        
        int totalUnits = 0;
        while (true) {
            System.out.println("Enter Number of Units: ");
            totalUnits = scanner.nextInt(); // Get the number of units
            
            // Check if the total units are within allowed range
            if (totalUnits > 0 && totalUnits <= MAX_SUBJECTS) {
                break; // Exit loop if valid
            } else {
                System.out.println("Invalid number of units. Please enter a value between 1 and 10.");
            }
        }

        // Step 2: Compute total enrollment fee
        int totalFee = computeEnrollmentFee(totalUnits);

        // Display student's name and total fee
        System.out.println("Student Name: " + studentName);
        System.out.println("Total Enrollment Fee: " + totalFee);

        // Step 3: Payment handling
        System.out.println("Enter Payment Amount: ");
        int paymentAmount = scanner.nextInt(); // Get payment from student

        // Step 4: Check payment status
        checkPaymentStatus(paymentAmount, totalFee);
        
        scanner.close(); // Close the scanner to avoid resource leak
    }

    // Method to compute the enrollment fee
    public static int computeEnrollmentFee(int units) {
        return units * FEE_PER_UNIT;
    }

    // Method to check payment status
    public static void checkPaymentStatus(int payment, int totalFee) {
        if (payment == totalFee) {
            System.out.println("Fully Paid");
        } else if (payment < totalFee) {
            System.out.println("Partial Payment");
            System.out.println("Amount Paid: " + payment);
            System.out.println("Remaining Balance: " + (totalFee - payment));
        } else {
            System.out.println("Overpaid! You paid " + payment + " but the total fee is " + totalFee);
        }
    }
}