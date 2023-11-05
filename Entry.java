import java.lang.reflect.Array;
import java.util.ArrayList;

public class Entry {
    int id;
    double grossMonthlyIncome;
    double creditCardPayment;
    double carPayment;
    double studentLoanPayments;
    double appraisedValue;
    double downPayment;
    double loanAmount;
    double monthlyMortgagePayment;
    double creditScore;
    private boolean approved = true;
    private String[] rejectionReason = {"", "", ""};
    private String[] warnings = {"", "", ""};

    //--- CONSTRUCTORS ---
    public Entry(int id, double grossMonthlyIncome, double creditCardPayment, double carPayment, double studentLoanPayments, double appraisedValue,
                    double downPayment, double loanAmount, double monthlyMortgagePayment, double creditScore){
    
        this.id = id;
        this.grossMonthlyIncome = grossMonthlyIncome;
        this.creditCardPayment = creditCardPayment;
        this.carPayment = carPayment;
        this.studentLoanPayments = studentLoanPayments;
        this.appraisedValue = appraisedValue;
        this.downPayment = downPayment;
        this.loanAmount = loanAmount;
        this.monthlyMortgagePayment = monthlyMortgagePayment;
        this.creditScore = creditScore;

    }

    //--- GETTERS & SETTERS ---

    //approval status
    public boolean getApproved(){
        return this.approved;
    }
    public void setApproved(boolean approved){
        this.approved = approved;
    }

    //rejection reasons
    public String[] getRejectionRason(){
        return this.rejectionReason;
    }
    public void setRejectionReason(String[] rejectionReason){
         this.rejectionReason = rejectionReason;
    }
    public void addRejectionReason(int position, String rejectionReason){
        this.rejectionReason[position] = rejectionReason;
    }

    //warnings
    public String[] getWarnings(){
        return this.warnings;
    }    
    public void addWarnings(int position, String warning){
        this.warnings[position] = warning;
    }
    
    //--- METHODS ---
    public String entryToString(){
        return "id : "+ id+ "\ngrossMonthlyIncome: " +grossMonthlyIncome + "\ncreditCardPayment: " 
        + creditCardPayment + "\ncarPayment: " + carPayment + "\nstudentLoanPayments: " 
        + studentLoanPayments + "\nappraised value: " + appraisedValue + "\ndown payment: " 
        + downPayment + "\nloan amount: " + loanAmount + "\nmonthly mortgage payment:" 
        + monthlyMortgagePayment + "\ncredit score: " + creditScore + "\napproved: " + approved 
        + "\nrejectionReason: " + rejectionToString() + "\nwarnings: " + warningToString() + "\n\n";
    }

    public String rejectionToString(){
        return rejectionReason[0] + ", " + rejectionReason[1] + ", " + rejectionReason[2];
    }
    public String warningToString(){
        return warnings[0] + ", " + warnings[1];
    }
}
