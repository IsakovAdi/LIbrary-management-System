package LibraryManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Book book1 = new Book(Library.genUniqueId(), "Арутюнян", "Организационное поведение");
        Book book2 = new Book(Library.genUniqueId(), "Ричард Бренсон", "К черту все, берись и делай");
        Book book3 = new Book(Library.genUniqueId(), "Говард Шульц", "Как чашка за чашкой строилась Starbucks");
        Book book4 = new Book(Library.genUniqueId(), "Шамиль Аляутдинов", "Деньги под контролем");
        Book book5 = new Book(Library.genUniqueId(), "Маркова", "Я познаю мир");
        Book book6 = new Book(Library.genUniqueId(), "Макси Ильяхов", "Пиши и сокращай");
        Book book7 = new Book(Library.genUniqueId(), "Валерий Синельников", "Прививка от стресса");
        Book book8 = new Book(Library.genUniqueId(), "Стюарт Котце", "Результативность");
        Book book9 = new Book(Library.genUniqueId(), "Филипп Котлер", "Основы Маркетинга");
        Book book10 = new Book(Library.genUniqueId(), "Бонни Вэнэк", "Кобра и наложница");

        Teacher teacher = new Teacher(Library.genUniqueId(), "Timur", "TimurCabr", "Timur");
        Student student = new Student(Library.genUniqueId(), "Adilet", "Adilet", "1994");
        List<Reader> readerList = new ArrayList<>();
        readerList.add(teacher);
        readerList.add(student);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);

        Library library = new Library(readerList, bookList);
        Scanner scanner = new Scanner(System.in);
        GetInfo.mainMenu(library, scanner);

    }
}
