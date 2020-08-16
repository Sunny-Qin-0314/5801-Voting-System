package mypackage;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

/**
* ParserCPL.java - a class to parse the csv file for CPL voting.
* @see Parser
* @author  Sunny Qin, Yingjin Zhang
* @since   2019-11-16
*/
public class ParserCPL extends Parser{
  /**
  *  Constructor for CPL parser
  */
  public ParserCPL(){
    super();
  }

  /**
  * parse file for CPL process, get the useful info, count ballots and save them into an object array
  * @param filename Input csv filename, ex. "voting.csv"
  * @param auditfile auditfile name, by default: "audit.txt"
  * @return An object array that contains num_seats, num_ballots, party_names, party_ballots, cand_ballots
  * @throws FileNotFoundException throws exception when the file does not exists
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


    Parser pp = new Parser();
    Object[] results = pp.read_initial_info(scanner, audit, auditfile);
    ArrayList<Hashtable<String, Integer>> party_ballots_l = (ArrayList<Hashtable<String,Integer>>) results[3];
    ArrayList<String> party_names = (ArrayList<String>) results[2];
    int num = party_names.size();
    ArrayList<Integer> cand_parties = (ArrayList<Integer>) results[5];

    party_ballots_l = pp.read_ballots(type, num, party_ballots_l, party_names, cand_parties, scanner, audit, auditfile);

    results[3] = party_ballots_l.get(0);
    audit.writeAuditFile("Parser results: "+ party_ballots_l.get(0).toString() + "\n", auditfile);

    return results;
  }


}
