/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Alex
 */
public class WaterState extends DestroyableIceTile{

    public WaterState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }
       
//    @Override
//    public boolean collide(Entity e){
//        if(e instanceof Player)
//           ((Player) e).kill();
//        return false;
//    } 

    @Override
    public void nextState(ContextDestroyable context){
        context.setState(new IntactState((int)x, (int)y, Sprite.icebroken_4));
    }
    
    @Override
    public boolean getChange() {
        return change;
    }
    
    @Override
    public void setChange(boolean change){
        this.change = change;
    }
}