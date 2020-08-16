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
          for (int i = 0; i < info1.length; i++) {
              if (i == 2) {
                  String[] list1 = (String[]) info1[i];
                  for (int j = 0; j < list1.length; j++) {
                      System.out.println(list1[j]);
                  }
              }
              else {
                  System.out.println(info1[i]);
              }
          }
          System.out.println("\n");
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }


      // Test 2: test the parser function for OPL when there is a tie
      try {
          Object[] info2 = p.parse_cpl("test_cpl_tie.csv", "audit.txt");
          System.out.println("Test 2: test the parser function for OPL when there is a tie" + "\n");
          for (int i = 0; i < info2.length; i++) {
              if (i == 2) {
                  String[] list2 = (String[]) info2[i];
                  for (int j = 0; j < list2.length; j++) {
                      System.out.println(list2[j]);
                  }
              }
              else {
                  System.out.println(info2[i]);
              }
          }
          System.out.println("\n");
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

      // Test 3: test the parser function for CPL when there is no tie but two candidates have the same name
      try {
          Object[] info3 = p.parse_cpl("test_cpl_sameName.csv", "audit.txt");
          System.out.println("Test 3: test the parser function for CPL when there is no tie but two candidates have the same name" + "\n");
          for (int i = 0; i < info3.length; i++) {
              if (i == 2) {
                  String[] list3 = (String[]) info3[i];
                  for (int j = 0; j < list3.length; j++) {
                      System.out.println(list3[j]);
                  }
              }
              else {
                  System.out.println(info3[i]);
              }
          }
          System.out.println("\n");
      } catch (FileNotFoundException e) {
          System.err.println("Unable to find input file: ");
          System.err.println("Terminating...");
          System.exit(3);
      }

  }
}
