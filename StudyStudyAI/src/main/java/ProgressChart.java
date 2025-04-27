import javax.swing.*;
import java.awt.*;
import java.io.*;
public class ProgressChart extends JFrame {
    public ProgressChart() {
        setTitle("Progress Chart");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        int total = 0, completed = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("studyplan.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                total++;
                if (line.contains("(done)")) {
                    completed++;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No study data available.");
        }
        int pending = total - completed;
        if (total == 0) total = 1; // avoid division by zero
        double donePercent = (completed * 100.0) / total;
        double pendingPercent = (pending * 100.0) / total;
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.append("Completed: " + String.format("%.2f", donePercent) + "%\n");
        area.append("Pending: " + String.format("%.2f", pendingPercent) + "%\n");
        add(new JScrollPane(area));
        setVisible(true);
    }
}