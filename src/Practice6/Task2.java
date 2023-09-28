package Practice6;

public class Task2 {
    public static void main(String[] args) {
        Dog sheepdog = new Sheepdog("BLACK", 10);
        System.out.println(sheepdog);
        sheepdog.bark();
        Dog bulldog = new Bulldog("WHITE", 5);
        System.out.println(bulldog);
        bulldog.bark();
    }
}

abstract class Dog {
    protected String color;
    protected double weight;

    public Dog() {}

    public Dog(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void bark();
    public abstract String toString();
}

class Sheepdog extends Dog {
    public Sheepdog(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public void bark() {
        System.out.println("Овчарка лает так: WUUF WUUF");
    }

    @Override
    public String toString() { return "Собака - Овчарка, Окраска: " + getColor() + ", Вес: " + getWeight(); }
}

class Bulldog extends Dog {
    public Bulldog(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public void bark() {
        System.out.println("Бульдог лает так: wuf wuf");
    }

    @Override
    public String toString() {
        return "Собака - Бульдог, Окраска: " + getColor() + ", Вес: " + getWeight();
    }
}

