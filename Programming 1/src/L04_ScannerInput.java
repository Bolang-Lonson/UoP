import java.util.Scanner;

public class L04_ScannerInput {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);     // creating the scanner object

        double principal, rate, interest;

        System.out.println("Enter the initial investment: ");
        principal = stdin.nextDouble();

        System.out.print("Enter the annual interest rate (as a decimal): ");
        rate = stdin.nextDouble();

        interest = principal * rate; // Compute this year’s interest.
        principal = principal + interest; // Add it to principal.

        System.out.printf("The amount of interest is $%1.2f%n", interest);
        System.out.printf("The value after one year is $%1.2f%n", principal);
    }
}
