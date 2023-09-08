package Practice2;

import java.util.Scanner;
public class Task8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int n = s.nextInt();

        String[] arr = new String[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.next();
        }
        System.out.print("Исходный массив: ");
        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
        int k = 0;
        for(int i = arr.length - 1; i >= arr.length/2; i--) {
            String tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
            k++;
        }
        System.out.print("В обратном порядке: ");
        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}
