import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener {

    
    private JLabel label;
    private JButton newGame_button, exitGame_button;
    
    
    public MainMenu(){

        this.setPreferredSize(new Dimension(500,400));
       
        //label
        label = new JLabel("THE GAME OF CAN'T STOP!");
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        label.setAlignmentX(CENTER_ALIGNMENT);
        
        //buttons
        newGame_button = new JButton("NEW GAME");
        newGame_button.setAlignmentX(CENTER_ALIGNMENT);
        newGame_button.setFont(new Font("Arial", Font.PLAIN, 15));
        newGame_button.addActionListener(this);
        
        exitGame_button = new JButton("EXIT GAME");
        exitGame_button.setAlignmentX(CENTER_ALIGNMENT);
        exitGame_button.setFont(new Font("Arial", Font.PLAIN, 15));
        exitGame_button.addActionListener(this);


        //set box layout for the frame, add and arrange components for presentation
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));

        getContentPane().add(Box.createRigidArea(new Dimension(0,70)));     //placing empty spaces 
        add(label);
        //getContentPane().add(Box.createVerticalGlue());

        getContentPane().add(Box.createRigidArea(new Dimension(0,50)));
        add(newGame_button);

        getContentPane().add(Box.createRigidArea(new Dimension(0,50)));
        add(exitGame_button);

        
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setVisible(true);

    }    


    public void actionPerformed(ActionEvent aevt)
    {

        Object selected = aevt.getSource();

        if(selected.equals(newGame_button))
        {
            //System.out.println("build in progress");
            dispose();
            WindowDemo demo = new WindowDemo(17, 17);
        }

        else if(selected.equals(exitGame_button))
        {
            System.exit(0);
        }
    }


}
