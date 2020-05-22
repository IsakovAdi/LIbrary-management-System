package LibraryManagementSystem;

import java.util.Scanner;

public class Student extends Reader {
    public Student(){}
    public Student(int id, String name, String login, String password) {
        super(id, name, login, password);
    }

    public static void LogInStudent(Library library, Scanner scanner){
        int id = 0;
        String name = null;
        String login = null;
        String password = null;

        for (int i = 0; i <4 ; i++) {
            if (i==0){
                id = Library.genUniqueId();
            }
            else if (i==1){
                System.out.println("Enter your name");
                name=scanner.next();
            }
            else if (i==2){
                System.out.println("Enter the login");
                login = scanner.next();
            }
            else {
                System.out.println("Enter the password");
                password = scanner.next();
            }
        }
        Student student= new Student(id, name, login, password);
        library.addStudent(student);
    }
}
