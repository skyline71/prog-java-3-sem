package Practice17;

import Practice11.StudentGPA;
import Practice11.SortingStudentsByGPA;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        ClassTask2 task2 = new ClassTask2();
        task2.createList();
        System.out.println("Полученный список студентов:");
        task2.getList();
        Scanner s = new Scanner(System.in);
        System.out.print("Введите имя студента: ");
        String name = s.next();
        try {
            System.out.println(task2.searchStudent(name));
        } catch (SearchException e) {
            System.out.println("Student not found");
        }
    }
}

class SearchException extends Exception {
    SearchException() {
        super("Object search exception");
    }
}

class ClassTask2 {
    private StudentGPA[] students;

    public void createList() {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите количество элементов класса StudentGPA");
        int n = s.nextInt();
        students = new StudentGPA[n];
        double[] valueGPA = new double[n];
        for(int i = 0; i < valueGPA.length; i++) {
            valueGPA[i] = Math.round(Math.random() * 1000) / 10.;
            students[i] = new StudentGPA(String.format("Student#%d", i+1), valueGPA[i]);
        }
    }

    public void sortList() {
        SortingStudentsByGPA.quickSort(students,0, students.length - 1);
    }

    public void getList() {
        for (StudentGPA student : students) {
            System.out.println(student);
        }
    }

    public StudentGPA searchStudent(String studentName) throws SearchException {
        for (StudentGPA student : students) {
            if(Objects.equals(student.getName(), studentName)) {
                return student;
            }
        }
        throw new SearchException();
    }
}
