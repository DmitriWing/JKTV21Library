package managers;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import managers.interfaces.SaveManagerInterface;

public class BaseManager implements SaveManagerInterface{
    private final EntityManagerFactory emf; 
    private final EntityManager em;
    
    // constructor
    public BaseManager() {
        emf = Persistence.createEntityManagerFactory("JKTV21LibraryPU");
        em = emf.createEntityManager();
    }
    //------------------- books -------------------------------
    @Override
    public void saveBooks(List<Book> books){
        em.getTransaction().begin();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            for (int j = 0; j < book.getAuthors().size(); j++) {
                Author author = book.getAuthors().get(j);
                if (author.getId() == null) {
                    em.persist(author);
                }else{
                    em.merge(author);
                }
            }   // ends for (int j = 0; j < book.getAuthors().size(); j++)
            if (book.getId() == null) {
                em.persist(book);
            }else{
                em.merge(book);
            }
        }   // ends for (int i = 0; i < books.size(); i++)
        em.getTransaction().commit();
    
    }   // ends public void save(List<Book> books)
    
    @Override
    public List<Book> loadBooks() {
        return em.createQuery("SELECT b FROM Book b")
                .getResultList();
    }   // ends public List<Book> loadBooks()
    
    //------------------- readers -------------------------------
    @Override
    public void saveReaders(List<Reader> readers){
        em.getTransaction().begin();
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = readers.get(i);
            if (reader.getId() == null) {
                em.persist(reader);
            }else{
                em.merge(reader);
            }
        }   // ends for (int i = 0; i < readers.size(); i++)
        em.getTransaction().commit();
    
    }   // ends public void save(List<Reader> readerss)
    
    @Override
    public List<Reader> loadReaders() {
        return em.createQuery("SELECT r FROM Reader r")
                .getResultList();
    }   // ends  public List<Reader> loadReaders()
    
    //------------------- histories ----------------------------
    @Override
    public void saveHistories(List<History> histories){
        em.getTransaction().begin();
        for (int i = 0; i < histories.size(); i++) {
            History history = histories.get(i);
            if (history.getId() == null) {
                em.persist(history);
            }else{
                em.merge(history);
            }
        }   // ends for (int i = 0; i < histories.size(); i++)
        em.getTransaction().commit();
    
    }   // ends public void saveHistories(List<History> histories)
    
    @Override
    public List<History> loadHistories() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }   // ends  public List<Reader> loadHistories
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}   // ends public class BaseManager
