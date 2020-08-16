package mypackage;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WriteSummary.java: Implement functions for writing data to summary report file
 * @author: Xiaohui Chao
 * @since 2019.11.13
 */

public class WriteSummary {
    /**
     * This method shows how to write a summary report file
     * @param path summary filename, which is privided by user
     * @param votingType a string which shows the voting type, i.e., "CPL" or "OPL"
     * @param partyBallots a hashtable which stores the party names and their corresponding ballots
     * @param partyNames a string array which stores the party names
     * @param results an arraylist of hashtables which stores the candidate names and ballots (for OPL) or ranks (for CPL)
     */
    public static void writeSummaryReport(String path, String votingType, Hashtable<String, Integer> partyBallots, String[] partyNames, ArrayList<Hashtable<String, Integer>> results) {
        //Write data
        File filename = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(filename, true);

            /* Write the title */
            fr.write("Election Summary Report");
            fr.write(System.lineSeparator());

            /* Write the voting type */
            fr.write(System.lineSeparator());
            fr.write("The voting type is " + votingType + ".");
            fr.write(System.lineSeparator());
            fr.write(System.lineSeparator());

            /* Write the party ballots */
            fr.write("The party ballot results are as follows:");
            fr.write(System.lineSeparator());
            for (Object i : partyBallots.keySet()) {
                fr.write("Party: " + i + ", Number of Votes: " + partyBallots.get(i));
                fr.write(System.lineSeparator());
            }
            fr.write(System.lineSeparator());

            /* Write the candidate ballots */
            fr.write("The candidate ballot results are as follows:");
            fr.write(System.lineSeparator());
            int j = 0;
            for (int i=0; i <  partyNames.length; i++) {
                /* Write the party name */
                fr.write("Party: " + partyNames[i] + ", ");
                /* Write the candidate ballots */
                fr.write("Candidates: ");
                for(Map.Entry<String,Integer> entry: results.get(i).entrySet()) {
                    String candidate = entry.getKey();
                    int ballot = entry.getValue();
                    fr.write(candidate + ": " + ballot + " ");
                }
                fr.write(System.lineSeparator());
                j = j + 1;
            }
            fr.write(System.lineSeparator());
            fr.write("For CPL, the number is the candidate's order on the original list.");
            fr.write(System.lineSeparator());
            fr.write("For OPL, the number is the candidate's number of individual votes.");
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
