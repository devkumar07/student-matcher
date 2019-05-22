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
  public static int get_net_score(ArrayList<Student> roster, int student){
    int net_score=0;
    for(int i=0; i<roster.get(student).get_size();i++){
        net_score+=roster.get(student).get_score(i);
    }
    return net_score;
  }
  //This method will sort the list by the preference that student puts
  public static ArrayList<Student> sort_by_preference(ArrayList<Student> roster, int project_id){
    ArrayList<Student> temp = roster;
    int index = 0;
    for(int i=temp.size()-1;i>0;i--){
      index=0;
      for(int j=1;j<=i;j++){
          if(temp.get(j).get_score(project_id)<temp.get(index).get_score(project_id)){
            index=j;
          }
      }
      Student temp1 = temp.get(index);
      temp.set(index,temp.get(i));
      temp.set(i,temp1);
    }
    return temp;
  }
  public static int range(ArrayList<Student> roster, int target, int start, int project_id){
    int r=0;
    int s=start;
    while(roster.get(s).get_score(project_id)==target){
      s++;
      r++;
    }
    return r;
  }
  public static ArrayList<Student> sort_by_netscore(ArrayList<Student> roster, int start, int end){
    ArrayList<Student> temp = roster;
    int index = 0;
    for(int i=start;i<end;i++){
      index=i;
      for(int j=i+1;j<end;j++){
          if(get_net_score(temp,j)<get_net_score(temp,index)){
            index=j;
          }
      }
      Student temp1 = temp.get(index);
      temp.set(index,temp.get(i));
      temp.set(i,temp1);
    }
    return temp;
  }
  public static ArrayList<Student> match(ArrayList<Student> roster, int project){
    //All the code in here is used for testing the algorithm 
    ArrayList<Student> fl = sort_by_preference(roster,project);
    System.out.println("Sorting by preference");
    System.out.println(fl);
    int end = range(roster,5,0,0);
    System.out.println("end="+end);
    fl=sort_by_netscore(fl,0,end);
    System.out.println("Sorting by netscore");
    System.out.println(fl);
    return fl;
  }
}
