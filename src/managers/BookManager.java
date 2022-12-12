package managers;

import entity.Author;
import entity.Book;
import java.util.Arrays;
import java.util.List;
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
        System.out.println("How many books in library: ");
        book.setQuantity(scanner.nextInt());
        scanner.nextLine();
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
    
    public void printListBooks(List<Book> books){
        for (int i = 0; i < books.size(); i++) {
            Book book1 = books.get(i);
            System.out.printf("%d: %s; ",i+1, book1.getTitle());
            System.out.print("\n\tAuthors: ");
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
            System.out.printf("\n\tAvailable: %d pieces ", book1.getQuantity());
            
            System.out.println("");
        }
    }
    
    public List<Book> editBook(List<Book> books){
        this.printListBooks(books);
        System.out.print("Choose book number to edit: ");
        int bookNrToEdit = scanner.nextInt()-1; scanner.nextLine();
        System.out.printf("Edit title '%s'? Choose option: (y / n) ", books.get(bookNrToEdit).getTitle());
            String task = scanner.nextLine();
            switch (task.toLowerCase()){
                case "y":
                    System.out.print("Input new title: ");
                    books.get(bookNrToEdit).setTitle(scanner.nextLine());
                break;
            }
            System.out.println("This book has " + books.get(bookNrToEdit).getAuthors().length + " author(s)");
            System.out.println("Change authors quantity? (y / n)");
            task = scanner.nextLine();
            switch(task.toLowerCase()){
                case "y":
                System.out.println("Input new authors quantity");   // can be less or more than recorded
                
                int newAuthorsQtyAtBook = scanner.nextInt(); scanner.nextLine();
                // if new qty less, than output numeric list of authors and ask specify what to be deleted
                if(newAuthorsQtyAtBook < books.get(bookNrToEdit).getAuthors().length){
                    int deltaAuthors = books.get(bookNrToEdit).getAuthors().length - newAuthorsQtyAtBook;
                    for (int n = 0; n < deltaAuthors; n++) {
                        //удаляем лишних (deltaAuthors) авторов из книги
                        for (int i = 0; i < books.get(bookNrToEdit - 1).getAuthors().length; i++) {
                            System.out.println(
                                        i+1+". "+books.get(bookNrToEdit - 1).getAuthors()[i].getName()+" "+
                                                books.get(bookNrToEdit - 1).getAuthors()[i].getlastName());
                            }
                        System.out.println("Какого автора удалить? ");
                        int numDeleteAuthor = scanner.nextInt();
                        scanner.nextLine();
                        books.get(bookNrToEdit - 1).removeAuthor(numDeleteAuthor-1);
                    }
                }else{
                    for (int i = 0; i < newAuthorsQtyAtBook; i++) {
                        // newAuthorsQtyAtBook more than authors qty in book
                        if (i >= books.get(bookNrToEdit).getAuthors().length) {
                            // add new author to the book
                            Author newAuthor = new Author();
                            System.out.print("Input new author name " + (i+1) + ": ");
                            newAuthor.setName(scanner.nextLine());
                            System.out.print("Input new author lastname " + (i+1) + ": ");
                            newAuthor.setlastName(scanner.nextLine());
                            books.get(bookNrToEdit).addAuthor(newAuthor);
                        }else if(i < books.get(bookNrToEdit).getAuthors().length){
                            // change existing authors
                            System.out.println(i+1 + "author: " 
                                                + books.get(bookNrToEdit).getAuthors()[i].getName() + " " 
                                                +books.get(bookNrToEdit).getAuthors()[i].getlastName() );
                            System.out.print("Edit author name? (y / n)" );
                            task = scanner.nextLine();
                            switch(task.toLowerCase()){
                                case "y":
                                    System.out.print("Input new name: " );
                                    books.get(bookNrToEdit).getAuthors()[i].setName(scanner.nextLine());
                                    break;
                            }
                            System.out.print("Edit author lastname? (y / n)" );
                            task = scanner.nextLine();
                            switch(task.toLowerCase()){
                                case "y":
                                    System.out.print("Input new lastname: " );
                                    books.get(bookNrToEdit).getAuthors()[i].setlastName(scanner.nextLine());
                                    break;
                            }
                        }
                    }
                }
            }
//            for (int i = 0; i < books[bookNrToEdit].getAuthors().length; i++) {
//                System.out.print(books[bookNrToEdit].getAuthors()[i]);
//            }
//            System.out.println("\nEdit author(s)? Choose option: (y / n) ");
//            task = scanner.nextLine();
//            switch (task.toLowerCase()){
//                case "y":
//                    for (int i = 0; i < books[bookNrToEdit].getAuthors().length; i++) {
//                       books[bookNrToEdit].addAuthor(createAuthor());
//                    }
//                break;
//            }
            System.out.printf("Edit quantity '%d'? Choose option: (y / n) ", books.get(bookNrToEdit).getQuantity());
            task = scanner.nextLine();
            switch (task.toLowerCase()){
                case "y":
                    System.out.print("Input new quantity: ");
                    books.get(bookNrToEdit).setQuantity(scanner.nextInt()); scanner.nextLine();
                break;
            }
        return books;
    }

    private Book deleteAuthorBook(Book book) {
        for (int i = 0; i < book.getAuthors().length; i++) {
            System.out.println(
                i+1 + ". " 
                + book.getAuthors()[i].getName() + " " 
                + book.getAuthors()[i].getlastName());
        }
        System.out.print("Choose author number to delete: ");
        int authorNumDelete = scanner.nextInt(); scanner.nextLine();
        book.removeAuthor(authorNumDelete);
        return book;
    }
    
    
    
    
    
    
    
}   // public class BookManager ends
