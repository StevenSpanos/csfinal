import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    private static Lawn lawn = new Lawn();
    private static Scanner input = new Scanner(System.in);
    public static ArrayList<Packet> packets = new ArrayList<Packet>();
    public static void main(String[] args){
        Packet packet = new Packet("Bamboozler", 3);
        packet = new Packet("Water Lily", 2);
        packet = new Packet("Cashew Guard", 2);
        System.out.println("1. Play");
        System.out.println("-1. Exit");
        lawn.resetLawn();
        int choice = input.nextInt();
        spawn();
        while (choice != -1){
            lawn.printLawn();
            choice = inputHandler();

            updatePlants();
            updateBugs();
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
            return 2;
        }
        if(x == 3){
            return 3;
        }
        return x;
    }

    public static void plant(){
        clear();
        lawn.printLawn();
        System.out.println("Select your plant: ");
        for(int x = 1; x < packets.size()+1; x++){
            System.out.println(x + ". " + packets.get(x-1).getName());
        }
        int a = input.nextInt();
        System.out.print("X value: ");
        int x = input.nextInt();
        System.out.print("Y value: ");
        int y = input.nextInt();
        if(a == 1){lawn.plant(new Plant(10, x, y, "B", 0,1));}
        if(a == 2){lawn.plant(new Plant(7, x, y, "W", 1, 2));}
        if(a == 3){lawn.plant(new Plant(25,x, y,"C",0,3));}
    }

    public static void spawn(){
        lawn.spawn(new Bug(3, 5, 0, "X", 1, 1));
    }

    public static void updatePlants(){
        for(Plant p : Plant.plants){

        }
    }
    public static void updateBugs(){
        for(Bug b : Bug.bugs){
            b.walk();
        }
    }
}
