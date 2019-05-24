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
public class Student{
  private String first_name;
  private String last_name;
  private String email;
  private String team;
  private ArrayList<Integer> preferences = new ArrayList<Integer>();

  public Student(String first, String last, String email, ArrayList<Integer> preferences){
      this.first_name = first;
      this.last_name = last;
      this.email = email;
      this.preferences = preferences;
      this.team = "N/A";
    }

  public String get_first_name() { //Returns first name
    return first_name;
  }

  public String get_last_name() { //Returns last name
    return last_name;
  }

  public String get_email_id() { //Returns email
    return email;
  }
  public void set_team(String t){
    this.team=t;
  }
  public String get_team(){
    return team;
  }
  public ArrayList<Integer> get_preferences(){
    return preferences;
  }
  public int get_pref(){ //Returns the list of preference in numeric for a particular student; Was used for testing 
    for(int i=0; i<preferences.size(); i++){
      System.out.println(preferences.get(i));
    }
    return 100;
  }
  public int get_size(){ //Returns the length of the preference list
    return preferences.size();
  }
  public int get_score(int pos){ //Returns the specific score for the particular project
    return preferences.get(pos);
  }
  public String toString(){
    return first_name+";"+get_team();
  }
}
