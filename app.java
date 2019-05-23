import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
public class app{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the roster");
    String data_student="data/"+input.nextLine();
    System.out.println("Enter the project");
    String data_project="data/"+input.nextLine();
    ArrayList<Student> roster = new ArrayList<Student>();
    ArrayList<String> project_list = new ArrayList<String>();
    String first_name="";
    String last_name="";
    String email="";
    try {
        BufferedReader read_student = new BufferedReader( new FileReader(data_student));
        BufferedReader read_project = new BufferedReader( new FileReader(data_project));
        String strLine = null;
        StringTokenizer st = null;
        int lineNumber = 0, tokenNumber = 0;
        while( (data_student = read_student.readLine()) != null)
        {
          lineNumber++;
          //break comma separated line using ","
          st = new StringTokenizer(data_student, ",");
          ArrayList<Integer> preferences = new ArrayList<Integer>();
          while(st.hasMoreTokens())
          {
            //display csv values
            tokenNumber++;
            if(tokenNumber==1){
              first_name=st.nextToken();
            }
            if(tokenNumber==2){
              last_name=st.nextToken();
            }
            if(tokenNumber==3){
              email=st.nextToken();
            }
            if(tokenNumber>3){
              int val=0;
              String pref_value = st.nextToken();
              if(pref_value.equals("No thanks")){
                val=1;
              }
              if(pref_value.equals("Probably not")){
                val=2;
              }
              if(pref_value.equals("Maybe")){
                val=3;
              }
              if(pref_value.equals("Probably yes")){
                val=4;
              }
              if(pref_value.equals("Definitely yes")){
                val=5;
              }
              preferences.add(val);
            }
        }
        roster.add(new Student(first_name,last_name,email,preferences));
        tokenNumber = 0;
      }
        lineNumber=0;
        tokenNumber=0;
        while((data_project = read_project.readLine()) != null)
        {
          lineNumber++;
          st = new StringTokenizer(data_project, ",");

          while(st.hasMoreTokens())
          {
            tokenNumber++;
            String value= st.nextToken();
            if(tokenNumber==1){
              project_list.add(value);
            }
          }
          tokenNumber = 0;
        }
      }
  catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        Matcher test = new Matcher(roster,project_list);
        test.match(6);
  }
}
