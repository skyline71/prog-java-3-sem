package Practice9;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car("Bus");
        Animal animal = new Animal("Sparrow");
        Human human = new Human("Tom");

        getName(car);
        getName(animal);
        getName(human);
    }

    public static void getName(Nameable object) {
        System.out.println(object.getName());
    }
}

interface Nameable {
    public String getName();
}

class Car implements Nameable {
    private String name;

    public Car(String name) { this.name = name; }
    public String getName() { return name; }
}

class Animal implements Nameable {
    private String name;

    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
}

class Human implements Nameable {
    private String name;

    public Human(String name) { this.name = name; }
    public String getName() { return name; }
}



