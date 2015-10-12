// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 9, 2015
// Description: This class models a tax square in monopoly 
//              (ie. income tax and luxury tax)

import java.lang.Math;
import java.lang.String;

public class TaxSquare extends BoardLocation
{
    private static final int INCOMETAX = 200;    // amount player must pay when landing on
                                                 //     income tax
    private static final int LUXURYTAX = 75;     // amount player must pay when landing on
                                                 //     luxury tax
    public TaxSquare()
    // POST: A default TaxSquare object is created
    {
        super();                                 // call superclass constructor
    }

    public TaxSquare(String name, int address)
    {
        super(name, address);
    }

    public String toString()
    // POST: FCTVAL == string representation of this TaxSquare
    {   
        return super.toString() + " Income Tax: $" + INCOMETAX + " Luxury Tax: $" + LUXURYTAX;
    }

/*
    public int incomeTax()
    // POST: FCTVAL == random dollar amount to be taken or given to the player
    {
        return (int) ( (Math.random() * (MAX - MIN) + 1) + MIN)
    }

    public int drawCommunityChest()
    // POST: FCTVAL == random dollar amount to be taken or given to the player
    {
        return (int) ( (Math.random() * (MAX - MIN) + 1) + MIN)
    }
*/

}
