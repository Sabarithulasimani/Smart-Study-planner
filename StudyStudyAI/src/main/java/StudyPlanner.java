import javax.swing.*;
import java.awt.*;
import java.io.*;
public class StudyPlanner extends JFrame {
    public StudyPlanner() {
        setTitle("Study Planner");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField();
        JLabel dateLabel = new JLabel("Date (dd-mm-yyyy):");
        JTextField dateField = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("studyplan.txt", true))) {
                bw.write(subjectField.getText() + " on " + dateField.getText());
                bw.newLine();
                JOptionPane.showMessageDialog(this, "Study Plan Added!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        setLayout(new GridLayout(3, 2));
        add(subjectLabel); add(subjectField);
        add(dateLabel); add(dateField);
        add(new JLabel()); add(addButton);
        setVisible(true);
    }
}