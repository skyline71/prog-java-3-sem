package Practice9;

public class Task2 {
    public static void main(String[] args) {
        Book book = new Book(699.99);
        Computer computer = new Computer(71800);
        Furniture furniture = new Furniture(220000);

        getPrice(book);
        getPrice(computer);
        getPrice(furniture);
    }

    public static void getPrice(Priceable object) {
        System.out.println(object.getPrice());
    }
}

interface Priceable {
    public double getPrice();
}

class Book implements Priceable {
    private double price;

    public Book(double price) { this.price = price; }
    public double getPrice() { return price; }
}

class Computer implements Priceable {
    private double price;

    public Computer(double price) { this.price = price; }
    public double getPrice() { return price; }
}

class Furniture implements Priceable {
    private double price;

    public Furniture(double price) { this.price = price; }
    public double getPrice() { return price; }
}



