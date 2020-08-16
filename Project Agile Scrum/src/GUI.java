package mypackage;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;
import java.io.FileNotFoundException;
import java.lang.*;
import javax.swing.*;


/**
* GUI.java - a public class to implement GUI
* @author  Sunny Qin, Yingjin Zhang, Rex Zhu
* @since   2019-12-2
*/
public class GUI{

  /**
  *  Constructor for GUI
  */
    public GUI() {

        //Test step 1: generate a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 100));
        frame.setTitle("Import voting ballots");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        //Test step 2: create a button
        JButton search = new JButton();
        search.setText("Import from a local csv file");
        frame.add(search);
        frame.setVisible(true);

        //Test step 3: create the second button
        JButton create = new JButton();
        create.setText("Create new ballots csv file");
        frame.add(create);
        frame.pack();
        frame.setVisible(true);

        //Test step 4: create a window for searching files when user clicks on the "Import from a local csv file" button
        search.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    new mypackage.SystemVoting();
                }
                catch (FileNotFoundException error) {
                    System.err.println("FileNotFoundException: " + error.getMessage());

                }
            }
        });

    }

}
