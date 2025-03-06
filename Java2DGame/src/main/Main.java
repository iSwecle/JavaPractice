package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame frame, login;
    static GamePanel panel;
    static LoginPanel loginP;
    static ImageIcon icon = new ImageIcon("src/icon.png");
    public static boolean success;
    public static Main game;
    private static  int man;
    //the disadvantage of declaring variables on class level is not noticing
    // if you accidentally deleted a line of code that assigns a value

    public Main(){
        //Only here so I don't have to provide arguments
    }
    public Main(boolean isLogin){

        if(isLogin){
            //FOURTH

            frame = new JFrame();
            panel = new GamePanel();

            frame.setIconImage(icon.getImage());
            frame.setTitle("CarrotHunt");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame ends java program when exit.
            //frame.setSize(576,576);
            frame.add(panel, BorderLayout.CENTER);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.pack();
            login.dispose(); //Originally was in LaunchGame, this closes the login window.
            //I moved it here so I can easily skip the login window.

        }
        //YOU CAN CONTROL THE FLOW OF YOUR PROGRAM USING CONSTRUCTORS LIKE METHODS DOES
        //IF ARGUMENTS ARE MET THAT CONSTRUCTOR WILL BE EXECUTED, OTHERWISE IGNORED
        //YOU DO NOT ACCESS IT LIKE METHODS, YOU ACCESS IT BY INITIATING AN INSTANCE AND
        //PROVIDING A MATCHING ARGUMENT
        //YOU CAN EXECUTE 2 OR MORE CONSTRUCTOR AT ONCE IF IT HAS THE SAME PARAMETER DATA TYPES

    }
    public static void main(String[] args) {
        //main is FIRST
        game = new Main(true); //nothing happens because it is false
        //Switch it to true to skip the Login Window


        man = 1;
        game.loginScreen(); //Launches SECOND



        while (true) {
            //Coordinates Display on Console
            System.out.print("\rX:"+GamePanel.x+" Y:"+GamePanel.y);

        }

        //CONTROL YOUR FLOW ON MAIN METHOD ONLY

    }
    private void loginScreen(){
        //SECOND
        login = new JFrame();
        loginP = new LoginPanel(); //Inside, it launches THIRD if login is a success
        login.setIconImage(icon.getImage());
        login.add(loginP);
        login.setTitle("CarrotHunt");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(270,200);
        login.add(loginP, BorderLayout.CENTER);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);

    }
    public void LaunchGame(){
        //THIRD

        if(success){
            new Main(true); //LAUNCHES FOURTH
            //Anything after this line is unreachable.
            System.out.println("[This Does Not Print]");


        }

    }
}
