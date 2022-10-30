package managers;

import entity.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DataManager {
    private final String FILENAME_BOOKS = "files/Mybooks";      // vatiable consists relative route and file name - derictory/file name
    private final File file;
    
    public DataManager() {
        file = new File("files");       
        file.mkdirs();      // creates new folder in the root
    }
    
    
    public void saveBooksToFile(Book[] books){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_BOOKS);    // FileOutputStream fileOutputStream = new FileOutputStream("file name");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);  // write array books to file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        }
    }
    
    public Book[] loadBooksFromFile() {
        Book[] books = new Book[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_BOOKS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (Book[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The class doesn't exist", ex);
        }
        return books;
    }
            
}       // public class DataManager ENDS
