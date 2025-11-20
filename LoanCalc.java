// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
    
    static double epsilon = 0.00001;  // Approximation accuracy
    static int iterationCounter;    // Number of iterations 
    
    // Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
    public static void main(String[] args) {       
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Computes the periodical payment using brute force search
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        // Computes the periodical payment using bisection search
        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    // Computes the ending balance of a loan after n periods.
    private static double endBalance(double loan, double rate, int n, double payment) {  
        for (int i = 0; i < n; i++) {
            loan = loan * (1 + rate / 100.0) - payment;
        }
        return loan;
    }
    
    // Sequential search (brute force)
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double payment = loan / n;
        iterationCounter = 0;

        while (endBalance(loan, rate, n, payment) > 0) {
            payment = payment + epsilon;
            iterationCounter++;
        }
        return payment;
    }
    
    // Bisection search
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;

        double lo = 0;
        double hi = loan * (1 + rate / 100.0);
        double m = (lo + hi) / 2;

        while ((hi - lo) > epsilon) {

            iterationCounter++;

            double fLo = endBalance(loan, rate, n, lo);
            double fM  = endBalance(loan, rate, n, m);

            if (fLo * fM > 0) {
                lo = m;
            } else {
                hi = m;
            }

            m = (lo + hi) / 2;
        }
        return m;
    }
}
