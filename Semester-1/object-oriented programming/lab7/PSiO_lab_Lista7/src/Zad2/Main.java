package Zad2;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, false));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997, true));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, true));
        books.add(new Book("Clean Code", "Robert C. Martin", 2008, false));
        books.add(new Book("1984", "George Orwell", 1949, false));
        books.add(new Book("Animal Farm", "George Orwell", 1945, true));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, false));

        HashMap<String, ArrayList<Book>> booksByAuthor = new HashMap<>();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String author = book.getAuthor();

            if (!booksByAuthor.containsKey(author)) {
                booksByAuthor.put(author, new ArrayList<>());
            }
            booksByAuthor.get(author).add(book);
        }

        System.out.println("--- Authors and number of books ---");
        for (String author : booksByAuthor.keySet()) {
            System.out.println(author + ": " + booksByAuthor.get(author).size());
        }

        String authorWithMostBooks = "";
        int maxBooks = -1;

        for (String author : booksByAuthor.keySet()) {
            int count = booksByAuthor.get(author).size();
            if (count > maxBooks) {
                maxBooks = count;
                authorWithMostBooks = author;
            }
        }
        System.out.println("\nAuthor with the most books: " + authorWithMostBooks);

        int ageThreshold = 50;
        int currentYear = 2025;
        System.out.println("\n--- Books older than " + ageThreshold + " years ---");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (currentYear - book.getYear() > ageThreshold) {
                System.out.println(book);
            }
        }

        System.out.println("\n--- Borrowed books ---");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.isBorrowed()) {
                System.out.println(book);
            }
        }

        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - 1 - i; j++) {
                if (books.get(j).getYear() > books.get(j + 1).getYear()) {
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n--- Books sorted by year ---");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}
