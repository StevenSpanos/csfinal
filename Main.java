import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static Lawn lawn = new Lawn();
    public static int round = -1;
    private static Scanner input = new Scanner(System.in);
    public static int water = 1;
    public static ArrayList<Packet> packets = new ArrayList<Packet>();
    public static void main(String[] args){
        Packet packet = new Packet("Bamboozler", 3);
        packet = new Packet("Water Lily", 1);
        packet = new Packet("Cashew Guard", 2);
        clear();
        System.out.println("1. Play");
        System.out.println("-1. Exit");
        lawn.resetLawn();
        int choice = input.nextInt();
        while (choice != -1){
            round++;
            lawn.printLawn();
            choice = inputHandler();
            if(choice == 1){
                updatePlants();
                updateBugs();
            }
            if(round % 30 == 0 && round >= 30){
                spawn();
            }
            if(round % 100 == 0 && round >= 100){
                for(int i = 0; i < 5; i++){
                    spawn();
                }
            }
            if(round % 15 == 0){
                water++;
            }

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
        System.out.println("4. Checkup");
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
            shovel();
            return 3;
        }
        if(x == 4){
            checkup();
        }
        if(x == 5){
            water = 1000;
        }
        return x;
    }

    public static void plant(){
        clear();
        lawn.printLawn();
        System.out.println("Select your plant: ");
        for(int x = 1; x < packets.size()+1; x++){
            System.out.println(x + ". " + packets.get(x-1).getName() + "; Cost: " + packets.get(x-1).getCost());
        }

        int a = input.nextInt();
        while(a > packets.size() || packets.get(a-1).getCost() > water){
            if(a >= packets.size()){System.out.println("Invalid Input.");}
            else if(packets.get(a-1).getCost() > water){System.out.println("Not Enough Water");}
            a = input.nextInt();
        }
        int x = -1,y = -1;
        while(!checkXY(x,y)){
            System.out.print("X value: ");
            x = input.nextInt();
            System.out.print("Y value: ");
            y = input.nextInt();
            if(!checkXY(x,y)){System.out.println("There is a plant at that spot.");}
        }
        if(a == 1){lawn.plant(new Plant(10, x, y, "B", 2,1));}
        if(a == 2){lawn.plant(new Plant(7, x, y, "W", 7, 2));}
        if(a == 3){lawn.plant(new Plant(25,x, y,"C",0,3));}
        water -= packets.get(a-1).getCost();
    }

    public static void spawn(){
        int random = (int) (Math.random() * 5);
        lawn.spawn(new Bug(25, 7, random, "X", 5, 1));
    }

    public static void updatePlants(){
        for(Plant p : Plant.plants){
            p.step();
        }
    }
    public static void updateBugs(){
        for(Bug b : Bug.bugs){
            b.walk();
        }
    }

    public static void lose(){
        clear();
        System.out.println("The bugs ate your fruits \nor something \nidk");
        System.exit((int) (Math.random() * Integer.MAX_VALUE));
    }

    public static boolean checkXY(int x, int y){
        if(x < 0 || y < 0){return false;}
        for(Plant p : Plant.plants){
            if(p.getX() == x && p.getY() == y){
                return false;
            }
        }
        return true;
    }

    public static void shovel(){
        boolean real = false;
        Plant plant = null;
        while(!real){
            System.out.print("X Value: ");
            int x = input.nextInt();
            System.out.print("Y Value: ");
            int y = input.nextInt();
            for(Plant p : Plant.plants){
                if(p.getX() == x && p.getY() == y){
                    real = true;
                    plant = p;
                    break;
                }
                System.out.println("There is no plant there");
            }
        }
        lawn.shovel(plant);
    }

    public static void checkup(){
        boolean real = false;
        Plant plant = null;
        while(!real){
            System.out.print("X Value: ");
            int x = input.nextInt();
            System.out.print("Y Value: ");
            int y = input.nextInt();
            for(Plant p : Plant.plants){
                if(p.getX() == x && p.getY() == y){
                    real = true;
                    plant = p;
                    break;
                }
                System.out.println("There is no plant there");
            }
        }
        System.out.println("Health Left: " + plant.getHealth());
        System.out.println("Input any number to quit");
        input.nextInt();
    }
}
