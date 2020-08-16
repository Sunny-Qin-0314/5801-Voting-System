import java.util.*;
import mypackage.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import mypackage.*;

class Test_parser_opl{
  public static void main(String[] args) throws FileNotFoundException {

      //Test 1: test the parser function for OPL when there is no tie
      mypackage.ParserOPL p = new mypackage.ParserOPL();
      try {
          Object[] info1 = p.parse_opl("test_opl_reg.csv", "audit.txt");
          System.out.println("Test1: test the parser function for OPL when there is no tie" + "\n");
          String exp1 = "[3, 30, [D, R, I], {I=5, R=11, D=14}, [{Pike=4, Foster=10}, {Deutsch=2, Walters=3, Borg=6}, {Smith=5}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Smith]]";
//          System.out.println(Arrays.toString(info1) + "\n");
          System.out.println(Arrays.toString(info1).equals(exp1));
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }


      // Test 2: test the parser function for OPL when there is a tie
      try {
          Object[] info2 = p.parse_opl("test_opl_tie.csv", "audit.txt");
          System.out.println("Test2: test the parser function for OPL when there is a tie" + "\n");
          String exp2 = "[3, 30, [D, R, I], {I=5, R=11, D=14}, [{Pike=5, Foster=9}, {Deutsch=2, Walters=3, Borg=6}, {Smith=5}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Smith]]";
          System.out.println(Arrays.toString(info2).equals(exp2));
//          System.out.println(Arrays.toString(info2) + "\n");
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

      // Test 3: test the parser function for OPL when there is no tie but two candidates have the same name
      try {
          Object[] info3 = p.parse_opl("test_opl_sameName.csv", "audit.txt");
          System.out.println("Test3: test the parser function for OPL when there is no tie but two candidates have the same name" + "\n");
//          System.out.println(Arrays.toString(info3) + "\n");
          String exp3 = "[3, 30, [D, R, I], {I=5, R=11, D=14}, [{Pike=4, Foster=10}, {Deutsch=2, Walters=3, Borg=6}, {Walters=5}], [0, 0, 1, 1, 1, 2], 6, [Pike, Foster, Deutsch, Borg, Walters, Walters]]";
          System.out.println(Arrays.toString(info3).equals(exp3));
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

  }



}
