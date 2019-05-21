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
public class Matcher{
  public int get_net_score(ArrayList<Student> roster, int student){
    int net_score=0;
    for(int i=0; i<roster.get(student).get_size();i++){
        net_score+=roster.get(student).get_score(i);
    }
    return net_score;
  }
}
