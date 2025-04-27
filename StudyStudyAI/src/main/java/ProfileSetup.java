import javax.swing.*;
import java.awt.*;
import java.io.*;
public class ProfileSetup extends JFrame {
    public ProfileSetup() {
        setTitle("Setup Profile");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel nameLabel = new JLabel("Enter Name:");
        JTextField nameField = new JTextField();
        JLabel hoursLabel = new JLabel("Study Hours/day:");
        JTextField hoursField = new JTextField();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("profile.txt"))) {
                bw.write(nameField.getText() + "," + hoursField.getText());
                JOptionPane.showMessageDialog(this, "Profile Saved!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        setLayout(new GridLayout(3, 2));
        add(nameLabel); add(nameField);
        add(hoursLabel); add(hoursField);
        add(new JLabel()); add(saveButton);
        setVisible(true);
    }
}