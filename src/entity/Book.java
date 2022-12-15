package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book implements Serializable{      // implements Serializable: add new data type to class - Serializable. To have opportunity save data in files. Serializable returns array byte[].
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String title;
    @OneToMany
   private List<Author> authors = new ArrayList<>();
   private int quantity;
   
    public Book() {
    }

    public Book(String title, List<Author> authors, int quantity) {
        this.title = title;
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthors(List<Author> authors) {
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
                + Arrays.toString(authors.toArray()) 
                + ", quantity="
                + quantity 
                + '}';
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(int authorNumDelete) { 
          this.authors.remove(authorNumDelete);
    }


    
   
   
}
