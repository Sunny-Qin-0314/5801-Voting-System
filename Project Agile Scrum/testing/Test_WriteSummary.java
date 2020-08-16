import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import mypackage.*;

public class Test_WriteSummary {
    public static void main(String[] args) {
        //Test1: Test write summary results to file for OPL
        /* Define voting type and path */
        String votingType1 = "OPL";
        String path1 = "Summary_OPL.txt";

        /* Define candidate ballots */
        ArrayList<Hashtable<String, Integer>> candBallots1 = new ArrayList<>();
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

        candBallots1.add(party1a);
        candBallots1.add(party1b);
        candBallots1.add(party1c);
        candBallots1.add(party1d);
        candBallots1.add(party1e);
        System.out.println(candBallots1);

        /* Define party name string array */
        String[] partyNames1 = {"Democratic", "Republican", "Reform", "Green", "Independent Candidate"};

        /* Define number of seats */
        int numOfSeats1 = 3;

        /* Define winners */
        ArrayList<Hashtable<String, Integer>> results1 = new ArrayList<>();
        Hashtable<String, Integer> party1aa = new Hashtable<>();
        Hashtable<String, Integer> party1bb = new Hashtable<>();
        Hashtable<String, Integer> party1cc = new Hashtable<>();
        Hashtable<String, Integer> party1dd = new Hashtable<>();
        Hashtable<String, Integer> party1ee = new Hashtable<>();

        party1aa.put("Mary", 2);
        party1bb.put("Rex", 3);
        party1bb.put("Sunny", 4);
        party1cc.put("Bob", 6);
        party1dd.put("Lily", 7);
        party1ee.put("Joe", 9);
   
        results1.add(party1aa);
        results1.add(party1bb);
        results1.add(party1cc);
        results1.add(party1dd);
        results1.add(party1ee);
        System.out.println(results1);

        /* Write the summary report */
        mypackage.WriteSummary writeSum1 = new mypackage.WriteSummary();
        writeSum1.writeSummaryReport(path1, votingType1, candBallots1, partyNames1, numOfSeats1, results1);

        /* Read the summary file and check results*/
        String line1 = "Party: Democratic, Candidates: Mary";
        String line2 = "Party: Republican, Candidates: Sunny Rex";
        String line3 = "Party: Reform, Candidates: Bob";
        String line4 = "Party: Green, Candidates: Lily";
        String line5 = "Party: Independent Candidate, Candidates: Joe";
        try {
            Scanner sc = new Scanner(new File(path1));
            Test_system.skipLines(sc, 27);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                line = line.trim();
                if (line.equals(line1) || line.equals(line2) || line.equals(line3) || line.equals(line4) || line.equals(line5)) {
                    System.out.println(line);
                    System.out.println("OPL Summary file PASS");
                } else {
                    System.out.println(line);
                    System.out.println("OPL Summary file FAIL");
                }
            }
        } catch (Exception e) {
        }


        //Test2: Test write summary results to file for CPL
        /* Define voting type and path */
        String votingType2 = "CPL";
        String path2 = "Summary_CPL.txt";

        /* Define candidate ballots */
        ArrayList<Hashtable<String, Integer>> candBallots2 = new ArrayList<>();
        Hashtable<String, Integer> party2a = new Hashtable<>();
        Hashtable<String, Integer> party2b = new Hashtable<>();
        Hashtable<String, Integer> party2c = new Hashtable<>();
        Hashtable<String, Integer> party2d = new Hashtable<>();
        Hashtable<String, Integer> party2e = new Hashtable<>();

        party2a.put("Jack", 1);
        party2a.put("Mary", 2);
        party2b.put("Rex", 3);
        party2b.put("Sunny", 4);
        party2c.put("Tom", 5);
        party2c.put("Bob", 6);
        party2d.put("Lily", 7);
        party2d.put("Brandon", 8);
        party2e.put("Joe", 9);
        party2e.put("Alice", 10);

        candBallots2.add(party2a);
        candBallots2.add(party2b);
        candBallots2.add(party2c);
        candBallots2.add(party2d);
        candBallots2.add(party2e);
        System.out.println(candBallots2);

        /* Define party name string array */
        String[] partyNames2 = {"Democratic", "Republican", "Reform", "Green", "Independent Candidate"};

        /* Define number of seats */
        int numOfSeats2 = 5;

        /* Define winners */
        ArrayList<Hashtable<String, Integer>> results2 = new ArrayList<>();
        Hashtable<String, Integer> party2aa = new Hashtable<>();
        Hashtable<String, Integer> party2bb = new Hashtable<>();
        Hashtable<String, Integer> party2cc = new Hashtable<>();
        Hashtable<String, Integer> party2dd = new Hashtable<>();
        Hashtable<String, Integer> party2ee = new Hashtable<>();

        party2aa.put("Jack", 10);
        party2aa.put("Mary", 20);
        party2bb.put("Rex", 30);
        party2bb.put("Sunny", 40);
        party2cc.put("Tom", 50);
        party2cc.put("Bob", 60);
        party2dd.put("Lily", 70);
        party2dd.put("Brandon", 80);
        party2ee.put("Joe", 90);
        party2ee.put("Alice", 100);

        results2.add(party2aa);
        results2.add(party2bb);
        results2.add(party2cc);
        results2.add(party2dd);
        results2.add(party2ee);
        System.out.println(results2);

        /* Write the summary report */
        mypackage.WriteSummary writeSum2 = new mypackage.WriteSummary();
        writeSum2.writeSummaryReport(path2, votingType2, candBallots2, partyNames2, numOfSeats2, results2);


        /* Read the summary file and check results*/
        String line6 = "Party: Democratic, Candidates: Mary Jack";
        String line7 = "Party: Republican, Candidates: Sunny Rex";
        String line8 = "Party: Reform, Candidates: Bob Tom";
        String line9 = "Party: Green, Candidates: Brandon Lily";
        String line10 = "Party: Independent Candidate, Candidates: Joe Alice";
        try {
            Scanner sc = new Scanner(new File(path2));
            Test_system.skipLines(sc, 27);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                line = line.trim();
                if (line.equals(line6) || line.equals(line7) || line.equals(line8) || line.equals(line9) || line.equals(line10)) {
                    System.out.println(line);
                    System.out.println("CPL Summary file PASS");
                } else {
                    System.out.println(line);
                    System.out.println("CPL Summary file FAIL");
                }
            }
        } catch (Exception e) {
        }
    }
}
