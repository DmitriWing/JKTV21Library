
package managers;

import entity.Reader;
import java.util.Scanner;

public class ReaderManager {
    private final Scanner scanner;
    private Reader[] readers;
    
    public ReaderManager() {
        scanner = new Scanner(System.in);
    }
    
    public Reader createReader(){
        Reader reader = new Reader();
        System.out.println("Input reader name ");
        reader.setName(scanner.nextLine());
        System.out.println("Input reader lastname ");
        reader.setlastName(scanner.nextLine());
        System.out.println("Input reader phone ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
    public void printListReaders (Reader readers[]){
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %s, phone: %s%n", 
                    i+1, 
                    readers[i].getName(), 
                    readers[i].getlastName(), 
                    readers[i].getPhone() );
        }
    }
}
