// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class JDicePanel extends JPanel
{
    private int[] diceValues; // values of dice

    public JDicePanel()
    {
        super();
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200, 100));
        setPreferredSize(new Dimension(200, 100));
        diceValues = new int[] {1, 1};
    }


    public void drawDice(int a, int b)
    {
        diceValues[0] = a;
        diceValues[1] = b;

        Graphics g = getGraphics();
        int padding = 6;
        g.clearRect(0, 0, getWidth(), getHeight());
        paint(getGraphics());
    }

    private void drawOne(Graphics g, int x, int y, int width, int number, Color color) 
    // PRE:  g is a legitimate initialized Graphics object 
    //       x >= 0 and x is within the drawing area
    //       y >= 0 and y is within the drawing area
    //       width >= 0 and width is a reasonable size
    //       number is within {1,2,3,4,5,6}
    //       color is a valid color
    // POST: this method will draw a die with its top left
    //       coner at (x,y) and width and height set to width
    //       and it will have the number of dots draw on its
    //       face in the color of color and with given number
    //       number.
    {
        int padding = 6;                           // padding around the border to make it look nicer
        int dotSize = (width - (padding * 2)) / 3; // this is to set the size of circles relative to die

        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, width);
        g.setColor(color);

        if(number == 1) 
        { // draw 1 circles on die
            g.fillOval(x+padding+dotSize, y+padding+dotSize, dotSize, dotSize);
        }
        else if(number == 2) 
        { // draw 2 circles on die
            g.fillOval(x+padding, y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding, dotSize, dotSize);
        }
        else if(number == 3)
        { // draw 3 circles on die
            g.fillOval(x+padding, y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding+dotSize, y+padding+dotSize, dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding, dotSize, dotSize);
        }
        else if(number == 4) 
        { // draw 4 circles on die
            g.fillOval(x+padding, y+padding, dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding, y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding, dotSize, dotSize);
        }
        else if(number == 5) 
        { // draw 5 circles on die
            g.fillOval(x+padding, y+padding, dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding, y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding, dotSize, dotSize);
            g.fillOval(x+padding+dotSize, y+padding+dotSize, dotSize, dotSize);
        }
        else if(number == 6)
        { // draw 6 circles on die
            g.fillOval(x+padding, y+padding, dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding, y+padding+(dotSize*2), dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding, dotSize, dotSize);
            g.fillOval(x+padding, y+padding+dotSize, dotSize, dotSize);
            g.fillOval(x+padding+(dotSize*2), y+padding+dotSize, dotSize, dotSize);
        }
    }

    public void paint(Graphics g)
    {
        int padding = 6;
        super.paint(g);
        g.setColor(Color.RED);

        drawOne(g, padding, padding, (getWidth() / 2) - (2*padding), diceValues[0], Color.BLACK);
        drawOne(g, padding + (getWidth() / 2), padding, (getWidth() / 2) - (2*padding), diceValues[1], Color.BLACK);
    }

    /*public static void main(String[] args)
    {
        JFrame f = new JFrame();
        JDicePanel dice = new JDicePanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(dice);
        f.show();
        f.pack();
        f.setVisible(true);
        dice.drawDice(5, 6);
        dice.drawDice(6, 6);
        dice.drawDice(2, 2);
    }*/
}