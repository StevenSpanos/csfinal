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
        Plant.plants.add(this);
    }

    //get methods
    public int getSpeed(){return speed;} public int getType(){return type;}

    public void shoot(){
        if(Bug.bugs.size() > 0){
            int leastX = 999;
            Bug bug = null;
            for(Bug x : Bug.bugs){
                if(x.getY() == getY()){
                    if(leastX > x.getX()){
                        leastX = x.getX();
                        bug = x;
                    }
                }
                
            }
            if(leastX != -1){bug.hurt();}
        }
    }

    public void step(){
        shoot();
    }
}
