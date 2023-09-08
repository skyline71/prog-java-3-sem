package Practice2;

import java.util.Scanner;
import java.util.Arrays;
public class BookTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Добавить книги? (YES/NO)");
        String ans = "";
        while(!(ans.equals("yes") || ans.equals("no"))) {
            ans = s.nextLine().toLowerCase();
            if(ans.equals("yes")) {
                boolean flag = true;
                String c = "";
                do {
                    System.out.print("Введите количество книг: ");
                    c = s.next();
                    for(int i = 0; i < c.length(); i++) {
                        if(!(Character.isDigit(c.charAt(i)) || c.charAt(i) == '-')) {
                            System.out.println("Необходимо ввести целое число!");
                            flag = false;
                            break;
                        }
                        flag = true;
                    }
                } while(!flag);
                int count = Integer.parseInt(c);
                if(count > 0) {
                    Book.Bookshelf bookshelf = new Book.Bookshelf(count);
                    for(int i = 0; i < count; i ++) {
                        Book newBook = new Book();
                        newBook.setId(i);
                        System.out.print("Введите автора: ");
                        s.nextLine();
                        newBook.setAuthor(s.nextLine());
                        System.out.print("Введите название: ");
                        newBook.setTitle(s.nextLine());
                        do {
                            System.out.print("Введите год выпуска: ");
                        } while(!newBook.setYear(s.next()));
                        bookshelf.addBook(newBook);
                    }
                    System.out.println("Книги добавлены успешно. Выберите пункт");
                    System.out.println("1 - Осмотреть книжную полку");
                    System.out.println("2 - Завершить работу");
                    String newAns = "0";
                    while(!(newAns.equals("1") || newAns.equals("2"))) {
                        newAns = s.next();
                        if(newAns.equals("1")) {
                            while(!newAns.equals("4")) {
                                if(!(newAns.equals("1") || newAns.equals("2")
                                        || newAns.equals("3") || newAns.equals("4"))) {
                                    newAns = s.next();
                                }
                                else {
                                    System.out.println("Выберите пункт");
                                    System.out.println("1 - Получить самую старую(новую) книгу на полке");
                                    System.out.println("2 - Получить список книг на полке");
                                    System.out.println("3 - Отсортировать книги по возрастанию года выпуска");
                                    System.out.println("4 - Завершить работу");
                                    newAns = s.next();
                                }
                                if(newAns.equals("1")) {
                                    int n = bookshelf.getBack().length, m = bookshelf.getFresh().length;
                                    Book[] backTmp = new Book[n]; Book[] freshTmp = new Book[m];
                                    for(int i = 0; i < n; i++) {
                                        backTmp[i] = bookshelf.getBack()[i];
                                    }
                                    for(int i = 0; i < m; i++) {
                                        freshTmp[i] = bookshelf.getFresh()[i];
                                    }
                                    System.out.println("Сведения о самой старой книге");
                                    for(int i = 0; i < n; i++) {
                                        System.out.print("Автор: " + backTmp[i].getAuthor() + ", ");
                                        System.out.print("Название: " + backTmp[i].getTitle() + ", ");
                                        System.out.println("Год выпуска: " + backTmp[i].getYear());
                                    }
                                    System.out.println("Сведения о самой новой книге");
                                    for(int i = 0; i < m; i++) {
                                        System.out.print("Автор: " + freshTmp[i].getAuthor() + ", ");
                                        System.out.print("Название: " + freshTmp[i].getTitle() + ", ");
                                        System.out.println("Год выпуска: " + freshTmp[i].getYear());
                                    }
                                }
                                else if(newAns.equals("2")) {
                                    bookshelf.getBooks();
                                }
                                else if(newAns.equals("3")) {
                                    bookshelf.sortBooks();
                                    System.out.println("Книги отсортированы успешно.");
                                }
                                else if(newAns.equals("4")) { return; }
                            }
                            return;
                        }
                        else if(newAns.equals("2")) { return; }
                    }

                }
                else {
                    System.out.println("Полка пуста. Выход...");
                    return;
                }
            }
            else if(ans.equals("no")) {
                System.out.println("Полка пуста. Выход...");
                return;
            }
        }
    }
}

class Book {
    private String author;
    private String title;
    private int pubYear;
    private int id;

    public void setAuthor(String name) { author = name; }
    public void setTitle(String title) { this.title = title; }
    public boolean setYear(String date) {
        for(int i = 0; i < date.length(); i++) {
            if(!Character.isDigit(date.charAt(i))) {
                System.out.println("Необходимо ввести целое число!");
                return false;
            }
        }
        pubYear = Integer.parseInt(date);
        return true;
    }
    public void setId(int number) { id = number; }
    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public int getYear() { return pubYear; }
    public int getId() { return id; }

    static class Bookshelf {
        private int amount;
        private int top;
        private Book[] books;

        public Bookshelf(int number) {
            amount = number;
            books = new Book[amount];
            top = 0;
        }

        public void addBook(Book newBook) {
            books[top] = newBook;
            top++;
        }

        public Book[] getBack() {
            Book[] backBooks;
            int minYear = Integer.MAX_VALUE;
            for(int i = 0; i < amount; i++) {
                if(books[i].pubYear < minYear) {
                    minYear = books[i].pubYear;
                }
            }
            int size = 0;
            for(int i = 0; i < amount; i++) {
                if(books[i].pubYear == minYear) { size++; }
            }
            backBooks = new Book[size]; int j = 0;
            for(int i = 0; i < amount; i++) {
                if(books[i].pubYear == minYear) {
                    backBooks[j] = books[i];
                    j++;
                }
            }
            return backBooks;
        }

        public Book[] getFresh() {
            Book[] freshBooks;
            int maxYear = Integer.MIN_VALUE;
            for(int i = 0; i < amount; i++) {
                if(books[i].pubYear > maxYear) {
                    maxYear = books[i].pubYear;
                }
            }
            int size = 0;
            for(int i = 0; i < amount; i++) {
                if(books[i].pubYear == maxYear) { size++; }
            }
            freshBooks = new Book[size]; int j = 0;
            for(int i = 0; i < amount; i++) {
                if(books[i].pubYear == maxYear) {
                    freshBooks[j] = books[i];
                    j++;
                }
            }
            return freshBooks;
        }

        public void getBooks() {
            for(int i = 0; i < amount; i++) {
                System.out.println("Книга #" + (i + 1));
                System.out.print("Автор: " + books[i].getAuthor() + ", ");
                System.out.print("Название: " + books[i].getTitle() + ", ");
                System.out.println("Год выпуска: " + books[i].getYear());
            }
        }

        public int getKey(Double number) {
            String str = Double.toString(number); String tmp = "";
            int i = str.indexOf(".");
            for(int j = i + 1; j < str.length(); j++) {
                tmp += str.charAt(j);
            }
            int key = Integer.parseInt(tmp);
            return key;
        }

        public void sortBooks() {
            double[] dates = new double[amount];
            for(int i = 0; i < amount; i++) {
                int digits = Integer.toString(books[i].id).length();
                double key = (double)books[i].id/(digits*10);
                dates[i] = books[i].pubYear + key;
            }
            Arrays.sort(dates);
            for(int i = 0; i < amount; i++) {
                int currId = getKey(dates[i]);
                for(int j = 0; j < amount; j++) {
                    if(books[j].id == currId) {
                        Book bookTmp = books[i];
                        books[i] = books[j];
                        books[j] = bookTmp;
                        break;
                    }
                }
            }
        }
    }
}
