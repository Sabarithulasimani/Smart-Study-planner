import javax.swing.*;
import java.awt.*;
import java.io.*;
public class ScheduleViewer extends JFrame {
    public ScheduleViewer() {
        setTitle("View Schedule");
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
            area.setText("No schedule found!");
        }
        add(new JScrollPane(area));
        setVisible(true);
    }
}