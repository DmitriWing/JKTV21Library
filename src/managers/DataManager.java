package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import managers.interfaces.SaveManagerInterface;



public class DataManager implements SaveManagerInterface {
    private final String FILENAME_BOOKS = "files/Mybooks";      // variable consists relative route and file name - derictory/file name
    private final String FILENAME_READERS = "files/Myreaders";      // variable consists relative route and file name - derictory/file name
    private final String FILENAME_HISTORY = "files/Myhistories";      // variable consists relative route and file name - derictory/file name
    private final File file;
    
    public DataManager() {
        file = new File("files");       
        file.mkdirs();      // creates new folder in the root
    }
    
    
    @Override
    public void saveBooks(List<Book> books){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_BOOKS);    // FileOutputStream fileOutputStream = new FileOutputStream("file name");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);  // write array books to file. data will be saved after file closed
            objectOutputStream.flush();     // write array books to file. data will be saved imediately
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        }
    }
    
    @Override
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_BOOKS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The class doesn't exist", ex);
        }
        return books;
    }

    @Override
    public void saveReaders(List<Reader> readers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_READERS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        }
        
    }
    
    @Override
    public List<Reader> loadReaders(){
        List<Reader> readers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_READERS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers = (List<Reader>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The class doesn't exist", ex);
        }
        
        return readers;
    }

    @Override
    public void saveHistories(List<History> histories) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_HISTORY);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(histories);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        }
    }
    
    @Override
    public List<History> loadHistories(){
        List<History> histories = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_HISTORY);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            histories = (List<History>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The file doesn't exist", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Error input / output", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "The class doesn't exist", ex);
        }
        return histories;
    }

   

    
    
            
}       // public class DataManager ENDS
