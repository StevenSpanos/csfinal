import java.util.ArrayList;

public class Bug extends Entity{
    private int speed;
    private int type;
    private int index;
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

    public void hurt(){
        super.hurt();
        if(super.getHealth() <= 0){
            for(int x = 0; x < bugs.size(); x++){
                Bug b = bugs.get(x);
                if(b.equals(this)){
                    bugs.remove(x);
                    return;
                }
            }
        }
    }

    public void walk(){
        setX(getX()-1);
    }
}
