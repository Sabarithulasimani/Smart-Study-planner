import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
public class DynamicPlanner extends JFrame {
    public DynamicPlanner() {
        setTitle("Dynamic Planner");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        try (BufferedReader br = new BufferedReader(new FileReader("studyplan.txt"))) {
            List<String> plans = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                plans.add(line);
            }
            if (plans.isEmpty()) {
                area.setText("No plans available.");
            } else {
                Collections.shuffle(plans);
                area.append("Suggested Dynamic Plan:\n\n");
                for (String plan : plans) {
                    area.append("- " + plan + "\n");
                }
            }
        } catch (IOException ex) {
            area.setText("No plans available.");
        }
        add(new JScrollPane(area));
        setVisible(true);
    }
}