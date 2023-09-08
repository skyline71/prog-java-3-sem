package Practice1;

public class Task6 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            double digit = 1./(i + 1);
            if(i == 0) { System.out.println(i + 1); }
            else {
                System.out.print("1/" + (i + 1) + " = ");
                System.out.println(Math.round(digit * 100.0) / 100.0);
            }

        }
    }
}
