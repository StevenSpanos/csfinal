public class Lawn {
    private  int rows;
    private int cols;
    private Entity[][] lawn;
    public Lawn(){
        rows = 5;
        cols = 8;
        lawn = new Entity[rows][cols];
    }
    public Lawn(int r, int c){
        rows = r;
        cols = c;
        lawn = new Entity[rows][cols];
    }
    public void resetLawn(){
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                lawn[r][c] = new Entity(c, r);
            }
        }
    }
    public void updateLawn(){
        for(Plant p : Plant.plants){
            int x = p.getX(); int y = p.getY();
            lawn[y][x] = p;
        }
        for(Bug b : Bug.bugs){
            int x = b.getX(); int y = b.getY();
            lawn[y][x] = b;
        }
    }

    public void printLawn(){
        Main.clear();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                Entity x = lawn[r][c];
                System.out.print("["+x.getCharacter()+"]");
            }
            System.out.println();
        }
    }

    public void plant(int x, int y){
        Plant.plants.add(new Plant(10,x,y,"B",1,0));
        updateLawn();
    }
}
