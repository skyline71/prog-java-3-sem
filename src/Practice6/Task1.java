package Practice6;

public class Task1 {
    public static void main(String[] args) {
        Dish plate = new Plate("RED", 500, 5);
        System.out.println(plate);
        SoupPlate plate1 = new SoupPlate("GREEN", 350, 5, 3);
        System.out.println(plate1);
    }
}

abstract class Dish {
    protected String color;
    protected double weight;

    public Dish() {};

    public Dish(String color, double weight) {
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

    public abstract double getSize();
    public abstract String toString();
}

class Plate extends Dish {
    protected int radius;
    protected int height;

    public Plate() {};

    public Plate(String color, double weight, int radius) {
        this.color = color;
        this.weight = weight;
        this.radius = radius;
        this.height = 1;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getSize() {
        return Math.round(Math.PI * radius*radius * height * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Тарелка - Цвет: " + getColor() + ", Вес: " + getWeight() + ", Радиус: " +
                getRadius() + ", Размер: " + getSize();
    }
}

class SoupPlate extends Plate {
    public SoupPlate() {};

    public SoupPlate(String color, double weight, int radius, int height) {
        this.color = color;
        this.weight = weight;
        this.radius = radius;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return "Суповая тарелка - Цвет: " + getColor() + ", Вес: " + getWeight() + ", Радиус: " +
                getRadius() + ", Глубина: " + getHeight() + ", Размер: " + getSize();
    }
}

