import java.util.ArrayList;

public class Bug extends Entity{
    private int speed;
    private int type;
    public static ArrayList<Bug> bugs = new ArrayList<Bug>();
    public Bug(){
        super(-1, -1);
        speed = 0;
        type = -1;
    }
    public Bug(int h, int x, int y, String c, int s, int t){
        super(h, x, y, c);
        speed = s;
        type = t;
        bugs.add(this);
    }

    //get methods
    public int getSpeed(){return speed;} public int getType(){return type;}
}
