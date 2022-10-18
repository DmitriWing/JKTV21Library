package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class HistoryManager {
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;

    public HistoryManager() {
        scanner = new Scanner(System.in);
        readerManager = new ReaderManager();
        bookManager = new BookManager();
    }
    
    public History takeOnBook(Reader[] readers, Book[] books){
        // choose reader number from the list
        // choose book number from the list
        // initialize fields History
        // add date of give book out
        System.out.println("Readers list");
        readerManager.printListReaders(readers);
        System.out.println("Choose reader number: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Books list");
        bookManager.printListBooks(books);
        System.out.println("Choose book number: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        History history = new History();
        history.setBook(books[numberBook-1]);
        history.setReader(readers[numberReader-1]);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }
    
    
    
}
