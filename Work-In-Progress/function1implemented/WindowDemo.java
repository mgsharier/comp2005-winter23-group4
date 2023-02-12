import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.Random;

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
    private JPanel topPanel,bottomPanel0, bottomPanel1,bottomPanel2,  rightPanel;    // top and bottom panels in the main window
    private JLabel instructionLabel, dice_label1, dice_label2, dice_label3, dice_label4;        // a text label to tell the user what to do
    private Combination dice_comb1, dice_comb2, dice_comb3, dice_comb4, dice_comb5, dice_comb6;
    private JLabel infoLabel,yo;            // a text label to show the coordinate of the selected square
    private JButton topButton,start, roll_Button;                // a 'reset' button to appear in the top panel
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
        this.setSize(1300,1000);
        this.counter = 0;

        // first create the panels
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));    //

        bottomPanel0 = new JPanel();
        bottomPanel0.setLayout(new BorderLayout());
        bottomPanel0.setBorder(BorderFactory.createLineBorder(Color.black));

        bottomPanel1 = new JPanel();
        bottomPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPanel1.setPreferredSize(new Dimension(300,50));
        

        
        bottomPanel2 = new JPanel();
        bottomPanel2.setLayout(new GridLayout(rows, columns));
        bottomPanel2.setSize(200,200);
        bottomPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setPreferredSize(new Dimension(300,200));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
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
                gridSquares[x][y].setColor(1);
                bottomPanel2.add(gridSquares[x][y]);
                gridSquares[x][y].setBorder(BorderFactory.createLineBorder(Color.black));
            }}
        

            // NOTICE: I altered the gridsquare placement 
        for ( int x = 0; x < 14; x ++){    
            if(x<5){
                for( int z = 6-x ; z<= 6+ x ; z++){
                gridSquares[x+1][z+1].setColor(2);    
                gridSquares[x+1][z+1].setSize(300, 300);
                gridSquares[x+1][z+1].addMouseListener(this);
                gridSquares[x+1][z+1].setBorder(BorderFactory.createLineBorder(Color.black));}
                
            }
            if(x>=5 && x<=7){
                for( int z = 6-5 ; z<= 6+ 5 ; z++){
                gridSquares[x+1][z+1].setColor(2);
                gridSquares[x+1][z+1].setSize(300, 300);
                gridSquares[x+1][z+1].addMouseListener(this);
                gridSquares[x+1][z+1].setBorder(BorderFactory.createLineBorder(Color.black));}
            } 
            if(x>=8 && x<=12){
                for( int z = x-6 ; z<=18-x  ; z++){
                gridSquares[x+1][z+1].setColor(2);
                gridSquares[x+1][z+1].setSize(300, 300);
                gridSquares[x+1][z+1].addMouseListener(this);
                gridSquares[x+1][z+1].setBorder(BorderFactory.createLineBorder(Color.black));}
            }

        }

        // bottomPanel1 column Numbers
        int r = 5;
        for(int c = 2; c <= 12; c++){
            gridSquares[Math.abs(r)][c].set_Header(c);
            r--;
        }

        // add panels to bottomPanel0
        bottomPanel0.add(bottomPanel1, BorderLayout.NORTH);
        bottomPanel0.add(bottomPanel2, BorderLayout.CENTER);

        
        // Right panel contents

        roll_Button = new JButton("ROLL");
        roll_Button.setAlignmentX(CENTER_ALIGNMENT);
        roll_Button.setPreferredSize(new Dimension(50,50));
        roll_Button.addActionListener(this);

        dice_label1 = new JLabel("N");
        dice_label1.setAlignmentX(CENTER_ALIGNMENT);
        dice_label1.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_label2 = new JLabel("N");
        dice_label2.setAlignmentX(CENTER_ALIGNMENT);
        dice_label2.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_label3 = new JLabel("N");
        dice_label3.setAlignmentX(CENTER_ALIGNMENT);
        dice_label3.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_label4 = new JLabel("N");
        dice_label4.setAlignmentX(CENTER_ALIGNMENT);
        dice_label4.setFont(new Font("Ariel", Font.PLAIN, 30));

        dice_comb1 = new Combination(0,0);
        dice_comb1.setAlignmentX(CENTER_ALIGNMENT);
        dice_comb1.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_comb1.setBackground(Color.DARK_GRAY);
        dice_comb1.addMouseListener(this); 

        dice_comb2 = new Combination(0,0);
        dice_comb2.setAlignmentX(CENTER_ALIGNMENT);
        dice_comb2.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_comb2.addMouseListener(this); 

        dice_comb3 = new Combination(0,0);
        dice_comb3.setAlignmentX(CENTER_ALIGNMENT);
        dice_comb3.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_comb3.addMouseListener(this); 

        dice_comb4 = new Combination(0,0);
        dice_comb4.setAlignmentX(CENTER_ALIGNMENT);
        dice_comb4.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_comb4.addMouseListener(this); 
        
        dice_comb5 = new Combination(0,0);
        dice_comb5.setAlignmentX(CENTER_ALIGNMENT);
        dice_comb5.setFont(new Font("Ariel", Font.PLAIN, 30)); 
        dice_comb5.addMouseListener(this); 
        
        dice_comb6 = new Combination(0,0);
        dice_comb6.setAlignmentX(CENTER_ALIGNMENT);
        dice_comb6.setFont(new Font("Ariel", Font.PLAIN, 30));
        dice_comb6.addMouseListener(this); 
        
        rightPanel.add(Box.createRigidArea(new Dimension(0,50)));
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(dice_label1);
        rightPanel.add(dice_label2);
        rightPanel.add(dice_label3);
        rightPanel.add(dice_label4);
        rightPanel.add(dice_comb1);
        rightPanel.add(dice_comb2);
        rightPanel.add(dice_comb3);
        rightPanel.add(dice_comb4);
        rightPanel.add(dice_comb5);
        rightPanel.add(dice_comb6);
        rightPanel.add(Box.createRigidArea(new Dimension(0,150)));
        rightPanel.add(roll_Button);
        rightPanel.add(Box.createRigidArea(new Dimension(0,150)));
        
        

        
        // now add the top and bottom panels to the main frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel0, BorderLayout.CENTER);        // needs to be center or will draw too small
        getContentPane().add(rightPanel, BorderLayout.EAST);

        // housekeeping : behaviour
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    
    // public void movePiece(int i){
    //     boolean found = false;
    //     int x = 0;
    //     while(!found && x <= rows ){

    //         if (gridSquares[x][i].equals) 

    //     }
    // }

    
    public void simulateDiceRoll(){
            Random rand = new Random();
            int w = rand.nextInt(7);
            int x = rand.nextInt(7);
            int y = rand.nextInt(7);
            int z = rand.nextInt(7);

            dice_label1.setText(""+w);
            dice_label2.setText(""+x);
            dice_label3.setText(""+y);
            dice_label4.setText(""+z);

            dice_comb1.setText(""+w+" "+x);
            dice_comb1.setValue1(w);
            dice_comb1.setValue2(x);
         
            dice_comb2.setText(""+w+" "+y);
            dice_comb2.setValue1(w);
            dice_comb2.setValue2(y);

            dice_comb3.setText(""+w+" "+z);
            dice_comb3.setValue1(w);
            dice_comb3.setValue2(z);

            dice_comb4.setText(""+y+" "+z);
            dice_comb4.setValue1(y);
            dice_comb4.setValue2(z);
  
            dice_comb5.setText(""+x+" "+z);
            dice_comb5.setValue1(x);
            dice_comb5.setValue2(z);
 
            dice_comb6.setText(""+y+" "+x);
            dice_comb6.setValue1(y);
            dice_comb6.setValue2(x);
 
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
        else if (selected.equals(roll_Button)){
                simulateDiceRoll();
        }
        /*else if(selected.equals(dice_comb1)){ 
            dice_comb1.setText("You selected" + dice_comb1.getValue1() +"and "+ dice_comb1.getValue2()); 
            
        }*/

    }


    // Mouse Listener events
    public void mouseClicked(MouseEvent mevt)
    {
        // get the object that was selected in the gui
        Object selected = mevt.getSource();
    
        if (selected instanceof GridSquare)
        {
            GridSquare square = (GridSquare) selected;
            square.switchColor();
            int x = square.getXcoord();
            int y = square.getYcoord();
            infoLabel.setText("("+x+","+y+") last selected.");
            
        }    
        else if (selected instanceof Combination)
        {
            System.out.println("Started");
            Combination currCombination = (Combination ) selected;
            int x = currCombination.getValue1();
            int y = currCombination.getValue2();
            int column = x+y;
            boolean runnerFound = false; 
            currCombination.setText("You selected" + x +"and "+ y);
            if(1<column && column<8){
                for ( int r = 8-column; r <= column+6; r++)
                {
                    if(gridSquares [r][column].containsRunner()){
                       gridSquares [r][column].removeRunner();
                       gridSquares [r-1][column].setRunner();
                       runnerFound=true;
                    }
                }
                if(runnerFound==false){
                   gridSquares [column+6][column].setRunner();
                }
            }
            else if(7<column && column<13){
                for ( int r = column-6; r <= (20-column); r++)
                {
                    if(gridSquares [r][column].containsRunner()){
                       gridSquares [r-1][column].setRunner();
                       gridSquares [r][column].removeRunner();
                       runnerFound=true;
                    }
                }
                if(runnerFound==false){
                   gridSquares [20-column][column].setRunner();
                }
            }
            
        }
        System.out.println("closed");
        
    }
    
    // not used but must be present to fulfil MouseListener contract
    public void mouseEntered(MouseEvent arg0){}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
}
