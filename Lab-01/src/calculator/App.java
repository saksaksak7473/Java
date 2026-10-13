package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class App {
    public static void main(String[] args) {
        JPanel nav = new JPanel(new GridLayout(1, 2, 0, 0));
        nav.setPreferredSize(new Dimension(0, 50));

        // =================================
        JPanel TopLeft = new JPanel();
        TopLeft.setBackground(Color.GREEN);
        JButton[] buttons = {
            new JButton("Home"),
            new JButton("Events"),
            new JButton("Courses"),
            new JButton("Resources"),
            new JButton("About")
        };
        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(100, 20));
            TopLeft.add(button);
        }
        nav.add(TopLeft);
        // ================================
        
        JPanel TopRight = new JPanel();
        TopRight.setBackground(Color.GREEN);
        nav.add(TopRight);

        JTextField search = new PlaceholderTextField("Search...", 15);
        TopRight.add(search);

        JPanel langPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        JButton[] langs = {
            new JButton("KH"),
            new JButton("ENG")
        };
        for (JButton lang : langs) {
            lang.setPreferredSize(new Dimension(70, 20));
            langPanel.add(lang);
        }
        TopRight.add(langPanel);

        JButton noti = new JButton("🔔");
        noti.setPreferredSize(new Dimension (50, 20));
        TopRight.add(noti);

        JButton drawerButton = new JButton("Menu");
        JPopupMenu acc = new JPopupMenu();

        JButton[] drawers = {
            new JButton("Setting"),
            new JButton("Dashboard"),
            new JButton("Result")
        };
        for (JButton drawer : drawers) {
            acc.add(drawer);
        }

        TopRight.add(acc);
        acc.setVisible(false);
        TopRight.add(drawerButton);
        drawerButton.setPreferredSize(new Dimension(70, 20));
        drawerButton.addActionListener(e -> {
            acc.show(drawerButton , 0 , drawerButton.getHeight());
        });

        // ================================
        JFrame window = new JFrame("GIC Copy");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        window.setSize(800, 600);
        window.setLocationRelativeTo(null);

        window.add(nav, BorderLayout.NORTH);

        window.getContentPane().setBackground(Color.GRAY);
        window.setVisible(true);
    }
}

class PlaceholderTextField extends JTextField {
    private final String placeholder;

    PlaceholderTextField(String placeholder, int columns) {
        super(columns);
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (!getText().isEmpty()) {
            return;
        }

        Graphics2D g = (Graphics2D) graphics.create();
        try {
            Color color = UIManager.getColor("TextField.placeholderForeground");
            if (color == null) {
                color = UIManager.getColor("TextField.inactiveForeground");
            }
            g.setColor(color != null ? color : new Color(128, 128, 128));

            Insets insets = getInsets();
            FontMetrics metrics = g.getFontMetrics(getFont());
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g.drawString(placeholder, insets.left, y);
        } finally {
            g.dispose();
        }
    }
}
