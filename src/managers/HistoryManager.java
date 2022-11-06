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
//    private DataManager dataManager;

    public HistoryManager() {
        scanner = new Scanner(System.in);
        readerManager = new ReaderManager();
        bookManager = new BookManager();
    }
    
    public History takeOnBook(Reader[] readers, Book[] books){
        History history = new History();
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
        
        // choose how many books you take
        
        Boolean itemQty = true;
        do {
            System.out.println("How many books would you take? ");
            int booksQtyTaken = scanner.nextInt(); scanner.nextLine();
            if (booksQtyTaken > books[numberBook-1].getQuantity()) {
                System.out.println("Not enough books in library.");
            }else{
                history.setBook(books[numberBook-1]);
                history.setReader(readers[numberReader-1]);
                history.setBooksQtyTaken(booksQtyTaken);
                int remainedBooks = books[numberBook-1].getQuantity() - booksQtyTaken;
                books[numberBook-1].setQuantity(remainedBooks);
                itemQty = false;
            }
            
        } while (itemQty);

        
        // initialize fields History
        
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
        int numberHistory = scanner.nextInt() - 1; scanner.nextLine();
        // write date of return
        histories[numberHistory].setReturnBook(new GregorianCalendar().getTime());
        return histories;
    }

    public void prinListReadingBooks(History[] histories) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, hh:mm");
        for (int i = 0; i < histories.length; i++) {
            History history = histories[i];
            if (history.getReturnBook() == null) {
                System.out.printf("%d. %s%n\tReader: %s %s, %s %n\tTaken: %d pieces %n\tGiven out at: %s%n", 
                    i+1,
                    history.getBook().getTitle(),
                    history.getReader().getName(),
                    history.getReader().getlastName(),
                    history.getReader().getPhone(),
                    history.getBooksQtyTaken(),
                    sdf.format(history.getTakeOnBook()));
            }
        }
    
    }
    
    
    
    
}
