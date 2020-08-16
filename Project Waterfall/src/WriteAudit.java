package mypackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WriteAudit.java: Implement functions for writing string data to audit file
 * @author: Xiaohui Chao
 * @since 2019.11.13
 */

public class WriteAudit {
    /**
     * This method shows how to write an audit file
     * @param str input string
     * @param path audit filename, by default: "audit.txt"
     */
    public static void writeAuditFile(String str, String path) {
        //Write data
        File filename = new File(path);
        FileWriter fr = null;
        try {
            fr = new FileWriter(filename, true);
            // Check if the input string is null
            if (str != null) {
                fr.write(str);
            }
            else {
                System.out.println("The input data is null.");
            }
            fr.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
