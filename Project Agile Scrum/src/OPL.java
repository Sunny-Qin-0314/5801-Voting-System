package mypackage;
import java.util.*;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
* OPL.java - a class to generate the voting result for a OPL voting.
*
* @see Process
* @author  Yingjin Zhang, Sunny Qin
* @since   2019-11-13
*/

public class OPL extends Process{
    /**
   * The results of the OPL voting stored in a list of Hashtable
   */
  private ArrayList<Hashtable<String, Integer>> results;

  /*Initialize OPL by inheriting process*/
  public OPL(){
    super();
  }

  /**
  * This method generates the winners by using their votes and seats assigned to them.
  * @param party_seats The number of seats assigned to each party. This parameter requires an integer array with No. of seats for each party.
 * @param cand_ballots In each party, their candidates' votes received corresponds to their names.
 * @param auditfile the auditfile name , by default: "audit.txt"
 * @return the winners and their votes for each party
 */

  public ArrayList<Hashtable<String, Integer>> generate_result_OPL(int[] party_seats, ArrayList<Hashtable<String, Integer>> cand_ballots, String auditfile){
    String cand = "";
    int i = 0;
    ArrayList<Hashtable<String, Integer>> results =
        new ArrayList<Hashtable<String, Integer>>();

    WriteAudit audit = new WriteAudit();
    audit.writeAuditFile("The number of party seats assigned (index corresponds to party): "+ Arrays.toString(party_seats) + "\n", auditfile);
    int k = 0 ;
    for(Hashtable<String, Integer> hash_p: cand_ballots){

      audit.writeAuditFile("Candidate votes : "+ hash_p.toString(), auditfile);
      k++;
    }
    // Traverse each party's candidate info , generate result for each party
    for(Hashtable<String, Integer> hash_p: cand_ballots){
      int party_seat = party_seats[i];
      Hashtable<String, Integer> party_result = new Hashtable<String, Integer>();

      // find the max votes in each party
      while(party_seat != 0){
        int max = Collections.max(hash_p.values());
        List<String> cands = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry: hash_p.entrySet()){
          if(entry.getValue().equals(max)){
            cands.add(entry.getKey());
          }
        }

        // Tie occurred: two more candidates have same votes
        if(cands.size() >= 2){
          Flipcoin rand = new Flipcoin();
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
        // put candidate name and their votes in corresponding party index
        party_result.put(cand,max);
        hash_p.replace(cand, 0);
        party_seat--;
      }
      i++;
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
