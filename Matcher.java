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
    ArrayList<Student> final_list = new ArrayList<Student>();
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
  public int range(ArrayList<Student> roster, int target, int start, int project_id){
    int r=0;
    int s=start;
    while(roster.get(s).get_score(project_id)==target){
      r++;
    }
    return r;
  }
  /*public ArrayList<Student> sort_by_netscore(ArrayList<Student> roster, int start, int end){

  }*/
  public static ArrayList<Student> match(ArrayList<Student> roster, int project){
    ArrayList<Student> fl=sort_by_preference(roster,project);
    System.out.println(fl);
    return fl;
  }
}
