import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DailyGoals extends JFrame {
    public DailyGoals() {
        setTitle("Today's Study Goals");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        List<String> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("studyplan.txt"))) {
            String line;
            while ((line = br.readLine()) != null && tasks.size() < 3) {
                if (!line.contains("done")) {
                    tasks.add(line);
                }
            }
        } catch (IOException ex) {
            area.setText("No pending tasks.");
        }
        if (tasks.isEmpty()) {
            area.setText("You are all caught up! 🎉");
        } else {
            area.append("Today's Study Targets:\n\n");
            for (String task : tasks) {
                area.append("- " + task + "\n");
            }
        }
        add(new JScrollPane(area));
        setVisible(true);
    }
}