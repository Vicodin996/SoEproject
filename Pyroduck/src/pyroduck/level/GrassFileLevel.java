package pyroduck.level;

import java.io.BufferedReader;
import pyroduck.entities.mob.Mob;
import pyroduck.entities.mob.enemy.graphic.*;
import pyroduck.entities.tile.*;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.entities.tile.powerup.*;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class GrassFileLevel extends FileLevel{

    public GrassFileLevel(BufferedReader in, int level) {
        super(in,level);
    }

    @Override
    public WallTile createWall(int x, int y) {
        WallTile w = new WallTile(x, y, Sprite.wall);
        return w;
    }

    @Override
    public BrickTile createBrick(int x, int y) {
       return new BrickTile(x ,y, Sprite.brick);
    }

    @Override
    public GrassTile createGrass(int x, int y) {
        return new GrassTile(x, y, Sprite.grass);
    }

    @Override
    public Mob createFirstEnemy(int x, int y) {
        return new Golbat(x, y);
    }

    @Override
    public Mob createSecondEnemy(int x, int y,int choose) {
        if(choose == 2)
            return new Machamp(x, y);
        return new Arbok(x, y);
    }

    @Override
    public Powerup createPowerup(int x, int y) {
        return new MalusSlow(x, y, Sprite.brick);
    }  
}