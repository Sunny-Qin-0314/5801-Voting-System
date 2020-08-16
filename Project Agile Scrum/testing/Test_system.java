import java.io.FileInputStream;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import mypackage.*;

public class Test_system{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner s = new Scanner(System.in);
    System.out.println("Please enter an input voting file name");
    String filename = s.next();
    System.out.println("Please enter an output summary file name");
    String output = s.next();
    File file = new File(output);
    file.delete();
    Scanner scanner = new Scanner(new File(filename));
    scanner.useDelimiter("\n");
    String type = scanner.next();
    // type = type.substring(1,type.length());
    for (int i = 0; i < type.length(); i++){
      // String char = type.substring(i,i+1);
      if (type.substring(i,i+1).equals("C") || type.substring(i,i+1).equals("O")){
        type = type.substring(i,type.length());
      }
    }

    System.out.println(type);
    Object[] info = new Object[5];
    if (type.equals("CPL")){

      try{
        mypackage.ParserCPL parser = new mypackage.ParserCPL();
        info= parser.parse_cpl(filename,"audit.txt");
        // System.out.println(Arrays.toString(info));

      }
      catch (FileNotFoundException e) {
              System.err.println("Unable to find input file: ");
              System.err.println("Terminating...");
              System.exit(3);
            }


      ArrayList<String> party_names = (ArrayList<String>) info[2];

      Hashtable<String,Integer> party_ballots = (Hashtable<String,Integer>) info[3];
      ArrayList<Hashtable<String, Integer>> cand_ballots = (ArrayList<Hashtable<String, Integer>>) info[4];
      int num_ballots = (int) info[1];
      int num_seats = (int) info[0];

      String[] party_names_arr = new String[party_names.size()];

      for(int j = 0 ; j < party_names.size(); j ++){
        party_names_arr[j] = party_names.get(j);
      }


      mypackage.CPL p = new mypackage.CPL();
      int[] party_seats = p.allocate_seats(party_names_arr, party_ballots, cand_ballots, num_ballots, num_seats,"audit.txt");
      ArrayList<Hashtable<String, Integer>> results = p.generate_result_CPL(party_seats, cand_ballots,"audit.txt");
      p.display_results(results, party_names_arr, num_seats);
      mypackage.WriteSummary w = new mypackage.WriteSummary();
      w.writeSummaryReport(output, "CPL", cand_ballots, party_names_arr, num_seats, results);
    }
    else{
      try{
        mypackage.ParserOPL parser = new mypackage.ParserOPL();
        info= parser.parse_opl(filename,"audit.txt");
        // System.out.println(Arrays.toString(info));

      }
      catch (FileNotFoundException e) {
              System.err.println("Unable to find input file: ");
              System.err.println("Terminating...");
              System.exit(3);
            }

      ArrayList<String> party_names = (ArrayList<String>) info[2];
      Hashtable<String,Integer> party_ballots = (Hashtable<String,Integer>) info[3];
      ArrayList<Hashtable<String, Integer>> cand_ballots = (ArrayList<Hashtable<String, Integer>>) info[4];
      int num_ballots = (int) info[1];
      int num_seats = (int) info[0];

      String[] party_names_arr = new String[party_names.size()];

      for(int j = 0 ; j < party_names.size(); j ++){
        party_names_arr[j] = party_names.get(j);
      }


      mypackage.OPL p = new mypackage.OPL();
      int[] party_seats = p.allocate_seats(party_names_arr, party_ballots, cand_ballots, num_ballots, num_seats,"audit.txt");
      ArrayList<Hashtable<String, Integer>> results = p.generate_result_OPL(party_seats, cand_ballots,"audit.txt");
      p.display_results(results, party_names_arr, num_seats);
      mypackage.WriteSummary w = new mypackage.WriteSummary();
      w.writeSummaryReport(output, "OPL", cand_ballots, party_names_arr, num_seats, results);
    }

