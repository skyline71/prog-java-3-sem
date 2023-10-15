package Practice8;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        URL url = Task2.class.getResource(path);
        ImageIcon image = new ImageIcon(url);

        JLabel label = new JLabel(image);
        JPanel pane = new JPanel();
        pane.add(label);

        JFrame frame = new JFrame();
        frame.setTitle("View image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(pane, BorderLayout.CENTER);
    }
}