package jktv21library;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Scanner;

public class App {
    public void run(){
        String splitter = "------------------------------------------------------------------------------";
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        do{
            System.out.println("App functions:");
            System.out.println("0 - Quit");
            System.out.println("1 - Add book");
            System.out.println("2 - Add reader");
            System.out.println("3 - Give book out");
            System.out.println("4 - Return book");
            System.out.println("5 - Books list");
            System.out.println("6 - Authors list");
            System.out.println("Choose function number:");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                   repeat = false;
                   break;
                case 1:
                    System.out.println("1 - Add book");
                    Book book =  new Book();
                    
                    System.out.println(splitter);
                   break;
                case 2:
                    System.out.println("2 - Add reader");
                    Reader reader =  new Reader();
                    
                    System.out.println(splitter);
                    break;
                case 3:
                    System.out.println("3 - Give book out");
                    History history =  new History();
                    
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Return book");
                    
                    System.out.println(splitter);
                    break;
                case 5:
                    System.out.println("5 - Books list");
                    
                    System.out.println(splitter);
                    break;
                case 6:
                    System.out.println("6 - Authors list");
                    
                    System.out.println(splitter);
                    break;
                    
                default:
                    System.out.println("Choose function number from the list!\n---------------------------------------------------------------------------");
            }
            
            
        }while(repeat);
        System.out.println("Good bye!");
    }
}
