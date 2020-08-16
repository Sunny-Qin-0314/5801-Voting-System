import java.util.*;
import mypackage.*;

class Test_process_display{
  public static void main(String[] args){
    //Test 1: Display for OPL
    String[] party_names = new String[3];
    party_names[0] = "D";
    party_names[1] = "G";
    party_names[2] = "I";


    int num_seats = 10;

    ArrayList<Hashtable<String, Integer>> results = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1 = new Hashtable<String, Integer>();
    party1.put("a", 40);
    party1.put("b", 60);
    results.add(party1);
    Hashtable<String, Integer> party2 = new Hashtable<String, Integer>();
    party2.put("c", 50);
    party2.put("d", 90);
    party2.put("e", 110);
    results.add(party2);
    Hashtable<String, Integer> party3 = new Hashtable<String, Integer>();
    party3.put("f", 50);
    party3.put("g", 80);
    party3.put("h", 110);
    party3.put("i", 90);
    party3.put("j", 20);
    results.add(party3);

    System.out.println("Test 1: Display OPL results");
    mypackage.Process p = new mypackage.Process();
    p.display_results(results, party_names,num_seats);



    // Test 2: CPL

    String[] party_names2 = new String[3];
    party_names2[0] = "D";
    party_names2[1] = "G";
    party_names2[2] = "I";

    int num_seats2 = 10;

    ArrayList<Hashtable<String, Integer>> results2 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party12 = new Hashtable<String, Integer>();
    party12.put("a", 1);
    party12.put("b", 2);
    results2.add(party12);
    Hashtable<String, Integer> party22 = new Hashtable<String, Integer>();
    party22.put("c", 2);
    party22.put("d", 1);
    party22.put("e", 3);
    results2.add(party22);
    Hashtable<String, Integer> party32 = new Hashtable<String, Integer>();
    party32.put("f", 4);
    party32.put("g", 5);
    party32.put("h", 1);
    party32.put("i", 2);
    party32.put("j", 3);
    results2.add(party32);

    System.out.println("Test 2: Display CPL results");
    mypackage.Process p2 = new mypackage.Process();
    p2.display_results(results2, party_names2,num_seats2);


  }
}
