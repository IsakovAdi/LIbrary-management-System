package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GetInfo {
    public static void mainMenu(Library library, Scanner scanner) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Welcome to the library management system");
        while (true) {
            System.out.println("Please, choose an option");
            System.out.println("1. Search a book");
            System.out.println("2. Available books");
            System.out.println("3. Browse users");
            System.out.println("4. Inaccessible books");
            System.out.println("5. Add book");
            System.out.println("6. Log in");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Book.searchBook(library, reader);
                    break;
                case 2:
                    Book.getAvailableBook(library);
                    break;
                case 3:
                    Reader.getReaderlist(library);
                    break;
                case 4:
                    Book.getInaccessibleBooks(library);
                    break;
                case 5:
                    Book.addNewBook(library, scanner);
                    break;
                case 6:
                    System.out.println("1. You have log in");
                    System.out.println("2. You have not log in");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            Reader.haveLogIn(library, scanner, reader);
                            signInMenu(library, scanner, reader);
                        case 2:
                        System.out.println("2. You are:");
                        System.out.println("1. Teacher");
                        System.out.println("2. Student");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                Teacher.LogInTeacher(library, scanner);
                                signInMenu(library, scanner, reader);
                            case 2:
                                Student.LogInStudent(library, scanner);
                                signInMenu(library, scanner, reader);
                        }
                        case 7:
                            System.out.println("Quitting...........");
                            System.exit(0);
                    }
            }
        }
    }

    public static void signInMenu(Library library, Scanner scanner, BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("Welcome to the library management system");
            System.out.println("Please, choose an option");
            System.out.println("1. Search a book");
            System.out.println("2. Available books");
            System.out.println("3. Browse users");
            System.out.println("4. Inaccessible books");
            System.out.println("5. Take the book");
            System.out.println("6. Return the book");
            System.out.println("7. Add book");
            System.out.println("8. Log out");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Book.searchBook(library, reader);
                    signInMenu(library, scanner, reader);
                case 2:
                    Book.getAvailableBook(library);
                    signInMenu(library, scanner, reader);
                case 3:
                    Reader.getReaderlist(library);
                    signInMenu(library, scanner, reader);
                case 4:
                    Book.getInaccessibleBooks(library);
                    signInMenu(library, scanner, reader);
                case 5:
                    System.out.println("Enter your login");
                    String login = reader.readLine();
                    System.out.println("Enter your password");
                    String password = reader.readLine();
                    Book.takeBook(library, reader, Reader.getReader(library, login, password));
                    signInMenu(library, scanner, reader);
                case 6:
                    System.out.println("Enter your login");
                    String userLogin = reader.readLine();
                    System.out.println("Enter your password");
                    String userPassword = reader.readLine();
                    Book.returnBook(reader, Reader.getReader(library,userLogin, userPassword));
                    signInMenu(library, scanner, reader);
                case 7:
                    Book.addNewBook(library, scanner);
                    signInMenu(library, scanner, reader);
                case 8:
                    mainMenu(library, scanner);
                    break;
                case 9:
                    System.out.println("Quitting...........");
                    System.exit(0);
            }
        }
    }
}
