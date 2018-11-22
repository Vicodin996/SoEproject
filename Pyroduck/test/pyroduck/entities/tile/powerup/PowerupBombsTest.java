package pyroduck.entities.tile.powerup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.Game;
import pyroduck.bomb.DirectionalExplosion;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author La Femina, Petruzzello
 */
public class PowerupBombsTest {
    
    public PowerupBombsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class PowerupBombs.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Board b = new Board(new Keyboard(), new Screen());
        Entity e1 = new DirectionalExplosion(1, 2, 0, 1, b);
        Entity e2 = new Player(1, 1, b);
        Entity e3 = new BrickTile(1, 1, Sprite.brick);
        PowerupBombs instance = new PowerupBombs(1, 1, Sprite.brick);
        boolean des = instance.collide(e1);
        assertFalse(des);
        assertTrue(instance.isDestroyed());
        boolean d2 = instance.collide(e2);
        assertTrue(d2);
        assertEquals(instance.isRemoved(), true);
        boolean d3 = instance.collide(e3);
        assertFalse(d3);
    }

    /**
     * Test of setValues method, of class PowerupBombs.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        PowerupBombs instance = new PowerupBombs(1, 1, Sprite.brick);
        assertEquals(2, Game.getBombRate(), 0);
        instance.setValues();
        assertEquals(3, Game.getBombRate(), 0);
    }  
}