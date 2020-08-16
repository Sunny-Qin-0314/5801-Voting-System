package mypackage;
import java.util.*;
import java.lang.Math.*;

/**
* Process.java: Implement basic functions for both OPL and CPL process, so they can reuse these functions
* @author Yingjin Zhang, Sunny Qin
* @since 2019.11.13
*/
public class Process{
  /**
 * assigned number of seats in party_seats, index corresponds to each party
 * remainers after the first round is kept in remainers array
 */
  private int[] party_seats;
  private int[] remainers;
  private int num_parties;
  /**
 * Create a new process given the number of parties, initialize the party_seats array and remainers array
 */
  public Process(){
  }

  /**
  * This method calculate how many seats are supposed to be assigned to each party based on their votes and total number of seats
 * @param party_names all parties' name
 * @param party_ballots each party votes received corresponds to their party name
 * @param cand_ballots In each party, their candidates' votes received corresponds to their names
 * @param num_ballots total ballots
 * @param num_seats total seats
 * @param auditfile the auditfile name , by default: "audit.txt"
 * @return number of seats assigned for each party
 */
  public int[] allocate_seats(String[] party_names, Hashtable<String,Integer> party_ballots, ArrayList<Hashtable<String, Integer>> cand_ballots, int num_ballots, int num_seats, String auditfile){

    int step = (int) Math.ceil((float) num_ballots/ (float) num_seats);
    int total_seat = 0;
    int remain_parties = party_names.length;
    party_seats = new int[party_names.length];
    remainers = new int[party_names.length];

    WriteAudit audit = new WriteAudit();
    audit.writeAuditFile("Quato: "+ Integer.toString(step), auditfile);
    audit.writeAuditFile("Party names: "+ Arrays.toString(party_names) + "\n", auditfile);
    audit.writeAuditFile("First Round", auditfile);

    // First round
    for(int i = 0; i < party_names.length; i++){
        int cand_num = cand_ballots.get(i).size();
        int party_seat = (int) party_ballots.get(party_names[i])/step;
        int remainer = (int) party_ballots.get(party_names[i])%step;
        // if seats > cand_num
        if(party_seat > cand_num){
          party_seat = cand_num;
          remainer = -1;
          remain_parties--;
          audit.writeAuditFile("Assigned seats > number of candidates : set remainer to -1", auditfile);
        }
        total_seat = total_seat + party_seat;
        party_seats[i] = party_seat;
        remainers[i] = remainer;
    }
    audit.writeAuditFile("The number of party seats assigned after first round (index corresponds to party): "+ Arrays.toString(party_seats), auditfile);
    audit.writeAuditFile("The remainers after first round (index corresponds to party): "+ Arrays.toString(remainers) + "\n", auditfile);

    // more than two Rounds
    int remain_seats = num_seats - total_seat;
    audit.writeAuditFile("Remain seats: "+ Integer.toString(remain_seats), auditfile);
    audit.writeAuditFile("Remain parties: "+ Integer.toString(remain_parties) + "\n", auditfile);
    while(remain_seats >= remain_parties){
      for(int i=0; i<party_names.length;i++){
        int new_cand_num = cand_ballots.get(i).size();
        if (remainers[i] != -1){
          party_seats[i]++;
          if(party_seats[i] > new_cand_num){
            party_seats[i] = new_cand_num;
            remainers[i] = -1;
            remain_parties--;
            remain_seats++;
          }
          remain_seats--;
        }
      }
      audit.writeAuditFile("Remain seats > remain parties (need extra rounds)", auditfile);
      audit.writeAuditFile("Extra Round", auditfile);
      audit.writeAuditFile("The number of party seats assigned after extra round (index corresponds to party): "+ Arrays.toString(party_seats) + "\n", auditfile);
    }
    // Second round
    while(remain_seats != 0){
      audit.writeAuditFile("Second Round", auditfile);

      int max = remainers[0];
      List<Integer> ind = new ArrayList<Integer>();
  		for (int i = 0; i < party_names.length; i++)
  		{
  			if (max < remainers[i])
  			{
  				max = remainers[i];
  			}
  		}
      for (int j = 0; j < party_names.length; j++){
        if (remainers[j] == max){
          ind.add(j);
        }
      }
      // flip coins
      int index = 0;
      if(ind.size() >= 2){
        int i=0;
        Flipcoin rand = new Flipcoin();
        while(i<1001){
          index = rand.random_int(ind);
          i++;
        }
        audit.writeAuditFile("Tie occured, need to flip coin.", auditfile);
        audit.writeAuditFile("Flip Coin", auditfile);
        audit.writeAuditFile("Flip coin winner: " + party_names[index], auditfile);

      }
      else{
        index = ind.get(0);
      }
      party_seats[index]++;

      // party_seat > cand_num
      if(party_seats[index] > cand_ballots.get(index).size()){
        party_seats[index]--;
        remainers[index] = -1;
        remain_parties--;
      }
      else{
        remainers[index] = 0;
        remain_seats--;
      }
      audit.writeAuditFile("The number of party seats assigned after second round (index corresponds to party): "+ Arrays.toString(party_seats) + "\n", auditfile);

    }
    audit.writeAuditFile("Finish allocating seats\n", auditfile);

    return party_seats;
  }

  /**
  * This method display the winners in a table on the screen.
  * The results will include: candidate name, their party, and their ballots received or their rank in party.
 * @param results This winner results should include winners'name and their votes. The index of hashtable corresponds to their party.
 * @param party_names This party names should include all the parties' names.
 * @param num_seats total seats
 */
  public void display_results(ArrayList<Hashtable<String, Integer>> results, String[] party_names, int num_seats){
    final Object[][] table = new String[num_seats+1][];
    table[0] = new String[] { "Candidate", "Party", "Ballots / Rank" };
    int j = 0;
    for(int i =0; i < party_names.length; i++){

      for(Map.Entry<String,Integer> entry: results.get(i).entrySet()){
        String cand = entry.getKey();
        int ballot = entry.getValue();
        table[j+1] = new String[] {cand, party_names[i], Integer.toString(ballot)};
        j++;
      }
    }

    for (final Object[] row : table) {
        System.out.format("%20s%20s%20s\n", row);
      }
  }
}
