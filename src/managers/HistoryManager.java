package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.text.SimpleDateFormat;
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
        System.out.println("Readers list");
        readerManager.printListReaders(readers);
        System.out.println("Choose reader number: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        
        // choose book number from the list
        System.out.println("Books list");
        bookManager.printListBooks(books);
        System.out.println("Choose book number: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        
        // initialize fields History
        History history = new History();
        history.setBook(books[numberBook-1]);
        history.setReader(readers[numberReader-1]);
        
        // add date of give book out
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }
    
    public History[] returnBook (History[] histories){
        // choose history number with given out book
        System.out.println("Given out books list");
        this.prinListReadingBooks(histories);
        System.out.print("Choose book number to return: ");
        int numberHistory = scanner.nextInt(); scanner.nextLine();
        // write date of return
        histories[numberHistory-1].setReturnBook(new GregorianCalendar().getTime());
        return histories;
        
    }

    public void prinListReadingBooks(History[] histories) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, hh:mm");
        for (int i = 0; i < histories.length; i++) {
            History history = histories[i];
            if (history.getReturnBook() == null) {
                System.out.printf("%d. %s%nReader: %s %s, %s%nGiven out at: %s%n", 
                    i+1,
                    history.getBook().getTitle(),
                    history.getReader().getName(),
                    history.getReader().getlastName(),
                    history.getReader().getPhone(),
                    sdf.format(history.getTakeOnBook()));
            }
        }
    
    }
    
    
    
    
}
