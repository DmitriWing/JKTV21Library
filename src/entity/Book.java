package entity;

import java.io.Serializable;
import java.util.Arrays;


public class Book implements Serializable{      // implements Serializable: add new data type to class - Serializable. To have opportunity save data in files. Serializable returns array byte[].
   private String title;
   private Author[] authors = new Author[0];
   private int quantity;

    public Book() {
    }

    public Book(String title, Author[] authors, int quantity) {
        this.title = title;
        this.authors = authors;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    @Override
    public String toString() {
        return "Book{" 
                + "title=" 
                + title 
                + ", authors=" 
                + Arrays.toString(getAuthors()) 
                + ", quantity="
                + quantity 
                + '}';
    }

    public void addAuthor(Author author) {
        Author[] newAuthors = Arrays.copyOf(authors, authors.length+1);     // create new array newAuthors = Arrays.copyOf(array to copy, qty of the cells)
        newAuthors[newAuthors.length-1] = author;
        this.authors = newAuthors;
    }

    public void removeAuthor(int authorNumDelete) { 
        this.getAuthors()[authorNumDelete-1] = null;        // reset specified author(by index) to null
        Author[] newAuthors = new Author[this.getAuthors().length - 1];     // create an array with less on 1 elements
        // copy elements to new array excluding null cell
        int j = 0;
        for (Author author : this.getAuthors()) {
            if (author != null) {
                newAuthors[j] = author;
                j++;
            }
        }
        this.setAuthors(newAuthors);    
    }

    
   
   
}
