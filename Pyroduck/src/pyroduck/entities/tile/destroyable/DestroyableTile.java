package pyroduck.entities.tile.destroyable;

import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.tile.Tile;
import pyroduck.graphics.Sprite;

/**
 * Represent the tile that can be destroyed during the game.
 * Is used to menage what happen when an object of this class is destroyed and the menagement of the releted animations.
 * @author Bini, Petruzzello
 * @version 1.0
 */
public abstract class DestroyableTile extends Tile {

    private final int MAX_ANIMATE = 7500; //save the animation status and dont let this get too big
    private int animate = 0;
    protected boolean destroyed = false;
    protected int timeToDisapear = 20;
    protected Sprite belowSprite = Sprite.grass; //default

    /**
     * Constructor that create an object of this class.
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param sprite related to the tile.
     */
    public DestroyableTile(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    /**
     * Check if the tile has been destroyed and if so, menage the animation related.
     */
    @Override
    public void update() {
        if(destroyed) {
            if(animate < MAX_ANIMATE) 
                animate++; 
            else 
                animate = 0; //reset animation
            if(timeToDisapear > 0) 
                timeToDisapear--;
            else
                remove();
        }
    }

    /**
     * Check if the tile must be removed.
     * @return true if the tile must be destroyed, false otherwise.
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Add a sprite at the bottom level.
     * @param sprite added at the bottom level.
     */
    public void addBelowSprite(Sprite sprite) {
        belowSprite = sprite;
    }

    /**
     * Menage the animation of the tile returning the image to shown in a specific moment.
     * @param normal is the sprite to show in the normal state.
     * @param x1 is the first sprite of the animation sequence.
     * @param x2 is the last sprite of the animation sequence.
     * @return the sprite related at the state in which the tile is.
     */
    protected Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2) {
        int calc = animate % 30;
        if(calc < 10) {
            return normal;
        }
        if(calc < 20) {
            return x1;
        }
        return x2;
    }
    
    @Override
    public boolean collide(Entity e){
        if(e instanceof DirectionalExplosion)
            destroyed = true;
        return true;
    }
}