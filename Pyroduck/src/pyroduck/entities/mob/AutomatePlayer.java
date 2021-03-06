package pyroduck.entities.mob;

import java.util.Iterator;
import java.util.LinkedList;
import pyroduck.*;
import pyroduck.bomb.Bomb;
import pyroduck.level.Coordinates;

/**
 *
 * @author
 */
public class AutomatePlayer extends Player{

    private boolean putBomb = false;
    private int counter_idle = 0;
    private final LinkedList<Double> registerX = new LinkedList<>();
    private final LinkedList<Double> registerY = new LinkedList<>();

    public AutomatePlayer(int x, int y) {
        super(x, y);
        fillRegisters();
    }

    private void fillRegisters() {
            moveRight(2);
            moveDown(2);
            moveRight(3);
            wait(3);
            putBomb();
            moveLeft(2);
            wait(3);
            moveRight(3);
            wait(8);
            putBomb();
            moveLeft(2);
            moveDown(1);
            wait(2);
            moveUp(1);
            moveLeft(2);
            putBomb();
            moveLeft(2);
            moveDown(2);
            wait(5);
            moveRight(2);
            moveDown(1); 
            wait(1);
            putBomb();
            moveUp(1);
            moveLeft(1);
            wait(4);
            moveRight(1);
            moveDown(2);
            wait(8);
            moveUp(4);
            moveRight(2);
            wait(1);
            putBomb();
            moveLeft(1);
            putBomb();
            moveLeft(1);
            moveDown(2);
            putBomb();
            moveLeft(2);
            moveDown(1);
            wait(3);
            moveUp(1);
            moveRight(2);
            moveDown(2);
    }

    @Override
    protected void calculateMove(){
        if(!isRemoved()){
            if(counter_idle < 350){  //player initial idle -> 500*15 ms
                counter_idle++;
                return;
            }
            if(registerX.size() > 0 && registerY.size() > 0){
                Double xa = registerX.pop();
                Double ya = registerY.pop();
               if(xa != 0 || ya != 0)  {
                    if(xa == 3)
                        putBomb = true;
                    else{
                        move(xa, ya);
                        moving = true;
                    }
                } else {
                    moving = false;
                }
            }
            else
                moving = false;
        }
    }

    @Override
    protected void detectPlaceBomb() {
        if(putBomb){
                int xt = Coordinates.pixelToTile(x + 16);
                int yt = Coordinates.pixelToTile(y - 16); //subtract half player height and minus 1 y position
                placeBomb(xt,yt);
                Game.getInstance().addBombRate(-1);
                putBomb = false;
        }
    }

    @Override
    protected void placeBomb(int x, int y) {
        Bomb b = new Bomb(x, y);
        Board.getInstance().addBomb(b);
    }

    private void moveLeft(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(-1.0);
            registerY.add(0.0);
        }
    }

    private void moveRight(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(1.0);
            registerY.add(0.0);
        }
    }

    private void moveUp(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(0.0);
            registerY.add(-1.0);
        }
    }

    private void moveDown(int n){
        for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(0.0);
            registerY.add(1.0);
        }
    }

    private void wait(int n){
       for(int i=0; i<n*Game.TILES_SIZE; i++){
            registerX.add(0.0);
            registerY.add(0.0);
        }
    }

    private void putBomb(){
        registerX.add(3.0);
        registerY.add(0.0);
    }
    
    public void removeBombs(){
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while (bs.hasNext()) {
            b = (Bomb) bs.next();
            bs.remove();
            Game.getInstance().addBombRate(1);
            
        }
    }
    

    @Override
    protected void updateTimerBreaker(){}
}