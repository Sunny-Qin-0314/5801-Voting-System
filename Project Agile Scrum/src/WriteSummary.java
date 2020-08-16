package mypackage;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * WriteSummary.java: Implement functions for writing data to summary report file
 * @author Xiaohui Chao
 * @since 2019.11.13
 */

public class WriteSummary {
    /**
     * This method shows how to write a summary report file
     * @param path a String contians summary filename, which is privided by user
     * @param votingType a String which shows the voting type, i.e., "CPL" or "OPL"
     * @param cand_ballots an ArrayList of Hashtable which stores the candidates' names and their corresponding ballots
     * @param partyNames a String array which stores the party names
     * @param numOfSeats a Integer of the number of seats
     * @param results an arraylist of hashtables which stores the candidate names and ballots (for OPL) or ranks (for CPL)
     */
    public static void writeSummaryReport(String path, String votingType, ArrayList<Hashtable<String, Integer>> cand_ballots , String[] partyNames, int numOfSeats, ArrayList<Hashtable<String, Integer>> results) {
        //Write data
        File filename = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(filename, true);

            /* Write the title */
            fr.write("Election Summary Report");
            fr.write(System.lineSeparator());

            /* Write the Date */
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            fr.write(dateFormat.format(date));

            /* Write the voting type */
            fr.write(System.lineSeparator());
            fr.write("The voting type is " + votingType + ".");
            fr.write(System.lineSeparator());
            fr.write(System.lineSeparator());

            /* Write the candidates and their parties */
            // fr.write("The candidates and corresponding parties are as follows:");
            // fr.write(System.lineSeparator());
            // for (Object i : candidateInfo.keySet()) {
            //     fr.write("Candidate: " + i + ", Corresponding Party: " + candidateInfo.get(i));
            //     fr.write(System.lineSeparator());
            // }
            // fr.write(System.lineSeparator());
            int k = 0 ;
            for(Hashtable<String, Integer> hash_p: cand_ballots){
              fr.write("Party "+ partyNames[k]+": " + "\n");
              for(Map.Entry<String,Integer> entry: hash_p.entrySet()){
                fr.write(entry.getKey());
                fr.write(System.lineSeparator());
              }
              fr.write(System.lineSeparator());
              k++;
            }
            // fr.write(System.lineSeparator());

            /* Write the number of seats */
            fr.write("The number of seats is " + Integer.toString(numOfSeats)+ "\n");
            fr.write(System.lineSeparator());

            /* Write the candidate ballots */
            fr.write("The winners are as follows:");
            fr.write(System.lineSeparator());
            int j = 0;
            for (int i=0; i <  partyNames.length; i++) {
                /* Write the party name */
                fr.write("Party: " + partyNames[i] + ", ");
                /* Write the candidate ballots */
                fr.write("Candidates: ");
                for(Map.Entry<String,Integer> entry: results.get(i).entrySet()) {
                    String candidate = entry.getKey();
                    // int ballot = entry.getValue();
                    fr.write(candidate + " ");
                }
                fr.write(System.lineSeparator());
                j = j + 1;
            }

            // /* Write the party ballots */
            // fr.write("The party ballot results are as follows:");
            // fr.write(System.lineSeparator());
            // for (Object i : partyBallots.keySet()) {
            //     fr.write("Party: " + i + ", Number of Votes: " + partyBallots.get(i));
            //     fr.write(System.lineSeparator());
            // }
            // fr.write(System.lineSeparator());

            /* Write the candidate ballots */
            // fr.write("The candidate ballot results are as follows:");
            // fr.write(System.lineSeparator());
            // int j = 0;
            // for (int i=0; i <  partyNames.length; i++) {
            //     /* Write the party name */
            //     fr.write("Party: " + partyNames[i] + ", ");
            //     /* Write the candidate ballots */
            //     fr.write("Candidates: ");
            //     for(Map.Entry<String,Integer> entry: results.get(i).entrySet()) {
            //         String candidate = entry.getKey();
            //         int ballot = entry.getValue();
            //         fr.write(candidate + ": " + ballot + " ");
            //     }
            //     fr.write(System.lineSeparator());
            //     j = j + 1;
            // }
            // fr.write(System.lineSeparator());
            // fr.write("For CPL, the number is the candidate's order on the original list.");
            // fr.write(System.lineSeparator());
            // fr.write("For OPL, the number is the candidate's number of individual votes.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
