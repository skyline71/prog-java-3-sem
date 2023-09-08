package Practice1;

import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int n = s.nextInt();
        int[] arr = new int[n]; int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.next());
        }
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("Среднее арифметическое = " + sum/n);
    }
}
