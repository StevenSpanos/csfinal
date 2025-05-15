import java.util.ArrayList;

public class Plant extends Entity{
    private int speed;
    private int type;
    private int countdown = 0;
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
    public int getSpeed(){return speed;} public int getType(){return type;} public int getCountdown(){return countdown;}

    public void shoot(){
        if(Bug.bugs.size() > 0){
            int leastX = 999;
            Bug bug = null;
            for(Bug x : Bug.bugs){
                if(x.getY() == getY()){
                    if(leastX > x.getX() && x.getX() >= getX()){
                        leastX = x.getX();
                        bug = x;
                    }
                }
                
            }
            if(leastX != -1 && bug != null){bug.hurt();}
        }
    }

    public void step(){
        if(type == 1){shoot();}
        if(type == 2){water();}
    }

    public void water(){
        if(speed > 0){
            countdown++;
            if(countdown >= speed){
                countdown = 0;
                Main.water++;
            }
        }
    }

    public void hurt(Bug b){
        setHealth(getHealth()-1);
        if(b.getX() < Main.lawn.getCols()-1){b.setX(b.getX()+1);}
        if(getHealth() <= 0){
            for(int x = 0; x < plants.size(); x++){
                Plant p = plants.get(x);
                if(this.equals(p)){
                    plants.remove(x);
                    x--;
                    Main.lawn.updateLawn();
                    return;
                }
            }
        }
    }
}
