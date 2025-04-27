import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class MarkTaskCompleted extends JFrame {
    public MarkTaskCompleted() {
        setTitle("Mark Task as Completed");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        try (BufferedReader br = new BufferedReader(new FileReader("studyplan.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No study plan found.");
        }
        JButton markButton = new JButton("Mark Selected as Done");
        markButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String task = listModel.get(selectedIndex) + " (done)";
                listModel.set(selectedIndex, task);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("studyplan.txt"))) {
                    for (int i = 0; i < listModel.size(); i++) {
                        bw.write(listModel.getElementAt(i));
                        bw.newLine();
                    }
                    JOptionPane.showMessageDialog(this, "Task Updated!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(markButton, BorderLayout.SOUTH);
        setVisible(true);
    }
}