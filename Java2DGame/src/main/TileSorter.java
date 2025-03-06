package main;

import entities.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileSorter {

    public static BufferedImage[] box;
    static BufferedImage grass, bricks, bricks2, big_carrot;
    static int tileHorizontal;
    static int tileVertical;
    static int tileWidth = 64;
    static int tileHeight =64;

    TileSorter(){

    }
    public static void Files() throws IOException {
        grass = ImageIO.read(new File("Tiles/grass.png"));
        bricks = ImageIO.read(new File("Tiles/bricks.png"));
        bricks2 = ImageIO.read(new File("Tiles/bricks2.png"));
        big_carrot = ImageIO.read(new File("Tiles/big_carrot.png"));

    }
    public static void Tilebox(){
        box = new BufferedImage[4];
        box[0] = grass; box[1] = bricks; box[2] = bricks2; box[3] = big_carrot;


    }
    public static void Grass(){


    }

}
