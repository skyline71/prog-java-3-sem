package Practice22;

public class TestTask1 {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        Complex number1 = factory.CreateComplex(2,3);
        System.out.println(number1);
        Complex number2 = factory.createComplex();
        System.out.println(number2);
    }
}
