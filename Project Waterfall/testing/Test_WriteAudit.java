import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        //Test 2: Test write null string to audit file
        String str2 = null;
        String path2 = "AuditFile2.txt";
        System.out.println("Test 2: Test write null string to audit file");
        mypackage.WriteAudit write2 = new mypackage.WriteAudit();
        write2.writeAuditFile(str2, path2);

        //Test 3: Test write empty string to audit file
        String str3 = "";
        String path3 = "AuditFile3.txt";
        System.out.println("Test 3: Test write empty string to audit file");
        mypackage.WriteAudit write3 = new mypackage.WriteAudit();
        write3.writeAuditFile(str3, path3);
    }


}
