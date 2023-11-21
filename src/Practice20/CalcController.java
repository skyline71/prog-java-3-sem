package Practice20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalcController implements ActionListener {
    CalcModel model;
    CalcView view;

    CalcController(CalcModel model, CalcView view) {
        this.model = model;
        this.view = view;
        addActionEvent();
    }

    public void addActionEvent() {
        view.button0.addActionListener(this);
        view.button1.addActionListener(this);
        view.button2.addActionListener(this);
        view.button3.addActionListener(this);
        view.button4.addActionListener(this);
        view.button5.addActionListener(this);
        view.button6.addActionListener(this);
        view.button7.addActionListener(this);
        view.button8.addActionListener(this);
        view.button9.addActionListener(this);
        view.buttonPlus.addActionListener(this);
        view.buttonMinus.addActionListener(this);
        view.buttonMul.addActionListener(this);
        view.buttonDiv.addActionListener(this);
        view.buttonPoint.addActionListener(this);
        view.buttonEqual.addActionListener(this);
        view.buttonC.addActionListener(this);
        view.buttonCE.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(Objects.equals(view.textField.getText(), "Некорректная операция")) {
            model.setActivated(false);
        }
        if(source == view.button0) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "0");
            }
            else {
                view.textField.setText("0");
            }
            model.setActivated(true);
        } else if(source == view.button1) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "1");
            } else {
                view.textField.setText("1");
                model.setChanged(true);
            }
            model.setActivated(true);
         } else if(source == view.button2) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "2");
            } else {
                view.textField.setText("2");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button3) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "3");
            } else {
                view.textField.setText("3");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button4) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "4");
            } else {
                view.textField.setText("4");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button5) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "5");
            } else {
                view.textField.setText("5");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button6) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "6");
            } else {
                view.textField.setText("6");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button7) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "7");
            } else {
                view.textField.setText("7");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button8) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "8");
            } else {
                view.textField.setText("8");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.button9) {
            if(model.isChanged()) {
                view.textField.setText(view.textField.getText() + "9");
            } else {
                view.textField.setText("9");
                model.setChanged(true);
            }
            model.setActivated(true);
        } else if(source == view.buttonPoint) {
            if(model.getActivated()) {
                if(view.textField.getText().contains(".")) {
                    return;
                } else {
                    view.textField.setText(view.textField.getText() + ".");
                    model.setChanged(true);
                }
            }
            model.setActivated(true);
        } else if(source == view.buttonPlus) {
            if(model.getActivated()) {
                String tmp = view.textField.getText();
                model.setNumber(Double.parseDouble(view.textField.getText()));
                view.label.setText(tmp + "+");
                model.setOperation(1);
                model.setChanged(false);
            }
        } else if(source == view.buttonMinus) {
            if(model.getActivated()) {
                String tmp = view.textField.getText();
                model.setNumber(Double.parseDouble(tmp));
                view.label.setText(tmp + "-");
                model.setOperation(2);
                model.setChanged(false);
            }
        } else if(source == view.buttonMul) {
            if(model.getActivated()) {
                String tmp = view.textField.getText();
                model.setNumber(Double.parseDouble(tmp));
                view.label.setText(tmp + "*");
                model.setOperation(3);
                model.setChanged(false);
            }
        } else if(source == view.buttonDiv) {
            if(model.getActivated()) {
                String tmp = view.textField.getText();
                model.setNumber(Double.parseDouble(tmp));
                view.label.setText(tmp + "/");
                model.setOperation(4);
                model.setChanged(false);
            }
        } else if(source == view.buttonC) {
            view.textField.setText("0");
            model.setNumber(0);
            model.setChanged(false);
            view.label.setText("");
        } else if(source == view.buttonCE) {
            view.textField.setText("0");
            model.setChanged(false);
        } else if(source == view.buttonEqual) {
            if(model.getActivated()) {
                buttonEquals();
            }
        }
        if(Objects.equals(view.textField.getText(), "Infinity") || Objects.equals(view.textField.getText(), "NaN")) {
            view.label.setText("");
            view.textField.setText("Некорректная операция");
        }
    }

    public void buttonEquals() {
        if(view.label.getText().endsWith("=")) {
            return;
        }
        switch(model.getOperation()) {
            case 1:
                view.label.setText(view.label.getText() + view.textField.getText() + "=");
                model.setResult(model.getNumber() + Double.parseDouble(view.textField.getText()));
                if (Double.toString(model.getResult()).endsWith(".0")) {
                    view.textField.setText(Double.toString(model.getResult()).replace(".0", ""));
                } else {
                    view.textField.setText(Double.toString(model.getResult()));
                }
                break;
            case 2:
                view.label.setText(view.label.getText() + view.textField.getText() + "=");
                model.setResult(model.getNumber() - Double.parseDouble(view.textField.getText()));
                if (Double.toString(model.getResult()).endsWith(".0")) {
                    view.textField.setText(Double.toString(model.getResult()).replace(".0", ""));
                } else {
                    view.textField.setText(Double.toString(model.getResult()));
                }
                break;
            case 3:
                view.label.setText(view.label.getText() + view.textField.getText() + "=");
                model.setResult(model.getNumber() * Double.parseDouble(view.textField.getText()));
                if (Double.toString(model.getResult()).endsWith(".0")) {
                    view.textField.setText(Double.toString(model.getResult()).replace(".0", ""));
                } else {
                    view.textField.setText(Double.toString(model.getResult()));
                }
                break;
            case 4:
                view.label.setText(view.label.getText() + view.textField.getText() + "=");
                model.setResult(model.getNumber() / Double.parseDouble(view.textField.getText()));
                if (Double.toString(model.getResult()).endsWith(".0")) {
                    view.textField.setText(Double.toString(model.getResult()).replace(".0", ""));
                } else {
                    view.textField.setText(Double.toString(model.getResult()));
                }
                break;
        }
        model.setChanged(false);
    }
}

