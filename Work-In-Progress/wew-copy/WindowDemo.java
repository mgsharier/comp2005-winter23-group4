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
public class WindowDemo extends JFrame implements ActionListener, MouseListener
{
    // gui components that are contained in this frame:
    private JPanel topPanel, bottomPanel;    // top and bottom panels in the main window
    private JLabel instructionLabel;        // a text label to tell the user what to do
    private JLabel infoLabel,yo;            // a text label to show the coordinate of the selected square
    private JButton topButton,start;                // a 'reset' button to appear in the top panel
    private GridSquare [][] gridSquares;    // squares to appear in grid formation in the bottom panel
    private int rows,columns,counter;                // the size of the grid
    
    /*
     *  constructor method takes as input how many rows and columns of gridsquares to create
     *  it then creates the panels, their subcomponents and puts them all together in the main frame
     *  it makes sure that action listeners are added to selectable items
     *  it makes sure that the gui will be visible
     */
    public WindowDemo(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.setSize(1000,1000);
        this.counter = 0;
        // first create the panels
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(rows, columns));
        bottomPanel.setSize(200,200);
        
        // then create the components for each panel and add them to it
        
        // for the top panel:
        instructionLabel = new JLabel("Click the Squares!");
        infoLabel = new JLabel("No square clicked yet.");
    
        topButton = new JButton("Reset");
        start= new JButton("Start new game");
        topButton.addActionListener(this);            // IMPORTANT! Without this, clicking the square does nothing.
        
        topPanel.add(instructionLabel);
        topPanel.add (topButton);
        topPanel.add(infoLabel);
        
    
        // for the bottom panel:    
        // create the squares and add them to the grid
        gridSquares = new GridSquare[rows][columns];
        for ( int x = 0; x < rows; x ++)
        {
            for ( int y = 0; y < columns; y ++)
            {
                gridSquares[x][y] = new GridSquare(x, y);

                bottomPanel.add(gridSquares[x][y]);
            }}
        
        for ( int x = 0; x < 14; x ++){    
            if(x<5){
                for( int z = 6-x ; z<= 6+ x ; z++){
                gridSquares[x][z].setColor(2);
                gridSquares[x][z].setSize(300, 300);
                gridSquares[x][z].addMouseListener(this);}
            }
            if(x>=5 && x<=7){
                for( int z = 6-5 ; z<= 6+ 5 ; z++){
                gridSquares[x][z].setColor(2);
                gridSquares[x][z].setSize(300, 300);
                gridSquares[x][z].addMouseListener(this);}
            }
            if(x>=8 && x<=12){
                for( int z = x-6 ; z<=18-x  ; z++){
                gridSquares[x][z].setColor(2);
                gridSquares[x][z].setSize(300, 300);
                gridSquares[x][z].addMouseListener(this);}
            }

        }
        
        // now add the top and bottom panels to the main frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.CENTER);        // needs to be center or will draw too small
        
        // housekeeping : behaviour
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
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
        if ( selected.equals(topButton) )
        {
            for ( int x = 0; x < columns; x ++)
            {
                for ( int y = 0; y < rows; y ++)
                {
                    gridSquares [x][y].setColor(x + y);
                }
            }
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
        
        // if a gridsquare is selected then switch its color
        if (selected instanceof GridSquare)
        {
            GridSquare square = (GridSquare) selected;
            square.switchColor();
            int x = square.getXcoord();
            int y = square.getYcoord();
            infoLabel.setText("("+x+","+y+") last selected.");
            
        }    
    }
    
    // not used but must be present to fulfil MouseListener contract
    public void mouseEntered(MouseEvent arg0){}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
}
