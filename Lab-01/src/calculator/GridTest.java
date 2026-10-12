package calculator;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(1, 9, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);

        ArrayList <JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(Integer.toString(i + 1));
            buttons.add(button);
            frame.add(button);
        }
        buttons.get(0).setLayout(new GridLayout(9, 1, 5, 5));
        for (int i = 0; i < 9; i++) {
            buttons.get(0).add(new JButton(Integer.toString(i + 1)));
        }

        frame.setVisible(true);
    }
}
