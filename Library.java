package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Reader> readerList;
    private List<Book> bookList;

    public Library(){}


    public Library(List<Reader> readerList, List<Book> bookList) {
        this.readerList = readerList;
        this.bookList = bookList;
    }

    public List<Reader> getReaderList() {
        return readerList;
    }

    public void setReaderList(List<Reader> readerList) {
        this.readerList = readerList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book){
        bookList.add(book);
    }
    public void addStudent(Student student){
        readerList.add(student);
    }
    public void addTeacher(Teacher teacher){
        readerList.add(teacher);
    }

    private static ArrayList<Integer> ids = new ArrayList<>();

    /**
     * происходит генерация нового уникального id
     * @return возвращает новую id
     */
    public static int genUniqueId(){
        int id = 0;
        while (true) {
            id = (int)(Math.random()*899)+100;
            if (checkForDuplicates(id)) {
                ids.add(id);
                break;
            }
        }
        return id;
    }

    /**
     * происходит проверка нового id на отсутствие дубликата
     * @param id новое сгенерированное id которую мы проверяем на уникальность
     * @return false если дубликат найден
     * @return true если дубликата нет
     */
    public static boolean checkForDuplicates(int id){
        for (int i:ids) {
            if (i == id){
                return false;
            }
        }
        return true;
    }
}
