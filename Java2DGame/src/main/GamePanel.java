package main;
import entities.Entity;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {


    static int x= 190, y = 180; //Player Location
    static int speed = 5;

    KeyControls keyC = new KeyControls(); //CREATE INSTANCE TO RUN (I OFTEN FORGOT)
    public static BufferedImage image;

    //static int returner;

    static Thread time;

    public GamePanel(){

        this.setPreferredSize(new Dimension(9 * 64, 9 * 64));
        new Entity();
        try{
            TileSorter.Files();  // Load tile images
            TileSorter.Tilebox();  // Initialize the box array with the images
        }
        catch(IOException e){

        }



        this.setBackground(Color.LIGHT_GRAY);
        //to refer to panel if you are in its class, use "this"
        //idk why I forgot that after using it many times
        try{

            Entity.idle = ImageIO.read(new File("Sprites/Usada Pekora-idle.png"));
            Entity.idleUp = ImageIO.read(new File("Sprites/Usada Pekora-idleUp.png"));
            Entity.idleL = ImageIO.read(new File("Sprites/Usada Pekora-idleL.png"));
            Entity.idleR = ImageIO.read(new File("Sprites/Usada Pekora-idleR.png"));
            Entity.up = ImageIO.read(new File("Sprites/Usada Pekora-Up.png"));
            Entity.up1 = ImageIO.read(new File("Sprites/Usada Pekora-Up1.png"));
            Entity.down = ImageIO.read(new File("Sprites/Usada Pekora_1-1.png"));
            Entity.down1 = ImageIO.read(new File("Sprites/Usada Pekora_2-1.png"));
            Entity.left = ImageIO.read(new File("Sprites/Usada Pekora-L-1.png"));
            Entity.left1 = ImageIO.read(new File("Sprites/Usada Pekora-L-2.png"));
            Entity.right = ImageIO.read(new File("Sprites/Usada Pekora-R-1.png"));
            Entity.right1 = ImageIO.read(new File("Sprites/Usada Pekora-R-2.png"));


            //IF ONE OF THESE DOESN'T MATCH THE FILE NAMES, NOTHING WILL RENDER.

        }
        catch(IOException e){
            e.printStackTrace();
        }

        time = new Thread(this); //if class is separated, pass the class name,
        // if it is extended or implemented, use "this".
        time.start();


    }
    static String direction = "down"; //this needs value so images will render properly or else white panel.
    public static void Update()
    {
        //Updates Location
        if(KeyControls.w){
            direction = "up";
            y-= speed;


        }
        else if(KeyControls.s){
            direction = "down";
            y+= speed;

        }
        //Vertical

        if(KeyControls.a){
            direction = "left";;
            x-= speed;

        }
        else if(KeyControls.d){
            direction = "right";
            x+= speed;



        }


        //Horizontal




        Entity.spriteCounter++;
        if(Entity.spriteCounter > 5) {

            if(KeyControls.w || KeyControls.s || KeyControls.a || KeyControls.d ){

                if (Entity.spriteReferral == 3) {
                    Entity.spriteReferral = 1;
                }
                else if (Entity.spriteReferral == 1){
                    Entity.spriteReferral = 2;
                }
                else if (Entity.spriteReferral == 2) {
                    Entity.spriteReferral = 3;
                }



            }
            else{
                Entity.spriteReferral = 3;
            }



            Entity.spriteCounter = 0;


        }




    }

    public void run(){
        this.setFocusable(true); // so I can control the box
        this.addKeyListener(keyC); //I added controls to the panel
        //DON'T PUT ON LOOP, KeyControls IS ALREADY "RUNNING" if added to the panel

        while(time != null) {
            //You tried to add data type here even though you declared it already on class level.
            //DON'T DO THAT AGAIN



                //This loop iterates but each iteration is too fast.
                //So we have to pause the thread for like 0.0167 seconds making each iteration longer
                //so each iteration is 0.0167 seconds long so if it adds up to 60 it adds up to a  second.
                //However, pausing a thread needs it in milliseconds, so multiply 0.0167 by 1000.
                //0.0167 seconds = 16.67 milliseconds




            Update(); //Update Location


            repaint(); //Update Visuals

            try {
                    Thread.sleep((long) 16.67);
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
            //Sleeper Method

        }

    }




    static Graphics2D square;
    //I created this method to add things to paint besides the bg color.
    public void paintComponent(Graphics g){
        //x = Main.x;
       // y = Main.y;
        super.paintComponent(g);
        square = (Graphics2D) g; //"(Graphics2d)" is called casting, it changes the data types of g.
        //casting only works if you extend a class and you can change the data type of the original variable to your own,
        //square.setColor(Color.blue);
        //square.fillRect(x,y,100,100);


        image = null;



        //I used the tutorial for the switch case usage here and the Entity.Java
        switch(direction){
            case"up":
                if(Entity.spriteReferral == 1){
                    image = Entity.up;

                }
                if(Entity.spriteReferral == 2){
                    image = Entity.up1;
                }
                if(Entity.spriteReferral == 3){
                    image = Entity.idleUp;
                }
                break;

            case"down":
                if(Entity.spriteReferral == 1) {
                    image = Entity.down;
                }
                if(Entity.spriteReferral == 2) {
                    image = Entity.down1;
                }
                if(Entity.spriteReferral == 3){
                    image = Entity.idle;
                }
                break;

            case"left":
                if(Entity.spriteReferral == 1) {
                    image = Entity.left;
                }
                if(Entity.spriteReferral == 2) {
                    image = Entity.left1;
                }
                if(Entity.spriteReferral == 3){
                    image = Entity.idleL;
                }
                break;


            case"right":
                if(Entity.spriteReferral == 1) {
                    image = Entity.right;
                }
                if(Entity.spriteReferral == 2) {
                    image = Entity.right1;
                }
                if(Entity.spriteReferral == 3){
                    image = Entity.idleR;
                }
                break;
        }





        int limit = 9;
        int tile_x = 0, tile_y = 0;
        for(int i = 1; i<=81; i++)//will add tiles until it finishes 9x9 window filling it up
        {
            square.drawImage(TileSorter.box[0], tile_x,tile_y,TileSorter.tileWidth,TileSorter.tileHeight, null);
            tile_x+=64; //Increments a tile which is 64 pixels wide.
            if(i == limit){ //if the iteration reaches 9 we increment visibility
                limit+=9;
                tile_y+=64;
                tile_x=0;
            }

        }

        Horizontal(32, 0);
        Vertical(0, 0);
        Vertical(544, 0);
        Horizontal(32, 544);

        square.drawImage(image, x,y,64,64, null);






        square.dispose();


    }
    public static void Horizontal(int tile1_x, int tile1_y){
        for(int i = 1; i<=16; i++)//will add tiles until it finishes 9x9 window filling it up
        {
            square.drawImage(TileSorter.box[1], tile1_x,tile1_y,32,32, null);
            tile1_x+=32; //Increments a tile which is 64 pixels wide.

        }
    }
    public static void Vertical(int tile1_x, int tile1_y){
        for(int i = 1; i<=18; i++)//will add tiles until it finishes 9x9 window filling it up
        {
            square.drawImage(TileSorter.box[2], tile1_x,tile1_y,32,32, null);
            tile1_y+=32; //Increments a tile which is 64 pixels wide.

        }
    }
}

