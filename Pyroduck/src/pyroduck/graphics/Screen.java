package pyroduck.graphics;

import pyroduck.Board;
import pyroduck.Game;
import pyroduck.entities.Entity;
import pyroduck.entities.mob.Player;

/**
 * Represent the game screen printer.
 * It takes care to print on screen everything that happen in the game. 
 * @author Bini, Corbisiero, Petruzzello
 */
public class Screen {
    protected int width, height;
    public int[] pixels;
    private final int transparentColor = 0xffff00ff; //pink with alpha channel (ff in the begining)
    public static int xOffset = 0, yOffset = 0;

    /**
     * Constructor creates an instance of the screen and set its parameters.
     * @param width width of the screen.
     * @param height height of the screen.
     */
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
    }

    /**
     * Set the pixels in order to show a black screen.
     */
    public void clear() {
        for (int i = 0; i <pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    // Questa classe riempie i pixel della schermata relativi a ciascuna entità
    // per farlo utilla come variabili:
    // - xp, yp: posizioni iniziali alle quali aggiungere l'entita (angolo in basso a destra);
    // - xOffset, yOffset: dimensioni width e height dell'entità;
    // - x, y: posizione relativa all'interno dell'entità;
    // - xa, ya: posizione assoluta del pixel che si sta modificando.
    public void renderEntity(int xp, int yp, Entity entity) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < entity.getSprite().getSize(); y++) {
            int ya = y + yp; //add offset
            for (int x = 0; x < entity.getSprite().getSize(); x++) {
                int xa = x + xp; //add offset
                if(xa < -entity.getSprite().getSize() || xa >=width || ya < 0 || ya >= height) 
                    break; //fix black margins
                if(xa < 0) 
                    xa = 0; //start at 0 from left
                int color = entity.getSprite().getPixel(x + y * entity.getSprite().getSize());
                if(color != transparentColor) 
                    pixels[xa + ya *width] = color;
            }
        }
    }

    // L'unica differenza con il precedente è che quando il colore è quello di fondo bisogna sostituirlo con
    // l'immagine dello sprite sottostante.
    public void renderEntityWithBelowSprite(int xp, int yp, Entity entity, Sprite below) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < entity.getSprite().getSize(); y++) {
            int ya = y + yp;
            for (int x = 0; x < entity.getSprite().getSize(); x++) {
                int xa = x + xp;
                if(xa < -entity.getSprite().getSize() || xa >= width || ya < 0 || ya >= height)
                    break; //fix black margins
                if(xa < 0) 
                    xa = 0;
                int color = entity.getSprite().getPixel(x + y * entity.getSprite().getSize());
                if(color != transparentColor) 
                    pixels[xa + ya * width] = color;
                else
                    pixels[xa + ya * width] = below.getPixel(x + y * below.getSize());
            }
        }
    }

    public static void setOffset(int xO, int yO) {
        xOffset = xO;
        yOffset = yO;
    }

    public static int calculateXOffset(Board board, Player player) {
        if(player == null)
            return 0;
        int temp = xOffset;
        double playerX = player.getX() / 32;
        double complement = 0.5;
        int firstBreakpoint = board.getWidth() / 4;
        int lastBreakpoint = board.getWidth() - firstBreakpoint;
        if( playerX > firstBreakpoint + complement && playerX < lastBreakpoint - complement) {
            temp = (int)player.getX() - (Game.WIDTH / 2);
        }
        return temp;
    }

    /**
     * Return a width of he screen.
     * @return a width of he screen.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Return a height of he screen.
     * @return a height of he screen.
     */
    public int getHeight() {
        return height;
    }
}