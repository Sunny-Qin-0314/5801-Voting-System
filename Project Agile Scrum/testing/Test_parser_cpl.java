import java.util.*;
import mypackage.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

class Test_parser_cpl{
  public static void main(String[] args) throws FileNotFoundException {

      //Test 1: test the parser function for CPL when there is no tie
      mypackage.ParserCPL p = new mypackage.ParserCPL();
      try {
          Object[] info1 = p.parse_cpl("test_cpl_reg.csv", "audit.txt");
          System.out.println("Test 1: test the parser function for CPL when there is no tie" + "\n");
          String exp1 = "[3, 30, [D, R, I], {I=10, R=14, D=6}, [{Pike=1, Foster=2}, {Deutsch=1, Walters=3, Borg=2}, {Smith=1}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Smith]]";
//          System.out.println(Arrays.toString(info1) + "\n");
          if(exp1.equals(Arrays.toString(info1))) System.out.println("true");
          else System.out.println("false");

      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

      // Test 2: test the parser function for OPL when there is a tie
      try {
          Object[] info2 = p.parse_cpl("test_cpl_tie.csv", "audit.txt");
          System.out.println("Test 2: test the parser function for OPL when there is a tie" + "\n");
          String exp2 = "[3, 30, [D, R, I], {I=12, R=9, D=9}, [{Pike=1, Foster=2}, {Deutsch=1, Walters=3, Borg=2}, {Smith=1}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Smith]]";
          if(exp2.equals(Arrays.toString(info2))) System.out.println("true");
          else System.out.println("false");
          //          System.out.println(Arrays.toString(info2) + "\n");
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

      // Test 3: test the parser function for CPL when there is no tie but two candidates have the same name
      try {
          Object[] info3 = p.parse_cpl("test_cpl_sameName.csv", "audit.txt");
          System.out.println("Test 3: test the parser function for CPL when there is no tie but two candidates have the same name" + "\n");
//          System.out.println(Arrays.toString(info3) + "\n");
          String exp3 = "[3, 30, [D, R, I], {I=10, R=14, D=6}, [{Pike=1, Foster=2}, {Deutsch=1, Walters=3, Borg=2}, {Walters=1}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Walters]]";
          if(exp3.equals(Arrays.toString(info3)))
              System.out.println("true");
          else System.out.println("false");

      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

  }
}
