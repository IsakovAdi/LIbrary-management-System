package LibraryManagementSystem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private int id;
    private String author;
    private String name;
    private boolean inStock = true;
    private Reader user;

    public Book(int id, String author, String name) {
        this.id = id;
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void isInStock(Library library) {
        List<Book> bookList = library.getBookList();
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Reader getUser() {
        return user;
    }

    public void setUser(Reader user) {
        this.user = user;
    }


    public static void addNewBook(Library library, Scanner scanner) {
        int id = 0;
        String author = null;
        String name = null;


        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                id = Library.genUniqueId();
            } else if (i == 1) {
                System.out.println("Enter the author");
                author = scanner.next();
            } else {
                System.out.println("Enter name of book...");
                name = scanner.next();
            }
        }
        System.out.println("Your book: ");
        System.out.println("ID: " + id + " | Author: " + author + " | name: " + name);
        Book book = new Book(id, name, author);
        library.addBook(book);
    }

    public static void searchBook(Library library, BufferedReader reader) throws IOException {
        System.out.println("Please, enter author or title of the book");
        List<Book> bookList = library.getBookList();
        List<Book> searchedBooks = new ArrayList<>();
        String search = reader.readLine().toLowerCase();
        while (search.isEmpty()) {
            System.out.println("No input is detected. Try again!");
            search = reader.readLine().toLowerCase();
        }
        for (Book b : bookList) {
            if ((b.getName().toLowerCase().matches("(.*)" + search + "(.*)")) || (b.getAuthor().toLowerCase().matches("(.*)" + search + "(.*)"))) {
                searchedBooks.add(b);
                System.out.println("  Id: " + b.getId() + "   |   Author:  " + b.getAuthor() + "  |   Name:   " + b.getName() + "   |   inStock:   "+b.inStock);
            }
        }
    }

    public static void takeBook(Library library, BufferedReader reader, Reader signedReader) throws IOException {
        System.out.println("Please, enter the author or name of the book");
        String userBook = reader.readLine().toLowerCase();
        List<Book> bookList = library.getBookList();
        while (userBook.isEmpty()) {
            System.out.println("No input is detected. Try again!");
            userBook = reader.readLine().toLowerCase();
        }
        for (Book b : bookList) {
            if ((b.getName().toLowerCase().matches("(.*)" + userBook + "(.*)")) || (b.getAuthor().toLowerCase().matches("(.*)" + userBook + "(.*)"))) {
                b.inStock = false;
                System.out.println("You got the book:" + "  Id: " + b.getId() + "   |   Author:  " + b.getAuthor() + "  |   Name:   " + b.getName());
                b.setUser(signedReader);
                signedReader.addIssueBook(b);
            }
        }
    }

    public static void returnBook(BufferedReader reader, Reader signedReader) throws IOException {
        List<Book> bookList = signedReader.getIssuedBooks();
        System.out.println("Please, enter the author or name of the book");
        String userBook = reader.readLine().toLowerCase();
        for (Book b : bookList) {
            if ((b.getName().toLowerCase().matches("(.*)" + userBook + "(.*)")) || (b.getAuthor().toLowerCase().matches("(.*)" + userBook + "(.*)"))) {
                b.inStock = true;
                System.out.println("You return the book:" + "  Id: " + b.getId() + "   |   Author:  " + b.getAuthor() + "  |   Name:   " + b.getName());
                b.setUser(null);
                signedReader.removeIssuedBook(b);
            }
        }
    }

    public static void getAvailableBook(Library library) {
        List<Book> books = library.getBookList();
        List<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.inStock = true) {
                bookList.add(b);
            }
        }
        for (Book b : bookList) {
            System.out.println("ID: " + b.getId() + " | Name: " + b.getName() + " | Author: " + b.getAuthor() + " | Is in Stock:$" + b.inStock);
            System.out.println("-----------------------------------------------------------");
        }
    }

    public static void getInaccessibleBooks(Library library) {
        List<Book> books = library.getBookList();
        List<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.inStock = false) {
                bookList.add(b);
            }
        }
        for (Book b : bookList) {
            System.out.println("ID: " + b.getId() + " | Name: " + b.getName() + " | Author: " + b.getAuthor() + " | Is in Stock:$" + b.inStock);
            System.out.println("-----------------------------------------------------------");
        }
    }
}
