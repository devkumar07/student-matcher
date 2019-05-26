import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Gui implements ActionListener {

    JFrame frame;
    JPanel pan_input, pan_buttons;
    JLabel lbl_student_roster, lbl_project_roster;
    JTextField tf_student_roster, tf_project_roster;
    JButton but_match;

    public Gui() {
        frame = new JFrame("I2G Student Matcher");
        pan_input = new JPanel();
        pan_buttons = new JPanel();
        lbl_student_roster = new JLabel("Student Roster");
        lbl_project_roster = new JLabel("Project Roster");
        tf_student_roster = new JTextField();
        tf_project_roster = new JTextField();
        but_match = new JButton("Match");
    }

    public void launchFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        lbl_student_roster.setLabelFor(tf_student_roster);
        lbl_project_roster.setLabelFor(tf_project_roster);

        pan_input.setLayout(new SpringLayout());

        pan_input.add(lbl_student_roster);
        pan_input.add(tf_student_roster);
        pan_input.add(lbl_project_roster);
        pan_input.add(tf_project_roster);

        SpringUtilities.makeCompactGrid(pan_input, 2, 2, 6, 6, 6, 6);

        pan_buttons.add(but_match);

        frame.getContentPane().add(pan_input, BorderLayout.PAGE_START);
        frame.getContentPane().add(pan_buttons, BorderLayout.PAGE_END);
        frame.setVisible(true);

        but_match.addActionListener(this);

        // b1.addActionListener(new ClearButton());
        // b2.addActionListener(new CopyButton());
    }

    public String getProjectFieldText() {
        return tf_project_roster.getText();
    }

    public String getStudentFieldText() {
        return tf_student_roster.getText();
    }

    public void actionPerformed(ActionEvent e) {

        String student = this.getProjectFieldText(); // "roster.csv"; //instance.getProjectFieldText();
        String projects = this.getStudentFieldText();// "projects.csv"; //instance.getStudentFieldText();

        app.apprun(student, projects);

        JOptionPane.showMessageDialog(null, "Done!");
    }

    public static void main(String args[]) {
        Gui gui = new Gui();
        gui.launchFrame();
    }
}

