package Practice3;

public class Task21 {
    public static void main(String[] args) {
        Double d1 = Double.valueOf(2.71);
        Double d2 = Double.parseDouble("123.4");
        Byte b = d1.byteValue();
        Float f = d1.floatValue();
        Integer n = d1.intValue();
        Long l = d1.longValue();
        Short s = d1.shortValue();
        System.out.println(d2);
        String d = Double.toString(3.14);
    }
}
