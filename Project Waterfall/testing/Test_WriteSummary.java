import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mypackage.*;

public class Test_WriteSummary {
    public static void main(String[] args) {
        //Test1: Test write summary results to file for OPL
        /* Define voting type and path */
        String votingType1 = "OPL";
        String path1 = "Summary_OPL.txt";

        /* Define party ballots */
        Hashtable<String, Integer> partyBallots1 = new Hashtable<>();
        partyBallots1.put("Democratic", 3);
        partyBallots1.put("Republican", 2);
        partyBallots1.put("Reform", 1);
        partyBallots1.put("Green", 1);
        partyBallots1.put("Independent Candidate", 0);
        System.out.println(partyBallots1);

        /* Define party name string array */
        String[] partyNames1 = {"Democratic", "Republican", "Reform", "Green", "Independent Candidate"};

        /* Define candidate ballots */
        ArrayList<Hashtable<String, Integer>> results1 = new ArrayList<>();
        Hashtable<String, Integer> party1a = new Hashtable<>();
        Hashtable<String, Integer> party1b = new Hashtable<>();
        Hashtable<String, Integer> party1c = new Hashtable<>();
        Hashtable<String, Integer> party1d = new Hashtable<>();
        Hashtable<String, Integer> party1e = new Hashtable<>();

        party1a.put("Jack", 1);
        party1a.put("Mary", 2);
        party1b.put("Rex", 3);
        party1b.put("Sunny", 4);
        party1c.put("Tom", 5);
        party1c.put("Bob", 6);
        party1d.put("Lily", 7);
        party1d.put("Brandon", 8);
        party1e.put("Joe", 9);
        party1e.put("Alice", 10);

        results1.add(party1a);
        results1.add(party1b);
        results1.add(party1c);
        results1.add(party1d);
        results1.add(party1e);
        System.out.println(results1);

        /* Write the summary report */
        mypackage.WriteSummary writeSum1 = new mypackage.WriteSummary();
        writeSum1.writeSummaryReport(path1, votingType1, partyBallots1, partyNames1, results1);


        //Test2: Test write summary results to file for CPL
        /* Define voting type and path */
        String votingType2 = "CPL";
        String path2 = "Summary_CPL.txt";

        /* Define party ballots */
        Hashtable<String, Integer> partyBallots2 = new Hashtable<>();
        partyBallots2.put("Democratic", 5);
        partyBallots2.put("Republican", 6);
        partyBallots2.put("Reform", 3);
        partyBallots2.put("Green", 2);
        partyBallots2.put("Independent Candidate", 1);
        System.out.println(partyBallots2);

        /* Define party name string array */
        String[] partyNames2 = {"Democratic", "Republican", "Reform", "Green", "Independent Candidate"};

        /* Define candidate ballots */
        ArrayList<Hashtable<String, Integer>> results2 = new ArrayList<>();
        Hashtable<String, Integer> party2a = new Hashtable<>();
        Hashtable<String, Integer> party2b = new Hashtable<>();
        Hashtable<String, Integer> party2c = new Hashtable<>();
        Hashtable<String, Integer> party2d = new Hashtable<>();
        Hashtable<String, Integer> party2e = new Hashtable<>();

        party2a.put("Jack", 10);
        party2a.put("Mary", 20);
        party2b.put("Rex", 30);
        party2b.put("Sunny", 40);
        party2c.put("Tom", 50);
        party2c.put("Bob", 60);
        party2d.put("Lily", 70);
        party2d.put("Brandon", 80);
        party2e.put("Joe", 90);
        party2e.put("Alice", 100);

        results2.add(party2a);
        results2.add(party2b);
        results2.add(party2c);
        results2.add(party2d);
        results2.add(party2e);
        System.out.println(results2);

        /* Write the summary report */
        mypackage.WriteSummary writeSum2 = new mypackage.WriteSummary();
        writeSum2.writeSummaryReport(path2, votingType2, partyBallots2, partyNames2, results2);
    }
}
