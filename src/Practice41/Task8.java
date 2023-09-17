package Practice41;

public class Task8 {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "green", false);
        Rectangle rectangle = new Rectangle(10, 20, "yellow", true);
        Square square = new Square(3, "white", false);
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
    }
}

abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public  void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}

class Circle extends Shape {
    protected double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.round(Math.PI * radius*radius * 100.0) / 100.0;
    }

    public double getPerimeter() {
        return Math.round(2 * Math.PI * radius * 100.0) / 100.0;
    }

    public String toString() {
        return "Фигура: Круг, Цвет: " + getColor() + ", Заполнен: " + isFilled() + ", Радиус: " + getRadius()
                + ", Площадь: " + getArea() + ", Периметр: " + getPerimeter();
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return Math.round(width * length * 100.0) / 100.0;
    }

    public double getPerimeter() {
        return Math.round(2 * (width + length) * 100.0) / 100.0;
    }

    public String toString() {
        return "Фигура: Прямоугольник, Цвет: " + getColor() + ", Заполнен: " + isFilled() + ", Длина: "
                + getLength() + ", Ширина: " + getWidth() +", Площадь: " + getArea() + ", Периметр: " + getPerimeter();
    }
}

class Square extends Rectangle {
    public Square() {};

    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    public Square(double side, String color, boolean filled) {
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        this.length = side;
        this.width = side;
    }

    public String toString() {
        return "Фигура: Квадрат, Цвет: " + getColor() + ", Заполнен: " + isFilled() + ", Сторона: "
                + getSide() +", Площадь: " + getArea() + ", Периметр: " + getPerimeter();
    }
}