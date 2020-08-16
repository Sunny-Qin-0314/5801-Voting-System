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

      String[] party_names = (String[]) info[2];
      Hashtable<String,Integer> party_ballots = (Hashtable<String,Integer>) info[3];
      ArrayList<Hashtable<String, Integer>> cand_ballots = (ArrayList<Hashtable<String, Integer>>) info[4];
      int num_ballots = (int) info[1];
      int num_seats = (int) info[0];

      mypackage.CPL p = new mypackage.CPL();
      int[] party_seats = p.allocate_seats(party_names, party_ballots, cand_ballots, num_ballots, num_seats,"audit.txt");
      ArrayList<Hashtable<String, Integer>> results = p.generate_result_CPL(party_seats, cand_ballots,"audit.txt");
      p.display_results(results, party_names, num_seats);
      mypackage.WriteSummary w = new mypackage.WriteSummary();
      w.writeSummaryReport(output, "CPL", party_ballots, party_names, results);
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
      w.writeSummaryReport(output, "OPL", party_ballots, party_names_arr, results);
    }


  }

}
