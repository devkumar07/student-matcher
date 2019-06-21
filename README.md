# Student-Matcher Program

Welcome to Student-Matcher Compare!

## Setup:
In order to run the application, you need to have JDK installed in your system.

Tools needed for running the app:

Link to installing JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Running the application:

Note: You should have two CSV files in the “Data/Input” folder before running the application. Refer to the sample format for student roster and projects roster in the files "roster.csv" and "projects.csv". 

- Open the "Gui.class" file. Once you open, a dialog box will appear with a welcome message 

- Enter the Student roster CSV file (Ex. roster.csv)

- Enter the Project roster CSV file (Ex. projects.csv)

- You will recieve a "Success!" message indicating that the comparision is completed. The output will be stored in the “list.txt” folder

## Troubleshooting (Unix)
If you are having issues follow these steps.

### This program requires the latest version of Java. Follow these steps to reinstall

- Uninstall previous versions of Java 
   - `sudo rm -fr /Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin `
   - `sudo rm -fr /Library/PreferencePanes/JavaControlPanel.prefPane `
   - `sudo rm -fr ~/Library/Application\ Support/Oracle/Java`

- To check if uninstallation happened successfully
  - `java -version`

- Download and install the JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
   - Check if the JRE and JDK are the same versions using `java -version `
 
- If problems persist try to remove any bad class files (./Team_Agreement.class), we might have to delete. 
  - `rm -rf *.class`

