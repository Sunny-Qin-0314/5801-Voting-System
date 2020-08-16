# Voting System

The Voting System is a useful, self-contained product. It is designed to count the voting ballots and decide the winners and winning parties. This system is supposed to be used after the actual voting is finished and a voting file is provided to the election officials. It allows election officials to transfer the original voting file into a final election result with the election information and output the result. Also, this system helps the election officials send results to media and let the public know the election results. All the functions mentioned above can be accomplished by this system itself.

## Getting Started

To start, please download all the files from https://github.umn.edu/umn-csci-5801-f19/repo-Team12/tree/master/Project1 and save them on the local machine. The folder "src" stores all the program files. The folder "testing" stores all test logs along with all test files that were used for testing. The folder "documentation" stores all documentation documents. The folder "misc" stores other files. The file "Readme.md" (this file) provide instructions to use the software. The file "buglist" is used to document the bugs and issues.

### Prerequisites

To use the Voting System, you are required to install Java on the local machine. A legitimate voting result file in the csv format is required. For instructions on how to install Java, please see https://java.com/en/download/help/download_options.xml.  

### Installing

After the files are downloaded, use the command "cd" to enter the "src" folder. Then, compile all the program files in the "src" folder using the command "javac *.java". Then enter the command "javac -d ../testing *.java". After that, enter the "testing" folder and type "javac *.java." The file "Test_system.java" in the "testing" folder is used to run the Voting System. When running the Voting System, you may receice some notes on the terminal window, but they will not affect the results. 

All the other java files that start with "Test_" are used for unit testing of each method. "Test_WriteAudit.java" is used to test the “writeAuditFile” method to see if the election result is saved in the audit file. "Test_WriteSummary.java" is used to test the “writeSummaryReport” method to see if the election result is saved in the summary file. "Test_opl_generateResult.java" is used to test generate results method for OPL to see whether it can generate correct results based on candidates' votes and number of seats. "Test_cpl_generateResult.java" is used to test generate results method for CPL to see whether it can generate correct results based on candidates' votes and number of seats. "Test_process_display.java" is used to test the displaying results method to see whether the voting results can be correctly printed to the screen. "Test_process_allocateseats.java" is used to test allocating seat method to see whether it can allocate correct seats to each party. "Test_flipcoin_str.java" is used to test random integer generator when for a string list, which is called “Flipcoin” in our code to make sure it is a fair call. "Test_flipcoin_int.java" is used to test random integer generator when for integers list, which is called “Flipcoin” in our code to make sure it is a fair call. "Test_parser_opl.java" is used to test the “parse_opl” method to see if the csv file can be correctly parsed. "Test_parser_cpl.java" is used to test the “parse_cpl” method to see if the csv file can be correctly parsed.

## Running the system tests

After compiling the java file, use the command "java Test_system" to start the system test. When running the system test, the System first prompts the user to enter the input csv file name, after the user enter the file name and hit "enter," the System prompts the user to enter the output summary file name. After user enters the file name and hit "enter," the System will count the ballots from the csv file and generate two files, i.e., an audit file and a summary report file. Meanwhile, the System will print to screen the election result with the candidate names, parties, and ballots/ranks.

### Break down into unit tests

Unit test is to test program components such as methods or object classes to ensure the functionality of these components work properly. For this system, each unit test program is used to test one method. After enter the "testing" folder and compiling all the java files, use the command "javac *" for unit test, where "*" should be replaced with the compiled test file name. 

## Built With

* [IntelliJ](https://www.jetbrains.com/idea/) - The java IDE used

## Authors

* **Team 12**
* **Yingjin Zhang** - *zhan4973* - 
* **Sunny Qin** - *qing0002* - 
* **Zhendong Zhu** - *zhu00100* - 
* **Xiaohui Chao** - *chao0070* - 

## Acknowledgments

* We acknowledge the TA Taihui Li for answering all of our questions

