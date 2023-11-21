package Practice18;

import java.io.Serializable;

public class Task3 {
    public static void main(String[] args) {
        Animal animal = new Animal("bird");
        GenericBox<String, Integer, Animal> box = new GenericBox<>("testString", 1, animal);
        System.out.println(box);
    }
}

class GenericBox<T extends Comparable<T>, V extends Serializable, K extends Animal> {
    private T content1;
    private V content2;
    private K content3;

    public GenericBox(T content1, V content2, K content3) {
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
    }

    public T getContentT() {
        return content1;
    }
    public V getContentV() {
        return content2;
    }
    public K getContentK() {
        return content3;
    }

    @Override
    public String toString() {
        return  content1 + " className: " + content1.getClass() + "\n" +
                content2 + " className: " + content2.getClass() + "\n" +
                content3 + " className: " +content3.getClass();
    }

    public int compareTo(T o) {
        return 0;
    }
}

class Animal {
    String type;

    public Animal(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
