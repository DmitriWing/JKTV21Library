package managers;

import entity.Author;
import entity.Book;
import java.util.Scanner;

public class BookManager {
    private final Scanner scanner;
//    private Book[] books;     // initialize object book with null = link to Book[0]

    public BookManager() {
        scanner = new Scanner(System.in);
    }
    
    public Book createBook(){
        
        Book book =  new Book();
        System.out.println("Input book title: ");
        book.setTitle(scanner.nextLine());  // call class book.method setTitle(value)
        System.out.println("How many authors: ");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countAuthorsInBook; i++) {
            book.addAuthor(createAuthor());     // class book.method addAuthor(method CreateAuthor());
        }
        return book;
    }
    
    private Author createAuthor() {
       Author author = new Author();   // create variable based on class Author
       System.out.println("Author name: ");
       author.setName(scanner.nextLine());     // initialize author by setter
       System.out.println("Author lastname: ");
       author.setlastName(scanner.nextLine());
       return author;
    }
    
    public void printListBooks(Book[] books){
        for (int i = 0; i < books.length; i++) {
            Book book1 = books[i];
            System.out.printf("%d: %s; ",i+1, book1.getTitle());
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
    }

    public void editBook(Book[] books) {
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
    }
}
