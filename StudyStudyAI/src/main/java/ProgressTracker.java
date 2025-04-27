import javax.swing.*;
import java.awt.*;
import java.io.*;
public class ProgressTracker extends JFrame {
    public ProgressTracker() {
        setTitle("Progress Tracker");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        try (BufferedReader br = new BufferedReader(new FileReader("studyplan.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                area.append(line + "\n");
            }
        } catch (IOException ex) {
            area.setText("No tasks added yet!");
        }
        add(new JScrollPane(area));
        setVisible(true);
    }
}