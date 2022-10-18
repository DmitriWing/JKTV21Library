
package managers;

import entity.Reader;
import java.util.Scanner;

public class Readermanager {
    private final Scanner scanner;
    private Reader[] readers;
    
    public Readermanager() {
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
}
