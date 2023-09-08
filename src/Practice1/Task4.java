package Practice1;

import java.util.Scanner;
import java.util.Arrays;
public class Task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int n = s.nextInt();
        int[] arr = new int[n]; int sum = 0;
        int i = 0;
        do {
            arr[i] = s.nextInt();
            sum += arr[i];
            i++;
        } while(i < n);
        //System.out.println("Сумма = " + sum);
        sum = 0; i = 0;
        while(i < n) {
            sum += arr[i];
            i++;
        }
        System.out.println("Сумма = " + sum);
        int min = Arrays.stream(arr).min().orElseThrow();
        int max = Arrays.stream(arr).max().orElseThrow();
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
}
