import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

import mypackage.*;

public class Test_WriteAudit {
    public static void main(String[] args) {
        //Test 1: Test write string to audit file
        String str1 = "CPL";
        //int num = 3;
        //String str = Integer.toString(num);  //if input is integer, transfer it to string
        String path1 = "AuditFile1.txt";
        System.out.println("Test 1: Test write string to audit file");
        mypackage.WriteAudit write1 = new mypackage.WriteAudit();
        write1.writeAuditFile(str1, path1);

        FileInputStream inputStream1;
        Scanner scanner1;
        try{
            inputStream1 = new FileInputStream("AuditFile1.txt");
            scanner1 = new Scanner(inputStream1, "UTF-8");
            while (scanner1.hasNextLine()){
                String line1 = scanner1.nextLine();
                if (str1.equals(line1)) {
                    System.out.println("Expected results: " + str1);
                    System.out.println("Output results: " + line1);
                    System.out.println("PASS");
                } else {
                    System.out.println("Expected results: " + str1);
                    System.out.println("Output results: " + line1);
                    System.out.println("FAIL");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Test 2: Test write null string to audit file
        String str2 = null;
        String path2 = "AuditFile2.txt";
        System.out.println("Test 2: Test write null string to audit file");
        mypackage.WriteAudit write2 = new mypackage.WriteAudit();
        write2.writeAuditFile(str2, path2);


        FileInputStream inputStream2;
        Scanner scanner2;
        try{
            inputStream2 = new FileInputStream("AuditFile2.txt");
            scanner2 = new Scanner(inputStream2, "UTF-8");

            while (scanner2.hasNextLine()){
                System.out.println(scanner2.nextLine());
                String line2 = scanner2.nextLine();
                if (line2.equals("")) {
                    System.out.println("Expected results: " + "");
                    System.out.println("Output results: " + line2);
                    System.out.println("PASS");
                } else {
                    System.out.println("Expected results: " + str2);
                    System.out.println("Output results: " + line2);
                    System.out.println("FAIL");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
//            System.out.println("Expected results: null");
//            System.out.println("Output results: null");
//            System.out.println("PASS");
        }

        //Test 3: Test write empty string to audit file
        String str3 = "";
        String path3 = "AuditFile3.txt";
        System.out.println("Test 3: Test write empty string to audit file");
        mypackage.WriteAudit write3 = new mypackage.WriteAudit();
        write3.writeAuditFile(str3, path3);


        FileInputStream inputStream3;
        Scanner scanner3;
        try{
            inputStream3 = new FileInputStream("AuditFile3.txt");
            scanner3 = new Scanner(inputStream3, "UTF-8");
            while (scanner3.hasNextLine()){
                String line3 = scanner3.nextLine();
                if (line3.equals(str3)) {
                    System.out.println("Expected results: " + str3);
                    System.out.println("Output results: " + line3);
                    System.out.println("PASS");
                } else {
                    System.out.println("Expected results: " + str3);
                    System.out.println("Output results: " + line3);
                    System.out.println("FAIL");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
