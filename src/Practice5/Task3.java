package Practice5;

public class Task3 {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius()); method getRadius doesnt exist in Shape

        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        //Shape s2 = new Shape(); abstract class cant be initialized

        Rectangle s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength()); method getLength doesnt exist in Shape

        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getColor());
        System.out.println(s3.getLength());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide()); method getSide doesnt exist in Shape

        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide()); method getSide doesnt exist in Rectangle
        System.out.println(r2.getLength());

        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
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

