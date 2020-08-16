package mypackage;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

/**
* ParserCPL.java - a class to parse the csv file for CPL voting.
* @author  Yingjin Zhang
* @since   2019-11-16
*/
public class ParserCPL{
  /**
  *  Constructor for CPL parser
  */
  public ParserCPL(){
  }

  /**
  * parse file for CPL process, get the useful info, count ballots and save them into an object array
  * @param filename Input csv filename, ex. "voting.csv"
  * @param auditfile auditfile name, by default: "audit.txt"
  * @return An object array that contains num_seats, num_ballots, party_names, party_ballots, cand_ballots
  * @throws FileNotFoundException
  */
  public static Object[] parse_cpl(String filename, String auditfile) throws FileNotFoundException{
    Scanner scanner = new Scanner(new File(filename));
    scanner.useDelimiter("\n");
    String type = scanner.next();
    WriteAudit audit = new WriteAudit();
    File file = new File(auditfile);
    file.delete();

    audit.writeAuditFile(type, auditfile);

    // Get useful info line by line until arrive the specific ballot
    int num_parties = Integer.parseInt(scanner.next());
    audit.writeAuditFile("number of parties: "+ Integer.toString(num_parties), auditfile);
    String parties = scanner.next();
    audit.writeAuditFile("Parties: "+ parties, auditfile);

    parties = parties.substring(1, parties.length()-1);
    String[] party_names;
    party_names = parties.split(",");

    int num_seats = Integer.parseInt(scanner.next());
    audit.writeAuditFile("number of seats: "+ Integer.toString(num_seats), auditfile);

    int num_ballots = Integer.parseInt(scanner.next());
    audit.writeAuditFile("number of ballots: "+ Integer.toString(num_ballots), auditfile);

    int num_cand = Integer.parseInt(scanner.next());
    audit.writeAuditFile("number of candidates: "+ Integer.toString(num_cand), auditfile);

    // Parser candidate list, convert them into required type, and initialize them with 0 votes at this step
    ArrayList<String> cand_names = new ArrayList<String>();
    String old_party_name = "Hello";
    Hashtable<String, Integer> party_ballots = new Hashtable<String, Integer>();
    Hashtable<String, Integer> cand_party_ballots = new Hashtable<String, Integer>();
    ArrayList<Hashtable<String, Integer>> cand_ballots = new ArrayList<Hashtable<String, Integer>>();
    for(int i=0; i<num_cand; i++){
      String cand = scanner.next();
      cand = cand.substring(1, cand.length()-1);
      String[] cand_party = cand.split(",");
      String cand_name = cand_party[0];
      String party_name = cand_party[1];
      int cand_rank = Integer.parseInt(cand_party[2]);

      if(!party_name.equals(old_party_name) && old_party_name.equals("Hello")){
        cand_names.add(cand_name);
        party_ballots.put(party_name, 0);
        old_party_name = party_name;
        cand_party_ballots.put(cand_name, cand_rank);
      }

      // Different party's candidate goes into different hashtable
      else if(!party_name.equals(old_party_name) && !old_party_name.equals("Hello")){

        cand_names.add(cand_name);
        party_ballots.put(party_name, 0);
        old_party_name = party_name;
        cand_ballots.add(cand_party_ballots);
        cand_party_ballots = new Hashtable<String, Integer>();
        cand_party_ballots.put(cand_name, cand_rank);
      }
      // Same party's candidate goes into same hashtable
      else{
        cand_names.add(cand_name);
        cand_party_ballots.put(cand_name, cand_rank);
      }
      if(i==num_cand-1)
      {
        cand_ballots.add(cand_party_ballots);
      }
    }

    audit.writeAuditFile("Initialize party ballots: "+ party_ballots.toString(), auditfile);
    int j = 0 ;
    for(Hashtable<String, Integer> hash_p: cand_ballots){

      audit.writeAuditFile("Candidate rank for party "+ party_names[j] +": "+ hash_p.toString(), auditfile);
      j++;
    }

    // Parse ballots, add 1 to corresponding party
    while(scanner.hasNext()){
      String ballot = scanner.next();
      for(int i=0; i<num_parties; i++){
        if(ballot.substring(i,i+1).equals("1")){
            for(Map.Entry<String,Integer> entry: party_ballots.entrySet()){
              if(entry.getKey().equals(party_names[i])){
                entry.setValue(entry.getValue()+1);
                audit.writeAuditFile("Party "+ party_names[i] + " votes + 1. Current votes: " + Integer.toString(entry.getValue()), auditfile);

                break;
              }
            }
        }
      }
    }

    audit.writeAuditFile("Parser results: "+ party_ballots.toString() + "\n", auditfile);


    return new Object[] {num_seats, num_ballots, party_names, party_ballots, cand_ballots};
  }


}
