package Practice20;

import javax.swing.*;
import java.awt.*;

public class CalcView {
    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonPoint = new JButton(".");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonDiv = new JButton("/");
    JButton buttonEqual = new JButton("=");
    JButton buttonC = new JButton("C");
    JButton buttonCE = new JButton("CE");

    CalcView() {
        mainWindow();
        setComponents();
    }

    public void mainWindow() {
        frame = new JFrame("Calculator");
        frame.setSize(400, 610);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setComponents() {
        label.setBounds(260, 10, 100, 50);
        label.setFont(new Font("Arial", Font.BOLD, 23));
        label.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(label);

        textField.setBounds(10, 60, 360, 50);
        textField.setFont(new Font("Arial", Font.BOLD, 25));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        buttonC.setBounds(100, 120, 80, 80);
        buttonC.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonC);

        buttonCE.setBounds(190, 120, 80, 80);
        buttonCE.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonCE);

        button7.setBounds(10, 210, 80, 80);
        button7.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button7);

        button8.setBounds(100, 210, 80, 80);
        button8.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button8);

        button9.setBounds(190, 210, 80, 80);
        button9.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button9);

        buttonDiv.setBounds(290, 120, 80, 80);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonDiv);

        button4.setBounds(10, 300, 80, 80);
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button4);

        button5.setBounds(100, 300, 80, 80);
        button5.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button5);

        button6.setBounds(190, 300, 80, 80);
        button6.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button6);

        buttonMul.setBounds(290, 210, 80, 80);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonMul);

        button1.setBounds(10, 390, 80, 80);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button1);

        button2.setBounds(100, 390, 80, 80);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button2);

        button3.setBounds(190, 390, 80, 80);
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button3);

        buttonMinus.setBounds(290, 300, 80, 80);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonMinus);

        button0.setBounds(10, 480, 170, 80);
        button0.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button0);

        buttonPoint.setBounds(190, 480, 80, 80);
        buttonPoint.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonPoint);

        buttonPlus.setBounds(290, 390, 80, 80);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonPlus);

        buttonEqual.setBounds(290, 480, 80, 80);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEqual);

        textField.setText("0");
    }
}