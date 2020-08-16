import java.util.*;
import mypackage.*;

class Test_cpl_generateResult{
  public static void main(String[] args){

    // Test 1: Regular CPL
    System.out.println("Test 1: Regular");
    mypackage.CPL p = new mypackage.CPL();

    ArrayList<Hashtable<String, Integer>> cand_ballots = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1 = new Hashtable<String, Integer>();
    party1.put("a", 1);
    party1.put("b", 2);
    cand_ballots.add(party1);
    Hashtable<String, Integer> party2 = new Hashtable<String, Integer>();
    party2.put("c", 2);
    party2.put("d", 1);
    party2.put("e", 3);
    cand_ballots.add(party2);
    Hashtable<String, Integer> party3 = new Hashtable<String, Integer>();
    party3.put("f", 4);
    party3.put("g", 5);
    party3.put("h", 1);
    party3.put("i", 2);
    party3.put("j", 3);
    cand_ballots.add(party3);

    int[] ps = new int[3];
    ps[0] = 1;
    ps[1] = 2;
    ps[2] = 3;

    ArrayList<Hashtable<String, Integer>> results = p.generate_result_CPL(ps, cand_ballots,"audit.txt");

    System.out.println(results.get(0).get("a"));
    System.out.println(results.get(0).get("b"));

    System.out.println(results.get(1).get("c"));
    System.out.println(results.get(1).get("d"));
    System.out.println(results.get(1).get("e"));

    System.out.println(results.get(2).get("f"));
    System.out.println(results.get(2).get("g"));
    System.out.println(results.get(2).get("h"));
    System.out.println(results.get(2).get("i"));
    System.out.println(results.get(2).get("j"));
    // System.out.println("\n");
    // Test 2: Regular CPL with 0 seat for a party
    System.out.println("Test 2: 0 seat");

    mypackage.CPL p2 = new mypackage.CPL();

    ArrayList<Hashtable<String, Integer>> cand_ballots2 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1_2 = new Hashtable<String, Integer>();
    party1_2.put("a", 1);
    party1_2.put("b", 2);
    cand_ballots2.add(party1_2);
    Hashtable<String, Integer> party2_2 = new Hashtable<String, Integer>();
    party2_2.put("c", 2);
    party2_2.put("d", 1);
    party2_2.put("e", 3);
    cand_ballots2.add(party2_2);
    Hashtable<String, Integer> party3_2 = new Hashtable<String, Integer>();
    party3_2.put("f", 4);
    party3_2.put("g", 5);
    party3_2.put("h", 1);
    party3_2.put("i", 2);
    party3_2.put("j", 3);
    cand_ballots2.add(party3_2);

    int[] ps2 = new int[3];
    ps2[0] = 0;
    ps2[1] = 2;
    ps2[2] = 3;

    ArrayList<Hashtable<String, Integer>> results2 = p2.generate_result_CPL(ps2, cand_ballots2,"audit.txt");

    System.out.println(results2.get(0).get("a"));
    System.out.println(results2.get(0).get("b"));

    System.out.println(results2.get(1).get("c"));
    System.out.println(results2.get(1).get("d"));
    System.out.println(results2.get(1).get("e"));

    System.out.println(results2.get(2).get("f"));
    System.out.println(results2.get(2).get("g"));
    System.out.println(results2.get(2).get("h"));
    System.out.println(results2.get(2).get("i"));
    System.out.println(results2.get(2).get("j"));


  }
}
