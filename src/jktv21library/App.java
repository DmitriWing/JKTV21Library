package jktv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import managers.BaseManager;
import managers.BookManager;
import managers.ReaderManager;
import managers.HistoryManager;
import managers.DataManager;
import managers.interfaces.SaveManagerInterface;

public class App {
    public static boolean saveToBase;
    private final Scanner scanner;
    private final BookManager bookManager ;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private final SaveManagerInterface saveManager;
    private List<Book> books;
    private List<Reader> readers;
    private List<History> histories;

    public App() {
        scanner = new Scanner(System.in);
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
        if (App.saveToBase) {
        saveManager = new BaseManager();
        }else{
        saveManager = new DataManager();
        }
        books = saveManager.loadBooks();
        readers = saveManager.loadReaders();
        histories = saveManager.loadHistories();
    }
    public void run(){
        String splitter = "------------------------------------------------------------------------------";
        
        boolean repeat = true;
        do{
            System.out.println("0 - Quit");
            System.out.println("1 - Add book        | 2 - Books list    | 3 - Edit book");
            System.out.println("4 - Give book out   | 5 - Return book   | 6 - Given books out list");
            System.out.println("7 - Add reader      | 8 - Readers list  | 9 - Edit reader");
            System.out.println("Choose function number:");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    System.out.println("0 - Quit");
                    repeat = false;
                    System.out.println((splitter));
                   break;
                case 1:
                    System.out.println("1 - Add book");
                    books.add(bookManager.createBook());
                    saveManager.saveBooks(books);
                    System.out.println(splitter);
                   break;
                case 2:
                    System.out.println("2 - Books list");
                    bookManager.printListBooks(books);
                    System.out.println(splitter);
                    break;
                case 3:
                    System.out.println("3 - Edit book");
                    bookManager.editBook(books);
                    saveManager.saveBooks(books);
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Give book out");
                    histories.add(historyManager.takeOnBook(readers, books));
                    saveManager.saveHistories(histories);
                    System.out.println(splitter);
                    break;
                case 5:
                    System.out.println("5 - Return book");
                    histories = historyManager.returnBook(histories);
                    System.out.println(splitter);
                    break;
                case 6:
                    System.out.println("6 - Given books out list");
                    historyManager.prinListReadingBooks(histories);
                    System.out.println(splitter);
                    break;
                case 7:
                    System.out.println("7 - Add reader");
                    readers.add(readerManager.createReader());
                    saveManager.saveReaders(readers);
                    System.out.println(splitter);
                    break;
                case 8:
                    System.out.println("8 - Readers list");
                    readerManager.printListReaders(readers);
                    System.out.println(splitter);
                    break;
                case 9:
                    System.out.println("9 - Edit reader");
                    readers = readerManager.editReader(readers);
                    saveManager.saveReaders(readers);
                    System.out.println(splitter);
                    break;
                default:
                    System.out.println("Choose function number from the list!\n---------------------------------------------------------------------------");
            }
        }while(repeat);
        System.out.println("Good bye!");
    }

    private Author createAuthor() {
        Author author = new Author();   // create variable based on class Author
        System.out.println("Author name: ");
        author.setName(scanner.nextLine());     // initialize author by setter
        System.out.println("Author lastname: ");
        author.setlastName(scanner.nextLine());
        return author;
    }
    


    

}
