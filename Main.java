public class Main{
    private static Lawn lawn = new Lawn();
    public static void main(String[] args){
        lawn.resetLawn();
        lawn.printLawn();
        lawn.plant(1,1);
        lawn.printLawn();
    }
}
