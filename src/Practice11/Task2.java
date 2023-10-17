package Practice11;

import java.util.Random;
import java.util.Scanner;
public class Task2 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите количество элементов класса StudentGPA");
        int n = s.nextInt();
        StudentGPA[] students = new StudentGPA[n];
        double[] valueGPA = new double[n];
        for(int i = 0; i < valueGPA.length; i++) {
            valueGPA[i] = Math.round(Math.random() * 1000) / 10.;
            students[i] = new StudentGPA("Student#" + (i+1), valueGPA[i]);
        }
        SortingStudentsByGPA.quickSort(students, 0, students.length - 1);
        for(int i = 0; i < valueGPA.length; i++) {
            System.out.println(students[i]);
        }
    }
}

interface Comparator<T> {
    public int compareTo(T object);
}

class StudentGPA implements Comparator<StudentGPA> {
    private String name;
    private double gpa;

    public StudentGPA(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public int compareTo(StudentGPA object) {
        if(this.gpa > object.gpa) return 1;
        else if(this.gpa < object.gpa) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Ученик " + name + "\tс итоговым баллом " + gpa;
    }
}

class SortingStudentsByGPA {
    public static void quickSort(Comparator[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        Comparator border = sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i].compareTo(border) > 0) i++;
            while (sortArr[j].compareTo(border) < 0) j--;
            if (i <= j) {
                Comparator swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }
}



