import java.awt.*;
import javax.swing.*;
public class Combination extends JButton
{
    private int value1, value2;     

    /**
     * Constructor for objects of class Combination
     */
    public Combination(int value1, int value2)
    {
       super();
       this.value1= value1;
       this.value2= value2;
       this.setSize(40,40);
    }
    
    public int getValue1(){
        return this.value1;
    }
    
    public int getValue2(){
        return this.value2;
    }    
    
    public void setValue1(int val1){
        this.value1= val1;
    }

    public void setValue2(int val2){
        this.value2= val2;
    }
    
    /*public void setColor( int decider)
    {
        if(decider==1){
            this.setBackground(Color.orange);    
        }
        else if( decider == 2){
            this.setBackground(Color.BLUE);
        }
        else if( decider == 3){
            this.setBackground(Color.PINK);
        }
        else if( decider == 4){
            this.setBackground(Color.GREEN);
        }
        else if( decider == 5){
            this.setBackground(Color.RED);
        }
        else if( decider == 6){
            this.setBackground(Color.yellow);
        }
    }*/
}
