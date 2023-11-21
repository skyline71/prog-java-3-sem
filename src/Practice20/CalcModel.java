package Practice20;

public class CalcModel {
    private double number, result;
    private int operation;
    private boolean changed = false;
    private boolean activated = true;

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setOperation(int operation) { this.operation = operation; }

    public int getOperation() { return operation; }
}