package pyroduck.entities.mob.enemy.graphic;

import pyroduck.Board;
import pyroduck.entities.mob.enemy.MediumPower;
import pyroduck.graphics.Sprite;

/**
 * Implements the behavior, select the image and manage the animation of this
 * enemy.
 *
 * @author Bini, Petruzzello
 */
public class Glalie extends Enemy {

    /**
     * Creates an instance of <b>Glalie</b> enemy.
     *
     * @param x horizontal coordinate in pixels.
     * @param y vertical coordinate in pixels.
     */
    public Glalie(int x, int y) {
        super(x, y, Sprite.glalie_dead, 0.8, 200);
        sprite = Sprite.glalie_left1;
        realWidth = 28;
        realHeight = 28;
        ep = new MediumPower(Board.getInstance().getPlayer(), this);
        direction = ep.calculateDirection();
    }

    /**
     * Chooses the sprite to show on the screen.
     */
    @Override
    protected void chooseSprite() {
        switch (direction) {
            case 0:
                if (moving) {
                    sprite = Sprite.movingSprite(Sprite.glalie_up1, Sprite.glalie_up2, Sprite.glalie_up3, animate, 60);
                } else {
                    sprite = Sprite.glalie_down1;
                }
                break;
            case 1:
                if (moving) {
                    sprite = Sprite.movingSprite(Sprite.glalie_right1, Sprite.glalie_right2, Sprite.glalie_right3, animate, 60);
                } else {
                    sprite = Sprite.glalie_down1;
                }
                break;
            case 2:
                if (moving) {
                    sprite = Sprite.movingSprite(Sprite.glalie_down1, Sprite.glalie_down2, Sprite.glalie_down3, animate, 60);
                } else {
                    sprite = Sprite.glalie_down1;
                }
                break;
            case 3:
                if (moving) {
                    sprite = Sprite.movingSprite(Sprite.glalie_left1, Sprite.glalie_left2, Sprite.glalie_left3, animate, 60);
                } else {
                    sprite = Sprite.glalie_down1;
                }
                break;
        }
    }
}