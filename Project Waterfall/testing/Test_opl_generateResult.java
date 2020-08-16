import java.util.*;
import mypackage.*;

class Test_opl_generateResult{
  public static void main(String[] args){

    // Test 1: Regular OPL
    System.out.println("Test 1: Regular");
    mypackage.OPL p = new mypackage.OPL();

    ArrayList<Hashtable<String, Integer>> cand_ballots = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1 = new Hashtable<String, Integer>();
    party1.put("a", 100);
    party1.put("b", 200);
    cand_ballots.add(party1);
    Hashtable<String, Integer> party2 = new Hashtable<String, Integer>();
    party2.put("c", 220);
    party2.put("d", 120);
    party2.put("e", 330);
    cand_ballots.add(party2);
    Hashtable<String, Integer> party3 = new Hashtable<String, Integer>();
    party3.put("f", 410);
    party3.put("g", 520);
    party3.put("h", 120);
    party3.put("i", 220);
    party3.put("j", 330);
    cand_ballots.add(party3);

    int[] ps = new int[3];
    ps[0] = 1;
    ps[1] = 2;
    ps[2] = 3;

    ArrayList<Hashtable<String, Integer>> results = p.generate_result_OPL(ps, cand_ballots,"audit.txt");

    System.out.println(results.get(0).get("a"));
    System.out.println(results.get(0).get("b"));

    System.out.println(results.get(1).get("c"));
    System.out.println(results.get(1).get("d"));
    System.out.println(results.get(1).get("e"));

    System.out.println(results.get(2).get("f"));
    System.out.println(results.get(2).get("g"));
    System.out.println(results.get(2).get("h"));
    System.out.println(results.get(2).get("i"));
    System.out.println(results.get(2).get("j") + "\n");

    // Test 2: Regular OPL with 0 seat for a party
    System.out.println("Test 2: 0 seat");

    mypackage.OPL p2 = new mypackage.OPL();

    ArrayList<Hashtable<String, Integer>> cand_ballots2 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1_2 = new Hashtable<String, Integer>();
    party1_2.put("a", 100);
    party1_2.put("b", 200);
    cand_ballots2.add(party1_2);
    Hashtable<String, Integer> party2_2 = new Hashtable<String, Integer>();
    party2_2.put("c", 200);
    party2_2.put("d", 100);
    party2_2.put("e", 330);
    cand_ballots2.add(party2_2);
    Hashtable<String, Integer> party3_2 = new Hashtable<String, Integer>();
    party3_2.put("f", 440);
    party3_2.put("g", 510);
    party3_2.put("h", 100);
    party3_2.put("i", 200);
    party3_2.put("j", 330);
    cand_ballots2.add(party3_2);

    int[] ps2 = new int[3];
    ps2[0] = 0;
    ps2[1] = 2;
    ps2[2] = 3;

    ArrayList<Hashtable<String, Integer>> results2 = p2.generate_result_OPL(ps2, cand_ballots2,"audit.txt");

    System.out.println(results2.get(0).get("a"));
    System.out.println(results2.get(0).get("b"));

    System.out.println(results2.get(1).get("c"));
    System.out.println(results2.get(1).get("d"));
    System.out.println(results2.get(1).get("e"));

    System.out.println(results2.get(2).get("f"));
    System.out.println(results2.get(2).get("g"));
    System.out.println(results2.get(2).get("h"));
    System.out.println(results2.get(2).get("i"));
    System.out.println(results2.get(2).get("j") + "\n");

    //Test 3 : Two candidate tie occurred. Flip coin once.
    System.out.println("Test 3: Tie");

    mypackage.OPL p3 = new mypackage.OPL();

    ArrayList<Hashtable<String, Integer>> cand_ballots3 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1_3 = new Hashtable<String, Integer>();
    party1_3.put("a", 100);
    party1_3.put("b", 100);
    cand_ballots3.add(party1_3);
    Hashtable<String, Integer> party2_3 = new Hashtable<String, Integer>();
    party2_3.put("c", 200);
    party2_3.put("d", 200);
    party2_3.put("e", 330);
    cand_ballots3.add(party2_3);
    Hashtable<String, Integer> party3_3 = new Hashtable<String, Integer>();
    party3_3.put("f", 440);
    party3_3.put("g", 440);
    party3_3.put("h", 100);
    party3_3.put("i", 200);
    party3_3.put("j", 330);
    cand_ballots3.add(party3_3);

    int[] ps3 = new int[3];
    ps3[0] = 1;
    ps3[1] = 2;
    ps3[2] = 3;

    ArrayList<Hashtable<String, Integer>> results3 = p3.generate_result_OPL(ps3, cand_ballots3,"audit.txt");

    System.out.println(results3.get(0).get("a"));
    System.out.println(results3.get(0).get("b"));

    System.out.println(results3.get(1).get("c"));
    System.out.println(results3.get(1).get("d"));
    System.out.println(results3.get(1).get("e"));

    System.out.println(results3.get(2).get("f"));
    System.out.println(results3.get(2).get("g"));
    System.out.println(results3.get(2).get("h"));
    System.out.println(results3.get(2).get("i"));
    System.out.println(results3.get(2).get("j") + "\n");

    //Test 4 : Three candidate tie occurred. Flip coin twice.
    System.out.println("Test 4: More Tie");

    mypackage.OPL p4 = new mypackage.OPL();

    ArrayList<Hashtable<String, Integer>> cand_ballots4 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1_4 = new Hashtable<String, Integer>();
    party1_4.put("a", 100);
    party1_4.put("b", 150);
    cand_ballots4.add(party1_4);
    Hashtable<String, Integer> party2_4 = new Hashtable<String, Integer>();
    party2_4.put("c", 200);
    party2_4.put("d", 200);
    party2_4.put("e", 200);
    cand_ballots4.add(party2_4);
    Hashtable<String, Integer> party3_4 = new Hashtable<String, Integer>();
    party3_4.put("f", 440);
    party3_4.put("g", 440);
    party3_4.put("h", 100);
    party3_4.put("i", 440);
    party3_4.put("j", 530);
    cand_ballots4.add(party3_4);

    int[] ps4 = new int[3];
    ps4[0] = 1;
    ps4[1] = 1;
    ps4[2] = 3;

    ArrayList<Hashtable<String, Integer>> results4 = p4.generate_result_OPL(ps4, cand_ballots4,"audit.txt");

    System.out.println(results4.get(0).get("a"));
    System.out.println(results4.get(0).get("b"));

    System.out.println(results4.get(1).get("c"));
    System.out.println(results4.get(1).get("d"));
    System.out.println(results4.get(1).get("e"));

    System.out.println(results4.get(2).get("f"));
    System.out.println(results4.get(2).get("g"));
    System.out.println(results4.get(2).get("h"));
    System.out.println(results4.get(2).get("i"));
    System.out.println(results4.get(2).get("j") + "\n");

  }
}
