package pyroduck;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pyroduck.bomb.Bomb;
import pyroduck.bomb.Explosion;
import pyroduck.entities.mob.Player;
import pyroduck.entities.tile.WallTile;
import pyroduck.graphics.Screen;
import pyroduck.graphics.Sprite;
import pyroduck.input.Keyboard;

/**
 *
 * @author all
 */
public class BoardTest {
    
    Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new Board(new Keyboard(), new Screen());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Board.
     */
    @Test
    public void testUpdate() {
        board.addMob(new Player(0, 0, board));
        assertTrue(board.mobs.get(0) instanceof Player);
        board.mobs.get(0).remove();
        board.update();
        assertTrue(board.bombs.isEmpty());
    }

    /**
     * Test of newGame method, of class Board.
     */
    @Test
    public void testNewGame() {
        Game.addBombRadius(1);
        Game.addBombRate(1);
        Game.addPlayerSpeed(1);
        board.addMob(new Player(0, 0, board));
        assertTrue(board.mobs.get(0) instanceof Player);
        board.addBomb(new Bomb(0, 0, board));
        board.addBomb(new Bomb(0, 0, board));
        board.addBomb(new Bomb(0, 0, board));
        assertEquals(board.bombs.size(), 3);
        board.newGame();
        assertEquals(1, Game.bombRadius);
        assertEquals(1, Game.bombRate);
        assertEquals(1.3, Game.playerSpeed, 0);
        assertTrue(board.mobs.size() == 1);
        assertTrue(board.bombs.isEmpty());
    }

    /**
     * Test of getEntity method, of class Board.
     */
    @Test
    public void testGetEntity() {
        Bomb bomb = new Bomb(0, 0, board);
        board.addBomb(bomb);
        assertTrue(board.getEntity(0, 0) instanceof Bomb);
    }

    /**
     * Test of getBombAt method, of class Board.
     */
    @Test
    public void testGetBombAt() {
        Bomb bomb = new Bomb(0, 0, board);
        board.addBomb(bomb);
        assertTrue(board.getBombAt(0, 0) instanceof Bomb);
    }

    /**
     * Test of getPlayer method, of class Board.
     */
    @Test
    public void testGetPlayer() {
        Player player = new Player(1, 2, board);
        board.addMob(player);
        assertTrue(board.getPlayer() instanceof Player);
    }

    /**
     * Test of getEntityAt method, of class Board.
     */
    @Test
    public void testGetEntityAt() {
        WallTile wall = new WallTile(0, 0, Sprite.wall);
        assertTrue(board.getEntityAt(0, 0) instanceof WallTile);
    }
}