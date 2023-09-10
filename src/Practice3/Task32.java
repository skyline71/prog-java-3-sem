package Practice3;

import java.util.Scanner;
public class Task32 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Добро пожаловать в книжный интернет-магазин Маст-рид! Наш ассортимент:");
        Book.Bookshelf bookshelf = new Book.Bookshelf(5);
        Book newBook = new Book("Булкагов М.А.", "Мастер и Маргарита", 670.99, 3, 0);
        bookshelf.addBook(newBook);
        newBook = new Book("Булкагов М.А.", "Белая Гвардия", 540.50, 5, 1);
        bookshelf.addBook(newBook);
        newBook = new Book("Достоевский Ф.М.", "Идиот", 460.00, 10, 2);
        bookshelf.addBook(newBook);
        newBook = new Book("Достоевский Ф.М.", "Братья Карамазовы", 799.99, 6, 3);
        bookshelf.addBook(newBook);
        newBook = new Book("Есенин С.A.", "Стихотворения и поэмы", 950.00, 15, 4);
        bookshelf.addBook(newBook);
        bookshelf.getBooks();
        System.out.println("\nДобавить товар в корзину");
        double sum = 0;
        int count = 0;
        for(int i = 0; i < 5; i++) {
            boolean flag = false;
            while(!flag) {
                System.out.printf("Книга #%d (шт): ", i+1);
                while(!s.hasNextInt()) {
                    if(i == 0) {
                        if(!s.hasNextInt()) System.out.printf("Необходимо ввести целое число!\nКнига #%d (шт): ", i+1);
                        s.nextLine();
                    }
                    else {
                        s.nextLine();
                        if(!s.hasNextInt()) System.out.printf("Необходимо ввести целое число!\nКнига #%d (шт): ", i+1);
                    }
                }
                count = s.nextInt();
                String warn = "Число не соответствует количеству книг на складе!";
                switch(i) {
                    case 0: {
                        if (count < 0 || count > 3) {
                            flag = false;
                            System.out.println(warn);
                        }
                        else flag = true; break;
                    }
                    case 1: {
                        if (count < 0 || count > 5) {
                            flag = false;
                            System.out.println(warn);
                        }
                        else flag = true; break;
                    }
                    case 2: {
                        if (count < 0 || count > 10) {
                            flag = false;
                            System.out.println(warn);
                        }
                        else flag = true; break;
                    }
                    case 3: {
                        if (count < 0 || count > 6) {
                            flag = false;
                            System.out.println(warn);
                        }
                        else flag = true; break;
                    }
                    case 4: {
                        if (count < 0 || count > 15) {
                            flag = false;
                            System.out.println(warn);
                        }
                        else flag = true; break;
                    }
                }
            }
            sum += count * bookshelf.getBookById(i).getPrice();
        }
        if(sum != 0) {
            System.out.println("Товар добавлен успешно. Выберите валюту для оплаты (Нажмите соответствующую цифру на клавиатуре)");
            System.out.println("1 - Доллар США (USD) \n2 - Евро (EUR) \n3 - Рубль (RUB) \n4 - Казахстанский тенге (KZT)");
            int ans = 0;
            while(!s.hasNextInt()) {
                s.nextLine();
                if(!s.hasNextInt()) System.out.println("Необходимо ввести целое число!");
            }
            boolean newFlag = false;
            while(!newFlag) {
                ans = s.nextInt();
                String msg = "Товар добавлен успешно. Итоговая сумма заказа:";
                switch(ans) {
                    case 1: {
                        sum /= 100;
                        System.out.printf("%s %.2f USD", msg, sum);
                        newFlag = true; break;
                    }
                    case 2: {
                        sum /= 105;
                        System.out.printf("%s %.2f EUR", msg, sum);
                        newFlag = true; break;
                    }
                    case 3: {
                        System.out.printf("%s %.2f RUB", msg, sum);
                        newFlag = true; break;
                    }
                    case 4: {
                        sum *= 5;
                        System.out.printf("%s %.2f KZT", msg, sum);
                        newFlag = true;break;
                    }
                    default: {
                        System.out.println("Недопустимое значение!");
                        newFlag = false; break;
                    }
                }
            }
        }
        else {
            System.out.print("Корзина пуста. Выход...");
        }
    }
}


class Book {
    private String author;
    private String title;
    private double price;
    private int amount;
    private int id;

    public Book(String authorName, String title, double price, int amount, int id) {
        author = authorName;
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.id = id;
    }

    public String getAuthor () {
        return author;
    }
    public String getTitle () {
        return title;
    }
    public double getPrice () {
        return price;
    }
    public int getAmount () {
        return amount;
    }
    public int getId () {
        return id;
    }

    static class Bookshelf {
        private int size;
        private int top;
        private Book[] books;

        public Bookshelf(int number) {
            size = number;
            books = new Book[size];
            top = 0;
        }

        public void addBook(Book newBook) {
            books[top] = newBook;
            top++;
        }

        public Book getBookById(int id) {
            return books[id];
        }

        public void getBooks() {
            for (int i = 0; i < size; i++) {
                System.out.printf("Книга #%d\n", i+1);
                System.out.printf("Автор: %s, ", books[i].getAuthor());
                System.out.printf("Название: %s, ", books[i].getTitle());
                System.out.printf("Количество: %s, ", books[i].getAmount());
                System.out.printf("Цена: %s RUB\n", books[i].getPrice());
            }
        }
    }
}
