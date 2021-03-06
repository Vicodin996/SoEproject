package pyroduck.entities;

import java.awt.Rectangle;
import java.util.Observable;
import pyroduck.Game;
import pyroduck.graphics.*;
import pyroduck.level.Coordinates;

/**
 * The abstract class represents the entities' backbone
 * Fixs the main behavior of each entity appearable on the map.
 * @author Montefusco, Nappi
 * @version 1.0
*/
public abstract class Entity extends Observable{

    protected double x, y;
    protected boolean removed = false;
    protected Sprite sprite;
    protected int realWidth = 32;
    protected int realHeight = 32;

    /**
    * Allows to update the state of the entity and it checks if something is changed
     */
    public abstract void update();

    /**
     * The implementation of this method invokes the screen's method to print the entity on screen.
     * @param screen screen on which the print is called.
     */
    public abstract void render(Screen screen);

    /**
     * Set the entity as to be removed.
     */
    public void remove() {
        removed = true;
    }

    /**
     * Checks if the entity must be removed.
     * @return true if the entity must be removed, false otherwise.
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * The implementation of this method checks if two entities collide with each other.
     * @param e is the entity with which is checked the collision.
     * @return true if the entities can collide with each other, false otherwise.
     */
    public abstract boolean collide(Entity e);
    
    public boolean checkRealCollision(Entity e, double tune){
        
        int x0_rectOffset = (Game.TILES_SIZE - realWidth)/2;
        int y0_rectOffset = (Game.TILES_SIZE - realHeight)/2;
        int x0_rect = (int)this.getX() + x0_rectOffset;
        int y0_rect = (int)this.getY() + y0_rectOffset;
        Rectangle thisEntityRectangle = new Rectangle(x0_rect, y0_rect, realWidth, realHeight);
        
        int x0_EntityRectOffset = (Game.TILES_SIZE - e.realWidth)/2; 
        int y0_EntityRectOffset = (Game.TILES_SIZE - e.realHeight)/2;
        int x0_EntityRect = (int)e.getX() + x0_EntityRectOffset;
        int y0_EntityRect = (int)e.getY() + y0_EntityRectOffset;
        Rectangle entityCollideRectangle = new Rectangle(x0_EntityRect, y0_EntityRect, e.realWidth, e.realHeight);
        Rectangle intersection = thisEntityRectangle.intersection(entityCollideRectangle);
        if( (intersection.getWidth() * intersection.getHeight() ) / (realWidth * realHeight) >= tune)
            return true;
        else 
            return false;
    }
    
    /**
     * Returns the sprite of the entity.
     * @return the sprite related at the entity.
     */
    public Sprite getSprite() {
        return sprite;
    }
    
    /**
     * Returns the <b>x</b> coordinate of the entity on the screen.
     * @return the <b>x</b> coordinate of the entity on the screen.
     */
    public double getX() {
        return x;
    }

    /**
     * Return the <b>y</b> coordinate of the entity on the screen.
     * @return <b>y</b> coordinate of the entity on the screen.
     */
    public double getY() {
        return y;
    }
    
    /**
     * 
     * @return 
     */
    public int getXTile() {
        return Coordinates.pixelToTile(x + 16); //plus half block for precision
    }
	
    /**
     * 
     * @return 
     */
    public int getYTile() {
        return Coordinates.pixelToTile(y - 16); //plus half block
    }
    
    public int getRealWidth(){
        return realWidth;
    }
    
    public int getRealHeight(){
        return realHeight;
    }
    
    public boolean isMob(){
        return false;
    }
    
    public boolean isTile(){
        return false;
    }
    
    public boolean isBomb(){
        return false;
    }
    
    public boolean isExplosion(){
        return false;
    }
}