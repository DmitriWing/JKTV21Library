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
//    private Author[] authors = new Author[0];
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
                        System.out.printf(i+1+": %s | ", book1.getTitle());
                        System.out.print("Authors: ");
                        for (int j = 0; j < book1.getAuthors().length; j++) {
                            if (j==(book1.getAuthors().length)-1) {     // current if-else construction is to avoid "," after last iteration
                                System.out.printf("%s %s",
                                    book1.getAuthors()[j].getName(),
                                    book1.getAuthors()[j].getlastName());
                            }else {
                            System.out.printf("%s %s, ",
                                    book1.getAuthors()[j].getName(),
                                    book1.getAuthors()[j].getlastName());
                            }
                        }
                        System.out.println("");
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
                            books[bookNrToEdit] = changeBook;               // // replace overpatching
                            break;
                    }   // switch (whatToEdit.toUpperCase()) ends
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
