package Practice8;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Task3 {
    Thread thread;
    ImageIcon images;
    JFrame frame;
    JLabel label;
    Panel panel;

    public Task3() {
        frame = new JFrame("View animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        thread = new Thread();
        label = new JLabel();
        panel = new Panel();
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);

        while(true) {
            startAnim();
        }
    }

    public void startAnim() {
        try {
            for(int i = 1; i <= 5; i++) {
                URL url = Task3.class.getResource(i + ".png");
                images = new ImageIcon(url);
                label.setIcon(images);
                thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {}
    }

    public static void main(String[] args) {
        new Task3();
    }
}