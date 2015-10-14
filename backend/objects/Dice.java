// Programmer:  Chris Griffith
// Section:     CS 342
// Assignment:  Lab 4
// Date:        September 21, 2015
// Description: The method sets up the graphics object to draw a random
//              side of a six sided die.

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.lang.Math;

public class Dice
{
    // Data Dictionary
    private int diceValue;                            // Holds a random value
    
    public Dice()
    // POST: A default dice object is created with diceValue set to -1
    {
        this.diceValue = -1;                          // Default die value
    }

    public int rollDie()
    // POST: FCTVAL == random diceValue (ie. random side of the die) 
    {
        diceValue = (int) ((Math.random() * 7) + 1);  // Random value from 1 to 6
    
        return diceValue;
    }

    public void drawDie(Graphics g, int startX, int startY, 
                         int value, int squareSize, Color colorInput)
    // PRE:  g != NULL and drawing canvas is at least the size of squareSize in pixels,
    //       startX contains a x-axis coordinate of the upper left corner of the square, 
    //          and 0 <= startX <= (canvas width - squareSize),
    //       startY contains a y-axis coordinate of the upper left corner of the square,
    //          and 0 <= startY <= (canvas height - squareSize),
    //       value >= 1 and <= 6,
    //       squareSize contains a length in pixels, squareSize > 0,
    //       colorInput contains a color object in the RGB model
    // POST: Graphics object g will be updated to show one side of a standard 
    //       six sided die where its location is set to startX and startY, its
    //       size is set to squareSize, its value is set to value, and color is 
    //       set to colorInput.
    {   
        // Data Dictionary
        int stringLocX;                                 // X location for the number on die
        int stringLocY;                                 // Y location for the number on die
        Font font;                                      // Current Font
    
        // Center string on die
        stringLocX = startX + squareSize / 3;    
        stringLocY = (int) (startY + squareSize / 1.5);

        g.setColor(Color.BLACK);                        // Die outline is always black
        
        g.drawRect(startX, startY, squareSize, squareSize);       // Draw die

        font = new Font("SansSerif", Font.PLAIN, squareSize / 2); // Select font
    
        g.setColor(colorInput);                         // Set drawing color to user choice
        g.setFont(font);                                // Set drawing font

        if(value == 1)                                  // Draw 1 at center of die
            g.drawString("1", stringLocX, stringLocY); 
        
        else if(value == 2)                             // Draw 2 at center of die
            g.drawString("2", stringLocX, stringLocY); 
        
        else if(value == 3)                             // Draw 3 at center of die
            g.drawString("3", stringLocX, stringLocY); 
        
        else if(value == 4)                             // Draw 4 at center of die
            g.drawString("4", stringLocX, stringLocY); 
        
        else if(value == 5)                             // Draw 5 at center of die
            g.drawString("5", stringLocX, stringLocY); 
        
        else                                            // Draw 6 at center of die
            g.drawString("6", stringLocX, stringLocY); 

        return;  
    }   
}
