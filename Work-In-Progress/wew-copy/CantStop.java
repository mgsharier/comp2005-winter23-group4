import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *  The main window of the gui.
 *  Notice that it extends JFrame - so we can add our own components.
 *  Notice that it implements ActionListener - so we can handle user input.
 *  This version also implements MouseListener to show equivalent functionality (compare with the other demo).
 *  @author mhatcher
 */
public class CantStop extends JFrame implements ActionListener, MouseListener
{
    private JPanel imagePanel, buttonPanel, settingPanel, dicePanel;          
    private JButton newGame,resumeGame, exitGame;               
    
    public CantStop ()
    {

        imagePanel = new JPanel();
        buttonPanel = new JPanel();
        settingPanel = new JPanel();
        dicePanel = new JPanel();
 
        newGame = new JButton("NEW GAME");
        resumeGame = new JButton("RESUME GAME");
        exitGame = new JButton("EXIT GAME");
        newGame.addActionListener(this);          
        resumeGame.addActionListener(this);
        exitGame.addActionListener(this);   
        
        buttonPanel.add(newGame);
        buttonPanel.add(resumeGame);
        buttonPanel.add(exitGame);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(imagePanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
    
    
    /*
     *  handles actions performed in the gui
     *  this method must be present to correctly implement the ActionListener interface
     */
    public void actionPerformed(ActionEvent aevt)
    {
        // get the object that was selected in the gui
        Object selected = aevt.getSource();
                
        // if resetting the squares' colours is requested then do so
        if ( selected.equals(newGame) )
        {  
            WindowDemo w = new WindowDemo(17,17);
        }
    }


    // Mouse Listener events
    public void mouseClicked(MouseEvent mevt)
    {
        // get the object that was selected in the gui
        Object selected = mevt.getSource();
        
        /*
         * I'm using instanceof here so that I can easily cover the selection of any of the gridsquares
         * with just one piece of code.
         * In a real system you'll probably have one piece of action code per selectable item.
         * Later in the course we'll see that the Command Holder pattern is a much smarter way to handle actions.
         */
    }
    
    // not used but must be present to fulfil MouseListener contract
    public void mouseEntered(MouseEvent arg0){}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
}