    // Test 1: compare output results with expected results when input file is test_opl_reg.csv
    // Voting type: OPL. Regular ballots.
    if (filename.equals("test_opl_reg.csv")) {
      String line1 = "Party: D, Candidates: Foster";
      String line2 = "Party: R, Candidates: Borg";
      String line3 = "Party: I, Candidates: Smith";
      String line4 = "Winners for parties with their total votes: {Foster=10}";
      String line5 = "Winners for parties with their total votes: {Borg=6}";
      String line6 = "Winners for parties with their total votes: {Smith=5}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 19);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1) || line.equals(line2) || line.equals(line3)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 60);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4) || lineAudit.equals(line5) || lineAudit.equals(line6)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

    // Test 2: compare output results with expected results when input file is test_cpl_reg.csv
    // Voting type: CPL. Regular ballots.
    if (filename.equals("test_cpl_reg.csv")) {
      String line1 = "Party: D, Candidates: Pike";
      String line2 = "Party: R, Candidates: Deutsch";
      String line3 = "Party: I, Candidates: Smith";
      String line4 = "Winners for parties with their total votes: {Pike=1}";
      String line5 = "Winners for parties with their total votes: {Deutsch=1}";
      String line6 = "Winners for parties with their total votes: {Smith=1}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 19);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1) || line.equals(line2) || line.equals(line3)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 62);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4) || lineAudit.equals(line5) || lineAudit.equals(line6)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

    // Test 3: compare output results with expected results when input file is test_opl_tie.csv
    // Voting type: OPL. There is a tie between 2 candidates
    if (filename.equals("test_opl_tie.csv")) {
      String line1 = "Party: D, Candidates: Foster";
      String line2 = "Party: R, Candidates: Borg";
      String line3a = "Party: I, Candidates: Pike";
      String line3b = "Party: I, Candidates: Smith";
      String line4 = "Winners for parties with their total votes: {Foster=9}";
      String line5 = "Winners for parties with their total votes: {Borg=6}";
      String line6a = "Winners for parties with their total votes: {Pike=5}";
      String line6b = "Winners for parties with their total votes: {Smith=5}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 19);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1) || line.equals(line2) || line.equals(line3a) || line.equals(line3b)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 60);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4) || lineAudit.equals(line5) || lineAudit.equals(line6a) || lineAudit.equals(line6b)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

    // Test 4: compare output results with expected results when input file is test_cpl_tie.csv
    // Voting type: CPL. There is a tie between 2 parties
    if (filename.equals("test_cpl_tie.csv")) {
      String line1a = "Party: D, Candidates:";
      String line1b = "Party: D, Candidates: Pike";
      String line2a = "Party: R, Candidates:";
      String line2b = "Party: R, Candidates: Deutsch";
      String line3 = "Party: I, Candidates: Smith";
      String line4a = "Winners for parties with their total votes: {}";
      String line4b = "Winners for parties with their total votes: {Pike=1}";
      String line5a = "Winners for parties with their total votes: {}";
      String line5b = "Winners for parties with their total votes: {Deutsch=1}";
      String line6 = "Winners for parties with their total votes: {Smith=1}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 19);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1a) || line.equals(line1b) || line.equals(line2a) || line.equals(line2b) || line.equals(line3)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 68);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4a) || lineAudit.equals(line4b) || lineAudit.equals(line5a) || lineAudit.equals(line5b) || lineAudit.equals(line6)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

    // Test 5: compare output results with expected results when input file is test_opl_sameName.csv
    // Voting type: OPL. In this case, two people from different parties have the same name
    if (filename.equals("test_opl_sameName.csv")) {
      String line1 = "Party: D, Candidates: Foster";
      String line2 = "Party: R, Candidates: Borg";
      String line3 = "Party: I, Candidates: Walters";
      String line4 = "Winners for parties with their total votes: {Foster=10}";
      String line5 = "Winners for parties with their total votes: {Borg=6}";
      String line6 = "Winners for parties with their total votes: {Walters=5}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 19);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1) || line.equals(line2) || line.equals(line3)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 60);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4) || lineAudit.equals(line5) || lineAudit.equals(line6)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

    // Test 6: compare output results with expected results when input file is test_cpl_sameName.csv
    // Voting type: CPL. In this case, two people from different parties have the same name
    if (filename.equals("test_cpl_sameName.csv")) {
      String line1 = "Party: D, Candidates: Pike";
      String line2 = "Party: R, Candidates: Deutsch";
      String line3 = "Party: I, Candidates: Walters";
      String line4 = "Winners for parties with their total votes: {Pike=1}";
      String line5 = "Winners for parties with their total votes: {Deutsch=1}";
      String line6 = "Winners for parties with their total votes: {Walters=1}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 19);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1) || line.equals(line2) || line.equals(line3)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 62);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4) || lineAudit.equals(line5) || lineAudit.equals(line6)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

    // Test 7: compare output results with expected results when input file is test_cpl_reg_error.csv
    // Voting type: CPL. In this case, two people from the same party have the same name
    if (filename.equals("test_cpl_reg_error.csv")) {
      String line1 = "Party: D, Candidates: Pike";
      String line2 = "Party: R, Candidates: Deutsch";
      String line3 = "Party: I, Candidates: Smith";
      String line4 = "Winners for parties with their total votes: {Pike=2}";
      String line5 = "Winners for parties with their total votes: {Deutsch=1}";
      String line6 = "Winners for parties with their total votes: {Smith=1}";
      try {
        Scanner sc = new Scanner(new File(output));
        skipLines(sc, 18);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          line = line.trim();
          if (line.equals(line1) || line.equals(line2) || line.equals(line3)) {
            System.out.println(line);
            System.out.println("Summary file PASS");
          } else {
            System.out.println(line);
            System.out.println("Summary file FAIL");
          }
        }

        Scanner scAudit = new Scanner(new File("audit.txt"));
        skipLines(scAudit, 62);
        while (scAudit.hasNextLine()) {
          String lineAudit = scAudit.nextLine();
          lineAudit = lineAudit.trim();
          if (lineAudit.equals(line4) || lineAudit.equals(line5) || lineAudit.equals(line6)) {
            System.out.println(lineAudit);
            System.out.println("Audit file PASS");
          } else {
            System.out.println(lineAudit);
            System.out.println("Audit file FAIL");
          }
        }
      } catch (Exception e) {
      }
    }

  }

  public static void skipLines(Scanner s, int lineNum) {
    for(int i = 0; i < lineNum; i++) {
      if(s.hasNextLine()) s.nextLine();
    }
  }

}
