package Practice1;

public class Task6 {
    public static void main(String[] args) {
        double digit = 1;
        for(int i = 2; i < 12; i++) {
            System.out.printf("%3f\n", digit);
            digit += 1./i;
        }
    }
}
