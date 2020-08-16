import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import mypackage.*;

public class Test_parser_readBallots{
  public static void main(String[] args) throws FileNotFoundException{
    // Test1: cpl
    mypackage.Parser p = new mypackage.Parser();
    String type = "CPL";
    int num = 6;
    ArrayList<Hashtable<String, Integer>> arr_l = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party_ballots = new Hashtable<String, Integer>();
    party_ballots.put("A",0);
    party_ballots.put("B",0);
    party_ballots.put("C",0);
    party_ballots.put("D",0);
    party_ballots.put("E",0);
    party_ballots.put("F",0);

    arr_l.add(party_ballots);
    ArrayList<String> names = new ArrayList<String>();
    names.add("A");
    names.add("B");
    names.add("C");
    names.add("D");
    names.add("E");
    names.add("F");

    ArrayList<Integer> cand_parties = new ArrayList<Integer>();
    Scanner scanner = new Scanner(new File("test_parser_read_ballots.csv"));
    scanner.useDelimiter("\n");

    mypackage.WriteAudit audit = new mypackage.WriteAudit();

    arr_l= p.read_ballots(type, num, arr_l, names, cand_parties, scanner, audit, "test_cpl_read_ballots.txt");

    String exp1 = "{A=4, F=5, E=3, D=6, C=2, B=10}";
    System.out.println(party_ballots.toString().equals(exp1));

    // Test2: opl
    mypackage.Parser p2 = new mypackage.Parser();
    String type2 = "OPL";
    ArrayList<Hashtable<String, Integer>> arr_l2 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> cand_ballots1 = new Hashtable<String, Integer>();
    Hashtable<String, Integer> cand_ballots2 = new Hashtable<String, Integer>();
    cand_ballots1.put("A",0);
    cand_ballots1.put("B",0);

    cand_ballots2.put("C",0);
    cand_ballots2.put("D",0);
    cand_ballots2.put("E",0);
    cand_ballots2.put("F",0);

    arr_l2.add(cand_ballots1);
    arr_l2.add(cand_ballots2);
    ArrayList<String> names2 = new ArrayList<String>();
    names2.add("A");
    names2.add("B");
    names2.add("C");
    names2.add("D");
    names2.add("E");
    names2.add("F");

    ArrayList<Integer> cand_parties2 = new ArrayList<Integer>();
    cand_parties2.add(0);
    cand_parties2.add(0);
    cand_parties2.add(1);
    cand_parties2.add(1);
    cand_parties2.add(1);
    cand_parties2.add(1);

    Scanner scanner2 = new Scanner(new File("test_parser_read_ballots.csv"));
    scanner2.useDelimiter("\n");

    mypackage.WriteAudit audit2 = new mypackage.WriteAudit();

    arr_l2 = p.read_ballots(type2, num, arr_l2, names2, cand_parties2, scanner2, audit2, "test_opl_read_ballots.txt");
    String exp2 = "[{A=4, B=10}, {F=5, E=3, D=6, C=2}]";
    System.out.println(arr_l2.toString().equals(exp2));

//    System.out.println(arr_l2);


  }
}
