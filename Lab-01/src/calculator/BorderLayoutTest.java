package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Border Layout Test");
        frame.setSize(800, 600);

        JLabel label = new JLabel("Hi there!!");
        label.setFont(label.getFont().deriveFont(24f));
        label.setForeground(Color.PINK);
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(Color.CYAN);
        for (int i = 0; i < 9; i ++) {
            JPanel subPanel = new JPanel();
            subPanel.setPreferredSize(new Dimension(100, 50));
            subPanel.add(new JLabel(Integer.toString(i + 1)));
            if (i == 5) {
                subPanel.setPreferredSize(new Dimension(300, 50));
            }
            panel.add(subPanel);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        
        frame.add(label, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
