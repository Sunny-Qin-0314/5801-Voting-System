package mypackage;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* FileChooser.java - a public class to implement GUI
* @author  Sunny Qin, Yingjin Zhang
* @since   2019-12-2
*/

public class FileChooser {
  /**
  *  Constructor for File chooser
  */

    public FileChooser(){

    }

    /**
    * Search file in a different directory and return path
    * @param functionality the name that shows on the button.
    * @return the path of the chosen file
    */
    public String chooser(String functionality) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        String path = "";

        int returnValue = jfc.showDialog(new JLabel(), functionality);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            path =  selectedFile.getAbsolutePath();
        }

        return path;
    }

}
