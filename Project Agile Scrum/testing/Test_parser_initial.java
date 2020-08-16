import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import mypackage.*;

public class Test_parser_initial{
  public static void main(String[] args) throws FileNotFoundException{
    // Test1: cpl
    mypackage.Parser p = new mypackage.Parser();
    try {
        Scanner scanner = new Scanner(new File("test_cpl_reg.csv"));
        scanner.useDelimiter("\n");

        mypackage.WriteAudit audit = new mypackage.WriteAudit();
        String type = scanner.next();

        int num_parties = Integer.parseInt(scanner.next());
        // audit.writeAuditFile("number of parties: "+ Integer.toString(num_parties), auditfile);
        String parties = scanner.next();
        // audit.writeAuditFile("Parties: "+ parties, auditfile);

        Object[] info1 = p.read_initial_info(scanner, audit, "audit_test_initial_cpl.txt");
        System.out.println("Test 1: test the parser initial infor function for CPL" + "\n");
        String exp1 = "[3, 30, [D, R, I], [{I=0, R=0, D=0}], [{Pike=1, Foster=2}, {Deutsch=1, Walters=3, Borg=2}, {Smith=1}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Smith]]";
//        for (int i = 0; i < info1.length; i++) {
//                System.out.println(info1[i]);
//        }

        System.out.println(Arrays.toString(info1).equals(exp1));


    } catch (FileNotFoundException e) {
        System.err.println("Unable to find input file: ");
        System.err.println("Terminating...");
        System.exit(3);
    }

    //Test 2: opl
    mypackage.Parser p1 = new mypackage.Parser();
    try {
        Scanner scanner1 = new Scanner(new File("test_opl_reg.csv"));
        scanner1.useDelimiter("\n");

        mypackage.WriteAudit audit1 = new mypackage.WriteAudit();
        String type1 = scanner1.next();


        Object[] info2 = p1.read_initial_info(scanner1, audit1, "audit_test_initial_opl.txt");
        System.out.println("Test 2: test the parser initial info function for OPL" + "\n");
        String exp2 = "[3, 30, [D, R, I], [{I=0, R=0, D=0}], [{Pike=0, Foster=0}, {Deutsch=0, Walters=0, Borg=0}, {Smith=0}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Smith]]";
        System.out.println(Arrays.toString(info2).equals(exp2));

//        for (int i = 0; i < info2.length; i++) {
//                System.out.println(info2[i]);
//        }

        System.out.println("\n");
    } catch (FileNotFoundException e) {
        System.err.println("Unable to find input file: ");
        System.err.println("Terminating...");
        System.exit(3);
    }

  }
}
