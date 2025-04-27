import javax.swing.*;
import java.awt.*;
public class MotivationZone extends JFrame {
    public MotivationZone() {
        setTitle("Motivation Zone");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] quotes = {
            "Believe you can and you're halfway there.",
            "Push yourself, because no one else is going to do it for you!",
            "Dream it. Wish it. Do it.",
            "Great things never come from comfort zones."
        };
        JLabel quoteLabel = new JLabel(quotes[(int)(Math.random() * quotes.length)], SwingConstants.CENTER);
        add(quoteLabel);
        setVisible(true);
    }
}