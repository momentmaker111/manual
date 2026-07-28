import java.util.Scanner;

public class PiCalculator {

    // Private variables
    private double piValue;
    private int terms;

    // Public constant
    public static final String SERIES_NAME =
            "Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)";

    // Constructor
    public PiCalculator(int terms) {
        this.terms = terms;
        this.piValue = computePi(terms);
    }

    // Private method
    private double computePi(int terms) {
        double pi = 0.0;
        int sign = 1;

        for (int i = 0; i < terms; i++) {
            pi += sign * (4.0 / (2 * i + 1));
            sign *= -1;
        }

        return pi;
    }

    // Public method
    public void displayResult() {
        System.out.println("Public Method - Displaying Result:");
        System.out.println("Approximated value of Pi: " + piValue);
        System.out.println();
    }

    // Protected method
    protected void displayPrecisionInfo() {
        System.out.println("Protected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + terms + " terms");
        System.out.println("Series used: " + SERIES_NAME);
        System.out.println();
    }

    // Public method accessing private data
    public void showPrivateDataAccess() {
        System.out.println("Private Data - Accessed only within class:");
        System.out.println("Raw computed value (private): " + piValue);
    }

    // Getter
    public double getPiValue() {
        return piValue;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Pi Calculator using Access Specifiers ===");
        System.out.print("Enter the number of terms for Pi approximation: ");
        int terms = sc.nextInt();

        System.out.println("\nCalculating Pi using Leibniz Series...\n");

        PiCalculator calc = new PiCalculator(terms);

        calc.displayResult();

        calc.displayPrecisionInfo();

        calc.showPrivateDataAccess();

        // Not allowed (private variable)
        // System.out.println(calc.piValue);

        sc.close();
    }
}
