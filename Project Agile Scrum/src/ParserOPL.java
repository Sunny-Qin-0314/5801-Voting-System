package mypackage;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

/**
* ParserOPL.java - a class to parse the csv file for CPL voting.
* @see Parser
* @author  Yingjin Zhang, Sunny Qin
* @since   2019-11-16
*/
public class ParserOPL extends Parser{
  /**
  *  Constructor for OPL parser
  */
  public ParserOPL(){
    super();
  }

  /**
  * parse file for OPL process, get the useful info, count ballots and save them into an object array
  * @param filename Input csv filename, ex. "voting.csv"
  * @param auditfile auditfile name, by default: "audit.txt"
  * @return An object array that contains num_seats, num_ballots, party_names, party_ballots, cand_ballots
  * @throws FileNotFoundException throws exception when the file does not exists
  */

  public static Object[] parse_opl(String filename, String auditfile) throws FileNotFoundException{
    Scanner scanner = new Scanner(new File(filename));
    scanner.useDelimiter("\n");
    String type = scanner.next();
    WriteAudit audit = new WriteAudit();
    File file = new File(auditfile);
    file.delete();
    audit.writeAuditFile(type, auditfile);


    Parser pp = new Parser();
    Object[] results = pp.read_initial_info(scanner, audit, auditfile);
    ArrayList<Hashtable<String, Integer>> cand_ballots = (ArrayList<Hashtable<String, Integer>>) results[4];
    ArrayList<Hashtable<String, Integer>> party_ballots_l = (ArrayList<Hashtable<String,Integer>>) results[3];
    ArrayList<String> party_names = (ArrayList<String>) results[2];
    Hashtable<String, Integer> party_ballots = party_ballots_l.get(0);
    int num_cand = (int) results[6];
    ArrayList<String> cand_names = (ArrayList<String>) results[7];
    ArrayList<Integer> cand_parties = (ArrayList<Integer>) results[5];

    cand_ballots = pp.read_ballots(type,num_cand,cand_ballots, cand_names, cand_parties, scanner,audit, auditfile);

    // Update party_ballots by adding up all candidates' ballots in that party
    int p = 0;
    for(Hashtable<String, Integer> hash_p: cand_ballots){
      int sum = 0;
      for(Map.Entry<String,Integer> entry: hash_p.entrySet()){
        sum = sum + entry.getValue();
      }
      for(Map.Entry<String,Integer> e: party_ballots.entrySet()){
        if(e.getKey().equals(party_names.get(p))){
          e.setValue(sum);
        }
      }
      p++;
    }

    results[3] = party_ballots;
    audit.writeAuditFile("Party parser results: "+ party_ballots.toString() + "\n", auditfile);

    return results;
  }
}
