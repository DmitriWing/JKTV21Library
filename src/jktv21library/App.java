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
            System.out.println("App functions:");
            System.out.println("0 - Quit");
            System.out.println("1 - Add book");
            System.out.println("2 - Add reader");
            System.out.println("3 - Give book out");
            System.out.println("4 - Return book");
            System.out.println("5 - Books list");
            System.out.println("6 - Readers list");
            System.out.println("7 - Edit book");
            System.out.println("8 - Given books out list");
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
                    System.out.println("2 - Add reader");
                    addReader(readerManager.createReader());
                    System.out.println(splitter);
                    break;
                case 3:
                    System.out.println("3 - Give book out");
                    addHistories(historyManager.takeOnBook(readers, books));
                    
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Return book");
                    histories = historyManager.returnBook(histories);
                    System.out.println(splitter);
                    break;
                case 5:
                    System.out.println("5 - Books list");
                    bookManager.printListBooks(books);
                    System.out.println(splitter);
                    break;
                case 6:
                    System.out.println("6 - Readers list");
                    readerManager.printListReaders(readers);
                    System.out.println(splitter);
                    break;
                case 7:
                    System.out.println("7 - Edit book");
                    System.out.println("Input book number you like to edit ");
                    int bookNrToEdit = scanner.nextInt()-1;
                    Book editBook = books[bookNrToEdit];    // editBook holds array element 
                    Book changeBook = new Book();           // changeBook will keep overpatching
                    System.out.println("Now you gonna edit book\n" + editBook);
                    System.out.println("Press 'T' to edit title\nPress 'A' to edit author(s)");
                    scanner.nextLine();
                    String whatToEdit = scanner.nextLine();
                    switch (whatToEdit.toUpperCase()){
                        case "T":
                            System.out.println("Input new title: ");
                            changeBook.setTitle(scanner.nextLine());        // set new title for changeBook
                            for (int i = 0; i < editBook.getAuthors().length; i++) {
                                changeBook.addAuthor(editBook.getAuthors()[i]);     // copy to changeBook array from editBook with old authors
                            }
                            books[bookNrToEdit] = changeBook;       // replace overpatching
                            break;
                        case "A":
                            System.out.println("This book has " + editBook.getAuthors().length + " author(s)");
                            if (editBook.getAuthors().length > 1) {     // if more than one author
                                for (int i = 0; i < editBook.getAuthors().length; i++) {
                                    System.out.println((i+1) + ". " + editBook.getAuthors()[i]);
                                }
                                System.out.println("Choose author number to edit");
                                int authorToEdit = scanner.nextInt()-1;
                                scanner.nextLine();
                                for (int i = 0; i < editBook.getAuthors().length; i++) {
                                    if (authorToEdit == i) {                    
                                        changeBook.addAuthor(createAuthor());   // create new author to changeBook
                                        
                                    }else {
                                        changeBook.addAuthor(editBook.getAuthors()[i]);     // copy not edited aothors for editBook to change Book
                                    }
                                }
                            }else{  // if only one author
                                System.out.println("Input new author data: ");
                                changeBook.addAuthor(createAuthor());
                            }
                            changeBook.setTitle(editBook.getTitle());       // copy title to changeBook from editBook
                            books[bookNrToEdit] = changeBook;               // replace overpatching
                            break;
                    }   // switch (whatToEdit.toUpperCase()) ends
                    System.out.println(splitter);
                case 8:
                    System.out.println("8 - Given books out list");
                    historyManager.prinListReadingBooks(histories);
                    
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
