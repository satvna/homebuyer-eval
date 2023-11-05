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

    @Override
    public String toString(){
        return "id:  "+ id+ "| grossMonthlyIncome: " +grossMonthlyIncome + "| creditCardPayment: " + creditCardPayment +
         "| carPayment: " + carPayment + "| studentLoanPayments: " +studentLoanPayments + "| appraised value: " + appraisedValue
         + "| down payment: " + downPayment + "| loan amount: " + loanAmount + "| monthly mortgage payment:" + monthlyMortgagePayment
         + "| credit score: " + creditScore + "\n\n";
    }
}
