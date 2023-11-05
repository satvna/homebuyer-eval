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

              //Add entry to list of entries
              homeBuyers.add(tempEntry);
            }
            br.close();
    }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        //print to see if it works
        for (int i = 0; i < 3; i++){
            System.out.println(homeBuyers.get(i).toString());
        }
    }
}