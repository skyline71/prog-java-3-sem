package Practice11;

import java.util.Random;
import java.util.Scanner;
public class Task1 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите количество элементов класса Student");
        int n = s.nextInt();
        Student[] students = new Student[n];
        int[] idNumber = new int[n];
        for(int i = 0; i < idNumber.length; i++) {
            idNumber[i] = rand.nextInt(n*n) + 1;
            students[i] = new Student(idNumber[i], "Student#" + (i+1));
        }
        Sorting.insertionSort(students);
        for(int i = 0; i < idNumber.length; i++) {
            System.out.println(students[i]);
        }
    }
}

interface Comparable<T> {
    public int compareTo(T object);
}

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int compareTo(Student object) {
        if(this.id > object.id) return 1;
        else if(this.id < object.id) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Ученик " + name + "\tс индексом " + id;
    }
}

class Sorting {
    public static void insertionSort(Comparable[] list) {
        int j;
        for (int i = 1; i < list.length; i++) {
            Comparable swap = list[i];
            for (j = i; j > 0 && swap.compareTo(list[j - 1]) < 0; j--) {
                list[j] = list[j - 1];
            }
            list[j] = swap;
        }
    }
}



