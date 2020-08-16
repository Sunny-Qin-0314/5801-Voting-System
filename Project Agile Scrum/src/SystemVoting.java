package mypackage;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileNotFoundException;
import java.lang.*;
import javax.swing.*;


/**
* SystemVoting.java - the implementation for the whole system, including GUI implementation
* @author  Sunny Qin, Yingjin Zhang
* @since   2019-12-4
*/
public class SystemVoting{

    /**
    *  Constructor for the voting system
    * @throws FileNotFoundException throws exception when the file does not exists
    */
    public SystemVoting() throws FileNotFoundException{
      // Combine GUI implementation and our main function
        FileChooser input = new FileChooser();
        String filename = input.chooser("Upload file");
        String extension = "";
        int t = filename.lastIndexOf('.');
        if (t >= 0) { extension = filename.substring(t+1); }
        if (!extension.equals("csv")){
          System.err.println("Input file should be in csv format");
          System.err.println("Terminating...");
          System.exit(0);
        }

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Please save your summary report. (Use extension '.txt')", "Save Summary Report", JOptionPane.PLAIN_MESSAGE);
        String output = input.chooser("Save summary report");
        File file = new File(output);
        file.delete();

        JFrame frame1 = new JFrame();
        JOptionPane.showMessageDialog(frame1, "Please save your audit report. (Use extension '.txt')", "Save Audit Report", JOptionPane.PLAIN_MESSAGE);
        String audit = input.chooser("Save Audit File");

        // Start our main system
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter("\n");
        String type = scanner.next();
        for (int i = 0; i < type.length(); i++){
            if (type.substring(i,i+1).equals("C") || type.substring(i,i+1).equals("O")){
                type = type.substring(i,type.length());
            }
        }

        System.out.println(type);
        Object[] info = new Object[5];
        if (type.equals("CPL")){

            try{
                mypackage.ParserCPL parser = new mypackage.ParserCPL();
                info= parser.parse_cpl(filename, audit);

            }
            catch (FileNotFoundException e) {
                System.err.println("Unable to find input file: ");
                System.err.println("Terminating...");
                System.exit(3);
            }

            ArrayList<String> party_names = (ArrayList<String>) info[2];
            Hashtable<String,Integer> party_ballots = (Hashtable<String,Integer>) info[3];
            ArrayList<Hashtable<String, Integer>> cand_ballots = (ArrayList<Hashtable<String, Integer>>) info[4];
            int num_ballots = (int) info[1];
            int num_seats = (int) info[0];

            String[] party_names_arr = new String[party_names.size()];

            for(int j = 0 ; j < party_names.size(); j ++){
                party_names_arr[j] = party_names.get(j);
            }

            mypackage.CPL p = new mypackage.CPL();
            int[] party_seats = p.allocate_seats(party_names_arr, party_ballots, cand_ballots, num_ballots, num_seats,"audit.txt");
            ArrayList<Hashtable<String, Integer>> results = p.generate_result_CPL(party_seats, cand_ballots,"audit.txt");
            p.display_results(results, party_names_arr, num_seats);
            mypackage.WriteSummary w = new mypackage.WriteSummary();
            w.writeSummaryReport(output, "CPL", cand_ballots, party_names_arr, num_seats, results);
        }
        else{
            try{
                mypackage.ParserOPL parser = new mypackage.ParserOPL();
                info= parser.parse_opl(filename,audit);

            }
            catch (FileNotFoundException e) {
                System.err.println("Unable to find input file: ");
                System.err.println("Terminating...");
                System.exit(3);
            }

            ArrayList<String> party_names = (ArrayList<String>) info[2];
            Hashtable<String,Integer> party_ballots = (Hashtable<String,Integer>) info[3];
            ArrayList<Hashtable<String, Integer>> cand_ballots = (ArrayList<Hashtable<String, Integer>>) info[4];
            int num_ballots = (int) info[1];
            int num_seats = (int) info[0];

            String[] party_names_arr = new String[party_names.size()];

            for(int j = 0 ; j < party_names.size(); j ++){
                party_names_arr[j] = party_names.get(j);
            }

            mypackage.OPL p = new mypackage.OPL();
            int[] party_seats = p.allocate_seats(party_names_arr, party_ballots, cand_ballots, num_ballots, num_seats,"audit.txt");
            ArrayList<Hashtable<String, Integer>> results = p.generate_result_OPL(party_seats, cand_ballots,"audit.txt");
            p.display_results(results, party_names_arr, num_seats);
            mypackage.WriteSummary w = new mypackage.WriteSummary();
            w.writeSummaryReport(output, "OPL", cand_ballots, party_names_arr, num_seats, results);
        }
    }


}
