public class Packet {
    private String name;
    private int cost;

    public Packet(){
        name = "N/A";
        cost = 0;
    }
    public Packet(String n, int c){
        name = n;
        cost = c;
        Main.packets.add(this);
    }

    //get methods
    public String getName(){return name;} public int getCost(){return cost;}
}
