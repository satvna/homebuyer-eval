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
                tempArr = line.split(delimiter); //split string into array of things separated by ","

                //Initialize new entry using constructor 
                Entry tempEntry = new Entry(Integer.parseInt(tempArr[0]), Double.parseDouble(tempArr[1]), Double.parseDouble(tempArr[2]),
                Double.parseDouble(tempArr[3]),Double.parseDouble(tempArr[4]), Double.parseDouble(tempArr[5]), Double.parseDouble(tempArr[6]),
                Double.parseDouble(tempArr[7]),Double.parseDouble(tempArr[8]), Double.parseDouble(tempArr[9]));
                calculateApproval(tempEntry);
                
                //Add entry to list of entries
                homeBuyers.add(tempEntry);

                // call approve method and pass the tempentry
                //boolean approved = calculateApproval(tempEntry);
                
            }
            br.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

        //print to see if it works
        for (int i = 200; i < 300; i++){
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
        if (myEntry.creditScore <= 640){
            myEntry.addRejectionReason(0, "Low credit score");
        }
        return myEntry.creditScore >= 640;
    }

    public boolean checkLTV(Entry myEntry) {
        // LTV = % after doing (appraisedValue - downPayment) / appraisedValue
        // if LTV is <80%, you're fine
        // if LTV is 80-95%, might qualify but you'd have to purchase PMI
        // PMI will add a small yearly % to the amt you pay for the house
        double LTV = (myEntry.appraisedValue - myEntry.downPayment) / myEntry.appraisedValue;
        if (LTV < 0.8) {
            return true;
        }
        else if (LTV >= 0.8 && LTV <= 0.95) {
            myEntry.addWarnings(0, "LTV % is high, you will probably have to purchase PMI \n" + 
            "if you are approved, or you may be rejected");
            return true;
        }
        else {
            myEntry.addRejectionReason(1, "LTV % too high");
            return false;
        }
    }
    
    public boolean checkDTI(Entry myEntry){
        double monthlyDebt = myEntry.carPayment + myEntry.creditCardPayment + myEntry.monthlyMortgagePayment;
        double dti = (myEntry.grossMonthlyIncome / monthlyDebt) * 100;
        
        double fedti = (myEntry.grossMonthlyIncome / myEntry.monthlyMortgagePayment) * 100;

        //DTI can't be more than 43, but less than 38 is ideal
        //FEDTI can't be more than 28
        if (dti > 43 && fedti > 28){ // if both are invalid
            myEntry.addRejectionReason(2, "DTI and FEDTI % too high");
            return false;
        }
        else if (dti > 43 && fedti <= 28){ // if dti is invalid and fedti is valid
            myEntry.addRejectionReason(2, "DTI % too high");
            return false;
        }
        else if (fedti > 28 && dti <= 43){ // if fedti is invalid and dti is valid
            myEntry.addRejectionReason(2, "FEDTI % too high");
            return false;
        }
        else {
            if (dti > 38){ //lenders typically accept no more than 38%
                myEntry.addWarnings(1, "DTI outside of preferred range");
            }     
            return true;
        }
    }
}