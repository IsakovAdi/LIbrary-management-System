package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private int id;
    private String name;
    private String login;
    private String password;
    private List<Book> issuedBooks;

    public Reader() {
    }

    public Reader(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void addIssueBook(Book book) {
        issuedBooks.add(book);
    }

    public void removeIssuedBook(Book book){
        issuedBooks.remove(book);
    }

    public static void getReaderlist(Library library) {
        List<Reader> readers = library.getReaderList();
        for (Reader r : readers) {
            System.out.println("ID: " + r.getId() + " | Name: " + r.getName());
            System.out.println("-----------------------------------------------------------");
        }
    }


    public static void haveLogIn(Library library, Scanner scanner, BufferedReader reader) throws IOException {
        int counter = 0;
        System.out.println("Please, enter your login and password");
        String userLogin = scanner.next();
        while (counter <= 2) {
            if (userLogin.isEmpty()) {
                System.out.println("You haven't enter the login, please enter the login");
                counter++;
                if (counter == 2) {
                    System.out.println("You didn't enter the login 3 times");
                    LibraryManagementSystem.GetInfo.mainMenu(library, scanner);
                }
            } else {
                String userPassword = scanner.next();
                counter = 0;
                while (counter <= 2) {
                    if (userPassword.isEmpty()) {
                        System.out.println("You haven't enter the password, please enter the password");
                        counter++;
                        if (counter == 2) {
                            System.out.println("You didn't enter the password 3 times");
                            LibraryManagementSystem.GetInfo.mainMenu(library, scanner);
                        }
                    }
                    else {
                        Reader reader1 = getReader(library, userLogin, userPassword);
                        for (Reader r: library.getReaderList() ) {
                            if (r == reader1){
                                System.out.println("welcome " + r.getName());
                                GetInfo.signInMenu(library, scanner, reader);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Reader getReader(Library library, String login, String password) {
        List<Reader> readerList = library.getReaderList();
        Reader reader = new Reader();
        for (Reader r : readerList) {
            if (r.getLogin().equals(login) && r.getPassword().equals(password)) {
                reader = r;
            }
        }
        return reader;
    }

}
