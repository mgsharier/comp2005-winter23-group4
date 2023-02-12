import java.awt.*;
import javax.swing.*;

/*
 *  A GUI component
 *
 *  A simple extension of JPanel which records its
 *  coordinates in xcoord and ycoord, NOT in 'x' and 'y'.
 *  Why not? Because 'x' and 'y' are already attributes of
 *  the panel (super) class which say where to draw it in the window.
 *
 *  The game grid and allows the background colour to be set with ease.
 *
 *  @author mhatcher
 */
public class GridSquare extends JPanel
{
    private int xcoord, ycoord;  
    private JLabel yoo;// location in the grid
    private boolean runnerStatus;
    // constructor takes the x and y coordinates of this square
    public GridSquare(int xcoord, int ycoord)
    {
        super();
        this.setSize(100,100);
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.yoo= new JLabel("Yoo");
        this.runnerStatus=false;
    }
    
    // if the decider is even, it chooses black, otherwise white (for 'column+row' will allow a chequerboard effect)
    public void setColor( int decider)
    {
        if(decider==2){
            this.setBackground(Color.RED);
            this.add(yoo);
            
        }
        else if( decider == 1){
            this.setBackground(Color.gray);
        }
    }
    
    public void set_Header(int num){
        JLabel head = new JLabel(""+num);
        head.setFont(new Font("Ariel", Font.BOLD, 30));
        head.setForeground(Color.RED);
        
        this.add(head);
    }
    
    public boolean containsRunner(){
        return this.runnerStatus;
    }
    
    public void setRunner(){
        this.setBackground(Color.WHITE);
        this.runnerStatus=true;
    }
    
    public void removeRunner(){
        this.setBackground(Color.RED);
        this.runnerStatus=false;
    }
    // if the square is black it becomes white, and vice-versa
    public void switchColor()
    {
        this.setBackground(Color.RED);
    }
    
    // simple setters and getters
    public void setXcoord(int value)    { xcoord = value; }
    public void setYcoord(int value)    { ycoord = value; }
    public int getXcoord()              { return xcoord; }
    public int getYcoord()              { return ycoord; }
}
