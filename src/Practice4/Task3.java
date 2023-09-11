package Practice4;

import java.util.Scanner;
public class Task3 {
    static void payOrder(double sum) {
        Scanner s = new Scanner(System.in);
        if(sum != 0) {
            System.out.println("Товар добавлен успешно. Выберите валюту для оплаты (Нажмите соответствующую цифру на клавиатуре)");
            System.out.println("1 - Доллар США (USD) \n2 - Евро (EUR) \n3 - Рубль (RUB) \n4 - Казахстанский тенге (KZT)");
            while(!s.hasNextInt()) {
                if(!s.hasNextInt()) System.out.println("Необходимо ввести целое число!");
                s.nextLine();
            }
            int ans = 0;
            boolean newFlag = false;
            while(!newFlag) {
                while(!s.hasNextInt()) {
                    if(!s.hasNextInt()) System.out.println("Необходимо ввести целое число!");
                    s.nextLine();
                    s.nextLine();
                }
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

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf(15);
        bookshelf.fillBookshelf();
        User user = new User();
        System.out.println("Рады приветствовать Вас в книжном интернет-магазине Маст-рид! Пожалуйста, пройдите авторизацию");
        System.out.print("Введите логин ");
        while(!user.setName(s.nextLine())) System.out.print("Введите логин ");
        System.out.print("Введите пароль ");
        while(!user.setPassword(s.nextLine())) System.out.print("Введите пароль ");

        System.out.println("Выберите соответсвующий каталог (Нажмите цифру на клавиатуре)");
        System.out.printf("1 - %s\n2 - %s\n3 - %s\n", Genre.ART.getTranslation(),
                Genre.SCIENCE.getTranslation(),Genre.SELFHELP.getTranslation());
        int key = 0;
        while(true) {
            switch(s.nextLine()) {
                case "1": bookshelf.getArtBooks(); key = 1; break;
                case "2": bookshelf.getScienceBooks(); key = 2; break;
                case "3": bookshelf.getSelfhelpBooks(); key = 3; break;
                default: System.out.println("Недопустимое значение!"); continue;
            }
            break;
        }

        System.out.println("\nДобавить товар в корзину");
        double sum = bookshelf.getOrderAmount(key);
        payOrder(sum);
    }
}

class Book {
    private String author;
    private String title;
    private double price;
    private int amount;
    private int id;

    public Book(String authorName, String title, double price, int amount, int id) {
        this.author = authorName;
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
}
class Bookshelf {
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

    public void getBooks(int begin, int end) {
        for(int i = begin; i < end; i++) {
            System.out.printf("Книга #%d\t\t", (i%5)+1);
            System.out.printf("Автор: %s, ", books[i].getAuthor());
            System.out.printf("Название: %s, ", books[i].getTitle());
            System.out.printf("Количество: %s, ", books[i].getAmount());
            System.out.printf("Цена: %s RUB\n", books[i].getPrice());
        }
    }

    public Book getBookById(int id) {
        return books[id];
    }

    public void fillBookshelf() {
        String[] authors = new String[]{"Булкагов М.А.", "Булкагов М.А.", "Достоевский Ф.М.", "Достоевский Ф.М.",
                "Есенин С.A.", "Д. Кнут", "А. Бхаргава", "Сканави М.И.", "Перельман Я.И.", "Окунь Л.Б.", "Д. Аллен",
                "Ч. Дахигг", "Б. Шефер", "Сунь-Цзы", "Х. Элрод"};
        String[] titles = new String[]{"Мастер и Маргарита", "Белая Гвардия", "Идиот", "Братья Карамазовы",
                "Стихотворения и поэмы", "Искусство программирования", "Грокаем алгоритмы", "Сборник задач по математике",
                "Занимательная геометрия", "Физика элементарных частиц", "Как привести дела в порядок", "Сила привычки",
                "Искусство управлять своим временем", "Искусство войны", "Магия утра"};
        double[] prices = new double[]{670.99, 540.50, 460.00, 799.99, 950.00, 375.50, 399.99, 299.00, 270.50,
                329.00, 699.99, 550.00, 730.50, 450.00, 560.00};
        int[] amounts = new int[]{8, 3, 4, 10, 5, 2, 5, 12, 4, 16, 5, 11, 10, 13, 14};
        Book newBook;
        for(int i = 0; i < size; i++) {
            newBook = new Book(authors[i], titles[i], prices[i], amounts[i], i);
            addBook(newBook);
        }
    }

    public void getArtBooks() {
        getBooks(0,5);
    }
    public void getScienceBooks() {
        getBooks(5,10);
    }
    public void getSelfhelpBooks() {
        getBooks(10,15);
    }

    public boolean checkBooksNumber(int count, int key, int loop) {
        int[] counts = new int[5];
        switch(key) {
            case 1: counts = new int[]{8, 3, 4, 10, 5}; break;
            case 2: counts = new int[]{2, 5, 12, 4, 16}; break;
            case 3: counts = new int[]{5, 11, 10, 13, 14}; break;
        }
        boolean flag = false;
        String warn = "Число не соответствует количеству книг на складе!";
        switch(loop) {
            case 0: {
                if (count < 0 || count > counts[0]) {
                    flag = false;
                    System.out.println(warn);
                }
                else flag = true; break;
            }
            case 1: {
                if (count < 0 || count > counts[1]) {
                    flag = false;
                    System.out.println(warn);
                }
                else flag = true; break;
            }
            case 2: {
                if (count < 0 || count > counts[2]) {
                    flag = false;
                    System.out.println(warn);
                }
                else flag = true; break;
            }
            case 3: {
                if (count < 0 || count > counts[3]) {
                    flag = false;
                    System.out.println(warn);
                }
                else flag = true; break;
            }
            case 4: {
                if (count < 0 || count > counts[4]) {
                    flag = false;
                    System.out.println(warn);
                }
                else flag = true; break;
            }
        }
        return flag;
    }

    double getOrderAmount(int key) {
        Scanner s = new Scanner(System.in);
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
                if(checkBooksNumber(count, key, i)) flag = true;
                else flag = false;
            }
            switch(key) {
                case 1: sum += count * getBookById(i).getPrice(); break;
                case 2: sum += count * getBookById(i+5).getPrice(); break;
                case 3: sum += count * getBookById(i+10).getPrice(); break;
            }
        }
        return sum;
    }
}

class User {
    private String name;
    private String password;

    public User() {
        setName("user");
        setPassword("password");
    }

    public boolean setName(String userName) {
        if(userName.isEmpty()) {
            System.out.println("Логин не может быть пустой строкой");
            return false;
        }
        name = userName;
        return true;
    }

    public boolean setPassword(String userPassword) {
        if(userPassword.isEmpty()) {
            System.out.println("Пароль не может быть пустой строкой");
            return false;
        }
        password = userPassword;
        return true;
    }
}

enum Genre {
    ART("Художественная литература"),
    SCIENCE("Научная литература"),
    SELFHELP("Саморазвитие");

    private String translation;

    Genre(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
