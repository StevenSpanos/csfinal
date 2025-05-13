import java.util.Scanner;
public class Main{
    private static Lawn lawn = new Lawn();
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("1. Play");
        System.out.println("-1. Exit");
        int choice = input.nextInt();
        while (choice != -1){
            lawn.resetLawn();
            lawn.printLawn();
            lawn.plant(1,1);
            lawn.printLawn();
            choice = inputHandler();
        }
        clear();
        System.out.println("Game Quit");
    }
    
    public static void clear(){
        System.out.print("\033[H\033[2J"); System.out.flush(); 
    }

    public static int inputHandler(){
        System.out.println("1. Step");
        System.out.println("2. Plant");
        System.out.println("3. Shovel");
        System.out.println("-1. Exit");
        int x = input.nextInt();
        if(x == 1){
            return 1;
        }
        if(x == 2){
            plant();
        }
        if(x == 3){
            
        }
        return x;
    }

    public static void plant(){

    }
}
