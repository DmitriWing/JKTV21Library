package jktv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[0];     // initialize object book with null = link to Book[0]
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
            System.out.println("6 - Authors list");
            System.out.println("7 - Edit book");
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
                    Book book =  new Book();
                    System.out.println("Input book title: ");
                    book.setTitle(scanner.nextLine());  // call class book.method setTitle(value)
                    System.out.println("How many authors: ");
                    int countAuthorsInBook = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < countAuthorsInBook; i++) {
                        book.addAuthor(createAuthor());     // class book.method addAuthor(method CreateAuthor());
                    }
                    Book[] newBook = Arrays.copyOf(this.books, this.books.length+1);    // this - means that variable belong to the class
                    newBook[newBook.length-1] = book;
                    this.books = newBook;
                    
                    System.out.println(splitter);
                   break;
                case 2:
                    System.out.println("2 - Add reader");
                    Reader reader =  new Reader();
                    
                    System.out.println(splitter);
                    break;
                case 3:
                    System.out.println("3 - Give book out");
                    History history =  new History();
                    
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Return book");
                    
                    System.out.println(splitter);
                    break;
                case 5:
                    System.out.println("5 - Books list");
                    for (int i = 0; i < books.length; i++) {
                        Book book1 = books[i];
                        System.out.printf(i+1+": %s\n", book1.getTitle());
                        
                        for (int j = 0; j < book1.getAuthors().length; j++) {
                            System.out.printf("Authors: \n%s %s.%n",
                                    book1.getAuthors()[j].getName(),
                                    book1.getAuthors()[j].getlastName());
                        }
                    }
                    
                    System.out.println(splitter);
                    break;
                case 6:
                    System.out.println("6 - Authors list");
                    
                    System.out.println(splitter);
                    break;
                case 7:
                    System.out.println("7 - Edit book");
                    System.out.println("Input book number you like to edit ");
                    int bookNrToEdit = scanner.nextInt()-1;
                    Book editBook = books[bookNrToEdit];
                    Book changeBook = new Book();
                    
                    
                    
                    
                    System.out.println(splitter);
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
