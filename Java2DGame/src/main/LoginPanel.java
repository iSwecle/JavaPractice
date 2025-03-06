package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener{
    static JTextField userField;
    static JPasswordField passField;
    static JLabel userLabel, passLabel, title, logging;
    static JButton login;
    static String username, password;



    public LoginPanel(){

        this.setBackground(Color.WHITE);
        title = new JLabel("Login to CarrotHunt");
        userLabel = new JLabel("Username:");
        userField = new JTextField(20);
        passLabel = new JLabel("Password:");
        passField = new JPasswordField(20);

        title.setBounds(57,10,500,20);
        userLabel.setBounds(10,50,100,20);
        userField.setBounds(76,52,150,20);
        passLabel.setBounds(12,80,100,20);
        passField.setBounds(76,82,150,20);
        login = new JButton("Login");
        login.setBounds(77,130,100,20);
        login.addActionListener(this);


        setLayout(null); //Often Forgotten
        this.add(title);
        this.add(userLabel);
        this.add(userField);
        this.add(passLabel);
        this.add(passField);
        this.add(login);
        revalidate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = userField.getText(); //JTextField method
        password = passField.getText(); //JPasswordField method
        if(username.equals("UsadaPekora") && password.equals("ninjin")){
            this.remove(login);
            logging = new JLabel("Logging In...");
            logging.setBounds(83,130,100,20);

            this.add(logging);
            revalidate();
            repaint();

            Main success =  new Main(true);
            success.LaunchGame();


        }



    }
}
