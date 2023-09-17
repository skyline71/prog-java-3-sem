package Practice3;

public class Task21 {
    public static void main(String[] args) {
        Double d1 = Double.valueOf(2.71);

        Double d2 = Double.parseDouble("123.4");

        byte b1 = d1.byteValue();
        float f = d1.floatValue();
        int n = d1.intValue();
        long l = d1.longValue();
        short s = d1.shortValue();

        System.out.println(d2);

        String d = Double.toString(3.14);
    }
}
