package LibraryManagementSystem;


import java.util.Scanner;

public class Teacher extends Reader{
    public Teacher(){}
    public Teacher(int id, String name, String login, String password) {
        super(id, name, login, password);
    }

    public static void LogInTeacher(Library library, Scanner scanner){
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
        Teacher teacher= new Teacher(id, name, login, password);
        library.addTeacher(teacher);
    }
}
