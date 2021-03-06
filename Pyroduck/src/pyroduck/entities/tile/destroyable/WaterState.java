package pyroduck.entities.tile.destroyable;

import pyroduck.entities.Entity;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.Player;
import pyroduck.graphics.Sprite;

/**
 *
 * @author Montefusco
 */
public class WaterState extends DestroyableIceTile{

    public WaterState(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean collide(Entity e){
        if(e.isMob() && !((((Mob)e).isPlayer()) && (((Player)e).isSuperPlayer()))){
               ((Mob)e).kill();
        }
        return false;
    }

    @Override
    public DestroyableIceTile nextState(ContextDestroyable context){
        return this;
    } 
}