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
  public int get_net_score(ArrayList<Student> roster, int student){
    int net_score=0;
    for(int i=0; i<roster.get(student).get_size();i++){
        net_score+=roster.get(student).get_score(i);
    }
    return net_score;
  }
  //This method will sort the list by the preference that student puts
  public ArrayList<Student> sort_by_preference(ArrayList<Student> roster, int project_id){
    ArrayList<Student> final_list = new ArrayList<Student>();
    ArrayList<Student> temp = roster;
    int index = 0;
    for(int i=0;i<temp.size();i++){
      for(int j=i+1;j<temp.size();j++){
          if(temp.get(j).get_score(project_id)>temp.get(i).get_score(project_id)){
            index=j;
          }
      }
      final_list.add(temp.get(index));
      temp.remove(index);
    }
    return final_list;
  }
  public ArrayList<Student> sort_by_netscore(ArrayList<Student> roster){

  }
  public ArrayList<Student> match(ArrayList<Student> roster, int project){

  }
}
