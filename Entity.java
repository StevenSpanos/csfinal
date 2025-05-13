public class Entity {
    private int health;
    private int x;
    private int y;
    private String character;
    public Entity(int x, int y){
        health = -1;
        this.x = x;
        this.y = y;
        character = " ";
    }
    public Entity(int h, int x, int y, String c){
        health = h;
        this.x = x;
        this.y = y;
        character = c;
    }

    //get methods
    public int getX(){return x;} public int getY(){return y;} public int getHealth(){return health;} public String getCharacter(){return character;}
    public void setX(int a){x = a;} public void setY(int a){y = a;} public void setHealth(int a){health = a;} public void getCharacter(String x){character = x;}

    public void hurt(){
        health--;
    }
}
