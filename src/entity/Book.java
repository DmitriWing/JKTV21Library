package entity;

import java.io.Serializable;
import java.util.Arrays;


public class Book implements Serializable{      // implements Serializable: add new data type to class - Serializable. To have opportunity save data in files. Serializable returns array byte[].
   private String title;
   private Author[] authors = new Author[0];

    public Book() {
    }

    public Book(String title, Author[] authors) {
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

    @Override
    public String toString() {
        return "Book{" 
                + "title=" 
                + title 
                + ", authors=" 
                + Arrays.toString(getAuthors()) + '}';
    }

    public void addAuthor(Author author) {
        Author[] newAuthors = Arrays.copyOf(authors, authors.length+1);     // create new array newAuthors = Arrays.copyOf(array to copy, qty of the cells)
        newAuthors[newAuthors.length-1] = author;
        this.authors = newAuthors;
    }
    
   
   
}
