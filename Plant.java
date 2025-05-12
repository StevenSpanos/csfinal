import java.util.ArrayList;

public class Plant extends Entity{
    private int speed;
    private int type;
    public static ArrayList<Plant> plants = new ArrayList<Plant>();
    public Plant(){
        super(-1, -1);
        speed = 0;
        type = -1;
    }
    public Plant(int h, int x, int y, String c, int s, int t){
        super(h, x, y, c);
        speed = s;
        type = t;
        plants.add(this);
    }

    //get methods
    public int getSpeed(){return speed;} public int getType(){return type;}
}
