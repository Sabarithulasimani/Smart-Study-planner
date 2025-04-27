import javax.swing.*;
import java.awt.*;
public class SmartSuggestions extends JFrame {
    public SmartSuggestions() {
        setTitle("Smart Suggestions");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] tips = {
            "Study in short sessions!",
            "Use active recall!",
            "Make quick notes!",
            "Revise regularly!",
            "Test yourself after learning!"
        };
        JLabel tipLabel = new JLabel(tips[(int)(Math.random() * tips.length)], SwingConstants.CENTER);
        add(tipLabel);
        setVisible(true);
    }
}