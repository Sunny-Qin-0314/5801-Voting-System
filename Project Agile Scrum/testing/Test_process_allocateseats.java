import java.util.*;
import mypackage.*;

class Test_process_allocateseats{
  public static void main(String[] args){
    //Test 1: Regular case, no AC or EX   124
    mypackage.Process p = new mypackage.Process();
    String[] party_names = new String[3];
    party_names[0] = "1";
    party_names[1] = "2";
    party_names[2] = "3";

    Hashtable<String,Integer> party_ballots = new Hashtable<String, Integer>();
    party_ballots.put("1",100);
    party_ballots.put("2",230);
    party_ballots.put("3",350);

    ArrayList<Hashtable<String, Integer>> cand_ballots = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1_3 = new Hashtable<String, Integer>();
    party1_3.put("a", 100);
    party1_3.put("b", 100);
    party1_3.put("k", 100);
    cand_ballots.add(party1_3);
    Hashtable<String, Integer> party2_3 = new Hashtable<String, Integer>();
    party2_3.put("c", 200);
    party2_3.put("d", 200);
    party2_3.put("e", 330);
    cand_ballots.add(party2_3);
    Hashtable<String, Integer> party3_3 = new Hashtable<String, Integer>();
    party3_3.put("f", 350);
    party3_3.put("g", 440);
    party3_3.put("h", 100);
    party3_3.put("i", 200);
    party3_3.put("j", 330);
    cand_ballots.add(party3_3);


    int num_seats = 7;
    int num_ballots = 680;

    int[] party_seats= p.allocate_seats(party_names, party_ballots, cand_ballots, num_ballots, num_seats,"audit.txt");
    int[] s = {1, 2, 4};
    System.out.println("Test 1: Regular case, no AC or EX");
    if(party_seats[0] == s[0] && party_seats[1] == s[1] && party_seats[2] == s[2])
      System.out.println("true");
    else
      System.out.println("false");

//    System.out.println("party 1 :"+ party_seats[0]);
//    System.out.println("party 2: " + party_seats[1]);
//    System.out.println("party 3: "+ party_seats[2]+ "\n");


    // Test 2: Tie(two parties) occurred, need to flip coins   124/133
    mypackage.Process p2 = new mypackage.Process();
    String[] party_names2 = new String[3];
    party_names2[0] = "1";
    party_names2[1] = "2";
    party_names2[2] = "3";

    Hashtable<String,Integer> party_ballots2 = new Hashtable<String, Integer>();
    party_ballots2.put("1",100);
    party_ballots2.put("2",250);
    party_ballots2.put("3",350);

    int num_seats2 = 7;
    int num_ballots2 = 700;

    int[] party_seats2= p2.allocate_seats(party_names2, party_ballots2, cand_ballots, num_ballots2, num_seats2,"audit.txt");
    System.out.println("Test 2: Tie(two parties) occurred, need to flip coins");

//    System.out.println("party 1 :"+ party_seats2[0]);
//    System.out.println("party 2: " + party_seats2[1]);
//    System.out.println("party 3: "+ party_seats2[2] + "\n");

    int[] s2 = {1, 3, 3};
    if(party_seats2[0] == s2[0] && party_seats2[1] == s2[1] && party_seats2[2] == s2[2])
      System.out.println("true");
    else
      System.out.println("false");


    // Test 3: Tie occurred, need to flip coins twice   233/332/323
    mypackage.Process p3 = new mypackage.Process();
    String[] party_names3 = new String[3];
    party_names3[0] = "1";
    party_names3[1] = "2";
    party_names3[2] = "3";

    Hashtable<String,Integer> party_ballots3 = new Hashtable<String, Integer>();
    party_ballots3.put("1",270);
    party_ballots3.put("2",270);
    party_ballots3.put("3",270);

    int num_seats3 = 8;
    int num_ballots3 = 810;

    int[] party_seats3= p3.allocate_seats(party_names3, party_ballots3, cand_ballots, num_ballots3, num_seats3,"audit.txt");
    System.out.println("Test 3: Tie(three more parties) occurred, need to flip coins more than once");
//    System.out.println("party 1 :"+ party_seats3[0]);
//    System.out.println("party 2: " + party_seats3[1]);
//    System.out.println("party 3: "+ party_seats3[2] + "\n");
    int[] s3 = {3, 2, 3};

    if(party_seats3[0] == s3[0] && party_seats3[1] == s3[1] && party_seats3[2] == s3[2])
      System.out.println("true");
    else
      System.out.println("false");


    // Test 4: two passes / cand_num < seats (second round assigned seats > parties number, need an extra round) after first allocation
    // 221
    mypackage.Process p4 = new mypackage.Process();
    String[] party_names4 = new String[3];
    party_names4[0] = "1";
    party_names4[1] = "2";
    party_names4[2] = "3";


    Hashtable<String,Integer> party_ballots4 = new Hashtable<String, Integer>();
    party_ballots4.put("1",1);
    party_ballots4.put("2",2);
    party_ballots4.put("3",1004);

    ArrayList<Hashtable<String, Integer>> cand_ballots2 = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party1_2 = new Hashtable<String, Integer>();
    party1_2.put("a", 100);
    party1_2.put("b", 100);
    party1_2.put("g", 100);
    cand_ballots2.add(party1_2);
    Hashtable<String, Integer> party2_2 = new Hashtable<String, Integer>();
    party2_2.put("c", 200);
    party2_2.put("d", 200);
    party2_2.put("e", 330);
    cand_ballots2.add(party2_2);
    Hashtable<String, Integer> party3_2 = new Hashtable<String, Integer>();
    party3_2.put("f", 350);
    cand_ballots2.add(party3_2);

    int num_seats4 = 4;
    int num_ballots4 = 1007;

    int[] party_seats4= p4.allocate_seats(party_names4, party_ballots4, cand_ballots2, num_ballots4, num_seats4,"audit.txt");
    System.out.println("Test 4: two passes (second round assigned seats > parties number, need an extra round) after first allocation");
//    System.out.println("party 1 :"+ party_seats4[0]);
//    System.out.println("party 2: "+ party_seats4[1]);
//    System.out.println("party 3: "+ party_seats4[2]);

    int[] s4 = {1, 2, 1};

    if(party_seats4[0] == s4[0] && party_seats4[1] == s4[1] && party_seats4[2] == s4[2])
      System.out.println("true");
    else
      System.out.println("false");


  }
}
