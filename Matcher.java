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
public class Matcher{
  ArrayList<Student> roster;//Contains the list of students with their preference
  ArrayList<String> Projects;//Contains the list of projects
  //Constructor
  public Matcher(ArrayList<Student> list, ArrayList<String> Projects){
    this.roster=list;
    this.Projects=Projects;
  }
  //This method returns the netscore of a student
  public int get_net_score(ArrayList<Student> roster, int student){
    int net_score=0;
    for(int i=0; i<roster.get(student).get_size();i++){
        net_score+=roster.get(student).get_score(i);
    }
    return net_score;
  }
  //This method removes duplicate entries from the list
  public void remove_duplicates(){
    int i=0;
    int j=0;
    while(i<this.roster.size()-1){
      j=i+1;
      while(j<this.roster.size()){
        if(this.roster.get(i).get_email_id().equals(this.roster.get(j).get_email_id())){
          this.roster.remove(i);
          j=i+1;
        }
        else{
          j++;
        }
      }
      i++;
    }
  }
  // This method is a helper method for the sort by netscore
  public void merge(ArrayList<Student> left, ArrayList<Student> right, ArrayList<Student> roster) {
        int leftIndex = 0;
        int rightIndex = 0;
        int k = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (get_net_score(left,leftIndex)<=get_net_score(right,rightIndex)){
                roster.set(k, left.get(leftIndex));
                leftIndex++;
            }
            else {
                roster.set(k, right.get(rightIndex));
                rightIndex++;
            }
            k++;
        }

        ArrayList<Student> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }
        for (int i=restIndex; i<rest.size(); i++) {
            roster.set(k, rest.get(i));
            k++;
        }
    }
  // This method sorts the student list by lowest netscore
  public ArrayList<Student> sort_by_netscore(ArrayList<Student> roster) {
    ArrayList<Student> left = new ArrayList<Student>();
    ArrayList<Student> right = new ArrayList<Student>();
    int middle;
    if (roster.size() == 1) {
        return roster;
    }
    else {
        middle = roster.size()/2;
        for (int i=0; i<middle; i++) {
                left.add(roster.get(i));
        }
        for (int i=middle; i<roster.size(); i++) {
                right.add(roster.get(i));
        }
        left  = sort_by_netscore(left);
        right = sort_by_netscore(right);
        merge(left, right, roster);
    }
    return roster;
}
  //This method checks whether all the elements in the list are "0"
  public boolean is_empty(ArrayList<Integer>roster){
    for(int i =0; i<roster.size();i++){
      if(roster.get(i)!=0){
        return false;
      }
    }
    return true;
  }
  //This method returns an array of index(Projects) that corresponds to the highest preference of a student
  public int[] sort_by_preference(ArrayList<Integer> roster){
    ArrayList<Integer> temp = roster;
    int[] sorted_preference_project = new int[temp.size()];
    int b=0;
    while(is_empty(temp)==false){
      int index=0;
      int temp_val=temp.get(0);
      for(int i = 0; i<temp.size();i++){
        if(temp_val<temp.get(i)){
          index=i;
          temp_val=temp.get(i);
        }
      }
      temp.set(index,0);
      sorted_preference_project[b]=index;
      b++;
    }
    return sorted_preference_project;
  }
  //This method checks whether there is space avaliable in the team
  public boolean space_avaliable(int[] space, int project, int max){
    if(space[project] < max){
      return true;
    }
    return false;
  }
  //This method performs the matching for students with the best team
  public void match(int size){
    this.remove_duplicates();
    this.roster=sort_by_netscore(this.roster);
    int[] capacity = new int[size];
    double temp_max = ((double)this.roster.size())/size;
    int max = (int)Math.ceil(temp_max);// This needs to be clarified
    for(int k=0; k<capacity.length;k++){
      capacity[k]=0;
    }
    for(int i=0;i<this.roster.size();i++){
      int[] sorted_preference_project = this.sort_by_preference(this.roster.get(i).get_preferences());
      for(int j=0;j<size;j++){
        if(space_avaliable(capacity,sorted_preference_project[j],max)){
          this.roster.get(i).set_team(Projects.get(sorted_preference_project[j]));
          capacity[sorted_preference_project[j]]++;
          j=0;
          break;
        }
      }
    }
  }
  public void output(){
    String fileName = "data/output/Student-Team.csv";
    try{
    					 PrintWriter outputStream = new PrintWriter(fileName);
               StringBuffer csvHeader = new StringBuffer("");
               StringBuffer csvData = new StringBuffer("");
               csvHeader.append("Students with the corresponding team");
               csvHeader.append("\n");
               csvData.append('\n');

               outputStream.write(csvHeader.toString());

               for(int i=0; i<this.Projects.size();i++){
                 String proj = this.Projects.get(i);
                 csvData.append("Project:");
                 csvData.append(',');
                 csvData.append(this.Projects.get(i));
                 csvData.append('\n');
                 csvData.append('\n');
                 csvData.append("First Name");
                 csvData.append(',');
                 csvData.append("Last Name");
                 csvData.append(',');
                 csvData.append("Email");
                 csvData.append('\n');
                 for(int j=0; j<this.roster.size(); j++){
                   if(this.roster.get(j).get_team().equals(proj)){
                     csvData.append(this.roster.get(j).get_first_name());
                     csvData.append(',');
                     csvData.append(this.roster.get(j).get_last_name());
                     csvData.append(',');
                     csvData.append(this.roster.get(j).get_email_id());
                     csvData.append('\n');
                   }
                 }
                 csvData.append('\n');
               }
               outputStream.write(csvData.toString());
    					 outputStream.close();
    		     }
    		     catch(FileNotFoundException e){
    		       e.printStackTrace();
    		     }
  }
}
