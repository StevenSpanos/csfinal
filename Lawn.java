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

    public int getRows(){return rows;} public int getCols(){return cols;}
    public void resetLawn(){
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                lawn[r][c] = new Entity(c, r);
            }
        }
    }
    public void updateLawn(){
        resetLawn();
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
        System.out.println("Water: "+Main.water);
        System.out.print("  "); for(int x = 0; x < cols; x++){System.out.print(" " + x + " ");}
        System.out.println();
        for(int r = 0; r < rows; r++){
            System.out.print(r + " ");
            for(int c = 0; c < cols; c++){
                Entity x = lawn[r][c];
                System.out.print("["+x.getCharacter()+"]");
            }
            System.out.println();
        }
    }

    public void plant(Plant p){
        updateLawn();
    }

    public void spawn(Bug b){
        updateLawn();
    }
}
