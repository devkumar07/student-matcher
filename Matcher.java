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
  ArrayList<Student> roster;
  public Matcher(ArrayList<Student> list){
    this.roster=list;
  }
  public static int get_net_score(ArrayList<Student> roster, int student){
    int net_score=0;
    for(int i=0; i<roster.get(student).get_size();i++){
        net_score+=roster.get(student).get_score(i);
    }
    return net_score;
  }
  public static void merge(ArrayList<Student> left, ArrayList<Student> right, ArrayList<Student> roster) {
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
  public static ArrayList<Student> sort_by_netscore(ArrayList<Student> roster) {
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
  public void match(int project){
    //All the code in here is used for testing the algorithm
      System.out.println("before sorting");
      System.out.println(this.roster);
      System.out.println("after sorting");
      System.out.println(sort_by_netscore(this.roster));
  }
}
