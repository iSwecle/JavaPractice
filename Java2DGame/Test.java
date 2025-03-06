import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test implements ActionListener{
    //either you implement a class to the whole class or implement it in a single line by using (classname)


    ImageIcon icon;

    int count = 0;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    public Test(){

        ImageIcon icon = new ImageIcon("1.png"); //Locates the image, it is recommended to use the relative path.

        frame = new JFrame();
        panel = new JPanel();

        JButton button = new JButton("Click"); //creates a button named "Click"
        button.addActionListener(this);
        /*An instance of the JButton class expects a button name as an argument, which goes in the constructor.
        Then, in one of the methods of JButton, addActionListener takes that button instance(ok) as input and performs
        an action defined in the argument provided. In this case, "this" refers to the class instance that contains
        the actionPerformed() method, which defines the action to be performed when the button is pressed.*/

        //JButton button2 = new JButton("Cancel");
        //button2.addActionListener(this);
        label = new JLabel("Welcome to Click Counter");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        //Spaces or borders around the panel.

        panel.setLayout(new GridLayout(0,1));

        panel.add(button); //Adds this button component inside the panel
        //panel.add(button2);
        panel.add(label);
        panel.setBackground(Color.WHITE); //Sets the color to black.
        frame.add(panel, BorderLayout.CENTER); //Implements JPanel to JFrame adding panel and its background and components inside the frame.
        //BorderLayout.CENTER keeps a component at the center.


        frame.setIconImage(icon.getImage()); //setIconImage sets the acquired image by getImage from ImageIcon class
        frame.setTitle("Click Counter"); //window title or name
        //frame.setSize(1280, 800); //window Size, choose between setSize or pack()
        frame.pack(); //The frame or the window adjusts itself based on the contents inside the panel such as buttons etc. to fit them all
        //make sure to put the buttons and layout before this line of code so it can see those components and layouts and act based on those.

        frame.setResizable(false); //whether the window is resizable or not

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the java program when the window is closed





        //frame.setLocation(100, 100); //where the window spawns on screen
        frame.setLocationRelativeTo(null);
        //where the window spawns on screen relative to another component, null sets it to center

        frame.setVisible(true); //shows or launches the window
        //put setVisible at the end to ensure the rendering is complete before the window is launched
    }

    public static void main(String[] args) {
        new Test();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of Clicks: " + count);

    }
}
