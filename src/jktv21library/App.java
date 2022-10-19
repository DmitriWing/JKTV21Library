package jktv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;
import managers.BookManager;
import managers.ReaderManager;
import managers.HistoryManager;

public class App {
    private final Scanner scanner;
    private final BookManager bookManager ;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private Book[] books;     // initialize object book with null = link to Book[0]
    private Reader[] readers;
    private History[] histories;
    

    public App() {
        scanner = new Scanner(System.in);
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
        
        books =  new Book[0];
        readers = new Reader[0];
        histories = new History[0];
        testAddbook();
        testAddReader();
    }
    public void run(){
        String splitter = "------------------------------------------------------------------------------";
        
        boolean repeat = true;
        do{
//            System.out.println("App functions:");
//            System.out.println("0 - Quit");
//            System.out.println("1 - Add book");
//            System.out.println("2 - Add reader");
//            System.out.println("3 - Give book out");
//            System.out.println("4 - Return book");
//            System.out.println("5 - Books list");
//            System.out.println("6 - Readers list");
//            System.out.println("7 - Edit book");
//            System.out.println("8 - Given books out list");
//            System.out.println("9 - Edit reader");
            
            System.out.println("0 - Quit");
            System.out.println("1 - Add book");
            System.out.println("2 - Books list");
            System.out.println("3 - Edit book");
            System.out.println("4 - Give book out");
            System.out.println("5 - Return book");
            System.out.println("6 - Given books out list");
            System.out.println("7 - Add reader");
            System.out.println("8 - Readers list");
            System.out.println("9 - Edit reader");
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
                    addBook(bookManager.createBook());
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
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Give book out");
                    addHistories(historyManager.takeOnBook(readers, books));
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
                    addReader(readerManager.createReader());
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
    
    private void addBook(Book book){
        books = Arrays.copyOf(books, books.length+1);
        books[books.length-1] = book;
    }
    
    private void addReader(Reader reader){
        readers = Arrays.copyOf(readers, readers.length+1);
        readers[readers.length-1] = reader;
    }
    
    private void addHistories(History history){
        histories = Arrays.copyOf(histories, histories.length+1);
        histories[histories.length-1] = history;
    }
    
    
    // to add book automatically
    private void testAddbook(){
        Book book = new Book();
        book.setTitle("War and Peace");
        Author author =  new Author("Lev", "Tolstoj");
        book.addAuthor(author);
        this.books = Arrays.copyOf(books, books.length + 1);
        this.books[this.books.length-1] = book;
    }
    
    // to add reader automatically
    private void testAddReader(){
        Reader reader = new Reader("Tolik", "Pruzhinkin", "55123123");
        this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
        this.readers[this.readers.length-1] = reader;
    }

}
