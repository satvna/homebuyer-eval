import java.util.*;
import java.io.*;

public class BuyerEval {
    BufferedReader inputFileReader;

    public static void main(String[] args) {
        BuyerEval eval = new BuyerEval("HackUTD-2023-HomeBuyerInfo.csv");
    }

    public BuyerEval(String filename) {
        List<Entry> homeBuyers = new ArrayList<>();
        try{
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String[] tempArr;
            String line = "";
            String delimiter = ",";
            br.readLine();

            while((line = br.readLine()) != null) { //until there are no more lines
                line = br.readLine();
                tempArr = line.split(delimiter); //split string into array of things separated by ","

                //Initialize new entry using constructor 
                Entry tempEntry = new Entry(Integer.parseInt(tempArr[0]), Double.parseDouble(tempArr[1]), Double.parseDouble(tempArr[2]),
                Double.parseDouble(tempArr[3]),Double.parseDouble(tempArr[4]), Double.parseDouble(tempArr[5]), Double.parseDouble(tempArr[6]),
                Double.parseDouble(tempArr[7]),Double.parseDouble(tempArr[8]), Double.parseDouble(tempArr[9]));
                tempEntry.setApproved(calculateApproval(tempEntry));
                
                //Add entry to list of entries
                homeBuyers.add(tempEntry);
            }
            br.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

        //print to see if it works
        for (int i = 0; i < 100; i++){
            System.out.println(homeBuyers.get(i).entryToString());
        }
    }

    // approve method that takes the entry
    public boolean calculateApproval(Entry myEntry){
        if (checkCreditScore(myEntry) && checkLTV(myEntry) && checkDTI(myEntry)){
            return true;
        }
        return false;
    }

    public boolean checkCreditScore(Entry myEntry) {
        if (myEntry.creditScore < 640){
            myEntry.addRejectionReason(0, "Low credit score");
            return false;
        }
        return true;
    }

    public boolean checkLTV(Entry myEntry) {
        // LTV = % after doing (appraisedValue - downPayment) / appraisedValue
        // if LTV is <80%, you're fine
        // if LTV is 80-95%, might qualify but you'd have to purchase PMI
        // PMI will add a small yearly % to the amt you pay for the house
        double LTV = (myEntry.appraisedValue - myEntry.downPayment) / myEntry.appraisedValue;

        if (LTV > 0.95) {
            myEntry.addRejectionReason(1, "LTV % too high");
            return false;
        }
        if (LTV >= 0.8 && LTV <= 0.95) {
            myEntry.addWarnings(0, "LTV % is high, you will probably have to purchase PMI \n" + 
            "if you are approved, or you may be rejected");
            return true;
        }
        return true;
    }
    
    public boolean checkDTI(Entry myEntry){
        double monthlyDebt = myEntry.carPayment + myEntry.creditCardPayment + myEntry.monthlyMortgagePayment;

        double dti = (monthlyDebt/myEntry.grossMonthlyIncome);
        double fedti = (myEntry.monthlyMortgagePayment / myEntry.grossMonthlyIncome);

        //DTI can't be more than 43, but less than 38 is ideal
        //FEDTI can't be more than 28
        if (dti > 0.43 && fedti > 0.28){ // if both are invalid
            myEntry.addRejectionReason(2, "DTI and FEDTI % too high");
            return false;
        }
        else if (dti > 0.43 && fedti <= 0.28){ // if dti is invalid and fedti is valid
            myEntry.addRejectionReason(2, "DTI % too high");
            return false;
        }
        else if (fedti > 0.28 && dti <= 0.43){ // if fedti is invalid and dti is valid
            myEntry.addRejectionReason(2, "FEDTI % too high");
            return false;
        }
        else {
            if (dti > 0.38){ //lenders typically accept no more than 38%
                myEntry.addWarnings(1, "DTI outside of preferred range");
            }     
            return true;
        }
    }
}