package Practice7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1 extends JFrame {
    JButton team1 = new JButton("AC Milan");
    JButton team2 = new JButton("Real Madrid");
    JLabel result = new JLabel("Result: 0 X 0");
    JLabel last = new JLabel("Last Scorer: N/A");
    JLabel winner = new JLabel("Winner: DRAW");
    int score1 = 0;
    int score2 = 0;
    String teamLast = "N/A";
    String teamWin = "N/A";

    Task1() {
        super("Window");
        setLayout(new GridLayout(3,1));
        setSize(500, 500);
        add(team1);
        add(team2);
        add(result);
        add(last);
        add(winner);

        team1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                score1++;
                teamLast = "AC Milan";
                if(score1 > score2) {
                    teamWin = "AC Milan";
                }
                else if(score1 < score2) {
                    teamWin = "Real Madrid";
                }
                else {
                    teamWin = "DRAW";
                }
                result.setText("Result: " + score1 + " X " + score2);
                last.setText("Last Scorer: " + teamLast);
                winner.setText("Winner: " + teamWin);
            }
        });

        team2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                score2++;
                teamLast = "Real Madrid";
                if(score1 > score2) {
                    teamWin = "AC Milan";
                }
                else if(score1 < score2) {
                    teamWin = "Real Madrid";
                }
                else {
                    teamWin = "DRAW";
                }
                result.setText("Result: " + score1 + " X " + score2);
                last.setText("Last Scorer: " + teamLast);
                winner.setText("Winner: " + teamWin);
            }
        });
    }

    public static void main(String[] args) {
        new Task1().setVisible(true);
    }
}
