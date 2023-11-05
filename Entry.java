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
        return "id : "+ id+ "\nGross monthly income: " +grossMonthlyIncome + "\nCredit card payment: "
        + creditCardPayment + "\nCar payment: " + carPayment + "\nStudent loan payments : "
        + studentLoanPayments + "\nAppraised value: " + appraisedValue + "\nDown payment: "
        + downPayment + "\nLoan amount: " + loanAmount + "\nMonthly mortgage payment:"
        + monthlyMortgagePayment + "\nCredit score: " + creditScore + "\nApproved: " + approvalLetter()
        + "\nRejection reasons: " + rejectionToString() + "\nwarnings: " + warningToString() + "\n\n";
    }

    public String approvalLetter(){
        if (approved==true){
            return "T";
        }
        else {
            return "F";
        }
    }
    public String rejectionToString(){
        String rejectionString = "";
        if (rejectionReason[0] != ""){
            rejectionString += rejectionReason[0];
        }
        if (rejectionReason[1] != ""){
            rejectionString += rejectionReason[1];
        }
        if (rejectionReason[2] != ""){
            rejectionString += rejectionReason[2];
        }

        if (rejectionString ==""){
            return "N/A";
        }
        return rejectionString;
    }
    public String warningToString(){
        String warningsString = "";

        if (warnings[1] != ""){
            warningsString += warnings[1];
        }
        if (warnings[2] != ""){
            warningsString += warnings[2];
        }

        if (warningsString ==""){
            return "N/A";
        }
        return warningsString;
    }
}
