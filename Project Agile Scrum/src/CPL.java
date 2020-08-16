package mypackage;
import java.util.*;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
* CPL.java - a class to generate the voting result for a CPL voting.
*
* @see Process
* @author  Yingjin Zhang, Sunny Qin
* @since   2019-11-13
*/
public class CPL extends Process{
  /**
   * The results of the CPL voting stored in a list of Hashtable
   */
  private ArrayList<Hashtable<String, Integer>> results;

  /* This is a constructor to call Process' constructor with no parameter.*/
  public CPL(){
    super();
  }

  /**
   *This is a method to generate the voting results for CPL voting.
   * @param party_seats a int list contains the numbers of seats of parties.
   * @param cand_ballots a list of Hashtable contains the name of candidats and
   *        their corresponding numbers of ballots.
   * @param auditfile the auditfile name , by default: "audit.txt"
   * @return a list of Hashtable containing the winners' name and their
   *         corresponding numbers of ballots.
   */
  public ArrayList<Hashtable<String, Integer>> generate_result_CPL
    (int[] party_seats, ArrayList<Hashtable<String, Integer>> cand_ballots, String auditfile){
    String cand = "";
    int i = 0;
    ArrayList<Hashtable<String, Integer>> results =
        new ArrayList<Hashtable<String, Integer>>();
    WriteAudit audit = new WriteAudit();
    audit.writeAuditFile("The number of party seats assigned (index corresponds to party): "+ Arrays.toString(party_seats) + "\n", auditfile);
    for(Hashtable<String, Integer> hash_p: cand_ballots){
      audit.writeAuditFile("Candidate rank : "+ hash_p.toString(), auditfile);
    }

    // for each party, find out the winners in the party based on the number of
    // seats allocated to the party.
    for(Hashtable<String, Integer> hash_p: cand_ballots){
      int party_seat = party_seats[i];
      Hashtable<String, Integer> party_result = new Hashtable<String, Integer>();
      // If there is any seat remaining in a party, add the next highest rank
      // candidate to the reult of the party.
      while(party_seat != 0){
        int min = Collections.min(hash_p.values());
        List<String> cands = new ArrayList<String>();
        // traverse all candidates in a party.
        for(Map.Entry<String,Integer> entry: hash_p.entrySet()){
          if(entry.getValue().equals(min)){
            cands.add(entry.getKey());
          }
        }
        // Tie occurred, flip coin
        if(cands.size() >= 2){
          Flipcoin rand = new Flipcoin();
          // Generate random ind
          int j = 0;
          while(j<1001){
            cand = rand.random_str(cands);
            j++;
          }
          audit.writeAuditFile("Tie occured, need to flip coin.", auditfile);
          audit.writeAuditFile("Flip Coin", auditfile);
          audit.writeAuditFile("Flip coin winner: " + cand, auditfile);

        }
        else{
          cand = cands.get(0);
        }
        party_result.put(cand,min);
        hash_p.replace(cand, 100000);
        party_seat--;
      }
      i++;
      // add the result of each party to our final result list.
      results.add(party_result);
    }
    int n = 0 ;
    for(Hashtable<String, Integer> hash_p: results){
      audit.writeAuditFile("Winners for parties with their total votes: " + hash_p.toString(), auditfile);
      n++;
    }

    return results;
  }

}
