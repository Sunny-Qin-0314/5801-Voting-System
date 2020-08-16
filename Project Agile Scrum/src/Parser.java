package mypackage;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

/**
* Parser.java - a parent class of ParserCPL and ParserOPL to parse the csv file for voting.
* @author  Sunny Qin, Yingjin Zhang
* @since   2019-11-25
*/

public class Parser{
  /**
  *  Constructor for CPL parser
  */
  public Parser(){

  }

  /**
  * parse file, get the useful initial info and save them into an object array
  * @param scanner a file Scanner
  * @param audit a WriteAudit processor
  * @param auditfile auditfile name, by default: "audit.txt"
  * @return An object array that contains num_seats, num_ballots, party_names, party_ballots_l, cand_ballots, cand_parties, num_cand, cand_names
  * @throws FileNotFoundException throws exception when the file does not exists
  */

  public Object[] read_initial_info(Scanner scanner, WriteAudit audit, String auditfile) throws FileNotFoundException{
    int num_seats = Integer.parseInt(scanner.next());
    int num_ballots = Integer.parseInt(scanner.next());
    int num_cand = Integer.parseInt(scanner.next());
    audit.writeAuditFile("number of seats: "+ Integer.toString(num_seats), auditfile);
    audit.writeAuditFile("number of ballots: "+ Integer.toString(num_ballots), auditfile);
    audit.writeAuditFile("number of candidates: "+ Integer.toString(num_cand), auditfile);

    ArrayList<String> party_names = new ArrayList<String>();
    ArrayList<String> cand_names = new ArrayList<String>();
    ArrayList<Integer> cand_parties = new ArrayList<Integer>();
    int j = 0;
    String old_party_name = "Hello";
    ArrayList<Hashtable<String, Integer>> party_ballots_l = new ArrayList<Hashtable<String, Integer>>();
    Hashtable<String, Integer> party_ballots = new Hashtable<String, Integer>();
    Hashtable<String, Integer> cand_party_ballots = new Hashtable<String, Integer>();
    ArrayList<Hashtable<String, Integer>> cand_ballots = new ArrayList<Hashtable<String, Integer>>();
    for(int i=0; i<num_cand; i++){
      String cand = scanner.next();
      cand = cand.substring(1, cand.length()-1);
      String[] cand_party = cand.split(",");
      int cand_rank = 0;
      if (cand_party.length !=2){
        cand_rank = Integer.parseInt(cand_party[2]);
      }
      String cand_name = cand_party[0];
      String party_name = cand_party[1];
      if(!party_name.equals(old_party_name) && old_party_name.equals("Hello")){
        party_names.add(party_name);
        cand_names.add(cand_name);
        cand_parties.add(j);
        party_ballots.put(party_name, 0);
        old_party_name = party_name;
        cand_party_ballots.put(cand_name, cand_rank);
      }
      // Different party's candidate goes into different hashtable
      else if(!party_name.equals(old_party_name) && !old_party_name.equals("Hello")){
        j++;
        party_names.add(party_name);
        cand_names.add(cand_name);
        cand_parties.add(j);
        party_ballots.put(party_name, 0);
        old_party_name = party_name;
        cand_ballots.add(cand_party_ballots);
        cand_party_ballots = new Hashtable<String, Integer>();
        cand_party_ballots.put(cand_name, cand_rank);
      }
      // Same party's candidate goes into same hashtable
      else{
        cand_names.add(cand_name);
        cand_parties.add(j);
        cand_party_ballots.put(cand_name, cand_rank);
      }
      if(i==num_cand-1)
      {
        cand_ballots.add(cand_party_ballots);
      }
    }
    party_ballots_l.add(party_ballots);
    audit.writeAuditFile("Initialize party ballots: "+ party_ballots.toString(), auditfile);
    int k = 0 ;
    for(Hashtable<String, Integer> hash_p: cand_ballots){
    audit.writeAuditFile("Initialize candidate ballots for party "+ party_names.get(k) +": "+ hash_p.toString(), auditfile);
    k++;
    }
    return new Object[] {num_seats, num_ballots, party_names, party_ballots_l, cand_ballots, cand_parties, num_cand, cand_names};
  }


  /**
  * read and counts ballots and save them into an ArrayList of Hashtable
  * @param type a String that indicates the voting type, can be: "OPL" or "CPL"
  * @param num a Interger which is the number of ballots
  * @param arr_l an ArrayList of Hashtable which is party_ballots_l for CPL and cand_ballots for OPL
  * @param names an ArrayList of string of names which is party_names for CPL and cand_names for OPL
  * @param cand_parties an ArrayList of Integer which stores the corresponding party number for each candidate
  * @param scanner a file Scanner
  * @param audit a WriteAudit processor
  * @param auditfile a String of auditfile name, by default: "audit.txt"
  * @return an ArrayList of Hashtable which contains the names and ballots
  */
  public ArrayList<Hashtable<String, Integer>> read_ballots(String type, int num, ArrayList<Hashtable<String, Integer>> arr_l,
                                ArrayList<String> names, ArrayList<Integer> cand_parties, Scanner scanner, WriteAudit audit, String auditfile){
    int index = 0;
    while(scanner.hasNext()){
      String ballot = scanner.next();
      for(int i=0; i<num; i++){
        if (type.equals("OPL")){
          index = cand_parties.get(i);
        }
        if(ballot.substring(i,i+1).equals("1")){
          Hashtable<String, Integer> hash_p = arr_l.get(index);
            for(Map.Entry<String,Integer> entry: hash_p.entrySet()){
              if(entry.getKey().equals(names.get(i))){
                entry.setValue(entry.getValue()+1);
                audit.writeAuditFile(names.get(i) + " votes + 1. Current votes: " + Integer.toString(entry.getValue()), auditfile);

                break;
              }
            }
        }
      }
    }
    return arr_l;

  }


}
