package Practice22;

public class FunctionalChair implements Chair {
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Functional chair that can calculate";
    }
}
