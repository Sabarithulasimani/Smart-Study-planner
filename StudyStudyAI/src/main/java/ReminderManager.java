import javax.swing.*;
import java.awt.*;
import java.io.*;
public class ReminderManager extends JFrame {
    public ReminderManager() {
        setTitle("Set Reminder");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel taskLabel = new JLabel("Reminder Task:");
        JTextField taskField = new JTextField();
        JLabel dateLabel = new JLabel("Date (dd-mm-yyyy):");
        JTextField dateField = new JTextField();
        JButton setButton = new JButton("Set Reminder");
        setButton.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("reminders.txt", true))) {
                bw.write(taskField.getText() + " on " + dateField.getText());
                bw.newLine();
                JOptionPane.showMessageDialog(this, "Reminder Saved!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        setLayout(new GridLayout(3, 2));
        add(taskLabel); add(taskField);
        add(dateLabel); add(dateField);
        add(new JLabel()); add(setButton);
        setVisible(true);
    }
}