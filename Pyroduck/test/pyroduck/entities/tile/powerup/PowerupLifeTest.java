package pyroduck.entities.tile.powerup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyroduck.Board;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.destroyable.BrickTile;
import pyroduck.graphics.Sprite;

/**
 *
 * @author 
 */
public class PowerupLifeTest {
    
    public PowerupLifeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Board.getInstance().addMob(new Player(0, 0));
        Board.getInstance().setLives(3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of collide method, of class PowerupLife.
     */
    @Test
    public void testCollide() {
        System.out.println("collide");
        Entity e1 = new Player(1, 1);      
        Entity e2 = new BrickTile(1, 1, Sprite.brick);
        PowerupLife instance = new PowerupLife(1, 1, Sprite.brick);
        boolean d1 = instance.collide(e1);
        assertTrue(d1);
        assertEquals(instance.isRemoved(), true);
        boolean d2 = instance.collide(e2);
        assertFalse(d2);
    }

    /**
     * Test of setValues method, of class PowerupLife.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        PowerupLife instance = new PowerupLife(1, 1, Sprite.brick);
        assertEquals(3, Board.getInstance().getLives(), 0);
        instance.setValues();
        assertEquals(4, Board.getInstance().getLives(), 0);
    } 
}