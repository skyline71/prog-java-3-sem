package Practice17;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер ИНН: ");
        String inn = scanner.next();
        OrderException oe = new OrderException("");
        try {
            oe.checkValue(inn);
        } catch (OrderException e) {
            System.out.println("Некорректное значение ИНН");
        }
    }
}

class OrderException extends Exception {
    public OrderException(String message) {
        super(message);
    }

    public void checkValue(String tin) throws OrderException {
        try {
            Long.parseLong(tin);
        } catch (NumberFormatException e) {
            throw new OrderException("Wrong sequence of digits");
        }
        if (tin.length() != 12) {
            throw new OrderException("Wrong number of digits");
        }
        else {
            System.out.println("Заказ оформлен успешно");
        }
    }
}