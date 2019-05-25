import javax.swing.*;
import java.awt.*;
class Gui {
    public static void main(String args[]) {

        JFrame frame = new JFrame("I2G Student Matcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,150);

        JLabel lbl_student_roster = new JLabel("Student Roster");
        JTextField tf_student_roster = new JTextField(20);
        lbl_student_roster.setLabelFor(tf_student_roster);
 
        JLabel lbl_project_roster = new JLabel("Project Roster");
        JTextField tf_project_roster = new JTextField(20);
        lbl_project_roster.setLabelFor(tf_project_roster);

        JPanel pan_input = new JPanel();
        pan_input.setLayout(new SpringLayout());
 
        pan_input.add(lbl_student_roster);
        pan_input.add(tf_student_roster);
        pan_input.add(lbl_project_roster);
        pan_input.add(tf_project_roster);

        SpringUtilities.makeCompactGrid(pan_input,
        2, 2,  //rows, cols
        6, 6,  //initX, initY
        6, 6); //xPad, yPad        

        JPanel pan_buttons = new JPanel();

        JButton but_match = new JButton("Match");

        pan_buttons.add(but_match);

       
        frame.getContentPane().add(pan_input, BorderLayout.PAGE_START);
        frame.getContentPane().add(pan_buttons, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
}