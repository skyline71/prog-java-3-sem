package Practice22;

public class VictorianChair implements Chair {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public VictorianChair() {
        this.age = 1;
    }

    public VictorianChair(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Victorian chair with age " + age;
    }
}
