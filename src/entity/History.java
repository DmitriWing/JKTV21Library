package entity;

import java.io.Serializable;
import java.util.Date;


public class History implements Serializable{
    private Reader reader;
    private Book book;
    private Date takeOnBook;
    private Date returnBook;
    private int booksQtyTaken;
    
    
    public History() {
        
    }

    public History(Reader reader, Book book, Date takeOnBook, Date returnBook, int booksQtyTaken) {
        this.reader = reader;
        this.book = book;
        this.takeOnBook = takeOnBook;
        this.returnBook = returnBook;
        this.booksQtyTaken = booksQtyTaken;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getTakeOnBook() {
        return takeOnBook;
    }

    public void setTakeOnBook(Date takeOnBook) {
        this.takeOnBook = takeOnBook;
    }
    
    public int getBooksQtyTaken() {
        return booksQtyTaken;
    }

    public void setBooksQtyTaken(int booksQtyTaken) {
        this.booksQtyTaken = booksQtyTaken;
    }
    
    
    

    @Override
    public String toString() {
        return "History{" 
                + "reader=" + reader 
                + ", book=" + book 
                + ", takeOnBook=" + takeOnBook 
                + ", returnBook=" + returnBook 
                + ", taken=" + booksQtyTaken + " pieces"
                + '}';
    }

    
    
    
    
    
}
