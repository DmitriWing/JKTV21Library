
package managers;

import entity.Reader;
import java.util.List;
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
    
    public void printListReaders (List<Reader> readers){
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s %s, phone: %s%n", 
                    i+1, 
                    readers.get(i).getName(), 
                    readers.get(i).getlastName(), 
                    readers.get(i).getPhone() );
        }
    }

    public List<Reader> editReader(List<Reader> readers) {
        System.out.println("Choose reader number from list below you like to edit");
        this.printListReaders(readers);
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println(readers.get(numberReader-1).getName());
        System.out.println("Change? (y/n)");
        String task = scanner.nextLine();
        switch (task.toUpperCase()){
            case "Y":
                readers.get(numberReader-1).setName(scanner.nextLine());
                break;

        }
        System.out.println(readers.get(numberReader-1).getlastName());
        System.out.println("Change? (y/n)");
        task = scanner.nextLine();
        switch (task.toUpperCase()){
            case "Y":
                readers.get(numberReader-1).setlastName(scanner.nextLine());
                break;

        }
        System.out.println(readers.get(numberReader-1).getPhone());
        System.out.println("Change? (y/n)");
        task = scanner.nextLine();
        switch (task.toUpperCase()){
            case "Y":
                readers.get(numberReader-1).setPhone(scanner.nextLine());
                break;

        }
        return readers;
        
    }
    
    
}
