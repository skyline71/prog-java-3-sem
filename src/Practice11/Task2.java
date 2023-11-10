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









