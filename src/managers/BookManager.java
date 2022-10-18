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
}
