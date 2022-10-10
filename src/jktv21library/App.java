package jktv21library;

import java.util.Scanner;

public class App {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        do{
            System.out.println("App functions:");
            System.out.println("0 - Quit");
            System.out.println("Choose function number:");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                   repeat = false; 
                    break;
                    
                default:
                    System.out.println("Choose function number from the list!");
            }
            
            
        }while(repeat);
        System.out.println("Good bye!");
    }
}
